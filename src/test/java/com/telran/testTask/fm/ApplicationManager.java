package com.telran.testTask.fm;

import com.telran.testTask.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   // WebDriver wd;
    EventFiringWebDriver wd;

    ItemHelper itemHelper;
    HeaderHelper headerHelper;
    FirstPageHelper firstPageHelper;
    SelectCategoryHelper selectCategoryHelper;


    public void init() {
       // wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.navigate().to("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        itemHelper = new ItemHelper(wd);
        headerHelper = new HeaderHelper(wd);
        firstPageHelper = new FirstPageHelper(wd);
        selectCategoryHelper = new SelectCategoryHelper(wd);

        wd.register(new MyListener());
    }

    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public FirstPageHelper getFirstPageHelper() {
        return firstPageHelper;
    }

    public SelectCategoryHelper getSelectCategoryHelper() {
        return selectCategoryHelper;
    }

    public void stop() {
        wd.quit();

    }
}
