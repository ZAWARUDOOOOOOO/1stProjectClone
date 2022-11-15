package com.example.demo.jUnitTests.pages;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TgLinkPage extends BaseSeleniumPage {


    @FindBy(xpath = "//*[@class=\"tgme_logo\"]")
    private WebElement tgLogo;

    @FindBy(xpath = "//a[@class=\"tgme_action_button_new shine\"]")
    private WebElement tgAppButton;

    public TgLinkPage() {
        PageFactory.initElements(driver, this);
    }

    public void switchToWindow() {
//        driver.switchTo().alert().accept();
        List<String> allWindowsArray = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindowsArray.get(1));
    }



    public Boolean isTgAppButtonDisplayed() {
        return tgAppButton.isDisplayed();
    }

    public Boolean isTgLogoDisplayed() {
        return tgLogo.isDisplayed();
    }
}
