package saucedemotests.componenttests;

import actions.HeaderAreaActions;
import actions.ProductsPageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderAreaTests extends BaseTest {

    private HeaderAreaActions headerAreaActions;
    private ProductsPageActions productsPageActions;

    @BeforeEach
    public void setUpHeaderArea() {
        navigateAndLoginStandardUser();

        headerAreaActions = new HeaderAreaActions(page);
        productsPageActions = new ProductsPageActions(page);
    }

    @Test
    public void openBurgerMenuTest() {
        headerAreaActions.openBurgerMenu();

        assertTrue(headerAreaActions.isBurgerMenuOpened());
    }

    @Test
    public void closeBurgerMenuOptionTest() {
        headerAreaActions.openBurgerMenu();

        headerAreaActions.closeBurgerMenu();
        assertTrue(headerAreaActions.isBurgerMenuClosed());
    }

    @Test
    public void headerAreaTextValidationTest() {
        assertEquals("Swag Labs", headerAreaActions.getHeaderTitleText());

        headerAreaActions.openBurgerMenu();
        assertEquals("All Items", headerAreaActions.getBurgerMenuAllItemsOptionText());
        assertEquals("About", headerAreaActions.getBurgerMenuAboutOptionText());
        assertEquals("Logout", headerAreaActions.getBurgerMenuLogoutOptionText());
        assertEquals("Reset App State", headerAreaActions.getBurgerMenuResetAppStateOptionText());
    }

    @Test
    public void clickableCartIconTest() {
        headerAreaActions.clickCartIcon();

        assertEquals("https://www.saucedemo.com/cart.html", page.url());
    }

    @Test
    public void clickableAllItemsBurgerMenuOptionTest() {
        headerAreaActions.clickCartIcon();
        headerAreaActions.openBurgerMenu();
        headerAreaActions.clickBurgerMenuAllItemsOption();

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
    }

    @Test
    public void clickableAboutBurgerMenuOptionTest() {
        headerAreaActions.openBurgerMenu();
        headerAreaActions.clickBurgerMenuAboutOption();

        assertEquals("https://saucelabs.com/", page.url());
    }

    @Test
    public void clickableLogoutBurgerMenuOptionTest() {
        headerAreaActions.openBurgerMenu();
        headerAreaActions.clickBurgerMenuLogoutOption();

        assertEquals("https://www.saucedemo.com/", page.url());
    }

    @Test
    public void clickableResetAppStateBurgerMenuOptionTest() {
        productsPageActions.clickSauceLabsBackpackAddToCartButton();

        headerAreaActions.openBurgerMenu();
        headerAreaActions.clickBurgerMenuResetAppStateOption();
        assertFalse(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void burgerMenuDefaultColorsValidationTest() {
        headerAreaActions.openBurgerMenu();

        assertEquals("#18583a", headerAreaActions.getBurgerMenuAllItemsOptionColor());
        assertEquals("#18583a", headerAreaActions.getBurgerMenuAboutOptionColor());
        assertEquals("#18583a", headerAreaActions.getBurgerMenuLogoutOptionColor());
        assertEquals("#18583a", headerAreaActions.getBurgerMenuResetAppStateOptionColor());
    }

    @Test
    public void burgerMenuHoverColorValidationTest() {
        headerAreaActions.openBurgerMenu();

        assertEquals("#3ddc91", headerAreaActions.getBurgerMenuAllItemsOptionHoverColor());
        assertEquals("#3ddc91", headerAreaActions.getBurgerMenuAboutOptionHoverColor());
        assertEquals("#3ddc91", headerAreaActions.getBurgerMenuLogoutOptionHoverColor());
        assertEquals("#3ddc91", headerAreaActions.getBurgerMenuResetAppStateOptionHoverColor());
    }

    @Test
    public void headerAreaFontValidationTest() {
        assertEquals("\"DM Mono\", \"sans-serif\"", headerAreaActions.getHeaderAreaTitleFont());
        assertEquals("24px", headerAreaActions.getHeaderAreaTitleFontSize());

        headerAreaActions.openBurgerMenu();
        assertEquals("\"DM Mono\", \"sans-serif\"", headerAreaActions.getBurgerMenuAllItemsOptionFont());
        assertEquals("16px", headerAreaActions.getBurgerMenuAllItemsOptionFontSize());

        assertEquals("\"DM Mono\", \"sans-serif\"", headerAreaActions.getBurgerMenuAboutOptionFont());
        assertEquals("16px", headerAreaActions.getBurgerMenuAboutOptionFontSize());

        assertEquals("\"DM Mono\", \"sans-serif\"", headerAreaActions.getBurgerMenuLogoutOptionFont());
        assertEquals("16px", headerAreaActions.getBurgerMenuLogoutOptionFontSize());

        assertEquals("\"DM Mono\", \"sans-serif\"", headerAreaActions.getBurgerMenuResetAppStateOptionFont());
        assertEquals("16px", headerAreaActions.getBurgerMenuResetAppStateOptionFontSize());
    }
}
