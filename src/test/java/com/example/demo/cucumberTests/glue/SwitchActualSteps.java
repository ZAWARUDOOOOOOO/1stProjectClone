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

public class SwitchActualSteps {

    private final WebDriver driver = StaticVariables.driver;

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Когда("прогружаются актуальные предложения")
    public void прогружаются_актуальные_предложения() {
        WebElement actualTable;
        actualTable = driver.findElement(By.xpath("//*[@id=\"2--tabpanel-0\"]/img"));
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
