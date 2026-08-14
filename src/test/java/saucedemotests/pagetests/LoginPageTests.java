package saucedemotests.pagetests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends BaseTest {

    @BeforeEach
    public void setUpLoginPage() {
        navigateToPage();
    }

    @Test
    public void loginPageTextValidationTest() {
        assertEquals("Swag Labs", loginPageActions.getLoginPageTitleText());
        assertEquals("Username", loginPageActions.getUsernameFieldText());
        assertEquals("Password", loginPageActions.getPasswordFieldText());
        assertEquals("Login", loginPageActions.getLoginButtonText());
    }

    @Test
    public void successfulLoginTest() {
        loginPageActions.login("standard_user", "secret_sauce");

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "secret_sauce", "user123"})
    public void usernameRequiredNegativeLoginTest(String password ) {
        loginPageActions.login("", password);

        assertEquals("Epic sadface: Username is required", loginPageActions.getErrorBlockText());
        assertTrue(loginPageActions.isUsernameFieldErrorIconDisplayed());
        assertEquals("#e2231a", loginPageActions.getUsernameFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "user123"})
    public void passwordRequiredNegativeLoginTest(String username) {
        loginPageActions.login(username, "");

        assertEquals("Epic sadface: Password is required", loginPageActions.getErrorBlockText());
        assertTrue(loginPageActions.isPasswordFieldErrorIconDisplayed());
        assertEquals("#e2231a", loginPageActions.getPasswordFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @CsvSource({
            "user,secret_sauce",
            "standard_user,user123"
    })
    public void usernameAndPasswordDoNotMatchNegativeLoginTest(String username, String password) {
        loginPageActions.login(username, password);

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPageActions.getErrorBlockText());
        assertTrue(loginPageActions.isUsernameFieldErrorIconDisplayed());
        assertTrue(loginPageActions.isPasswordFieldErrorIconDisplayed());
        assertEquals("#e2231a", loginPageActions.getUsernameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", loginPageActions.getPasswordFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"inventory", "cart", "checkout-step-one", "checkout-step-two", "checkout-complete"})
    public void deniedAccessToInternalPagesNegativeLoginTest(String pageName) {
        navigateToPage(pageName);

        assertEquals("Epic sadface: You can only access '/" + pageName + ".html' when you are logged in.", loginPageActions.getErrorBlockText());
        assertTrue(loginPageActions.isUsernameFieldErrorIconDisplayed());
        assertTrue(loginPageActions.isPasswordFieldErrorIconDisplayed());
        assertEquals("#e2231a", loginPageActions.getUsernameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", loginPageActions.getPasswordFieldBorderBottomErrorColor());
    }

    @Test
    public void closeErrorMessageTest() {
        loginPageActions.clickLoginButton();
        loginPageActions.clickErrorBlockXButton();

        assertFalse(loginPageActions.isErrorBlockTextDisplayed());
        assertFalse(loginPageActions.isUsernameFieldErrorIconDisplayed());
        assertFalse(loginPageActions.isPasswordFieldErrorIconDisplayed());
    }

    @Test
    public void loginPageDefaultColorsValidationTest() {
        assertEquals("#3ddc91", loginPageActions.getLoginButtonBackgroundColor());
        assertEquals("#132322", loginPageActions.getLoginButtonTextColor());

        loginPageActions.clickLoginButton();
        assertEquals("#e2231a", loginPageActions.getErrorBlockBackgroundColor());
        assertEquals("#ffffff", loginPageActions.getErrorBlockTextColor());
        assertEquals("#ffffff", loginPageActions.getErrorBlockXButtonColor());
    }

    @Test
    public void loginPageFontValidationTest() {
        assertEquals("\"DM Mono\", \"sans-serif\"", loginPageActions.getLoginPageTitleTextFont());
        assertEquals("24px", loginPageActions.getLoginPageTitleTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPageActions.getUsernameFieldTextFont());
        assertEquals("14px", loginPageActions.getUsernameFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPageActions.getPasswordFieldTextFont());
        assertEquals("14px", loginPageActions.getPasswordFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPageActions.getLoginButtonTextFont());
        assertEquals("16px", loginPageActions.getLoginButtonTextFontSize());

        loginPageActions.clickLoginButton();
        assertEquals("Roboto, Arial, Helvetica, sans-serif", loginPageActions.getErrorBlockTextFont());
        assertEquals("14px", loginPageActions.getErrorBlockTextFontSize());
    }
}
