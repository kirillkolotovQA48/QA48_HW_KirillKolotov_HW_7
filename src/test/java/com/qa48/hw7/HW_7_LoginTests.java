package com.qa48.hw7;

import com.qa48.hw7.data.UserData;
import com.qa48.hw7.models.HW_7_RegistForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_7_LoginTests extends HW_7_TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().loginLinkPresent()) {
            app.getUser().clickOnLoginLink();

            HW_7_RegistForm user = new HW_7_RegistForm()
                    .setEmail("23455@mail.ru")
                    .setPassword("Aa123456789!");

            app.getUser().typeEmail(user);
            app.getUser().typePassword(user);
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        HW_7_RegistForm user = new HW_7_RegistForm()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD);

        // Проверяем состояние пользователя
        if (app.getUser().logoutLinkPresent()) {
            // Пользователь уже залогинен — проверяем email
            String displayedText = driver.findElement(By.cssSelector(".account")).getText();
            Assert.assertEquals(displayedText, user.getEmail());
        } else {
            // Пользователь не залогинен — кликаем на логин и проверяем
            app.getUser().clickOnLoginLink();
            app.getUser().typeEmail(user);
            app.getUser().typePassword(user);
            app.getUser().clickOnLoginButton();

            String displayedText = driver.findElement(By.cssSelector(".account")).getText();
            Assert.assertEquals(displayedText, user.getEmail());
        }
    }
}

