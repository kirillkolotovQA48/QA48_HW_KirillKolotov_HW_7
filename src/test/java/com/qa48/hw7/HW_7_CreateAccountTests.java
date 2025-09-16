package com.qa48.hw7;

import com.qa48.hw7.models.HW_7_RegistForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_7_CreateAccountTests extends HW_7_TestBase{

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        app.getUser().clickOnRegistrationLink();
        app.getUser().selectGender();

        HW_7_RegistForm user = new HW_7_RegistForm()
                .setFirstName("Kirill")
                .setLastName("Kolotov")
                .setEmail("23455@mail.ru")
                .setPassword("Aa123456789!")
                .setConfirmPassword("Aa123456789!");

        app.getUser().fillRegistrationFields(user);

        app.getUser().clickRegistrationButton();

        String displayedText = driver.findElement(
                By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
        ).getText();

        Assert.assertEquals(displayedText, user.getEmail());
    }
    @Test(enabled = false)
    public void newUserRegistrationNegativeTest(){
        app.getUser().clickOnRegistrationLink();
        app.getUser().selectGender();

        HW_7_RegistForm user = new HW_7_RegistForm()
                .setFirstName("Kirill")
                .setLastName("Kolotov")
                .setEmail("")
                .setPassword("Aa123456789!")
                .setConfirmPassword("Aa123456789!");

        app.getUser().fillRegistrationFields(user);

        app.getUser().clickRegistrationButton();
    }
}