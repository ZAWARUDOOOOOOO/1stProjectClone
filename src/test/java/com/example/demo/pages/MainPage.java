package com.example.demo.pages;

import com.example.demo.AbstractClasses.BaseSeleniumPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BaseSeleniumPage {

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/div[2]")
    private WebElement header;

    @FindBy(xpath = "//*[@href=\"/business\"]")
    private WebElement businessButton;

    @FindBy(xpath = "//*[@id=\"popover-trigger-4\"]")
    private WebElement cards;

    @FindBy(xpath = "(//*[@href=\"https://t.me/mybspb\"])[1]")
    private WebElement learnMoreAboutTgButton;

    @FindBy(xpath = "//*[@id=\"2--tabpanel-0\"]/img")
    private WebElement actualTable;

    @FindBy(xpath = "//*[@id=\"6\"]/div/a")
    private WebElement actualTableMoreButton;

    @FindBy(xpath = "//*[contains(@class, \"chakra-tabs__tab \")][4]")
    private WebElement pensionServiceTab;

    @FindBy(xpath = "//*[@id=\"102\"]/div")
    private WebElement recommended;

    @FindBy(xpath = "//*[@id=\"102\"]/div/a[1]")
    private WebElement recommendedInternetBank;

    @FindBy(xpath = "//*[contains(@class, \"css-1erssxx\")]")
    private WebElement financeExchangeButton;

    @FindBy(xpath = "//*[@id=\"1\"][2]")
    private WebElement footer;

    @FindBy(xpath = "(//a[contains(@href,\"play.google\")])[2]")
    private WebElement footerGooglePlayButton;

    public MainPage() {
        driver.get("https://bspb.ru/");
        PageFactory.initElements(driver, this);
    }

    public Boolean loadedCorrectly() {
        Boolean isHeaderDisplayed = header.isDisplayed();
        Boolean isActualTableDisplayed = actualTable.isDisplayed();
        Boolean isRecommendedDisplayed = recommended.isDisplayed();
        Boolean isFooterDisplayed = footer.isDisplayed();
        return isHeaderDisplayed & isActualTableDisplayed & isRecommendedDisplayed & isFooterDisplayed;
    }

    public Boolean isCardsOpenedCorrectly() {
        Actions action = new Actions(driver);
        action.moveToElement(cards).perform();
        Boolean isDebitCardsButtonDisplayed = driver.findElement(By.xpath("//*[@href=\"/retail/cards/debit\"]")).isDisplayed();
        return isDebitCardsButtonDisplayed;
    }

    public Boolean isActualSwitchingCorrectly() {
        pensionServiceTab.click();
        Boolean isLearnMoreButtonSwitchable = driver.findElement(By.xpath("//*[@href=\"/retail/pensionary/1000pens\"]")).isDisplayed();
        return isLearnMoreButtonSwitchable;
    }

    public InternetBankPage goToInternetBank() {
        recommendedInternetBank.click();
        return new InternetBankPage();
    }

    public ForBusinessPage goToForBusiness() {
        businessButton.click();
        return new ForBusinessPage();
    }

    public TgLinkPage goToTelegram() {
        learnMoreAboutTgButton.click();
        return new TgLinkPage();
    }

    public FinanceExchangePage goToFinanceExchange() {
//        Point point = financeExchangeButton.getLocation();//top left corner coordinates
//        Dimension dimension = financeExchangeButton.getSize();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(financeExchangeButton)
//                .click()
//                .build().perform();

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", financeExchangeButton);
        return new FinanceExchangePage();
    }

    public GooglePlayBspbPage goToGooglePlay() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerGooglePlayButton);
//        wait.until(ExpectedConditions.elementToBeClickable(footerGooglePlayButton));
//        wait.until(ExpectedConditions.visibilityOf(footerGooglePlayButton));
//        footerGooglePlayButton.click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", footerGooglePlayButton); //works
        return new GooglePlayBspbPage();
    }
}
