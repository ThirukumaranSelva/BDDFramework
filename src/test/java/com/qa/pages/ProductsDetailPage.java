package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsDetailPage extends ProductPage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private WebElement productTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    private WebElement getProductTitleDesc;

    @AndroidFindBy(accessibility = "test-Price")
    private WebElement pdProductPrice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK TO PRODUCTS\"]/android.widget.TextView")
    private WebElement backToProductsPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Inventory item page\"]")
    private WebElement scrollableElement;

    public String productDetailScreenName() {
        return getText(productTitle);
    }

    public String productDetailScreenDescription() {
        return getText(getProductTitleDesc);
    }

    public String productDetailScreenPrice() {
        return getText(pdProductPrice);
    }
    public void scrollElement(double value){
        scroll(scrollableElement, value);
    }

    public ProductPage backToProductPage() {
        click(backToProductsPage);
        return new ProductPage();
    }
}
