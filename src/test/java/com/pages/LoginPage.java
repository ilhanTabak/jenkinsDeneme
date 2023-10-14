package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    WebDriver driver;

    @FindBy(css = "[id='cookie-ok']")
    public WebElement acceptButton;
    @FindBy(css = "[class='icon-user']")
    public WebElement userBox;
    @FindBy(css = "[class='userlink-login']")
    public WebElement anmelden;
    @FindBy(css = "[type='email']")
    public WebElement userName;
    @FindBy(css = "[type='password']")
    public WebElement password;
    @FindBy(css = "[id='LoginBtn']")
    public WebElement anmeldenButton;
    @FindBy(css = "[title='My Account']")
    public WebElement meinKonto;

    //Aşağıdaki web element Pasaport veya Şifre yanlış girildiğinde hata vermediğinden hala Login olunmadığını
    //kanıtlamak için!!! Eğer logoutButton var ise zaten login olunmuştur.
    @FindBy(xpath = "//*[@id=\"userBox\"]/div/div[2]/a[3]")
    public WebElement logoutButton;

    public void loginMethod() {
        acceptButton.click();
        userBox.click();
        BrowserUtils.waitFor(1);
        anmelden.click();

        driver = Driver.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");

        userName.sendKeys(ConfigurationReader.get("loginEmail"));
        password.sendKeys(ConfigurationReader.get("loginPassword"));
        BrowserUtils.waitFor(1);
        anmeldenButton.click();

        loginVerification();
    }

    public void loginNegativTest(String Email, String Password) {
        userName.sendKeys(Email);
        password.sendKeys(Password);
        BrowserUtils.waitFor(1);
        anmeldenButton.click();
    }

    public void loginVerification() {
        userBox.click();
        BrowserUtils.verifyElementDisplayed(logoutButton);
    }

    public void loginErrorMessage() {
        //Eğer Password giriş kutusu görünüyorsa login olunmamış demektir.
        //Error mesaj hiçbir şekilde alınmıyor.
        BrowserUtils.verifyElementDisplayed(password);
    }
}