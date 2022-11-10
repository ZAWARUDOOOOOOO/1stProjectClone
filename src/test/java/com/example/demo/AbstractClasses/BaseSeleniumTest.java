package com.example.demo.AbstractClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();//скачивает хром драйвер и прописывает его во всех путях для использования
        driver = new ChromeDriver();
        driver.manage().window().maximize();//запуск браузера на весь экран
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//Ожидание страницы 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();//Закрывает драйвер
        driver.quit();//Закрывает браузер
    }

}
