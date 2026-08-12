package saucedemotests.pagetests;

import actions.LoginActions;
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
        loginActions = new LoginActions(page);
    }

    @Test
    public void loginPageTextValidationTest() {
        assertEquals("Swag Labs", loginActions.getLoginPageTitleText());
        assertEquals("Username", loginActions.getUsernameFieldText());
        assertEquals("Password", loginActions.getPasswordFieldText());
        assertEquals("Login", loginActions.getLoginButtonText());
    }

    @Test
    public void successfulLoginTest() {
        loginActions.login("standard_user", "secret_sauce");

        assertEquals("https://www.saucedemo.com/inventory.html", page.url());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "secret_sauce", "user123"})
    public void usernameRequiredNegativeLoginTest(String password ) {
        loginActions.login("", password);

        assertEquals("Epic sadface: Username is required", loginActions.getErrorBlockMessageText());
        assertTrue(loginActions.isUsernameErrorIconDisplayed());
        assertEquals("#e2231a", loginActions.getUsernameFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "user123"})
    public void passwordRequiredNegativeLoginTest(String username) {
        loginActions.login(username, "");

        assertEquals("Epic sadface: Password is required", loginActions.getErrorBlockMessageText());
        assertTrue(loginActions.isPasswordErrorIconDisplayed());
        assertEquals("#e2231a", loginActions.getPasswordFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @CsvSource({
            "user,secret_sauce",
            "standard_user,user123"
    })
    public void usernameAndPasswordDoNotMatchNegativeLoginTest(String username, String password) {
        loginActions.login(username, password);

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginActions.getErrorBlockMessageText());
        assertTrue(loginActions.isUsernameErrorIconDisplayed());
        assertTrue(loginActions.isPasswordErrorIconDisplayed());
        assertEquals("#e2231a", loginActions.getUsernameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", loginActions.getPasswordFieldBorderBottomErrorColor());
    }

    @Test
    public void closeErrorMessageTest() {
        loginActions.clickLoginButton();
        loginActions.clickErrorBlockXButton();

        assertFalse(loginActions.isErrorBlockDisplayed());
    }

    @Test
    public void loginPageDefaultColorsValidationTest() {
        assertEquals("#3ddc91", loginActions.getLoginButtonBackgroundColor());
        assertEquals("#132322", loginActions.getLoginButtonTextColor());

        loginActions.clickLoginButton();
        assertEquals("#e2231a", loginActions.getErrorBlockBackgroundColor());
        assertEquals("#ffffff", loginActions.getErrorBlockTextColor());
    }

    @Test
    public void loginPageFontValidationTest() {
        assertEquals("\"DM Mono\", \"sans-serif\"", loginActions.getLoginPageTitleTextFont());
        assertEquals("24px", loginActions.getLoginPageTitleTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginActions.getUsernameFieldTextFont());
        assertEquals("14px", loginActions.getUsernameFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginActions.getPasswordFieldTextFont());
        assertEquals("14px", loginActions.getPasswordFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginActions.getLoginButtonTextFont());
        assertEquals("16px", loginActions.getLoginButtonTextFontSize());

        loginActions.clickLoginButton();
        assertEquals("Roboto, Arial, Helvetica, sans-serif", loginActions.getErrorBlockTextFont());
        assertEquals("14px", loginActions.getErrorBlockTextFontSize());
    }
}
