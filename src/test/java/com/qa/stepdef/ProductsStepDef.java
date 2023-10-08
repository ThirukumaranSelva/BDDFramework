package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.pages.ProductsDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductsStepDef {

    @Given("User logged in successfully")
    public void userLoggedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
      //  new LoginPage().login("standard_user", "secret_sauce");

    }

    @When("User verify product name {string} and product price {string}")
    public void userVerifyProductNameAndProductPrice(String productName, String productPrice) {
        // Write code here that turns the phrase above into concrete actions
        String name=new ProductPage().productName();
        String price=new ProductPage().productPrice();
        Assert.assertEquals(productName,name);
        Assert.assertEquals(productPrice,price);
    }

    @When("User clicks on product name {string}")
    public void userClicksOnProductName(String productName) {
        // Write code here that turns the phrase above into concrete actions
        String name=new ProductPage().productName();
        Assert.assertEquals(productName,name);
        new ProductPage().clickProductName();
    }

    @Then("verify product title {string} and verify product description {string}")
    public void verifyProductTitleAndVerifyProductDescription(String productTitle, String productDescription) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(productTitle,new ProductsDetailPage().productDetailScreenName());
        Assert.assertEquals(productDescription,new ProductsDetailPage().productDetailScreenDescription());
    }


    @When("User scrolls the page")
    public void userScrollsThePage() {
        new ProductsDetailPage().scrollElement(1.0);
    }

    @Then("verify the price {string}")
    public void verifyThePrice(String price) {
        Assert.assertEquals(price,new ProductsDetailPage().productDetailScreenPrice());
    }
}
