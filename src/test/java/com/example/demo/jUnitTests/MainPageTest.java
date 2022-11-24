package com.example.demo.jUnitTests;

import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumTest;
import com.example.demo.jUnitTests.pages.GooglePlayBspbPage;
import com.example.demo.jUnitTests.pages.MainPage;
import com.example.demo.jUnitTests.pages.TgLinkPage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.assertThat;

//@DisabledOnOs(OS.WINDOWS)
public class MainPageTest extends BaseSeleniumTest {
    private MainPage mainPage;

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Before
    public void init() {
        mainPage = new MainPage();
    }

    @Test
    public void checkMainPageLoading() {
        boolean isMainPageLoaded = mainPage.loadedCorrectly();
        assertThat(isMainPageLoaded)
                .as("Загрузка главной страницы")
                .isTrue();
    }

    @Test
    public void checkForBusinessButton() {
        boolean displayedCorrectly = mainPage.goToForBusiness()
                .isBusinessCardOffered();
        assertThat(displayedCorrectly)
                .as("Отображение выпадающего меню \"Бизнесу\"")
                .isTrue();
    }

    @Test
    public void checkCardOffers() {
        boolean displayedCorrectly = mainPage.isCardsOpenedCorrectly();
        assertThat(displayedCorrectly)
                .as("Отображение выпадающего меню \"Карты\"")
                .isTrue();
    }

    @Test
    public void checkInternetBankButton() {
        boolean displayedCorrectly = mainPage.goToInternetBank()
                .loginButtonDisplayed();
        assertThat(displayedCorrectly)
                .as("Отображение окна \"Интернет-банк\"")
                .isTrue();
    }

    //иногда падает, похоже, что телеграм иногда лагает и не грузится
    @Test
    public void checkTgLearnMoreButton() { //как работать с тг алертом
        TgLinkPage tgLinkPage = mainPage.goToTelegram();
        tgLinkPage.switchToWindow();
        boolean isTgLogoDisplayed = tgLinkPage.isTgLogoDisplayed();
        boolean isAppButtonDisplayed = tgLinkPage.isTgAppButtonDisplayed();
        softly.assertThat(isTgLogoDisplayed)
                .as("Отображение логотипа \"Телеграма\"")
                .isTrue();
        softly.assertThat(isAppButtonDisplayed)
                .as("Отображение кнопки \"Узнать больше\"")
                .isTrue();
    }

    @Test
    public void checkActualSwitching() {
        boolean isSwitchingCorrect = mainPage.isActualSwitchingCorrectly();
        assertThat(isSwitchingCorrect)
                .as("Переключение актуальных предложений")
                .isTrue();
    }

    @Test
    public void checkFinanceExchangeButton() {
        boolean isExchangeInfoDisplayed = mainPage.goToFinanceExchange()
                .isConverterDisplayed();
        assertThat(isExchangeInfoDisplayed)
                .as("Переход на страницу \"Обмен валюты\"")
                .isTrue();
    }

    @Test
    public void checkGooglePlayLink() {
        GooglePlayBspbPage gpPage = mainPage.goToGooglePlay();
        boolean isGpHeaderDisplayed = gpPage.isGpHeaderDisplayed();
        String developerName = gpPage.getDeveloperName();
        softly.assertThat(isGpHeaderDisplayed)
                .as("Отображения хедера Google Play")
                .isTrue();
        softly.assertThat(developerName)
                .as("Проверка имени разработчика банковского приложения")
                .isEqualTo("ПАО «Банк «Санкт-Петербург»");
    }
}
