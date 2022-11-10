package com.example.demo;

import com.example.demo.AbstractClasses.BaseSeleniumTest;
import com.example.demo.pages.TgLinkPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.example.demo.pages.MainPage;

public class MainPageTest extends BaseSeleniumTest {
    private MainPage mainPage;

    @Before
    public void init() {
        mainPage = new MainPage();
    }

    @Test
    public void checkMainPageLoading() {
        Boolean isMainPageLoaded = mainPage.loadedCorrectly();
        Assert.assertTrue(isMainPageLoaded);
    }

    @Test
    public void checkForBusinessButton() {
        Boolean displayedCorrectly = mainPage.goToForBusiness()
                .isBusinessCardOffered();
        Assert.assertTrue(displayedCorrectly);
    }

    @Test
    public void checkCardOffers() {
        Boolean displayedCorrectly = mainPage.isCardsOpenedCorrectly();
        Assert.assertTrue(displayedCorrectly);
    }

    @Test
    public void checkInternetBankButton() {
        Boolean displayedCorrectly = mainPage.goToInternetBank()
                .loginButtonDisplayed();
        Assert.assertTrue(displayedCorrectly);
    }

    @Test
    public void checkTgLearnMoreButton() {//написать баг репорт по driver.switchTo().alert().dismiss()
        TgLinkPage tgLinkPage = mainPage.goToTelegram();
        tgLinkPage.switchToWindow();
        Boolean isTgLogoDisplayed = tgLinkPage.isTgLogoDisplayed();
        Boolean isTgLinkCorrect = tgLinkPage.isTgLinkCorrect();
        Assert.assertTrue(isTgLogoDisplayed);
        Assert.assertTrue(isTgLinkCorrect);
    }

    @Test
    public void checkActualNewsSwitching() {
        Boolean isSwitchingCorrect = mainPage.isActualSwitchingCorrectly();
        Assert.assertTrue(isSwitchingCorrect);
    }

    @Test
    public void checkFinanceExchangeButton() {
        Boolean isExchangeInfoDisplayed = mainPage.goToFinanceExchange()
                .isConverterDisplayed();
        Assert.assertTrue(isExchangeInfoDisplayed);
    }

    @Test
    public void checkGooglePlayLink() {
        String developerName = mainPage.goToGooglePlay().getDeveloperName();
        Assert.assertEquals(developerName, "ПАО «Банк «Санкт-Петербург»");
    }
}
