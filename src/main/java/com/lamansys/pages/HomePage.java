package com.lamansys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private static By homeTittle = By.xpath("//div[@class='app_logo']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean getHomeTittle(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(homeTittle).isDisplayed();
    }

}
