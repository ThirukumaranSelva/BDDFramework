package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver1) {
        driver.set(driver1);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver4 = null;
        GlobalParams globalParams = new GlobalParams();
        ServerManager serverManager=new ServerManager();
        CapabilitiesManager capabilitiesManager=new CapabilitiesManager();
        try {
            Utils.logger().info("initializing Appium driver");
            switch (globalParams.getPlatformName()) {
                case "Android" -> driver4 = new AndroidDriver(serverManager.getServer().getUrl(),
                        capabilitiesManager.getDesiredCapabilities());
                case "iOS" -> driver4 = new IOSDriver(serverManager.getServer().getUrl(),
                        capabilitiesManager.getDesiredCapabilities());
            }
            if (driver4 == null) {
                throw new Exception("Driver initialization Failed!");
            }
            DriverManager.driver.set(driver4);
        } catch (Exception e) {
            e.getStackTrace();
            Utils.logger().fatal("Driver is initialization Failed! Abort"+e);
            throw e;
        }
    }
}
