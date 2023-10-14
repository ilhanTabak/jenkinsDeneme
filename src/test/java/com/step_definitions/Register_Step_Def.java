package com.step_definitions;
import com.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register_Step_Def {
    RegisterPage registerPage = new RegisterPage();
    @Given("The user on the register page")
    public void the_user_on_the_register_page() {

    }
    @When("The user enter valid credential")
    public void theUserEnterValidCredential() {
        registerPage.registerPageMethod();

    }
    @Then("The user can make register")
    public void the_user_can_make_register() {
        Assert.assertTrue(registerPage.RegisterText.getText().contains("Mitgliedschaft ist abgeschlossen!"));
    }

    //------------------------------------------------------------------------------------------------------

    @When("The user enter invalid  {string},{string},{string},{string},{string} credential")
    public void theUserEnterInvalidCredential(String firstName, String lastName, String eMail, String password1, String password2) {
        registerPage.registerNegative(firstName, lastName, eMail, password1, password2);

    }

    @Then("The user can not make register and see {string} message")
    public void theUserCanNotMakeRegisterAndSeeMessge(String warnung) {

        Assert.assertTrue(registerPage.warnungObligatorisch.getText().contains(warnung));

    }
}