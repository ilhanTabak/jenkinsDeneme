package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterPage extends BasePage{

 WebDriver driver;

    LoginPage loginpage=new LoginPage();
    Random randomNum2 = new Random();



    @FindBy(css = "[class=' icon-user-follow']")
    public WebElement anmeldung;

    @FindBy(css = "[id='FirstName']")
    public WebElement firstName;

    @FindBy(css = "[id='LastName']")
    public WebElement lastName;

    @FindBy(css = "[id='Email']")
    public WebElement eMail;

    @FindBy(css = "[id='Password']")
    public WebElement passwordRegister;

    @FindBy(css = "[id='ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//*[@id='T1']/div[6]/div/label/span[1]")
    public WebElement stimmeClick;

    @FindBy(css = "[id='LoginBtn']")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@id='cartWrapper']/div/div/div/div[3]")
    public WebElement RegisterText;

    @FindBy(css = "[class='field-validation-error']")
    public WebElement warnungObligatorisch;



    public void registerPageMethod(){

        BrowserUtils.waitFor(2);
        loginpage.acceptButton.click();
        BrowserUtils.waitFor(2);
        loginpage.userBox.click();
        BrowserUtils.waitFor(2);
        anmeldung.click();
        driver= Driver.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
        firstName.sendKeys("Soft");
        lastName.sendKeys("Skill");
        int randomNummer = randomSayi();
        eMail.sendKeys("abc" + randomNummer + "@gmail.com");
        passwordRegister.sendKeys("Test1234");
       confirmPassword.sendKeys("Test1234");
       stimmeClick.click();
       registerButton.click();

    }
    public int randomSayi() {
        int randomNummer2 = randomNum2.nextInt(10000);
        return randomNummer2;
    }

    public void registerNegative(String firstname,String lastname,String email,String password1,String password2){
        loginpage.acceptButton.click();
        loginpage.userBox.click();
        anmeldung.click();
        driver= Driver.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        eMail.sendKeys(email);
        passwordRegister.sendKeys(password1);
        confirmPassword.sendKeys(password2);
        stimmeClick.click();
        registerButton.click();
    }






}
