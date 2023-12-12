package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resource.testdata.TestData;

/**
 * 3. ComputerPageTest
 * Inside ComputerPageTest class create following testmethods
 * 1. verifyUserShouldNavigateToComputerPageSuccessfully()
 * Click on Computer tab
 * Verify "Computer" text
 * 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * Click on Computer tab
 * Click on Desktops link
 * Verify "Desktops" text
 * 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software)
 * Click on Computer tab
 * Click on Desktops link
 * Click on product name "Build your own computer"
 * Select processor "processor"
 * Select RAM "ram"
 * Select HDD "hdd"
 * Select OS "os"
 * Select Software "software"
 * Click on "ADD TO CART" Button
 * Verify message "The product has been added to your shopping cart"
 * DATA SET
 * | processor | ram | hdd | os | software |
 * | 2.2 GHz Intel Pentium Dual-Core E2200 | 2 GB | 320 GB | Vista Home [+$50.00] | Microsoft Office [+$50.00] |
 * | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00]| Vista Premium [+$60.00] | Acrobat Reader [+$10.00] |
 * | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB | Vista Home [+$50.00] | Total Commander [+$5.00] |
 */

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;
    ComputerPage computerPage;
    DeskTopPage deskTopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        deskTopPage = new DeskTopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() throws InterruptedException {

        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Verify "Computer" text
        String expectedMessage = "Computers";
        String actualMessage = computerPage.verifyComputerText();
        Assert.assertEquals(actualMessage,expectedMessage, "Message Displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Click on Desktops link
        computerPage.clickOnDeskTops();

        //Verify "Desktops" text
        String expectedMessage = "Desktops";
        String actualMessage = deskTopPage.verifyDeskTopsText();
        Assert.assertEquals(actualMessage,expectedMessage, "Message Displayed");
    }

    @Test(groups = {"regression"}, dataProvider = "dataSet", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        // Click on Computer tab
        homePage.clickOnComputerTab();

        // Click on Desktops link
        computerPage.clickOnDeskTops();

        // Click on product name "Build your own computer"
        deskTopPage.clickOnBuildYourOwnComputer();

        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);

        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);

        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);

        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);

        // Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);

        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();

        // Verify message "The product has been added to your shopping cart
        String expectedText = "The product has been added to your shopping cart";
        String actualText = buildYourOwnComputerPage.getMessageText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }
}




