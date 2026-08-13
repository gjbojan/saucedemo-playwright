package actions;

import com.microsoft.playwright.Page;
import pages.LoginPage;

public class LoginPageActions extends LoginPage {

    public LoginPageActions(Page page) {
        super(page);
    }

    // ==========================================
    // LOGIN ACTION
    // ==========================================
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        clickLoginButton();
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickErrorBlockXButton() {
        clickElement(errorBlockXButton);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getLoginPageTitleText() {
        return getElementText(loginPageTitle);
    }

    public String getUsernameFieldText() {
        return getElementAttributeValue(usernameField, PLACEHOLDER);
    }

    public String getPasswordFieldText() {
        return getElementAttributeValue(passwordField, PLACEHOLDER);
    }

    public String getLoginButtonText() {
        return getElementAttributeValue(loginButton, VALUE);
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

    public boolean isUsernameFieldErrorIconDisplayed() {
        return isElementVisible(usernameFieldErrorIcon);
    }

    public boolean isPasswordFieldErrorIconDisplayed() {
        return isElementVisible(passwordFieldErrorIcon);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getLoginButtonBackgroundColor() {
        return getColorAsHex(loginButton, BACKGROUND_COLOR);
    }

    public String getLoginButtonTextColor() {
        return getColorAsHex(loginButton, COLOR);
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

    public String getUsernameFieldBorderBottomErrorColor() {
        return getColorAsHex(usernameField, BORDER_BOTTOM_COLOR);
    }

    public String getPasswordFieldBorderBottomErrorColor() {
        return getColorAsHex(passwordField, BORDER_BOTTOM_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getLoginPageTitleTextFont() {
        return getCssValue(loginPageTitle, FONT);
    }

    public String getLoginPageTitleTextFontSize() {
        return getCssValue(loginPageTitle, FONT_SIZE);
    }

    public String getUsernameFieldTextFont() {
        return getCssValue(usernameField, FONT);
    }

    public String getUsernameFieldTextFontSize() {
        return getCssValue(usernameField, FONT_SIZE);
    }

    public String getPasswordFieldTextFont() {
        return getCssValue(passwordField, FONT);
    }

    public String getPasswordFieldTextFontSize() {
        return getCssValue(passwordField, FONT_SIZE);
    }

    public String getLoginButtonTextFont() {
        return getCssValue(loginButton, FONT);
    }

    public String getLoginButtonTextFontSize() {
        return getCssValue(loginButton, FONT_SIZE);
    }

    public String getErrorBlockTextFont() {
        return getCssValue(errorBlockText, FONT);
    }

    public String getErrorBlockTextFontSize() {
        return getCssValue(errorBlockText, FONT_SIZE);
    }
}
