package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * 6.RegisterPage - Register Text, male female radio, Firstname, lastname, Date of Birth drop down, email, Password, Confirm Password, Register Button, "First name is required.","Last name is required.", "Email is required.","Password is required.", "Password is required." error message,
 * "Your registration completed" message, "CONTINUE" button
 * Locators and it's actions
 */

public class RegisterPage extends Utility {
    //Click on Register Link
    @CacheLookup
    @FindBy(tagName = "h1")
    WebElement verifyRegisterText;

    //Click on "REGISTER" button
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement clickOnRegisterButton;

    //Verify the error message "First name is required
    @CacheLookup
    @FindBy(id = "FirstName-error")
    WebElement verifyErrorMessageFirstNameIsRequired;

    //Verify the error message "Last name is required."
    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement verifyErrorMessageLastNameIsRequired;

    //Verify the error message "Email is required."
    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement verifyErrorMessageEmailIsRequired;

    //Verify the error message "Password is required."
    @CacheLookup
    @FindBy(id = "Password-error")
    WebElement verifyErrorMessagePasswordIsRequired;

    //Verify the error message "ConfirmPassword is required."
    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement verifyErrorMessageConfirmPasswordIsRequired1;

    //Select gender "Male"
    @CacheLookup
    @FindBy(id = "gender-male")
    WebElement genderMale;

    //Select gender "Female"
    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement genderFemale;

    //Enter firstname
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement enterFirstName;

    //Enter Lastname
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement enterLastName;

    //Select day
    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;

    //Select month
    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirthDay;

    //Select year
    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthDay;

    //Enter Email
    @CacheLookup
    @FindBy(id = "Email")
    WebElement enterEmailId;

    //Enter password
    @CacheLookup
    @FindBy(id = "Password")
    WebElement enterPassword;


    //Enter Confirm Password
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement enterConfirmPassword;

    //Click on continue
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

  //Verify message "Your registration completed"
  @CacheLookup
  @FindBy(className = "result")
  WebElement verifyMessageYourRegistrationCompleted;

    //_____________________________________________________________________________//


    public String getVerifyRegisterText() {
        String message = getTextFromElement(verifyRegisterText);
        CustomListeners.test.log(Status.PASS, "Register ");
        return message;
    }

    public void clickOnRegisterButton() {
        clickOnElement(clickOnRegisterButton);
    }

    public String verifyErrorMessageFirstNameIsRequired() {
        String message = getTextFromElement(verifyErrorMessageFirstNameIsRequired);
        CustomListeners.test.log(Status.PASS, "First name is required. ");
        return message;
    }


    public String verifyErrorMessageLastNameIsRequired() {
        String message = getTextFromElement(verifyErrorMessageLastNameIsRequired);
        CustomListeners.test.log(Status.PASS, "Last name is required.");
        return message;
    }

    public String verifyErrorMessageEmailIsRequired() {
        String message = getTextFromElement(verifyErrorMessageEmailIsRequired);
        CustomListeners.test.log(Status.PASS, "Email is required.");
        System.out.println(message);
        return message;

    }

    public String verifyErrorMessagePasswordIsRequired() {
        String message = getTextFromElement(verifyErrorMessagePasswordIsRequired);
        CustomListeners.test.log(Status.PASS, "Password is required.");
        return message;
    }

    public String verifyErrorMessagePasswordIsRequired1() {
        String message = getTextFromElement(verifyErrorMessageConfirmPasswordIsRequired1);
        CustomListeners.test.log(Status.PASS, "Password is required.");
        return message;
    }

    public void selectGender(String maleOrFemale) {
        CustomListeners.test.log(Status.PASS, "Select gender." + maleOrFemale);
        switch (maleOrFemale) {
            case "Male":
                clickOnElement(genderMale);
                break;
            case "Female":
                clickOnElement(genderFemale);
                break;
            default:
                break;
        }
    }

    public void enterFirstName(String firstname) {
        sendTextToElement(enterFirstName,firstname);
    }

    public void enterLastName(String lastname) {
        sendTextToElement(enterLastName,lastname);
    }

    public void dateOfBirthDay(String day) {
        CustomListeners.test.log(Status.PASS, "Enter day for date of birth." + day);
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
    }

    public void dateOfBirthMonth(String month) {
        CustomListeners.test.log(Status.PASS, "Enter month for date of birth." + month);
        selectByVisibleTextFromDropDown(monthOfBirthDay, month);
    }

    public void dateOfBirthYear(String year) {
        CustomListeners.test.log(Status.PASS, "Enter year for date of birth." + year);
        selectByVisibleTextFromDropDown(yearOfBirthDay, year);
    }

//    public void enterEmailID(String email) {
//        sendTextToElement(enterEmail, email);
//        CustomListeners.test.log(Status.PASS, "Enter EmailId" + email);
//    }
public static String generatedEmail;

    public void enterEmail() {
        Random randomPartOfEmailGenerator = new Random(5000);
        int randomNumberInEmail = randomPartOfEmailGenerator.nextInt();
        //random string generator - to use in email
        RandomString randomString = new RandomString(5);
        String randomStringInEmailGenerator = randomString.nextString();
        generatedEmail = "mary" + randomNumberInEmail + randomStringInEmailGenerator + "john@gmail.com";
        sendTextToElement(enterEmailId, generatedEmail);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + generatedEmail);
    }

    public void enterPassword(String  password) {
        sendTextToElement(enterPassword,"Password");
    }
    public void enterConfirmPassword(String  confirmPassword) {
        sendTextToElement(enterConfirmPassword,"Password");
    }

    public String verifyMessageYourRegistrationCompleted() {
        String message = getTextFromElement(verifyMessageYourRegistrationCompleted);
        CustomListeners.test.log(Status.PASS, "Your registration completed");
        return message;
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }
}
