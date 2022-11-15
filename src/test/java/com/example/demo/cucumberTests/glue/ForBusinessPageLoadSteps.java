package com.example.demo.cucumberTests.glue;

import com.example.demo.cucumberTests.StaticVariables;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class ForBusinessPageLoadSteps {

    private WebDriver driver = StaticVariables.driver;

    @Когда("пользователь заходит на сайт банка")
    public void пользователь_заходит_на_сайт_банка() {
        driver.get("https://bspb.ru/");
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
}
