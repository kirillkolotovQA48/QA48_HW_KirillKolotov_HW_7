package com.qa48.hw7;

import com.qa48.hw7.data.UserData;
import com.qa48.hw7.models.HW_7_RegistForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_7_DeleteSelectionTests extends HW_7_TestBase {

    @BeforeMethod
    public void precondition() {
        // Логин, если нужно
        if (app.getUser().loginLinkPresent()) {
            app.getUser().clickOnLoginLink();

            HW_7_RegistForm user = new HW_7_RegistForm()
                    .setEmail(UserData.EMAIL)
                    .setPassword(UserData.PASSWORD);

            app.getUser().typeEmail(user);
            app.getUser().typePassword(user);
            app.getUser().clickOnLoginButton();
        }

        // Подождать появления книги и добавить в корзину
        app.getCart().waitForElement(By.cssSelector(".product-item")); // Подставь реальный селектор книги
        app.getCart().clickOnBookButton();
        app.getCart().addBookToCart();
        app.getCart().goToCart();
    }
    @Test
    public void deleteBooksPossitiveTest() {
        int sizeBefore = app.getCart().size0fBooksInCart();

        app.getCart().clickOnTheProductCheckboxes();
        app.getCart().clickUpdateShoppingCart();
        app.getCart().pause(1000);

        int sizeAfter = app.getCart().size0fBooksInCart();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
