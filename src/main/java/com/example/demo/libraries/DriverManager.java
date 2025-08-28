package com.example.demo.libraries;

import org.openqa.selenium.WebDriver;

public class DriverManager
{
    // this class handles the thread for webdriver
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

    public static WebDriver getDriverThread()
    {
        System.out.println("getDriverThread");
        return driverThread.get();
    }
    public static void setDriverThread(WebDriver driver)
    {
        System.out.println("setDriverThread");
        driverThread.set(driver);
    }

    public static void quitDriverThread()
    {

        WebDriver driver = driverThread.get();
        System.out.println("quitDriverThread : "+ getDriverThread().hashCode());
        if (driver != null){
            driver.quit();
            driverThread.remove();
        }


    }


}
