package com.qa48.hw7.fw;

import com.qa48.hw7.models.HW_7_RegistForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HW_7_UserHelper extends HW_7_BaseHelper {

    public HW_7_UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickRegistrationButton() {
        click(By.id("register-button"));
    }

    public void fillRegistrationFields(HW_7_RegistForm HW_7_RegistForm) {
        click(By.id("FirstName"));
        clear(By.id("FirstName"));
        type(By.id("FirstName"), HW_7_RegistForm.getFirstName());

        click(By.id("LastName"));
        clear(By.id("LastName"));
        type(By.id("LastName"), HW_7_RegistForm.getLastName());

        click(By.id("Email"));
        clear(By.id("Email"));
        type(By.id("Email"), HW_7_RegistForm.getEmail());

        click(By.id("Password"));
        clear(By.id("Password"));
        type(By.id("Password"), HW_7_RegistForm.getPassword());

        click(By.id("ConfirmPassword"));
        clear(By.id("ConfirmPassword"));
        type(By.id("ConfirmPassword"), HW_7_RegistForm.getConfirmPassword());
    }

    public void selectGender() {
        click(By.id("gender-male"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href=\"/register\"]"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

    public void typePassword(HW_7_RegistForm user) {
        type(By.xpath("//*[@id='Password']"), user.getPassword());
    }

    public void typeEmail(HW_7_RegistForm user) {
        type(By.xpath("//*[@id='Email']"), user.getEmail());;
    }

    public void clickOnLoginLink() {
        click(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public boolean loginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
    public boolean logoutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public String getLoggedInUserEmail() {
        if (logoutLinkPresent()) {
            return driver.findElement(By.cssSelector(".account")).getText();
        }
        return null;
    }
}