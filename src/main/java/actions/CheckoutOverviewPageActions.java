package actions;

import com.microsoft.playwright.Page;
import pages.CheckoutOverviewPage;

import java.util.List;

public class CheckoutOverviewPageActions extends CheckoutOverviewPage {

    public CheckoutOverviewPageActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickSauceLabsBackpackTitle() {
        clickElement(sauceLabsBackpackTitle);
    }

    public void clickCancelButton() {
        clickElement(cancelButton);
    }

    public void clickFinishButton() {
        clickElement(finishButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean doAllProductsHaveQuantityText() {
        return areAllElementsTextVisible(allItemQuantities);
    }

    // ==========================================
    // TOTAL PRICE CALCULATION
    // ==========================================
    public String getCalculatedPriceTotal() {
        List<String> allPrices = getAllElementsText(allItemPrices);

        return calculateExpectedTotal(allPrices);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getCheckoutOverviewPageTitleText() {
        return getElementText(checkoutOverviewPageTitle);
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

    public String getPaymentInformationLabelText() {
        return getElementText(paymentLabel);
    }

    public String getPaymentInformationValueText() {
        return getElementText(paymentValue);
    }

    public String getShippingInformationLabelText() {
        return getElementText(shippingLabel);
    }

    public String getShippingInformationValueText() {
        return getElementText(shippingValue);
    }

    public String getPriceTotalLabelText() {
        return getElementText(priceTotalLabel);
    }

    public String getItemTotalLabelText() {
        return getElementText(itemTotalLabel);
    }

    public String getTaxLabelText() {
        return getElementText(taxLabel);
    }

    public String getTotalLabelText() {
        return getElementText(totalLabel);
    }

    public String getCancelButtonText() {
        return getElementText(cancelButton);
    }

    public String getFinishButtonText() {
        return getElementText(finishButton);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getSauceLabsBackpackTitleDefaultColor() {
        return getColorAsHex(sauceLabsBackpackTitle, COLOR);
    }

    public String getCancelButtonTextColor() {
        return getColorAsHex(cancelButton, COLOR);
    }

    public String getCancelButtonBorderColor() {
        return getColorAsHex(cancelButton, BORDER_COLOR);
    }

    public String getCancelButtonBackgroundColor() {
        return getColorAsHex(cancelButton, BACKGROUND_COLOR);
    }

    public String getFinishButtonTextColor() {
        return getColorAsHex(finishButton, COLOR);
    }

    public String getFinishButtonBackgroundColor() {
        return getColorAsHex(finishButton, BACKGROUND_COLOR);
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
    public String getCheckoutOverviewPageTitleTextFont() {
        return getCssValue(checkoutOverviewPageTitle, FONT);
    }

    public String getCheckoutOverviewPageTitleTextFontSize() {
        return getCssValue(checkoutOverviewPageTitle, FONT_SIZE);
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

    public String getPaymentInformationLabelTextFont() {
        return getCssValue(paymentLabel, FONT);
    }

    public String getPaymentInformationLabelTextFontSize() {
        return getCssValue(paymentLabel, FONT_SIZE);
    }

    public String getPaymentInformationValueTextFont() {
        return getCssValue(paymentValue, FONT);
    }

    public String getPaymentInformationValueTextFontSize() {
        return getCssValue(paymentValue, FONT_SIZE);
    }

    public String getShippingInformationLabelTextFont() {
        return getCssValue(shippingLabel, FONT);
    }

    public String getShippingInformationLabelTextFontSize() {
        return getCssValue(shippingLabel, FONT_SIZE);
    }

    public String getShippingInformationValueTextFont() {
        return getCssValue(shippingValue, FONT);
    }

    public String getShippingInformationValueTextFontSize() {
        return getCssValue(shippingValue, FONT_SIZE);
    }

    public String getPriceTotalLabelTextFont() {
        return getCssValue(priceTotalLabel, FONT);
    }

    public String getPriceTotalLabelTextFontSize() {
        return getCssValue(priceTotalLabel, FONT_SIZE);
    }

    public String getItemTotalLabelTextFont() {
        return getCssValue(itemTotalLabel, FONT);
    }

    public String getItemTotalLabelTextFontSize() {
        return getCssValue(itemTotalLabel, FONT_SIZE);
    }

    public String getTaxLabelTextFont() {
        return getCssValue(taxLabel, FONT);
    }

    public String getTaxLabelTextFontSize() {
        return getCssValue(taxLabel, FONT_SIZE);
    }

    public String getTotalLabelTextFont() {
        return getCssValue(totalLabel, FONT);
    }

    public String getTotalLabelTextFontSize() {
        return getCssValue(totalLabel, FONT_SIZE);
    }

    public String getCancelButtonTextFont() {
        return getCssValue(cancelButton, FONT);
    }

    public String getCancelButtonTextFontSize() {
        return getCssValue(cancelButton, FONT_SIZE);
    }

    public String getFinishButtonTextFont() {
        return getCssValue(finishButton, FONT);
    }

    public String getFinishButtonTextFontSize() {
        return getCssValue(finishButton, FONT_SIZE);
    }
}
