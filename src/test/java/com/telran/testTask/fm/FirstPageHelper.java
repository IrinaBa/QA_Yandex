package com.telran.testTask.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPageHelper extends HelperBase {

    public FirstPageHelper(WebDriver wd){
        super(wd);
    }
    public void selectMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }
}
