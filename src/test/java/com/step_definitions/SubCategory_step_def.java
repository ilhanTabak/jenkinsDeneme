package com.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SubCategory_step_def {

    SubCategoryPage subCategoryPage=new SubCategoryPage();

    @When("The user navigate the Sub-Category Page Login")
    public void the_user_navigate_the_sub_category_page_login() {
        subCategoryPage.alleProdukte.click();


    }
    @Then("The user can see SubCategorys product")
    public void the_user_can_see_sub_categorys_product() {
        Assert.assertTrue(subCategoryPage.ErsteSchuhe.getText().contains("Schwarzes Santo"));

    }

    @Given("The user on the main page")
    public void the_user_on_the_main_page() {


    }
    @When("The user navigate the Sub-Category Page without Login")
    public void the_user_navigate_the_sub_category_page_without_login() {

        subCategoryPage.alleProdukte.click();

    }

    @Then("The user can see the SubCategorys product")
    public void theUserCanSeeTheSubCategorysProduct() {
        Assert.assertTrue(subCategoryPage.ErsteSchuhe.getText().contains("Schwarzes Santo"));
    }
}
