package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage (Page page) {
        super(page);

        checkoutCompletePageTitle = page.locator("[data-test='title']");
        ponyExpressImage = page.locator(".pony_express");
        thankYouHeader = page.locator(".complete-header");
        orderDispatchedText = page.locator(".complete-text");
        backHomeButton = page.locator("#back-to-products");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator checkoutCompletePageTitle;
    protected final Locator ponyExpressImage;
    protected final Locator thankYouHeader;
    protected final Locator orderDispatchedText;
    protected final Locator backHomeButton;
}
