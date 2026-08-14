package actions;

import com.microsoft.playwright.Page;
import pages.CartPage;

public class CartPageActions extends CartPage {

    public CartPageActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickContinueShoppingButton() {
        clickElement(continueShoppingButton);
    }

    public void clickCheckoutButton() {
        clickElement(checkoutButton);
    }

    public void clickSauceLabsBackpackTitle() {
        clickElement(sauceLabsBackpackTitle);
    }

    public void clickSauceLabsBackpackRemoveButton() {
        clickElement(sauceLabsBackpackRemoveButton);
    }

    public void clickSauceLabsOnesieRemoveButton() {
        clickElement(sauceLabsOnesieRemoveButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isSauceLabsBackpackInCart() {
        return isElementVisible(sauceLabsBackpackTitle);
    }

    public boolean doAllProductsHaveQuantityText() {
        return areAllElementsTextVisible(allItemQuantities);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getCartPageTitleText() {
        return getElementText(cartPageTitle);
    }

    public String getQuantityLabelText() {
        return getElementText(quantityLabel);
    }

    public String getDescriptionLabelText() {
        return getElementText(descriptionLabel);
    }

    public String getSauceLabsBackpackTitleText() {
        return getElementText(sauceLabsBackpackTitle);
    }

    public String getSauceLabsBackpackDescriptionText() {
        return getElementText(sauceLabsBackpackDescription);
    }

    public String getSauceLabsBackpackPriceText() {
        return getElementText(sauceLabsBackpackPrice);
    }

    public String getSauceLabsBackpackRemoveButtonText() {
        return getElementText(sauceLabsBackpackRemoveButton);
    }

    public String getContinueShoppingButtonText() {
        return getElementText(continueShoppingButton);
    }

    public String getCheckoutButtonText() {
        return getElementText(checkoutButton);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getSauceLabsBackpackTitleDefaultColor() {
        return getColorAsHex(sauceLabsBackpackTitle, COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonTextColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonBorderColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, BORDER_COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonBackgroundColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, BACKGROUND_COLOR);
    }

    public String getContinueShoppingButtonTextColor() {
        return getColorAsHex(continueShoppingButton, COLOR);
    }

    public String getContinueShoppingButtonBorderColor() {
        return getColorAsHex(continueShoppingButton, BORDER_COLOR);
    }

    public String getContinueShoppingButtonBackgroundColor() {
        return getColorAsHex(continueShoppingButton, BACKGROUND_COLOR);
    }

    public String getCheckoutButtonTextColor() {
        return getColorAsHex(checkoutButton, COLOR);
    }

    public String getCheckoutButtonBackgroundColor() {
        return getColorAsHex(checkoutButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // HOVER COLOR ACTIONS
    // ==========================================
    public String getSauceLabsBackpackTitleHoverColor() {
        hoverElement(sauceLabsBackpackTitle);

        return getColorAsHex(sauceLabsBackpackTitle, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getCartPageTitleTextFont() {
        return getCssValue(cartPageTitle, FONT);
    }

    public String getCartPageTitleTextFontSize() {
        return getCssValue(cartPageTitle, FONT_SIZE);
    }

    public String getQuantityLabelTextFont() {
        return getCssValue(quantityLabel, FONT);
    }

    public String getQuantityLabelTextFontSize() {
        return getCssValue(quantityLabel, FONT_SIZE);
    }

    public String getDescriptionLabelTextFont() {
        return getCssValue(descriptionLabel, FONT);
    }

    public String getDescriptionLabelTextFontSize() {
        return getCssValue(descriptionLabel, FONT_SIZE);
    }

    public String getQuantityNumberTextFont() {
        return getCssValue(sauceLabsBackpackItemQuantityNumber, FONT);
    }

    public String getQuantityNumberTextFontSize() {
        return getCssValue(sauceLabsBackpackItemQuantityNumber, FONT_SIZE);
    }

    public String getSauceLabsBackpackTitleFont() {
        return getCssValue(sauceLabsBackpackTitle, FONT);
    }

    public String getSauceLabsBackpackTitleFontSize() {
        return getCssValue(sauceLabsBackpackTitle, FONT_SIZE);
    }

    public String getSauceLabsBackpackDescriptionFont() {
        return getCssValue(sauceLabsBackpackDescription, FONT);
    }

    public String getSauceLabsBackpackDescriptionFontSize() {
        return getCssValue(sauceLabsBackpackDescription, FONT_SIZE);
    }

    public String getSauceLabsBackpackPriceFont() {
        return getCssValue(sauceLabsBackpackPrice, FONT);
    }

    public String getSauceLabsBackpackPriceFontSize() {
        return getCssValue(sauceLabsBackpackPrice, FONT_SIZE);
    }

    public String getSauceLabsBackpackRemoveButtonTextFont() {
        return getCssValue(sauceLabsBackpackRemoveButton, FONT);
    }

    public String getSauceLabsBackpackRemoveButtonTextFontSize() {
        return getCssValue(sauceLabsBackpackRemoveButton, FONT_SIZE);
    }

    public String getContinueShoppingButtonTextFont() {
        return getCssValue(continueShoppingButton, FONT);
    }

    public String getContinueShoppingButtonTextFontSize() {
        return getCssValue(continueShoppingButton, FONT_SIZE);
    }

    public String getCheckoutButtonTextFont() {
        return getCssValue(checkoutButton, FONT);
    }

    public String getCheckoutButtonTextFontSize() {
        return getCssValue(checkoutButton, FONT_SIZE);
    }
}
