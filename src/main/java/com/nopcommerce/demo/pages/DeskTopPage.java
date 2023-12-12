package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 4.DesktopsPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions
 */
public class DeskTopPage extends Utility {

    //Verify "Desktops" text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement verifyDeskTopsText;

    //Click on product name "Build your own computer"
    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement clickOnBuildYourOwnComputer;

    //___________________________________________________________________________//
    public String verifyDeskTopsText() {
        String message = getTextFromElement(verifyDeskTopsText);
        CustomListeners.test.log(Status.PASS, "Desktops");
        return message;
    }
    public void clickOnBuildYourOwnComputer(){
        clickOnElement(clickOnBuildYourOwnComputer);
    }
}