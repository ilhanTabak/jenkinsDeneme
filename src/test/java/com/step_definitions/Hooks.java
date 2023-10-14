package com.step_definitions;

import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before  //JAVA
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown() {
        //System.out.println("\tThis is coming from after method");

     Driver.closeDriver();







    }

//    @Before("@db")
//    public void setUpDB(){
//        System.out.println("t connection DB");
//    }
//    @After("@db")
//    public void tearDownDB(){
//        System.out.println("\tDisconnection DB");
//    }
}
