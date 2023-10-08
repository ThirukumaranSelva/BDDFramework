package com.qa.utils;

public class GlobalParams {

    /* Global Parameters
     platformName, udid, deviceName, systemPort,chromeDriverPort, wdaLocalPort, webkitDebugProxyPort
     */
    private static final ThreadLocal<String> platformName = new ThreadLocal<>();
    private static final ThreadLocal<String> udid = new ThreadLocal<>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static final ThreadLocal<String> systemPort = new ThreadLocal<>();
    private static final ThreadLocal<String> chromeDriverPort = new ThreadLocal<>();
    private static final ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static final ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();

    public void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public void setUdid(String udid1) {
        udid.set(udid1);
    }

    public String getUdid() {
        return udid.get();
    }

    public void setSystemPort(String systemPort1) {
        systemPort.set(systemPort1);
    }

    public String getSystemPort() {
        return systemPort.get();
    }


    public void setChromeDriverPort(String chromeDriverPort1) {
        chromeDriverPort.set(chromeDriverPort1);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }


    public void setWdaLocalPort(String wdaLocalPort1) {
        wdaLocalPort.set(wdaLocalPort1);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }


    public void setWebkitDebugProxyPort(String webkitDebugProxyPort1) {
        webkitDebugProxyPort.set(webkitDebugProxyPort1);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setDeviceName(String deviceName1) {
        deviceName.set(deviceName1);
    }
    public String getDeviceName() {
        return deviceName.get();
    }


    public void initializeGlobalParams() {

        setPlatformName(System.getProperty("platformName","Android"));
        setUdid(System.getProperty("udid","ce10171ab374340704"));
        setDeviceName(System.getProperty("deviceName","Samsung Galaxy S8+"));

        switch (getPlatformName()){
            case "Android"->{
                setSystemPort(System.getProperty("systemPort","10000"));
                setChromeDriverPort(System.getProperty("chromeDriverPort","11000"));
            }
            case "iOS"->{
                setWdaLocalPort(System.getProperty("wdaLocalPort","10001"));
                setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort","11001"));

            }
            default -> {
                throw new IllegalStateException("Invalid platform!");
            }
        }
    }

}
