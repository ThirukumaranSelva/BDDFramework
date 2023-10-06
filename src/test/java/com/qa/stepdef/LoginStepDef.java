package com.qa.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Click on loginButton")
    public void clickOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("User should get error {string}")
    public void userShouldGetError(String error) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("User landed in products screen")
    public void userLandedInProductsScreen() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("verify product title {string}")
    public void verifyProductTitle(String title) {
        // Write code here that turns the phrase above into concrete actions

    }



}
