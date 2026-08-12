package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage extends BasePage {

    public ProductsPage (Page page) {
        super(page);

        productsPageTitle = page.locator("[data-test='title']");
        dropDownMenu = page.locator(".product_sort_container");
        allProductTitles = page.locator(".inventory_item_name");
        allProductPictures = page.locator(".inventory_item_img img");
        allProductDescriptions = page.locator(".inventory_item_desc");
        allProductPrices = page.locator(".inventory_item_price");
        allProductAddToCartButtons = page.locator(".btn btn_primary btn_small btn_inventory ");
        sauceLabsBackpackAddToCartButton = page.locator("#add-to-cart-sauce-labs-backpack");
        sauceLabsBackpackRemoveButton = page.locator("#remove-sauce-labs-backpack");
        sauceLabsBackpackTitle = page.locator(".inventory_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-name']");
        sauceLabsBackpackDescription = page.locator(".inventory_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-desc']");
        sauceLabsBackpackPrice = page.locator(".inventory_item:has-text('Sauce Labs Backpack') [data-test='inventory-item-price']");
        sauceLabsBackpackPicture = page.locator("[data-test='inventory-item-sauce-labs-backpack-img']");
        sauceLabsOnesieAddToCartButton = page.locator("#add-to-cart-sauce-labs-onesie");
        sauceLabsOnesieRemoveButton = page.locator("#remove-sauce-labs-onesie");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator productsPageTitle;
    protected final Locator dropDownMenu;
    protected final Locator allProductTitles;
    protected final Locator allProductPictures;
    protected final Locator allProductDescriptions;
    protected final Locator allProductPrices;
    protected final Locator allProductAddToCartButtons;
    protected final Locator sauceLabsBackpackAddToCartButton;
    protected final Locator sauceLabsBackpackRemoveButton;
    protected final Locator sauceLabsBackpackTitle;
    protected final Locator sauceLabsBackpackPicture;
    protected final Locator sauceLabsBackpackDescription;
    protected final Locator sauceLabsBackpackPrice;
    protected final Locator sauceLabsOnesieAddToCartButton;
    protected final Locator sauceLabsOnesieRemoveButton;
}
