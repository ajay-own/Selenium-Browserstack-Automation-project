package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBasicApplication.class, args);




//    FirstClass firstClass = new FirstClass();
//    firstClass.firstMethod();

//      var firstClass = context.getBean(FirstClass.class); // even mulitple objects are created, they are same
//      firstClass.firstMethod();
//      var firstClass2 = context.getBean(FirstClass.class);
//      System.out.println("Object are same : " +  (firstClass == firstClass2));
//      System.out.println("firstClass has : " + firstClass.hashCode() + " firstClass2 hash : " + firstClass2.hashCode());
	}

}
