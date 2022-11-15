package com.example.demo.jUnitTests.pages;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankPage extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@id=\"39\"]/div/div[3]/a[1]")
    private WebElement login;

    public InternetBankPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean loginButtonDisplayed() {
        return driver.findElement(By.xpath("//*[@id=\"39\"]/div/div[3]/a[1]")).isDisplayed();
    }
}
