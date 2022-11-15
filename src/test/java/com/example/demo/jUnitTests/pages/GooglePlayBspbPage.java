package com.example.demo.jUnitTests.pages;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePlayBspbPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@aria-label=\"Логотип Google Play\"]")
    private WebElement googlePlayHeader;

    @FindBy(xpath = "//*[contains(@href, \"/store/apps/developer\")]")
    private WebElement developer;

    public GooglePlayBspbPage() {
        PageFactory.initElements(driver, this);
        //Перевод фокуса на новую страницу
        List<String> allWindowsArray = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindowsArray.get(1));
    }

    public String getDeveloperName() {
        return developer.getText();
    }

    public Boolean isGpHeaderDisplayed(){
        return googlePlayHeader.isDisplayed();
    }
}
