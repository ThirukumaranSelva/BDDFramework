package com.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDef {

    @Given("User logged in successfully")
    public void userLoggedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User verify product name {string} and product price {string}")
    public void userVerifyProductNameAndProductPrice(String productName, String productPrice) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User clicks on product name {string}")
    public void userClicksOnProductName(String productName) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("User landed to product Detailed view page")
    public void userLandedToProductDetailedViewPage() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("verify product title {string} and verify product description {string}")
    public void verifyProductTitleAndVerifyProductDescription(String productTitle, String productDescription) {
        // Write code here that turns the phrase above into concrete actions

    }
}
