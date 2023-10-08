package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends MenuPage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement productsTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    private WebElement getProductName;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
    private WebElement productPrice;

    public String verifyProductTitleAfterLogin() {
        return getText(productsTitle);
    }

    public String productName() {
        return getText(getProductName);
    }

    public String productPrice() {
        return getText(productPrice);
    }

    public ProductsDetailPage clickProductName() {
        click(getProductName);
        return new ProductsDetailPage();
    }
}
