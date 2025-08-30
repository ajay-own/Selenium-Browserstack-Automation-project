package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBasicApplicationTests {




//    @Autowired
//    WebDriverLibrary webDriverLibrary;
//    @Autowired
//    private WebDriver driver;
//    @Autowired
//    private MainPage mainPage;
//    @Value("${app.url}")
//    private String appUrl;
//
//    @BeforeEach
//    void start(){
//        System.out.println("start");
//
//
//    }
//    @org.junit.jupiter.api.Test
//    void contextLoads() {        System.out.println(" appurl " + appUrl );  }
//    //note : every test quits the driver after it is executed
//
//    @org.junit.jupiter.api.Test
//    void performLoginTest(){
//        mainPage.performLogin();
//    }
//
//
//    @AfterEach
//    void afterTest(){
//        System.out.println("after test");
//        mainPage.quitDriver();
//    }
//    @Value("${spring.application.value}")
//    int val;
//
//    @Value("${abc}")
//    int abc;
//
//    @Value("#{2 * 3}")
//    private int number;   // 6
//
//    @Value("#{systemProperties['user.name']}")
//    private String userName;  // current OS user
//
//    @Value("${user.name}")
//    private String user;  // current OS user
//
//    @Value("#{T(java.lang.Math).random() * 100}")
//    private double randomNumber;  // some random value
//
//    @Value("ajay, vijay, sanjay")
//    private List<String> user2;

//    @ConfigurationProperties(prefix = "app")
//    public class AppProperties {
//        private List<String> fruits;
//
//        // getters & setters
//    }

//    @Value("${fruits}")
//    private List<String> fruits;
//
//    @Value("${fruits}")
//    private String[] Arrayfruits;

//        System.out.println("arrayfuits " +  Arrayfruits[2] );
//        System.out.println(fruits.get(1));
//        System.out.println("user : " + user2);
//        System.out.println("properties file value : " + val);
//        System.out.println("abc value : " + abc);
//        System.out.println(number + " " + userName + " " + randomNumber);
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.get(appUrl); //as only one object of driver is created, the url will open in same browser window
//
//       MainPage mainPage = new MainPage(loginPage,homePage);
//       mainPage.performLogin();
//        LoginPage loginPage = homePage.ClickLogin();
//        loginPage.clickLogin();

}
