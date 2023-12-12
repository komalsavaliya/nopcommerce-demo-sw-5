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
 * Test package.
 * create all packages and class that you created for page object model
 * In Testsuite package
 * create classes
 * 1.LoginPageTest
 * Inside LoginPageTest class create following testmethods
 * 1.userShouldNavigateToLoginPageSuccessFully().
 * Click on login link
 * verify that "Welcome, Please Sign In!" message display
 * 2. verifyTheErrorMessageWithInValidCredentials().
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that the Error message
 * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that LogOut link is display
 * 4. verifyThatUserShouldLogOutSuccessFully()
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Click on LogOut Link
 * Verify that LogIn Link Display
 */

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() throws InterruptedException {
        // Click on login link
        homePage.clickOnLoginLink();
        Thread.sleep(2000);

        //verify that "Welcome, Please Sign In!" message display
        loginPage.getWelcomeText();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login page not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailID("maryjohn@gmail.com");

        //Enter Password
        loginPage.enterPassword("John_123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() throws InterruptedException {

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

        //Select month
        registerPage.dateOfBirthMonth("June");

        //Select year
        registerPage.dateOfBirthYear("1966");

        //Enter email
        registerPage.enterEmail();
        Thread.sleep(2000);

        //Enter password
        registerPage.enterPassword("John_123");
        Thread.sleep(2000);

        //Enter Confirm Password
        registerPage.enterConfirmPassword("John_123");
        Thread.sleep(2000);

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify message "Your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.verifyMessageYourRegistrationCompleted();
        Assert.assertEquals(actualMessage, expectedMessage, "Message Displayed");
        Thread.sleep(2000);

        //Click on continue
        registerPage.clickOnContinue();

        //Click on login link
        homePage.clickOnLoginLink();
        Thread.sleep(2000);

        //Enter Email Id
        loginPage.enterEmailID(RegisterPage.generatedEmail);
        Thread.sleep(2000);

        //Enter Password
        loginPage.enterPassword("John_123");
        Thread.sleep(2000);

        //Click on Login Button
        loginPage.clickOnLoginButton1();
        Thread.sleep(2000);

        //Verify that LogOut link is display
        String expectedErrorMessage = "Log out";
        String actualErrorMessage = homePage.verifyLogOutLink();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "LogOut Link Is Not Displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Select gender "Female"
        registerPage.selectGender("Female");

        //Enter firstname
        registerPage.enterFirstName("Mary");
        Thread.sleep(2000);

        //Enter lastname
        registerPage.enterLastName("John");
        Thread.sleep(2000);

        //Select day
        registerPage.dateOfBirthDay("6");
        Thread.sleep(2000);

        //Select month
        registerPage.dateOfBirthMonth("June");
        Thread.sleep(2000);

        //Select year
        registerPage.dateOfBirthYear("1966");
        Thread.sleep(2000);

        //Enter email
        registerPage.enterEmail();
        Thread.sleep(2000);

        //Enter password
        registerPage.enterPassword("John_123");
        Thread.sleep(2000);

        //Enter Confirm Password
        registerPage.enterConfirmPassword("John_123");
        Thread.sleep(2000);

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        Thread.sleep(2000);

        //Verify message "Your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.verifyMessageYourRegistrationCompleted();
        Assert.assertEquals(actualMessage, expectedMessage, "Message Displayed");
        Thread.sleep(2000);

        //Click on login link
        homePage.clickOnLoginLink();

        //Enter Email Id
        loginPage.enterEmailID(RegisterPage.generatedEmail);

        //Enter Password
        loginPage.enterPassword("John_123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Click on LogOut Link
        homePage.clickOnLogOutLink();

        //Verify that LogIn Link Display
        String expectedErrorMessage = "Login";
        String actualErrorMessage = homePage.verifyLogOutLink();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message");
    }
}





