package com.example.demo.cucumberTests.hooks;

import com.example.demo.cucumberTests.StaticVariables;
import com.example.demo.jUnitTests.AbstractClasses.BaseSeleniumPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();//скачивает хром драйвер и прописывает его во всех путях для использования
        StaticVariables.driver = new ChromeDriver();
        driver = StaticVariables.driver;
        driver.manage().window().maximize();//запуск браузера на весь экран
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//Ожидание страницы 10 секунд
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    @After
    public void tearDown() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.close();//Закрывает драйвер
        driver.quit();//Закрывает браузер
    }
}
