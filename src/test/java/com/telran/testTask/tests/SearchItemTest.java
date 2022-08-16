package com.telran.testTask.tests;

import com.telran.testTask.models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {
    WebDriver wd;

    @Test
    public void searchItemTest() {
        app.getFirstPageHelper().selectMarket();
        app.getFirstPageHelper().switchToNextTab(1);
        app.getSelectCategoryHelper().selectDepartment("Экспресс");
        app.getFirstPageHelper().acceptCookies();
        app.getSelectCategoryHelper().selectCatalog("Электроника");
        app.getSelectCategoryHelper().selectCategoryType("Смартфоны и аксессуары");
        app.getItemHelper().filterItem(new Item().setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));
        app.getHeaderHelper().pause(30000);
        String itemName = app.getItemHelper().getItemNameFromListByNumber(3);
        // pause(10000);
        System.out.println(itemName);
        app.getHeaderHelper().typeInSearchInputField(itemName);
        app.getFirstPageHelper().pause(30000);
        String foundItemName = app.getItemHelper().getItemNameFromListByNumber(2);
        System.out.println(foundItemName);
        Assert.assertEquals(foundItemName, itemName);


    }
}
