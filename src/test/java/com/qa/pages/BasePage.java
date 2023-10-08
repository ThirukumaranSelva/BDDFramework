package com.qa.pages;

import com.google.common.collect.ImmutableMap;
import com.qa.utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private final AppiumDriver driver;

    BasePage() {
        driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForElement(WebElement element) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(Utils.wait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void clear(WebElement element) {
        waitForElement(element);
        element.clear();
    }

    public void sendKeys(WebElement element, String text) {
        waitForElement(element);
        clear(element);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String text) {
        waitForElement(element);
        return element.getAttribute(text);
    }

    public String getText(WebElement element) {
        String text = null;
        switch (new GlobalParams().getPlatformName()) {
            case "Android" -> {
                text = getAttribute(element,"text");
            }
            case "iOS" -> {
                text = getAttribute(element,"label");
            }
            default -> {
                try {
                    throw new Exception("Invalid Platform");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return text;
    }

    public void scroll(WebElement element, double percent) {
        waitForElement(element);
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", percent
        ));
    }
}
