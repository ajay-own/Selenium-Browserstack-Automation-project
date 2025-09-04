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

import java.lang.reflect.Method;

@SpringBootTest
@ComponentScan(basePackages = "com.example.demo")   // <-- ensure BrowserFactory is found
@TestPropertySource(locations = "classpath:application-qa.properties")
public class BaseTest extends AbstractTestNGSpringContextTests { // this helps in injecting spring in testng

    @Autowired
    BrowserFactory browserFactory;

    @Value("${application.runLoc}")
    private String runLoc;

    @Value("${application.browser}")
    private String browser;

    private String JenkinBrowserParameter = System.getProperty("browser"); // string name same as jenkins parameters

    private String JenkinLocationParameter = System.getProperty("loc");



    @BeforeMethod(alwaysRun = true)
//    @Parameters({"browser", "runLoc"})
    public void setUp(Method testMethod) throws Exception {

        System.out.println("jenkin browser before: " + JenkinBrowserParameter);
        System.out.println("jenkin location: before " + JenkinLocationParameter);
        if(JenkinBrowserParameter == null || JenkinBrowserParameter.isEmpty()){
            JenkinBrowserParameter = browser;
        }
        if(JenkinLocationParameter == null || JenkinLocationParameter.isEmpty()){
            JenkinLocationParameter = runLoc;
        }
        System.out.println("jenkin browser: " + JenkinBrowserParameter);
        System.out.println("jenkin location: " + JenkinLocationParameter);
        System.out.println("inside basetest : setUp");
        WebDriver driver = browserFactory.createBrowserInstance(JenkinBrowserParameter, JenkinLocationParameter, testMethod.getName());
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
