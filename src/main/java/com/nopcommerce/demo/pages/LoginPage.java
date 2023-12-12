package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * baseUrl :https://demo.nopcommerce.com/
 * Page Object project with page factory with extent report, Use data provider, create runner.xml file to run test
 * Project name: nop-commerce-demo
 * Group-Id : com.nopcommerce.demo
 * Main package.
 * create all packages and class that you created for page object model
 * In Pages package
 * 1.LoginPage - Email, password, Login Button and "Welcome, Please Sign In!" text Locators and create appropriate methods for it.
 */

public class LoginPage extends Utility {
    //verify that "Welcome, Please Sign In!" message display
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement verifyWelcomeText;

    //Enter EmailId
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    //Enter Password
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    //Click on Login Button
   @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginButton;

   //Verify that the Error message
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginButton1;

    public String getWelcomeText(){
        String message = getTextFromElement(verifyWelcomeText);
        return message;
    }

    public void enterEmailID(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId" + email);
    }


    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password" +password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getErrorMessage(){
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"Get errorMessage");
        return message;
    }

    public void clickOnLoginButton1() {
        clickOnElement(loginButton1);
    }

}




