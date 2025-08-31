package com.example.demo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class BrowserFactory {

//    @Value("${application.runEnv}")
//    private String runEnv;
    @Value("${browserstack.userName}")
    private String username;
    @Value("${browserstack.accessKey}")
    private String accessKey;

    public WebDriver createBrowserInstance(String browser, String runEnv, String testMethodName) {
        System.out.println("runEnv:"+runEnv);
        if (runEnv.equalsIgnoreCase("remote")) {
            return createRemoteDriver(browser, testMethodName);
        } else {
            return CreateLocalChromeDriver(browser, testMethodName);
        }
    }

    private  WebDriver createRemoteDriver(String browser, String testMethodName) {
        try {
//            String username = System.getenv("BROWSERSTACK_USERNAME");
//            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

            String hubUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
            LocalDateTime now = LocalDateTime.now();

            // Format as yyyy-MM-dd HH:mm:ss
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);
            // Common BrowserStack options
            Map<String, Object> bs = new HashMap<>();
            bs.put("os", "Windows");            // or "OS X"
            bs.put("osVersion", "11");          // pick from BrowserStack’s supported list
            bs.put("projectName", "browserstack Demo Project");
            bs.put("buildName", "Test - " + testMethodName + " - "+formattedDate);
            bs.put("sessionName", "TestNG parallel : "+formattedDate);
            bs.put("seleniumVersion", "4.34.0"); // optional but recommended

            if(browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setBrowserVersion("latest");
                options.setCapability("bstack:options", bs);
                return new RemoteWebDriver(new URL(hubUrl), options);
            }
            if(browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setBrowserVersion("latest");
                options.setCapability("browserstack:options", bs);
                return new RemoteWebDriver(new URL(hubUrl), options);

            }

 //           driver = new RemoteWebDriver(new URL(hubUrl), options);

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("os", "Windows");
//            caps.setCapability("os_version", "11");
//            caps.setCapability("browser", browser);
//            caps.setCapability("browser_version", "latest");
//            caps.setCapability("name", "Parallel Test on " + browser); // test name in BrowserStack dashboard
            System.out.println("hubUrl:"+hubUrl);
            System.out.println("creating remote driver");
            return null;


        } catch (Exception e) {
            throw new RuntimeException("Failed to create remote driver", e);
        }
    }

    private  WebDriver CreateLocalChromeDriver(String browser, String testMethodName) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

}
