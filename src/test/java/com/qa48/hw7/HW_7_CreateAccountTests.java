package com.qa48.hw7;

import com.qa48.hw7.models.HW_7_RegistForm;
import com.qa48.hw7.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_7_CreateAccountTests extends HW_7_TestBase{

    @Test(dataProvider = "RegistrationFormWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvFileTest(HW_7_RegistForm user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().selectGender();

        // user берётся из DataProvider
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