package com.example.demo;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void SearchtestOne() {
        driver().get("https://www.bing.com");
        System.out.println("SearchTestOne running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

//    @Test
//    public void SearchtestTwo() {
//
//        System.out.println("SearchTestTwo running on Thread: " + Thread.currentThread().getId()
//                + " | Driver hashCode: " + driver().hashCode());
//    }
//
//    @Test
//    public void SearchtestThree() {
//
//        System.out.println("SearchTestThree running on Thread: " + Thread.currentThread().getId()
//                + " | Driver hashCode: " + driver().hashCode());
//    }
}
