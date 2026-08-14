package actions;

import com.microsoft.playwright.Page;
import pages.CheckoutCompletePage;

public class CheckoutCompletePageActions extends CheckoutCompletePage {

    public CheckoutCompletePageActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickBackHomeButton() {
        clickElement(backHomeButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getCheckoutCompletePageTitleText() {
        return getElementText(checkoutCompletePageTitle);
    }

    public String getThankYouHeaderText() {
        return getElementText(thankYouHeader);
    }

    public String getOrderDispatchedText() {
        return getElementText(orderDispatchedText);
    }

    public String getBackHomeButtonText() {
        return getElementText(backHomeButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isPonyExpressImageVisible() {
        return isElementVisible(ponyExpressImage);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getBackHomeButtonTextColor() {
        return getColorAsHex(backHomeButton, COLOR);
    }

    public String getBackHomeButtonBackgroundColor() {
        return getColorAsHex(backHomeButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getCheckoutCompletePageTitleTextFont() {
        return getCssValue(checkoutCompletePageTitle, FONT);
    }

    public String getCheckoutCompletePageTitleTextFontSize() {
        return getCssValue(checkoutCompletePageTitle, FONT_SIZE);
    }

    public String getThankYouHeaderTextFont() {
        return getCssValue(thankYouHeader, FONT);
    }

    public String getThankYouHeaderTextFontSize() {
        return getCssValue(thankYouHeader, FONT_SIZE);
    }

    public String getOrderDispatchedTextFont() {
        return getCssValue(orderDispatchedText, FONT);
    }

    public String getOrderDispatchedTextFontSize() {
        return getCssValue(orderDispatchedText, FONT_SIZE);
    }

    public String getBackHomeButtonTextFont() {
        return getCssValue(backHomeButton, FONT);
    }

    public String getBackHomeButtonTextFontSize() {
        return getCssValue(backHomeButton, FONT_SIZE);
    }
}
