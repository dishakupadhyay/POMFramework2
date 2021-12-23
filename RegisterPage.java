package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utils.Constants;
import com.demo.nopcommerce.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver driver;
    Utils utils;


    By email = By.id("Email");
    By password = By.id("Password");
    By genderButton = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By birthDay = By.name("DateOfBirthDay");
    By birthMonth = By.name("DateOfBirthMonth");
    By birthYear = By.name("DateOfBirthYear");
    By companyName = By.id("Company");
    By newsLetter = By.id("Newsletter");
    By confirmPassword = By.id("ConfirmPassword");
    By register = By.className("ico-register");
    By reg = By.id("register-button");
    By books = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a");
    By book1 = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]" +
            "/div[3]/div[2]/button[1]");
    By cart = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    By checkbox = By.id("termsofservice");
    By checkout = By.id("checkout");



    public RegisterPage(WebDriver driver){
        this.driver=driver;
        utils=new Utils(driver);
    }

    public String getRegisterPageTitle(){
        return utils.waitForTitlePresent(Constants.REGISTER_PAGE_TITLE,10);
    }

    public void registerUser(String firstname,String lastname, String day, String month,String year,String Email,
                             String cname, String pwd,
                             String cpassword) throws InterruptedException  {
        utils.doClick(register);
        utils.doClick(genderButton);
        utils.doSendKeys(firstName, firstname);
        Thread.sleep(3000);
        utils.doSendKeys(lastName, lastname);
       // Thread.sleep(3000);
        utils.selectValueFromDropDown(birthDay,day);
       // Thread.sleep(3000);
        utils.selectValueFromDropDown(birthMonth,month);
        //Thread.sleep(3000);
        utils.selectValueFromDropDown(birthYear,year);
       // Thread.sleep(3000);
        utils.doSendKeys(email, Email);
       // Thread.sleep(3000);
        utils.doSendKeys(companyName,cname);
        Thread.sleep(3000);
        utils.doClick(newsLetter);
        Thread.sleep(3000);
        utils.doSendKeys(password,pwd);
        Thread.sleep(3000);
        utils.doSendKeys(confirmPassword,cpassword);
        Thread.sleep(3000);
        utils.doClick(reg);
        Thread.sleep(3000);
        utils.doClick(books);
        Thread.sleep(3000);
        utils.doClick(book1);
        Thread.sleep(3000);
        utils.doClick(cart);
        Thread.sleep(3000);
        utils.doClick(checkbox);
        Thread.sleep(3000);
        utils.doClick(checkout);
        Thread.sleep(2000);

    }
    }


