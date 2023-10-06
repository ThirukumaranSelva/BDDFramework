package com.qa.utils;

public class GlobalParams {

    /* Global Parameters
     platformName, udid, deviceName, systemPort,chromeDriverPort, wdaLocalPort, webkitDebugProxyPort
     */
    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();

    public static void setPlatformName(ThreadLocal<String> platformName) {
        GlobalParams.platformName = platformName;
    }

    public static ThreadLocal<String> getPlatformName() {
        return platformName;
    }

    public static void setUdid(ThreadLocal<String> udid) {
        GlobalParams.udid = udid;
    }

    public static ThreadLocal<String> getUdid() {
        return udid;
    }

    public static void setSystemPort(ThreadLocal<String> systemPort) {
        GlobalParams.systemPort = systemPort;
    }

    public static ThreadLocal<String> getSystemPort() {
        return systemPort;
    }


    public static void setChromeDriverPort(ThreadLocal<String> chromeDriverPort) {
        GlobalParams.chromeDriverPort = chromeDriverPort;
    }

    public static ThreadLocal<String> getChromeDriverPort() {
        return chromeDriverPort;
    }


    public static void setWdaLocalPort(ThreadLocal<String> wdaLocalPort) {
        GlobalParams.wdaLocalPort = wdaLocalPort;
    }

    public static ThreadLocal<String> getWdaLocalPort() {
        return wdaLocalPort;
    }


    public static void setWebkitDebugProxyPort(ThreadLocal<String> webkitDebugProxyPort) {
        GlobalParams.webkitDebugProxyPort = webkitDebugProxyPort;
    }

    public static ThreadLocal<String> getWebkitDebugProxyPort() {
        return webkitDebugProxyPort;
    }


    public static ThreadLocal<String> getDeviceName() {
        return deviceName;
    }

    public static void setDeviceName(ThreadLocal<String> deviceName) {
        GlobalParams.deviceName = deviceName;
    }


}
