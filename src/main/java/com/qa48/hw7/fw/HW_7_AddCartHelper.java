package com.qa48.hw7.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HW_7_AddCartHelper extends HW_7_BaseHelper {

    public HW_7_AddCartHelper(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        click(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
    }

    public void addBookToCart() {
        click(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input"));
    }

    public void clickOnBookButton() {
        click(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a"));
    }

    public int size0fBooksInCart() {
        List<WebElement> items = driver.findElements(By.cssSelector("input[name='removefromcart']"));
        return items.size();

    }
    public void clickUpdateShoppingCart() {
        click(By.cssSelector("input[name='updatecart']"));
    }

    public void clickOnTheProductCheckboxes() {
        click(By.cssSelector("input[name='removefromcart']"));
    }
}