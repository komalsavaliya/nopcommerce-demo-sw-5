package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 3.ComputerPage - Computers text, DesktopsLink, NotebooksLink,
 * SoftwareLink Locators and create appropriate methods for it.
 */

public class ComputerPage extends Utility {

    //Verify "Computer" text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement verifyComputerText;

    //Click on Desktops link
    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
    WebElement clickOnDeskTops;


    //___________________________________________________________________________________________________//

    public String verifyComputerText() {
        String message = getTextFromElement(verifyComputerText);
        CustomListeners.test.log(Status.PASS, "Computers");
        return message;
    }

    public void clickOnDeskTops(){
        clickOnElement(clickOnDeskTops);
    }


}
