package com.demo.nopcommerce;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.utils.Constants;
import com.demo.nopcommerce.utils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {

    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeTest  // BeforeTest for only 1 browser
    public void openBrowser() throws InterruptedException{
        basePage = new BasePage(); //I will initialise basePage here.
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        registerPage = loginPage.doRegister();
    }
    @Test(priority = 1)
    public void verifyRegisterPageTitle(){
        String title = registerPage.getRegisterPageTitle();
        System.out.println("Registration Page title is: " + title);
        Assert.assertEquals(title, Constants.REGISTER_PAGE_TITLE);
    }

    @Test(priority=2)
    public void registerTest() throws InterruptedException {
        registerPage.registerUser(prop.getProperty("firstname"), prop.getProperty("lastname"),
                prop.getProperty("day"),prop.getProperty("month"), prop.getProperty("year"), prop.getProperty("Email")
                , prop.getProperty("cname"), prop.getProperty("pwd"), prop.getProperty("cpassword"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
