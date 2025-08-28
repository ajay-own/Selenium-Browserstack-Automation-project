package com.example.demo.Pages;

import com.example.demo.libraries.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v136.page.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void LoginTest(){
   //     WebDriver d= DriverManager.getDriverThread();
        System.out.println("LoginTest");
        driver().get("https://www.google.com");
//        getDriver().findElement(By.id(""));
//        getDriver().findElement(By.id("")).sendKeys("");
        Assert.assertTrue(true);

    }
    @Test
    public void testOne() {

        System.out.println("TestOne running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

    @Test
    public void testTwo() {

        System.out.println("TestTwo running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

    @Test
    public void testThree() {

        System.out.println("TestThree running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

}
