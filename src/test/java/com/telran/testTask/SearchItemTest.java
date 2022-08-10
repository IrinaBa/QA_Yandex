package com.telran.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchItemTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void searchItemTest() {
        wd.findElement(By.cssSelector("[data-id='market']")).click();
        switchToNextTab(1);
        wd.findElement(By.xpath("//span[contains(text(),'Экспресс')]")).click();

        //wd.findElement(By.xpath("//span[contains(text(),'Электроника')]")).click();

        wd.findElement(By.xpath("//a[contains(text(),'Смартфоны и аксессуары')]")).click();


    }


    public void switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(number));
        }
    }
}
