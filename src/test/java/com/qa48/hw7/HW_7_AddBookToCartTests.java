package com.qa48.hw7;

import com.qa48.hw7.models.HW_7_RegistForm;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_7_AddBookToCartTests extends HW_7_TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().loginLinkPresent()) {
            HW_7_RegistForm user = new HW_7_RegistForm()
                    .setEmail("23455@mail.ru")
                    .setPassword("Aa123456789!");

            app.getUser().clickOnLoginLink();
            app.getUser().typeEmail(user);
            app.getUser().typePassword(user);
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void AddBookToCartPossitiveTests() {
        int sizeBefore = app.getCart().size0fBooksInCart();

        app.getCart().clickOnBookButton();
        app.getCart().addBookToCart();
        app.getCart().goToCart();

        int sizeAfter = app.getCart().size0fBooksInCart();
        Assert.assertEquals(sizeAfter, sizeBefore + 1);
    }
}
