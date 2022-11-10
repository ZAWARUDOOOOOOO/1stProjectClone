package com.example.demo.pages;

import com.example.demo.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePlayBspbPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@aria-label=\"Логотип Google Play\"]")
    private WebElement googlePlayHeader;

    @FindBy(xpath = "//*[contains(@href, \"/store/apps/developer\")]")
    private WebElement developer;

    public GooglePlayBspbPage() {
        PageFactory.initElements(driver, this);
    }

    public String getDeveloperName(){
        return developer.getText();
    }
}
