package com.example.demo.jUnitTests.pages;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForBusinessPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"103\"]/div/a[4]")
    private WebElement businessCardOffer;

    public ForBusinessPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean isBusinessCardOffered() {
        return businessCardOffer.isDisplayed();
    }
}
