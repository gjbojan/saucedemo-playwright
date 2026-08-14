package saucedemotests.pagetests;

import actions.CheckoutOverviewPageActions;
import actions.HeaderAreaActions;
import actions.ProductsPageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutOverviewPageTests extends BaseTest {

    private ProductsPageActions productsPageActions;
    private CheckoutOverviewPageActions checkoutOverviewPageActions;
    private HeaderAreaActions headerAreaActions;

    private final static String DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    @BeforeEach
    public void setUpCheckoutOverviewPage() {
        navigateAndLoginStandardUser();
        productsPageActions = new ProductsPageActions(page);

        productsPageActions.clickSauceLabsBackpackAddToCartButton();

        navigateToPage("checkout-step-two");
        checkoutOverviewPageActions = new CheckoutOverviewPageActions(page);
        headerAreaActions = new HeaderAreaActions(page);
    }

    @Test
    public void verifyCheckoutOverviewPageLayoutAndNavigationElementsTest() {
        assertEquals("Checkout: Overview", checkoutOverviewPageActions.getCheckoutOverviewPageTitleText());
        assertEquals("QTY", checkoutOverviewPageActions.getQuantityLabelText());
        assertEquals("Description", checkoutOverviewPageActions.getDescriptionLabelText());
        assertEquals("Payment Information:", checkoutOverviewPageActions.getPaymentInformationLabelText());
        assertEquals("SauceCard #31337", checkoutOverviewPageActions.getPaymentInformationValueText());
        assertEquals("Shipping Information:", checkoutOverviewPageActions.getShippingInformationLabelText());
        assertEquals("Free Pony Express Delivery!", checkoutOverviewPageActions.getShippingInformationValueText());
        assertEquals("Price Total", checkoutOverviewPageActions.getPriceTotalLabelText());
        assertEquals("Cancel", checkoutOverviewPageActions.getCancelButtonText());
        assertEquals("Finish", checkoutOverviewPageActions.getFinishButtonText());
    }

    @Test
    public void verifyOrderSummaryFinancialCalculationTest() {
        checkoutOverviewPageActions.clickCancelButton();
        productsPageActions.clickSauceLabsOnesieAddToCartButton();
        navigateToPage("checkout-step-two");

        assertEquals("Item total: $37.98", checkoutOverviewPageActions.getItemTotalLabelText());
        assertEquals("Tax: $3.04", checkoutOverviewPageActions.getTaxLabelText());
        assertEquals(checkoutOverviewPageActions.getCalculatedPriceTotal(), checkoutOverviewPageActions.getTotalLabelText());
    }

    @Test
    public void verifyProductDetailsTest() {
        assertEquals("Sauce Labs Backpack", checkoutOverviewPageActions.getSauceLabsBackpackTitleText());
        assertEquals(DESCRIPTION, checkoutOverviewPageActions.getSauceLabsBackpackDescriptionText());
        assertEquals("$29.99", checkoutOverviewPageActions.getSauceLabsBackpackPriceText());
        assertTrue(checkoutOverviewPageActions.doAllProductsHaveQuantityText());
    }

    @Test
    public void clickableProductTitleTest() {
        checkoutOverviewPageActions.clickSauceLabsBackpackTitle();

        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", page.url());
    }

    @Test
    public void functionalUsageOfCancelButtonTest() {
        checkoutOverviewPageActions.clickCancelButton();

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
        assertTrue(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
        assertFalse(productsPageActions.isSauceLabsBackpackAddToCartButtonDisplayed());
        assertTrue(productsPageActions.isSauceLabsBackpackRemoveButtonDisplayed());
    }

    @Test
    public void functionalUsageOfFinishButtonTest() {
        checkoutOverviewPageActions.clickFinishButton();

        assertEquals("https://www.saucedemo.com/checkout-complete.html", page.url());
        assertFalse(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void checkoutOverviewPageNavigationButtonsColorTest() {
        assertEquals("#132322", checkoutOverviewPageActions.getCancelButtonTextColor());
        assertEquals("#132322", checkoutOverviewPageActions.getCancelButtonBorderColor());
        assertEquals("#ffffff", checkoutOverviewPageActions.getCancelButtonBackgroundColor());

        assertEquals("#132322", checkoutOverviewPageActions.getFinishButtonTextColor());
        assertEquals("#3ddc91", checkoutOverviewPageActions.getFinishButtonBackgroundColor());
    }

    @Test
    public void productDetailsColorTest() {
        assertEquals("#18583a", checkoutOverviewPageActions.getSauceLabsBackpackTitleDefaultColor());
        assertEquals("#3ddc91", checkoutOverviewPageActions.getSauceLabsBackpackTitleHoverColor());
    }

    @Test
    public void checkoutOverviewPageLayoutAndNavigationElementsFontTest() {
        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getCheckoutOverviewPageTitleTextFont());
        assertEquals("18px", checkoutOverviewPageActions.getCheckoutOverviewPageTitleTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getQuantityLabelTextFont());
        assertEquals("16px", checkoutOverviewPageActions.getQuantityLabelTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPageActions.getDescriptionLabelTextFont());
        assertEquals("16px", checkoutOverviewPageActions.getDescriptionLabelTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getPaymentInformationLabelTextFont());
        assertEquals("18px", checkoutOverviewPageActions.getPaymentInformationLabelTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getPaymentInformationValueTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getPaymentInformationValueTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getShippingInformationLabelTextFont());
        assertEquals("18px", checkoutOverviewPageActions.getShippingInformationLabelTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getShippingInformationValueTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getShippingInformationValueTextFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getPriceTotalLabelTextFont());
        assertEquals("18px", checkoutOverviewPageActions.getPriceTotalLabelTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPageActions.getItemTotalLabelTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getItemTotalLabelTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPageActions.getTaxLabelTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getTaxLabelTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPageActions.getTotalLabelTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getTotalLabelTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getCancelButtonTextFont());
        assertEquals("16px", checkoutOverviewPageActions.getCancelButtonTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getFinishButtonTextFont());
        assertEquals("16px", checkoutOverviewPageActions.getFinishButtonTextFontSize());
    }

    @Test
    public void productDetailsFontTest() {
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getSauceLabsBackpackTitleFont());
        assertEquals("20px", checkoutOverviewPageActions.getSauceLabsBackpackTitleFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPageActions.getSauceLabsBackpackDescriptionFont());
        assertEquals("14px", checkoutOverviewPageActions.getSauceLabsBackpackDescriptionFontSize());

        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPageActions.getSauceLabsBackpackPriceFont());
        assertEquals("20px", checkoutOverviewPageActions.getSauceLabsBackpackPriceFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPageActions.getQuantityNumberTextFont());
        assertEquals("14px", checkoutOverviewPageActions.getQuantityNumberTextFontSize());
    }
}
