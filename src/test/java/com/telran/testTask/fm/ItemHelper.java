package com.telran.testTask.fm;

import com.telran.testTask.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ItemHelper extends HelperBase {

    public ItemHelper(WebDriver wd){
        super(wd);
    }
    public String getItemNameFromListByNumber(int number) {
        return wd.findElement(By.cssSelector("div:nth-child("+number+") ._2UHry")).getText();
    }

    public void filterItem(Item item) {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        type(By.cssSelector("._1heDd:nth-child(1) ._3qxDp"), item.getPriceFrom());
        type(By.cssSelector("._1heDd:nth-child(2) ._3qxDp"), item.getPriceTo());
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }
}
