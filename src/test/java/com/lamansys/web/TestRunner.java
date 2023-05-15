package com.lamansys.web;

import com.lamansys.pages.EbayPage;
import com.lamansys.pages.HomePage;
import com.lamansys.pages.LoginPage;
import com.lamansys.utils.ConfigReader;
import com.lamansys.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRunner {
    private WebDriver driver;

    private ConfigReader configReader;
    private LoginPage loginPage;

    private HomePage homePage;

    private EbayPage ebayPage;


    @BeforeClass
    public void setUp() {
        configReader = new ConfigReader();
        driver = DriverFactory.getDriver(configReader.getProperty("browser"));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        ebayPage = new EbayPage(driver);
    }

    //@Ignore
    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/inventory.html");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertFalse(homePage.getHomeTittle(driver),"No se muestra la pagina principal");
    }

    @Test
    public void testSuccessfulSearch() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        ebayPage.searchGuitar("guitarra electrica");
        ebayPage.btnSearch();
        System.out.println("Precio "+ ebayPage.getFirstPrice());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
