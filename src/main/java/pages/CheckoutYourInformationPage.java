package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutYourInformationPage extends BasePage {

    public CheckoutYourInformationPage (Page page) {
        super(page);

        checkoutYourInformationPageTitle = page.locator("[data-test='title']");
        cancelButton = page.locator("#cancel");
        continueButton = page.locator("input[type='submit'][name='continue']");
        firstNameField = page.locator("#first-name");
        lastNameField = page.locator("#last-name");
        postalCodeField = page.locator("#postal-code");
        errorBlock = page.locator(".error-message-container");
        errorBlockText = page.locator("[data-test='error']");
        errorBlockXButton = page.locator(".error-button");
        firstNameFieldErrorIcon = page.locator(".form_group:has(#first-name) svg");
        lastNameFieldErrorIcon = page.locator(".form_group:has(#last-name) svg");
        postalCodeFieldErrorIcon = page.locator(".form_group:has(#postal-code) svg");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator checkoutYourInformationPageTitle;
    protected final Locator cancelButton;
    protected final Locator continueButton;
    protected final Locator firstNameField;
    protected final Locator lastNameField;
    protected final Locator postalCodeField;
    protected final Locator errorBlock;
    protected final Locator errorBlockText;
    protected final Locator errorBlockXButton;
    protected final Locator firstNameFieldErrorIcon;
    protected final Locator lastNameFieldErrorIcon;
    protected final Locator postalCodeFieldErrorIcon;
}
