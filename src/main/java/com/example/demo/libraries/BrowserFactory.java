package com.example.demo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
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

    public WebDriver createBrowserInstance(String browser, String runEnv) {
        System.out.println("runEnv:"+runEnv);
        if (runEnv.equalsIgnoreCase("remote")) {
            return createRemoteDriver(browser);
        } else {
            return createLocalDriver(browser);
        }
    }

    private  WebDriver createRemoteDriver(String browser) {
        try {
//            String username = System.getenv("BROWSERSTACK_USERNAME");
//            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

            String hubUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

            // Common BrowserStack options
            Map<String, Object> bs = new HashMap<>();
            bs.put("os", "Windows");            // or "OS X"
            bs.put("osVersion", "11");          // pick from BrowserStack’s supported list
            bs.put("projectName", "browserstack Demo Project");
            bs.put("buildName", "CI - #" + System.currentTimeMillis());
            bs.put("sessionName", "TestNG parallel");
            bs.put("seleniumVersion", "4.34.0"); // optional but recommended

            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("latest");
            options.setCapability("bstack:options", bs);
 //           driver = new RemoteWebDriver(new URL(hubUrl), options);

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("os", "Windows");
//            caps.setCapability("os_version", "11");
//            caps.setCapability("browser", browser);
//            caps.setCapability("browser_version", "latest");
//            caps.setCapability("name", "Parallel Test on " + browser); // test name in BrowserStack dashboard
            System.out.println("hubUrl:"+hubUrl);
            System.out.println("creating remote driver");
            return new RemoteWebDriver(new URL(hubUrl), options);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create remote driver", e);
        }
    }

    private  WebDriver createLocalDriver(String browser) {
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
