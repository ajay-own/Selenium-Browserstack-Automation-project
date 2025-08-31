package com.example.demo;

import com.example.demo.libraries.BrowserFactory;
import com.example.demo.libraries.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
@ComponentScan(basePackages = "com.example.demo")   // <-- ensure BrowserFactory is found
@TestPropertySource(locations = "classpath:application-qa.properties")
public class BaseTest extends AbstractTestNGSpringContextTests { // this helps in injecting spring in testng

    @Autowired
    BrowserFactory browserFactory;

    @Value("${application.runEnv}")
    private String runEnv;

    @Value("${appliaction.browser}")
    private String browser;

    private String JenkinBrowserParameter = System.getProperty("BROWSER");

    private String JenkinLocationParameter = System.getProperty("loc");


    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "runEnv"})
    public void setUp(@Optional("chrome") String browser, @Optional("local") String runEnv) {

        if(JenkinBrowserParameter == null || JenkinBrowserParameter.isEmpty()){
            JenkinBrowserParameter = browser;
        }
        if(JenkinLocationParameter == null || JenkinLocationParameter.isEmpty()){
            JenkinLocationParameter = runEnv;
        }
        System.out.println("jenkin browser: " + JenkinBrowserParameter);
        System.out.println("jenkin location: " + JenkinLocationParameter);
        System.out.println("inside basetest : setUp");
        WebDriver driver = browserFactory.createBrowserInstance(JenkinBrowserParameter, JenkinLocationParameter);
        DriverManager.setDriverThread(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        DriverManager.quitDriverThread();
    }

    public WebDriver driver() {
        return DriverManager.getDriverThread();
    }

}
