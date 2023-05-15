package com.lamansys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayPage {

    private WebDriver driver;
    private By searchTextBox = By.id("gh-ac");
    private By searchBtn = By.id("gh-btn");
    private By firstPrice = By.xpath("(//span[@class='s-item__price'])[2]");


    public EbayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchGuitar(String searchText) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(searchTextBox).sendKeys(searchText);
    }

    public void btnSearch() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(searchBtn).click();
    }

    public String getFirstPrice() {
        String price = "";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        price = driver.findElement(firstPrice).getText();
        return price;
    }

}
