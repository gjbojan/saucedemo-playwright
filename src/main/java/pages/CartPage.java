package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    public CartPage (Page page) {
        super(page);

        cartPageTitle = page.locator("[data-test='title']");
        quantityLabel = page.locator(".cart_quantity_label");
        descriptionLabel = page.locator(".cart_desc_label");
        sauceLabsBackpackTitle = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-name']");
        sauceLabsBackpackDescription = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-desc']");
        sauceLabsBackpackPrice = page.locator(".cart_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-price']");
        sauceLabsBackpackItemQuantityNumber = page.locator(".cart_quantity");
        sauceLabsBackpackRemoveButton = page.locator("#remove-sauce-labs-backpack");
        allItemQuantities = page.locator(".cart_quantity");
        sauceLabsOnesieTitle = page.locator(".cart_item:has-text('Sauce Labs Onesie') [data-test='inventory-item-name']");
        sauceLabsOnesieRemoveButton = page.locator("#remove-sauce-labs-onesie");
        continueShoppingButton = page.locator("#continue-shopping");
        checkoutButton = page.locator("#checkout");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator cartPageTitle;
    protected final Locator quantityLabel;
    protected final Locator descriptionLabel;
    protected final Locator sauceLabsBackpackTitle;
    protected final Locator sauceLabsBackpackDescription;
    protected final Locator sauceLabsBackpackPrice;
    protected final Locator sauceLabsBackpackItemQuantityNumber;
    protected final Locator sauceLabsBackpackRemoveButton;
    protected final Locator allItemQuantities;
    protected final Locator sauceLabsOnesieTitle;
    protected final Locator sauceLabsOnesieRemoveButton;
    protected final Locator continueShoppingButton;
    protected final Locator checkoutButton;
}
