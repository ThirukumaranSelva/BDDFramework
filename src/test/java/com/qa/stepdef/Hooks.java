package com.qa.stepdef;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.lv.Un;
import org.apache.logging.log4j.ThreadContext;

public class Hooks {

    @Before
    public void initialize() throws Exception {
       /* GlobalParams globalParams=new GlobalParams();
        globalParams.initializeGlobalParams();
        *//* Creating Logs for this method *//*
        ThreadContext.put("ROUTINGKEY",globalParams.getPlatformName()+"_"+globalParams.getDeviceName());
        *//* Start server *//*
        ServerManager serverManager=new ServerManager();
        serverManager.startServer();
        new DriverManager().initializeDriver();*/
    }

    @After
    public void quit(){
       /* DriverManager driverManager=new DriverManager();
        if(driverManager.getDriver()!=null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
            Utils.logger().info("Driver Quit!");
        }
        ServerManager serverManager=new ServerManager();
        if(serverManager.getServer()!=null){
            serverManager.getServer().stop();
            Utils.logger().info("Appium Server Stopped!");
        }


  */
}}
