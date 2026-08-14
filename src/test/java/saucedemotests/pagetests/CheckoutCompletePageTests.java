package saucedemotests.pagetests;

import actions.CheckoutCompletePageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCompletePageTests extends BaseTest {

    private CheckoutCompletePageActions checkoutCompletePageActions;

    private static final String ORDER_DISPATCHED_TEXT = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    @BeforeEach
    public void setUpCheckoutCompletePage() {
        navigateAndLoginStandardUser();
        navigateToPage("checkout-complete");

        checkoutCompletePageActions = new CheckoutCompletePageActions(page);
    }

    @Test
    public void checkoutCompletePageContentValidationTest() {
        assertTrue(checkoutCompletePageActions.isPonyExpressImageVisible());
        assertEquals("Checkout: Complete!", checkoutCompletePageActions.getCheckoutCompletePageTitleText());
        assertEquals("Thank you for your order!", checkoutCompletePageActions.getThankYouHeaderText());
        assertEquals(ORDER_DISPATCHED_TEXT, checkoutCompletePageActions.getOrderDispatchedText());
        assertEquals("Back Home", checkoutCompletePageActions.getBackHomeButtonText());
    }

    @Test
    public void functionalUsageOfBackHomeButtonTest() {
        checkoutCompletePageActions.clickBackHomeButton();

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
    }

    @Test
    public void backHomeButtonColorsValidationTest() {
        assertEquals("#132322", checkoutCompletePageActions.getBackHomeButtonTextColor());
        assertEquals("#3ddc91", checkoutCompletePageActions.getBackHomeButtonBackgroundColor());
    }

    @Test
    public void checkoutCompletePageFontValidationTest() {
        assertEquals("\"DM Sans\", sans-serif", checkoutCompletePageActions.getCheckoutCompletePageTitleTextFont());
        assertEquals("18px", checkoutCompletePageActions.getCheckoutCompletePageTitleTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutCompletePageActions.getThankYouHeaderTextFont());
        assertEquals("24px", checkoutCompletePageActions.getThankYouHeaderTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutCompletePageActions.getOrderDispatchedTextFont());
        assertEquals("14px", checkoutCompletePageActions.getOrderDispatchedTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutCompletePageActions.getBackHomeButtonTextFont());
        assertEquals("16px", checkoutCompletePageActions.getBackHomeButtonTextFontSize());
    }
}
