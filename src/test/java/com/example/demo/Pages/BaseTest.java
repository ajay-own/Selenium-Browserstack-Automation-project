package com.example.demo.Pages;

import com.example.demo.libraries.BrowserFactory;
import com.example.demo.libraries.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
@ComponentScan(basePackages = "com.example.demo")   // <-- ensure BrowserFactory is found
@TestPropertySource(locations = "classpath:application-qa.properties")
public class BaseTest extends AbstractTestNGSpringContextTests { // this helps in injecting spring in testng

    @Autowired
    BrowserFactory browserFactory;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        System.out.println("inside basetest : setUp");
        WebDriver driver = browserFactory.createBrowserInstance(browser);
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
