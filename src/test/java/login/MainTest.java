package login;

import base.BaseTest;
import pages.*;
import utils.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest extends BaseTest {

    @Test
    public void testSuccessfulLoginAndProductAdd() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginScreenLink();
        loginPage.setUsername(Constants.USERNAME);
        loginPage.setPassword(Constants.PASSWORD);
        LoggedInPage loggedInPage = loginPage.clickLoginButton();
        assertTrue(loggedInPage.isLoggedIn());
        SearchPage searchPage = loggedInPage.searchSomething(Constants.SEARCH_KEYWORD);
        ProductPage productPage = searchPage.goToPageTwo();
        assertTrue(searchPage.getCurrentURL().contains("sf=2"));
        productPage.addProductToBasket();
        CartPage cartPage = productPage.goToCartPage();
        productPage = cartPage.increaseAmount();
        productPage.addProductToBasket();
        cartPage = productPage.goToCartPage();
        cartPage.emptyCart();
        assertFalse(cartPage.isCartEmpty());
    }
}
