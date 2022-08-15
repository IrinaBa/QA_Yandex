package com.telran.testTask.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectCategoryHelper extends HelperBase {

    public SelectCategoryHelper(WebDriver wd){
        super(wd);
    }
    public void selectCategoryType(String categoryType) {
        click(By.xpath("//a[contains(text(),'" + categoryType + "')]"));
    }

    public void selectCatalog(String category) {
        click(By.xpath("//a[contains(text(),'" + category + "')]"));
    }

    public void selectDepartment(String department) {
        click(By.xpath("//span[contains(text(),'" + department + "')]"));
    }
}
