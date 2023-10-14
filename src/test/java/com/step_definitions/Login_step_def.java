package com.step_definitions;

import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Login_step_def {
    LoginPage loginPage = new LoginPage();
    WebDriver driver;

    @Given("The user is logging in with valid credentials")
    public void theUserIsLoggingInWithValidCredentials() {
        loginPage.loginMethod();
    }

    @Given("The user click on the Mein Konto")
    public void theUserClickOnTheMeinKonto() {
        loginPage.acceptButton.click();
        loginPage.userBox.click();
        BrowserUtils.waitFor(1);
    }

    @Then("The user click on the Anmelden")
    public void theUserClickOnTheAnmelden() {
        loginPage.anmelden.click();
    }

    @Then("The user enter the correct E-mail und Password")
    public void theUserEnterTheCorrectEmailUndPassword() {
        loginPage.userName.sendKeys(ConfigurationReader.get("loginEmail"));
        loginPage.password.sendKeys(ConfigurationReader.get("loginPassword"));
        BrowserUtils.waitFor(1);
    }

    @When("The user click the Anmelden button after entering the correct E-Mail and Password")
    public void theUserClickTheAnmeldenButtonAfterEnteringTheCorrectEmailAndPassword() {
        loginPage.anmeldenButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("The user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        loginPage.loginVerification();
    }

    @When("The user enters one or both of {string} and {string} incorrectly")
    public void theUserEntersOneOrBothOfAndIncorrectly(String Email, String Password) {
        loginPage.loginNegativTest(Email, Password);
    }

    @Then("The user should get an error Message, when the user enters the incorrect E-Mail or Password")
    public void theUserShouldGetAnErrorMessageWhenTheUserEntersTheIncorrectEMailOrPassword() {
        loginPage.loginErrorMessage();
    }

    @When("The user leaves one or both of the {string} and {string} fields blank")
    public void theUserLeavesOneOrBothOfTheAndFieldsBlank(String Email, String Password) {
        loginPage.loginNegativTest(Email, Password);
    }

    @Then("The user should get an error Message, when the user leaves one or both of the email and password fields blank")
    public void theUserShouldGetAnErrorMessageWhenTheUserLeavesOneOrBothOfTheEmailAndPasswordFieldsBlank() {
        loginPage.loginErrorMessage();
    }
}