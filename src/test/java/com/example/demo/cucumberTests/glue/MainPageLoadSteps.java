package com.example.demo.cucumberTests.glue;

import com.example.demo.cucumberTests.StaticVariables;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageLoadSteps {

    private final WebDriver driver = StaticVariables.driver;

    @FindBy(xpath = "//*[@id=\"app-wrapper\"]/div[2]")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"2--tabpanel-0\"]/img")
    private WebElement actualTable;

    @FindBy(xpath = "//*[@id=\"102\"]/div")
    private WebElement recommended;

    @FindBy(xpath = "//*[@id=\"1\"][2]")
    private WebElement footer;

    public boolean loadedCorrectly() {
        boolean isHeaderDisplayed = header.isDisplayed();
        boolean isActualTableDisplayed = actualTable.isDisplayed();
        boolean isRecommendedDisplayed = recommended.isDisplayed();
        boolean isFooterDisplayed = footer.isDisplayed();
        return isHeaderDisplayed & isActualTableDisplayed & isRecommendedDisplayed & isFooterDisplayed;
    }

    @Когда("^пользователь заходит на сайт$")
    public void пользователь_заходит_на_сайт() {
        PageFactory.initElements(driver, this);
        driver.get("https://bspb.ru/");
    }

    @Тогда("^прогружаются хедер, актуальные предложения, рекомендованные продукты, футер$")
    public void прогружаются_хедер_актуальные_предложения_рекомендованные_продукты_футер() {
        assertThat(loadedCorrectly())
                .as("Загрузка главной страницы")
                .isTrue();
    }
}
