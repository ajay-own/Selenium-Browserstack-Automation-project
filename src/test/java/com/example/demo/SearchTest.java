package com.example.demo;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testOne() {

        System.out.println("SearchTestOne running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

    @Test
    public void testTwo() {

        System.out.println("SearchTestTwo running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }

    @Test
    public void testThree() {

        System.out.println("SearchTestThree running on Thread: " + Thread.currentThread().getId()
                + " | Driver hashCode: " + driver().hashCode());
    }
}
