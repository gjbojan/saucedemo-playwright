package actions;

import com.microsoft.playwright.Page;
import pages.CheckoutYourInformationPage;

public class CheckoutYourInformationPageActions extends CheckoutYourInformationPage {

    public CheckoutYourInformationPageActions (Page page) {
        super(page);
    }

    // ==========================================
    // FORM INTERACTION ACTIONS
    // ==========================================
    public void fillInformationAndContinue(String firstname, String lastName, String postalCode) {
        type(firstNameField, firstname);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);

        clickElement(continueButton);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickContinueButton() {
        clickElement(continueButton);
    }

    public void clickCancelButton() {
        clickElement(cancelButton);
    }

    public void clickErrorBlockXButton() {
        clickElement(errorBlockXButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getCheckoutYourInformationPageTitleText() {
        return getElementText(checkoutYourInformationPageTitle);
    }

    public String getFirstNameFieldText() {
        return getElementAttributeValue(firstNameField, PLACEHOLDER);
    }

    public String getLastNameFieldText() {
        return getElementAttributeValue(lastNameField, PLACEHOLDER);
    }

    public String getPostalCodeFieldText() {
        return getElementAttributeValue(postalCodeField, PLACEHOLDER);
    }

    public String getCancelButtonText() {
        return getElementText(cancelButton);
    }

    public String getContinueButtonText() {
        return getElementAttributeValue(continueButton, VALUE);
    }

    public String getErrorBlockText() {
        return getElementText(errorBlockText);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isErrorBlockDisplayed() {
        return isElementVisible(errorBlockText);
    }

    public boolean isFirstNameFieldErrorIconDisplayed() {
        return isElementVisible(firstNameFieldErrorIcon);
    }

    public boolean isLastNameFieldErrorIconDisplayed() {
        return isElementVisible(lastNameFieldErrorIcon);
    }

    public boolean isPostalCodeFieldErrorIconDisplayed() {
        return isElementVisible(postalCodeFieldErrorIcon);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getCancelButtonTextColor() {
        return getColorAsHex(cancelButton, COLOR);
    }

    public String getCancelButtonBorderColor() {
        return getColorAsHex(cancelButton, BORDER_COLOR);
    }

    public String getCancelButtonBackgroundColor() {
        return getColorAsHex(cancelButton, BACKGROUND_COLOR);
    }

    public String getContinueButtonTextColor() {
        return getColorAsHex(continueButton, COLOR);
    }

    public String getContinueButtonBackgroundColor() {
        return getColorAsHex(continueButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // ERROR COLOR ACTIONS
    // ==========================================
    public String getErrorBlockBackgroundColor() {
        return getColorAsHex(errorBlock, BACKGROUND_COLOR);
    }

    public String getErrorBlockTextColor() {
        return getColorAsHex(errorBlockText, COLOR);
    }

    public String getErrorBlockXButtonColor() {
        return getColorAsHex(errorBlockXButton, COLOR);
    }

    public String getFirstNameFieldBorderBottomErrorColor() {
        return getColorAsHex(firstNameField, BORDER_BOTTOM_COLOR);
    }

    public String getLastNameFieldBorderBottomErrorColor() {
        return getColorAsHex(lastNameField, BORDER_BOTTOM_COLOR);
    }

    public String getPostalCodeFieldBorderBottomErrorColor() {
        return getColorAsHex(postalCodeField, BORDER_BOTTOM_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getCheckoutYourInformationPageTitleTextFont() {
        return getCssValue(checkoutYourInformationPageTitle, FONT);
    }

    public String getCheckoutYourInformationPageTitleTextFontSize() {
        return getCssValue(checkoutYourInformationPageTitle, FONT_SIZE);
    }

    public String getFirstNameFieldTextFont() {
        return getCssValue(firstNameField, FONT);
    }

    public String getFirstNameFieldTextFontSize() {
        return getCssValue(firstNameField, FONT_SIZE);
    }

    public String getLastNameFieldTextFont() {
        return getCssValue(lastNameField, FONT);
    }

    public String getLastNameFieldTextFontSize() {
        return getCssValue(lastNameField, FONT_SIZE);
    }

    public String getPostalCodeFieldTextFont() {
        return getCssValue(postalCodeField, FONT);
    }

    public String getPostalCodeFieldTextFontSize() {
        return getCssValue(postalCodeField, FONT_SIZE);
    }

    public String getCancelButtonTextFont() {
        return getCssValue(cancelButton, FONT);
    }

    public String getCancelButtonTextFontSize() {
        return getCssValue(cancelButton, FONT_SIZE);
    }

    public String getContinueButtonTextFont() {
        return getCssValue(continueButton, FONT);
    }

    public String getContinueButtonTextFontSize() {
        return getCssValue(continueButton, FONT_SIZE);
    }

    public String getErrorBlockTextFont() {
        return getCssValue(errorBlockText, FONT);
    }

    public String getErrorBlockTextFontSize() {
        return getCssValue(errorBlockText, FONT_SIZE);
    }
}
