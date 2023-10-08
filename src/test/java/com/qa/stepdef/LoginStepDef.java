package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage().sendUsername(username).sendPassword(password);

    }

    @When("Click on loginButton")
    public void clickOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        new LoginPage().clickLoginButton();
    }

    @Then("User should get error {string}")
    public void userShouldGetError(String error) {
        // Write code here that turns the phrase above into concrete actions
        String actual = new LoginPage().errorMessage();
        Assert.assertEquals(actual, error);
    }


    @Then("verify product title {string}")
    public void verifyProductTitle(String title) {
        // Write code here that turns the phrase above into concrete actions
        String actual=new ProductPage().verifyProductTitleAfterLogin();
        Assert.assertEquals(actual,title);

    }


}
