package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);

        loginPageTitle = page.locator(".login_logo");
        usernameField = page.locator("#user-name");
        passwordField = page.locator("#password");
        loginButton = page.locator("#login-button");
        errorBlock = page.locator(".error-message-container");
        errorBlockText = page.locator("[data-test='error']");
        errorBlockXButton = page.locator(".error-button");
        usernameFieldErrorIcon = page.locator(".form_group:has(#user-name) svg");
        passwordFieldErrorIcon = page.locator(".form_group:has(#password) svg");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator loginPageTitle;
    protected final Locator usernameField;
    protected final Locator passwordField;
    protected final Locator loginButton;
    protected final Locator errorBlock;
    protected final Locator errorBlockText;
    protected final Locator errorBlockXButton;
    protected final Locator usernameFieldErrorIcon;
    protected final Locator passwordFieldErrorIcon;
}
