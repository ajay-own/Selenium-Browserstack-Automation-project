package com.example.demo;


import org.springframework.stereotype.Component;


@Component
public class FirstClass {

    public FirstClass() {
        System.out.println("FirstClass intantiated");
    }
    public void firstMethod() {
        System.out.println("FirstMethod intantiated");
    }

}
