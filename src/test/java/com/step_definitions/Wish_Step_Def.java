package com.step_definitions;

import com.pages.WishPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wish_Step_Def {

    WishPage wishPage=new WishPage();

    @Given("The user on the all product page")
    public void the_user_on_the_all_product_page() {
        wishPage.alleProdukte.click();

    }

    @When("The user select a products wish button")
    public void the_user_select_a_products_wish_button() {
        wishPage.wishMethod();


    }

    @Then("The user see produkt in the wish list")
    public void the_user_see_produkt_in_the_wish_list() {
        Assert.assertFalse(wishPage.emptyText.getText().contains("empty!")||wishPage.emptyText.getText().contains("leer"));
    }


    //-------------------------------------------------------------------------
    @Then("The user can delete a product from wish list")
    public void theUserCanDeleteAProductFromWishList() {
        Assert.assertFalse(wishPage.emptyText.getText().contains("empty!")||wishPage.emptyText.getText().contains("leer"));

    }
}