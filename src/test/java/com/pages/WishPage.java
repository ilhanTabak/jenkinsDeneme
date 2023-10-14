package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishPage extends BasePage{




   @FindBy(css = "[id='64d943d5db5ea1d2fa4aa00f-menu']")
    public WebElement alleProdukte;

   @FindBy(xpath = "//*[@id=\"productList-64d945d9db5ea1d2fa0267ca\"]/a[2]/img")
    public WebElement schuheWishButton;

   @FindBy(css = "[class='icon-heart']")
    public WebElement heartButton;

   @FindBy(css = "[class='no-data text-center']")
    public WebElement emptyText;

   public void wishMethod(){


       schuheWishButton.click();
      heartButton.click();


   }

}
