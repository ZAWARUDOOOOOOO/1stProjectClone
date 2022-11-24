package com.example.demo.cucumberTests.glue;

import com.example.demo.cucumberTests.StaticVariables;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberSteps {

    private final WebDriver driver = StaticVariables.driver;

    @Когда("пользователь заходит на сайт")
    public void пользователь_заходит_на_сайт_банка() {
        driver.get("https://bspb.ru/");
    }

    @Тогда("^прогружаются хедер, актуальные предложения, рекомендованные продукты, футер$")
    public void прогружаются_хедер_актуальные_предложения_рекомендованные_продукты_футер() {
        boolean isHeaderDisplayed = driver
                .findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[2]"))
                .isDisplayed();
        boolean isActualTableDisplayed = driver
                .findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[2]"))
                .isDisplayed();
        boolean isRecommendedDisplayed = driver
                .findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[2]"))
                .isDisplayed();
        boolean isFooterDisplayed = driver
                .findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[2]"))
                .isDisplayed();
        boolean loadedCorrectly = isHeaderDisplayed & isActualTableDisplayed & isRecommendedDisplayed & isFooterDisplayed;

        assertThat(loadedCorrectly)
                .as("Загрузка главной страницы")
                .isTrue();
    }

    @Когда("нажимает кнопку \"Бизнесу\"")
    public void нажимает_кнопку_бизнесу() {
        WebElement businessButton = driver.findElement(By.xpath("//*[@href=\"/business\"]"));
        businessButton.click();
    }

    @Тогда("прогружается страница, на которой имеется предложение бизнес-карты")
    public void прогружается_страница_на_которой_имеется_предложение_бизнес_карты() {
        boolean isPageLoaded = driver.findElement(By.xpath("//*[@id=\"103\"]/div/a[4]")).isDisplayed();
        assertThat(isPageLoaded)
                .as("Отображение на странице предложения бизнес-карты")
                .isTrue();
    }

    @Когда("прогружаются актуальные предложения")
    public void прогружаются_актуальные_предложения() {
        WebElement actualTable;
        actualTable = driver.findElement(By.xpath("//*[@id=\"2--tabpanel-0\"]/img"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(actualTable));
    }

    @Тогда("нажимается кнопка \"пенсионное обслуживание\"")
    public void нажимается_кнопка_пенсионное_обслуживание() {
        driver.findElement(By.xpath("//*[contains(@class, \"chakra-tabs__tab \")][4]")).click();
    }

    @Тогда("в кнопке с текстом \"узнать больше\" появится нужная ссылка")
    public void в_кнопке_с_текстом_появится_нужная_ссылка() {
        boolean isLearnMoreButtonSwitchable = driver.findElement(By.xpath("//*[@href=\"/retail/pensionary/1000pens\"]")).isDisplayed();
        assertThat(isLearnMoreButtonSwitchable)
                .as("Изменение ссылки в кнопке \"Узнать больше\"")
                .isTrue();
    }
}
