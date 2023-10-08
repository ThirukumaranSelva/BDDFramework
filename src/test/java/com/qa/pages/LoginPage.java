package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    ProductPage productPage;

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userName;
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement userPassword;
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errorMessage;

    public LoginPage sendUsername(String username) {
        clear(userName);
        sendKeys(userName, username);
        return this;
    }

    public LoginPage sendPassword(String password) {
        clear(userPassword);
        sendKeys(userPassword, password);
        return this;
    }

    public ProductPage clickLoginButton() {
        click(loginButton);
        return new ProductPage();
    }

    public String errorMessage() {
        return getText(errorMessage);
    }

    public ProductPage login(String username, String password) {
        sendUsername(username);
        sendPassword(password);
        return clickLoginButton();

    }

}
