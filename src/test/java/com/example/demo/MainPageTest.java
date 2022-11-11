package com.example.demo;

import com.example.demo.AbstractClasses.BaseSeleniumTest;
import com.example.demo.pages.GooglePlayBspbPage;
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

    //иногда падает, похоже, что телеграм иногда лагает и не грузится
    @Test
    public void checkTgLearnMoreButton() { //как работать с тг алертом
        TgLinkPage tgLinkPage = mainPage.goToTelegram();
        tgLinkPage.switchToWindow();
        Boolean isTgLogoDisplayed = tgLinkPage.isTgLogoDisplayed();
        Boolean isAppButtonDisplayed = tgLinkPage.isTgAppButtonDisplayed();
        Assert.assertTrue(isTgLogoDisplayed);
        Assert.assertTrue(isAppButtonDisplayed);
    }

    @Test
    public void checkActualSwitching() {
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
        GooglePlayBspbPage gpPage = mainPage.goToGooglePlay();
        Boolean isGpHeaderDisplayed = gpPage.isGpHeaderDisplayed();
        String developerName = gpPage.getDeveloperName();
        Assert.assertTrue(isGpHeaderDisplayed);
        Assert.assertEquals(developerName, "ПАО «Банк «Санкт-Петербург»", developerName);
    }
}
