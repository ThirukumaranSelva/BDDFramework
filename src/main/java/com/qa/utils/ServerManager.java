package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {
    private static  ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    public AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        Utils.logger().info("Starting Appium Server!");
        AppiumDriverLocalService server = getServerCustom();
        server.start();
        if (server == null || !server.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Server is not started. Abort!");
        }
        server.clearOutPutStreams();
        /* server logs won't be visible in console if u add this one */

        ServerManager.server.set(server);
        Utils.logger().info("Appium Server Started!");
    }

    public AppiumDriverLocalService getServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService getServerCustom() {
        GlobalParams globalParams = new GlobalParams();
        String nodejs = "C:" + File.separator + "Program Files" + File.separator + "nodejs" + File.separator + "node.exe";
        String appiumJS = "C:" + File.separator + "Users" + File.separator + "Thirukumaran" + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "npm" + File.separator + "node_modules" + File.separator + "appium" + File.separator + "build" + File.separator + "lib" + File.separator + "main.js";
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                /*    .usingDriverExecutable(new File(nodejs)).withAppiumJS(new File(appiumJS))    */
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(globalParams.getPlatformName() + "_" + globalParams.getDeviceName() + File.separator +
                        "Server.log"))

        );
    }

    public AppiumDriverLocalService getMacServer() {
        GlobalParams globalParams = new GlobalParams();
        String nodejs = "C:" + File.separator + "Program Files" + File.separator + "nodejs" + File.separator + "node.exe";
        String appiumJS =
                "C:" + File.separator + "Users" + File.separator + "Thirukumaran" + File.separator + "AppData" + File.separator +
                        "Roaming" + File.separator + "npm" + File.separator + "node_modules" + File.separator + "appium" + File.separator + "build" + File.separator + "lib" + File.separator + "main.js";
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodejs)).withAppiumJS(new File(appiumJS))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(globalParams.getPlatformName() + "_" + globalParams.getDeviceName() + File.separator +
                        "Server.log")));
    }
}
