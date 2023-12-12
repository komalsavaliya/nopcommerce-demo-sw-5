package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
//    public String randomEmail = randomEmail();
//    By emailAddressOption = By.id("Email");
//    public void enterEmailAddress(){
//        sendTextToElement(emailAddressOption, randomEmail);
//    }
//
//    private static String randomEmail() {
//
//        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
//    }
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

}


