package com.demo.nopcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    FileInputStream file;

    /** This method used to initialise the driver on the basis of browserName.
     * Params: BrowserName
     * Returns:driver
     */

    public WebDriver initialiseDriver(String browserName){
      if (browserName.equals("chrome")){
          System.setProperty("webdriver.chrome.driver","C:\\Users\\Keyur\\IdeaProjects\\POMFramework2\\src\\test\\" +
                  "resources\\BrowserDriver\\chromedriver.exe");
          driver= new ChromeDriver();
    }
    else if (browserName.equals("firefox")){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Keyur\\IdeaProjects\\POMFramework2\\src\\test\\" +
                "resources\\BrowserDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    else if (browserName.equals("internetexplorer")){
        System.setProperty("webdriver.ie.driver","C:\\Users\\Keyur\\IdeaProjects\\POMFramework2\\src\\test\\" +
                "resources\\BrowserDriver\\IEDriverServer.exe");
        driver= new InternetExplorerDriver();
      } else {
          System.out.println(browserName + "Browser is invalid, please enter correct browser name");
      }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();

    return driver;

    }
    /**
     * This method used to read properties from config.properties file.
     * Returns:prop
     */
    public Properties initialiseProperties(){
        prop = new Properties();
        try{
            file = new FileInputStream("C:\\Users\\Keyur\\IdeaProjects\\POMFramework2\\src\\test\\" +
                    "resources\\TestData\\config.properties");

            prop.load(file); // Loading the file
        } catch (FileNotFoundException e) {
            System.out.println("Config file is not found,please check...");
        } catch (IOException e) {
            System.out.println("Properties could not be loaded...");
            e.printStackTrace();
        }
        return prop;
    }
}