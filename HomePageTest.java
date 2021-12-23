package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {
    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String hpTitle = homePage.getHomePageTitle();
        System.out.println(hpTitle);
        Assert.assertEquals(hpTitle, Constants.HOME_PAGE_TITLE, "Homepage title is missing" );
    }

    @Test(priority = 2)
    public void verifyLogOutLinkTest(){
        Assert.assertTrue(homePage.isLogOutLinkPresent(), "Log out link not present");
        String logOutLink = homePage.getLogOutText();
        System.out.println("Log out link is: "+ logOutLink);
        Assert.assertEquals(logOutLink, Constants.HOME_PAGE_LOGOUT, "Log out text mismatch" );
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}


