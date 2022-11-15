package com.example.demo.jUnitTests.pages;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinanceExchangePage extends BaseSeleniumPage {

    @FindBy(xpath = "(//*[contains(@class, \"css-1kz2xbf\")])[1]")
    private WebElement usdToRubInfoField;

    @FindBy(xpath = "(//*[contains(@class, \"css-1kz2xbf\")])[3]")
    private WebElement rubToUsdInfoField;

    public FinanceExchangePage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean isConverterDisplayed() {
        Boolean isUsdToRubInfoDisplayed = usdToRubInfoField.isDisplayed();
        Boolean isRubToUsdInfoDisplayed = rubToUsdInfoField.isDisplayed();
        return isUsdToRubInfoDisplayed & isRubToUsdInfoDisplayed;
    }
}
