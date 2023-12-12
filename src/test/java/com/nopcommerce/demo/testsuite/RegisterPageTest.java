package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2. RegisterPageTest
 * Inside RegisterPageTest class create following testmethods
 * 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
 * Click on Register Link
 * Verify "Register" text
 * 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
 * Click on Register Link
 * Click on "REGISTER" button
 * Verify the error message "First name is required."
 * Verify the error message "Last name is required."
 * Verify the error message "Email is required."
 * Verify the error message "Password is required."
 * Verify the error message "Password is required."
 * 2. verifyThatUserShouldCreateAccountSuccessfully()
 * Click on Register Link
 * Select gender "Female"
 * Enter firstname
 * Enter lastname
 * Select day
 * Select month
 * Select year
 * Enter email
 * Enter password
 * Enter Confirm Password
 * Click on "REGISTER" button
 * Verify message "Your registration completed"
 */

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;


    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Verify "Register" text
        String expectedMessage = "Register";
        String actualMessage = registerPage.getVerifyRegisterText();
        Assert.assertEquals(expectedMessage, actualMessage, "verifyRegisterText");
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() throws InterruptedException {

        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        Thread.sleep(3000);

        //Verify the error message "First name is required."
        String expectedErrorMessage = "First name is required.";
        String actualErrorMessage = registerPage.verifyErrorMessageFirstNameIsRequired();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage, "Error Message");
        //registerPage.verifyErrorMessageFirstNameIsRequired("First name is required.");
        Thread.sleep(3000);

        //Verify the error message "Last name is required."
        String expectedErrorMessage1 = "Last name is required.";
        String actualErrorMessage1 = registerPage.verifyErrorMessageLastNameIsRequired();
        Assert.assertEquals(actualErrorMessage1,expectedErrorMessage1, "Error Message");
        Thread.sleep(3000);

        //Verify the error message "Email is required."
        String expectedErrorMessage2 = "Email is required.";
        String actualErrorMessage2 = registerPage.verifyErrorMessageEmailIsRequired();
        Assert.assertEquals(actualErrorMessage2,expectedErrorMessage2, "Error Message");
        Thread.sleep(3000);

        //Verify the error message "Password is required."
        String expectedErrorMessage3 = "Password is required.";
        String actualErrorMessage3 = registerPage.verifyErrorMessagePasswordIsRequired();
        Assert.assertEquals(actualErrorMessage3,expectedErrorMessage3, "Error Message");
        registerPage.verifyErrorMessagePasswordIsRequired();
        Thread.sleep(3000);

        //Verify the error message "Password is required."
        String expectedErrorMessage4 = "Password is required.";
        String actualErrorMessage4 = registerPage.verifyErrorMessagePasswordIsRequired1();
        Assert.assertEquals(actualErrorMessage4,expectedErrorMessage4, "Error Message");
        registerPage.verifyErrorMessagePasswordIsRequired1();
        Thread.sleep(3000);
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Select gender "Female"
        registerPage.selectGender("Female");

        //Enter firstname
        registerPage.enterFirstName("Mary");

        //Enter lastname
        registerPage.enterLastName("John");

        //Select day
        registerPage.dateOfBirthDay("6");
        Thread.sleep(2000);

        //Select month
        registerPage.dateOfBirthMonth("June");

        //Select year
        registerPage.dateOfBirthYear("1966");

        //Enter email
        registerPage.enterEmail();

        //Enter password
        registerPage.enterPassword("John_123");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("John_123");

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        // Verify message "Your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.verifyMessageYourRegistrationCompleted();
        Assert.assertEquals(expectedMessage, actualMessage, "Message Displayed");
    }
}
