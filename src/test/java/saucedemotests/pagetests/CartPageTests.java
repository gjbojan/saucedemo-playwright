package saucedemotests.pagetests;

import actions.CartPageActions;
import actions.HeaderAreaActions;
import actions.ProductsPageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartPageTests extends BaseTest {

    private CartPageActions cartPageActions;
    private ProductsPageActions productsPageActions;
    private HeaderAreaActions headerAreaActions;

    private final static String description = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    @BeforeEach
    public void setUpCartPage() {
        navigateAndLoginStandardUser();
        productsPageActions = new ProductsPageActions(page);

        productsPageActions.clickSauceLabsBackpackAddToCartButton();
        navigateToPage("cart");
        headerAreaActions = new HeaderAreaActions(page);
        cartPageActions = new CartPageActions(page);
    }

    @Test
    public void verifyCartPageLayoutAndNavigationElementsTest() {
        assertEquals("Your Cart", cartPageActions.getCartPageTitleText());
        assertEquals("QTY", cartPageActions.getQuantityLabelText());
        assertEquals("Description", cartPageActions.getDescriptionLabelText());
        assertEquals("Continue Shopping", cartPageActions.getContinueShoppingButtonText());
        assertEquals("Checkout", cartPageActions.getCheckoutButtonText());
    }

    @Test
    public void verifyCartProductDetailsAndRemoveButtonTest() {
        assertEquals("Sauce Labs Backpack", cartPageActions.getSauceLabsBackpackTitleText());
        assertEquals(description, cartPageActions.getSauceLabsBackpackDescriptionText());
        assertEquals("$29.99", cartPageActions.getSauceLabsBackpackPriceText());
        assertTrue(cartPageActions.doAllProductsHaveQuantityText());
        assertEquals("Remove", cartPageActions.getSauceLabsBackpackRemoveButtonText());
    }

    @Test
    public void clickableProductTitleTest() {
        cartPageActions.clickSauceLabsBackpackTitle();

        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", page.url());
    }

    @Test
    public void functionalUsageOfRemoveButtonTest() {
        cartPageActions.clickSauceLabsBackpackRemoveButton();

        assertFalse(cartPageActions.isSauceLabsBackpackInCart());
        assertFalse(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void validateChangingOfTheNumberInTheBadgeOnTheCartIconTest() {
        cartPageActions.clickContinueShoppingButton();
        productsPageActions.clickSauceLabsOnesieAddToCartButton();
        headerAreaActions.clickCartIcon();

        assertEquals(2, headerAreaActions.getShoppingCartBadgeNumber());

        cartPageActions.clickSauceLabsOnesieRemoveButton();
        assertEquals(1, headerAreaActions.getShoppingCartBadgeNumber());
    }

    @Test
    public void functionalUsageOfContinueShoppingButtonTest() {
        cartPageActions.clickContinueShoppingButton();

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
        assertTrue(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());

        headerAreaActions.clickCartIcon();
        assertTrue(cartPageActions.isSauceLabsBackpackInCart());
    }

    @Test
    public void functionalUsageOfCheckoutButtonTest() {
        cartPageActions.clickCheckoutButton();

        assertEquals("https://www.saucedemo.com/checkout-step-one.html", page.url());
        assertTrue(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void cartPageNavigationButtonsColorTest() {
        assertEquals("#132322", cartPageActions.getContinueShoppingButtonTextColor());
        assertEquals("#132322", cartPageActions.getContinueShoppingButtonBorderColor());
        assertEquals("#ffffff", cartPageActions.getContinueShoppingButtonBackgroundColor());

        assertEquals("#132322", cartPageActions.getCheckoutButtonTextColor());
        assertEquals("#3ddc91", cartPageActions.getCheckoutButtonBackgroundColor());
    }

    @Test
    public void cartProductDetailsAndRemoveButtonColorTest() {
        assertEquals("#18583a", cartPageActions.getSauceLabsBackpackTitleDefaultColor());
        assertEquals("#3ddc91", cartPageActions.getSauceLabsBackpackTitleHoverColor());

        assertEquals("#e2231a", cartPageActions.getSauceLabsBackpackRemoveButtonTextColor());
        assertEquals("#e2231a", cartPageActions.getSauceLabsBackpackRemoveButtonBorderColor());
        assertEquals("#ffffff", cartPageActions.getSauceLabsBackpackRemoveButtonBackgroundColor());
    }

    @Test
    public void cartPageLayoutAndNavigationElementsFontTest() {
        assertEquals("\"DM Sans\", sans-serif", cartPageActions.getCartPageTitleTextFont());
        assertEquals("18px", cartPageActions.getCartPageTitleTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", cartPageActions.getQuantityLabelTextFont());
        assertEquals("16px", cartPageActions.getQuantityLabelTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", cartPageActions.getDescriptionLabelTextFont());
        assertEquals("16px", cartPageActions.getDescriptionLabelTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", cartPageActions.getContinueShoppingButtonTextFont());
        assertEquals("16px", cartPageActions.getContinueShoppingButtonTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", cartPageActions.getCheckoutButtonTextFont());
        assertEquals("16px", cartPageActions.getCheckoutButtonTextFontSize());
    }

    @Test
    public void cartProductDetailsAndRemoveButtonFontTest() {
        assertEquals("\"DM Mono\", sans-serif", cartPageActions.getSauceLabsBackpackTitleFont());
        assertEquals("20px", cartPageActions.getSauceLabsBackpackTitleFontSize());

        assertEquals("\"DM Sans\", sans-serif", cartPageActions.getSauceLabsBackpackDescriptionFont());
        assertEquals("14px", cartPageActions.getSauceLabsBackpackDescriptionFontSize());

        assertEquals("\"DM Mono\", sans-serif", cartPageActions.getSauceLabsBackpackPriceFont());
        assertEquals("20px", cartPageActions.getSauceLabsBackpackPriceFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", cartPageActions.getQuantityNumberTextFont());
        assertEquals("14px", cartPageActions.getQuantityNumberTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", cartPageActions.getSauceLabsBackpackRemoveButtonTextFont());
        assertEquals("16px", cartPageActions.getSauceLabsBackpackRemoveButtonTextFontSize());
    }
}
