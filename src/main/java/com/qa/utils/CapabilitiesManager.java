package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.an.E;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class CapabilitiesManager {

    public DesiredCapabilities getDesiredCapabilities() throws IOException {

        GlobalParams globalParams = new GlobalParams();
        PropertyManager propertyManager= new PropertyManager();
        try {
            Utils.logger().info("Getting Capabilities");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, globalParams.getPlatformName());
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, globalParams.getDeviceName());
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, globalParams.getUdid());

            switch (globalParams.getPlatformName()) {
                case "Android" -> {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                            propertyManager.getProperties().getProperty("androidAutomationName"));
                    desiredCapabilities.setCapability("systemPort", globalParams.getSystemPort());
                    desiredCapabilities.setCapability("chromeDriverPort", globalParams.getChromeDriverPort());
                    desiredCapabilities.setCapability("appPackage", propertyManager.getProperties().getProperty(
                            "androidSwagLabOldAppPackage"));
                    desiredCapabilities.setCapability("appActivity", propertyManager.getProperties().getProperty("androidSwagLabOldAppActivity"));
                    String androidAppURL =
                            System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
                                    "resources" + File.separator + "app" + File.separator + propertyManager.getProperties().getProperty("androidSauceLabsOldAppLocation");
                //    desiredCapabilities.setCapability(MobileCapabilityType.APP, androidAppURL);
                    Utils.logger().info("Capabilities Set for Android!");
                }
                case "iOS" -> {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyManager.getProperties().getProperty("iOSAutomationName"));
                    desiredCapabilities.setCapability("wdaLocalPort", globalParams.getWdaLocalPort());
                    desiredCapabilities.setCapability("webkitDebugProxyPort", globalParams.getWebkitDebugProxyPort());
                    desiredCapabilities.setCapability("bundleId", propertyManager.getProperties().getProperty("iOSBundleId"));
                    String iOSAppURL =
                            System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
                                    "resources" + File.separator + "app" + File.separator + propertyManager.getProperties().getProperty("iOSSauceLabsOldAppLocation");

                    desiredCapabilities.setCapability(MobileCapabilityType.APP, iOSAppURL);

                }
                default -> {
                    try {
                        throw new Exception("Invalid Platform Name!");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return desiredCapabilities;
        } catch (Exception e) {
            e.getStackTrace();
            Utils.logger().fatal("Capabilities failed to load!" + e);
            throw e;
        }
    }
}
