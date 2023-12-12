package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 2.HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link
 * and LogOut link locators and create appropriate methods for it.
 */

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']")
    WebElement topMenuBar;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement clickONComputerTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicsTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Electronics')]")
    WebElement electronicsPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement apparelPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloadTab;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement digitalDownloadPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement booksTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Books')]")
    WebElement booksPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelryTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Jewelry')]")
    WebElement jewelryPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCardsTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Gift Cards')]")
    WebElement giftCardsPageTitle;

    //Click on login link
    @CacheLookup
    @FindBy(className = "ico-login")
    WebElement loginLink;

    //Verify that LogOut link is display

    //Click on LogOut Link
    @CacheLookup
    @FindBy(className = "ico-logout")
    WebElement logoutLink;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Welcome to our store']")
    WebElement welcomeToOurStoreMessage;

    @CacheLookup
    @FindBy(className = "ico-register")
    WebElement clickOnRegisterLink;
//------------------------------------------------------------------------------------------//

    public void clickOnComputerTab(){
        clickOnElement(clickONComputerTab);
    }



    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public String verifyLogOutLink() {
        String message = getTextFromElement(logoutLink);
        CustomListeners.test.log(Status.PASS, "LogOut ");
        return message;
    }
    public void clickOnLogOutLink() {
        clickOnElement(logoutLink);
    }
    public void clickOnRegisterLink() {
        clickOnElement(clickOnRegisterLink);
    }

}