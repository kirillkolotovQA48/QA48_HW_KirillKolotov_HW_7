package com.qa48.hw7.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class HW_7_AppManager {

    String browser;
    WebDriver driver;
    HW_7_UserHelper user;
    HW_7_AddCartHelper cart;

    public HW_7_AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com");

        user = new HW_7_UserHelper(driver);
        cart = new HW_7_AddCartHelper(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        driver.quit();
    }

    public HW_7_AddCartHelper getCart() {
        return cart;
    }

    public HW_7_UserHelper getUser() {
        return user;
    }
}

