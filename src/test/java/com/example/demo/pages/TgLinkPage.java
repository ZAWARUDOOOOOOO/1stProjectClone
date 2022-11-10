package com.example.demo.pages;

import com.example.demo.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TgLinkPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@class=\"tgme_logo\"]")
    private WebElement tgLogo;

    @FindBy(xpath = "//a[contains(@class, \"tgme_action_web_button\")]")
    private WebElement tgWebLink;

    public TgLinkPage() {
        PageFactory.initElements(driver, this);
    }

    public void switchToWindow() {
        List<String> allWindowsArray = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindowsArray.get(1));
    }

    public Boolean isTgLinkCorrect() {
        return tgWebLink.getAttribute("href")
                .equals("https://web.telegram.org/z/#?tgaddr=tg%3A%2F%2Fresolve%3Fdomain%3Dmybspb");
    }

    public Boolean isTgLogoDisplayed() {
        return tgLogo.isDisplayed();
    }
}
