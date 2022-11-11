package com.example.demo.pages;

import com.example.demo.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TgLinkPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@class=\"tgme_logo\"]")
    private WebElement tgLogo;

    @FindBy(xpath = "//a[@class=\"tgme_action_button_new shine\"]")
    private WebElement tgAppButton;

    public TgLinkPage() {
        PageFactory.initElements(driver, this);
    }

    public void switchToWindow() {
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
