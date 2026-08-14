package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage (Page page) {
        super(page);

        checkoutOverviewPageTitle = page.locator("[data-test='title']");
        quantityLabel = page.locator(".cart_quantity_label");
        descriptionLabel = page.locator(".cart_desc_label");
        sauceLabsBackpackTitle = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-name']");
        sauceLabsBackpackDescription = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-desc']");
        sauceLabsBackpackPrice = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-price']");
        sauceLabsBackpackItemQuantityNumber = page.locator(".cart_quantity");
        allItemQuantities = page.locator(".cart_quantity");
        allItemPrices = page.locator(".inventory_item_price");
        paymentLabel = page.locator(".summary_info_label:has-text('Payment Information:')");
        paymentValue = page.locator(".summary_info_label:has-text('Payment Information:') + .summary_value_label");
        shippingLabel = page.locator(".summary_info_label:has-text('Shipping Information:')");
        shippingValue = page.locator(".summary_info_label:has-text('Shipping Information:') + .summary_value_label");
        priceTotalLabel = page.locator("[data-test='total-info-label']") ;
        itemTotalLabel = page.locator(".summary_subtotal_label");
        taxLabel = page.locator(".summary_tax_label");
        totalLabel = page.locator(".summary_total_label");
        cancelButton = page.locator("#cancel");
        finishButton = page.locator("#finish");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator checkoutOverviewPageTitle;
    protected final Locator quantityLabel;
    protected final Locator descriptionLabel;
    protected final Locator sauceLabsBackpackTitle;
    protected final Locator sauceLabsBackpackDescription;
    protected final Locator sauceLabsBackpackPrice;
    protected final Locator sauceLabsBackpackItemQuantityNumber;
    protected final Locator allItemQuantities;
    protected final Locator allItemPrices;
    protected final Locator paymentLabel;
    protected final Locator paymentValue;
    protected final Locator shippingLabel;
    protected final Locator shippingValue;
    protected final Locator priceTotalLabel;
    protected final Locator itemTotalLabel;
    protected final Locator taxLabel;
    protected final Locator totalLabel;
    protected final Locator cancelButton;
    protected final Locator finishButton;
}
