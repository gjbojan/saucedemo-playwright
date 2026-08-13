package saucedemotests.pagetests;

import actions.CheckoutYourInformationPageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutYourInformationPageTests extends BaseTest {

    private CheckoutYourInformationPageActions checkoutYourInformationPageActions;

    @BeforeEach
    public void setUpCheckoutYourInformationPage() {
        navigateAndLoginStandardUser();
        navigateToPage("checkout-step-one");

        checkoutYourInformationPageActions = new CheckoutYourInformationPageActions(page);
    }

    @Test
    public void checkoutYourInformationPageTextValidationTest() {
        assertEquals("Checkout: Your Information", checkoutYourInformationPageActions.getCheckoutYourInformationPageTitleText());
        assertEquals("First Name", checkoutYourInformationPageActions.getFirstNameFieldText());
        assertEquals("Last Name", checkoutYourInformationPageActions.getLastNameFieldText());
        assertEquals("Zip/Postal Code", checkoutYourInformationPageActions.getPostalCodeFieldText());
        assertEquals("Cancel", checkoutYourInformationPageActions.getCancelButtonText());
        assertEquals("Continue", checkoutYourInformationPageActions.getContinueButtonText());
    }

    @Test
    public void successfulCheckoutInformationSubmission() {
        checkoutYourInformationPageActions.fillInformationAndContinue("Marko", "Stankovic", "1000");

        assertEquals("https://www.saucedemo.com/checkout-step-two.html", page.url());
    }

    @ParameterizedTest
    @CsvSource({
            "'',''",
            "Stankovic,''",
            "'', 1000",
            "Stankovic, 1000"
    })
    public void firstNameIsRequiredNegativeSubmissionTest(String lastName, String postalCode) {
        checkoutYourInformationPageActions.fillInformationAndContinue("", lastName, postalCode);

        assertEquals("Error: First Name is required", checkoutYourInformationPageActions.getErrorBlockText());
        assertTrue(checkoutYourInformationPageActions.isFirstNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isLastNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isPostalCodeFieldErrorIconDisplayed());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getFirstNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getLastNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getPostalCodeFieldBorderBottomErrorColor());
    }

    @ParameterizedTest
    @CsvSource({
            "Marko,''",
            "Marko,1000"
    })
    public void lastNameIsRequiredNegativeSubmissionTest(String firstName, String postalCode) {
        checkoutYourInformationPageActions.fillInformationAndContinue(firstName, "", postalCode);

        assertEquals("Error: Last Name is required", checkoutYourInformationPageActions.getErrorBlockText());
        assertTrue(checkoutYourInformationPageActions.isFirstNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isLastNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isPostalCodeFieldErrorIconDisplayed());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getFirstNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getLastNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getPostalCodeFieldBorderBottomErrorColor());
    }

    @Test
    public void postalCodeIsRequiredNegativeSubmissionTest() {
        checkoutYourInformationPageActions.fillInformationAndContinue("Marko", "Stankovic", "");

        assertEquals("Error: Postal Code is required", checkoutYourInformationPageActions.getErrorBlockText());
        assertTrue(checkoutYourInformationPageActions.isFirstNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isLastNameFieldErrorIconDisplayed());
        assertTrue(checkoutYourInformationPageActions.isPostalCodeFieldErrorIconDisplayed());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getFirstNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getLastNameFieldBorderBottomErrorColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getPostalCodeFieldBorderBottomErrorColor());
    }

    @Test
    public void closeErrorMessageTest() {
        checkoutYourInformationPageActions.clickContinueButton();
        checkoutYourInformationPageActions.clickErrorBlockXButton();

        assertFalse(checkoutYourInformationPageActions.isErrorBlockDisplayed());
        assertFalse(checkoutYourInformationPageActions.isFirstNameFieldErrorIconDisplayed());
        assertFalse(checkoutYourInformationPageActions.isLastNameFieldErrorIconDisplayed());
        assertFalse(checkoutYourInformationPageActions.isPostalCodeFieldErrorIconDisplayed());
    }

    @Test
    public void functionalUsageOfCancelButtonTest() {
        checkoutYourInformationPageActions.clickCancelButton();

        assertEquals("https://www.saucedemo.com/cart.html", page.url());
    }

    @Test
    public void checkoutYourInformationPageDefaultColorsValidationTest() {
        assertEquals("#132322", checkoutYourInformationPageActions.getCancelButtonTextColor());
        assertEquals("#132322", checkoutYourInformationPageActions.getCancelButtonBorderColor());
        assertEquals("#ffffff", checkoutYourInformationPageActions.getCancelButtonBackgroundColor());

        assertEquals("#132322", checkoutYourInformationPageActions.getContinueButtonTextColor());
        assertEquals("#3ddc91", checkoutYourInformationPageActions.getContinueButtonBackgroundColor());

        checkoutYourInformationPageActions.clickContinueButton();
        assertEquals("#ffffff", checkoutYourInformationPageActions.getErrorBlockTextColor());
        assertEquals("#e2231a", checkoutYourInformationPageActions.getErrorBlockBackgroundColor());
        assertEquals("#ffffff", checkoutYourInformationPageActions.getErrorBlockXButtonColor());
    }

    @Test
    public void checkoutYourInformationPageFontValidationTest() {
        assertEquals("\"DM Sans\", sans-serif", checkoutYourInformationPageActions.getCheckoutYourInformationPageTitleTextFont());
        assertEquals("18px", checkoutYourInformationPageActions.getCheckoutYourInformationPageTitleTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformationPageActions.getFirstNameFieldTextFont());
        assertEquals("14px", checkoutYourInformationPageActions.getFirstNameFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformationPageActions.getLastNameFieldTextFont());
        assertEquals("14px", checkoutYourInformationPageActions.getLastNameFieldTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformationPageActions.getPostalCodeFieldTextFont());
        assertEquals("14px", checkoutYourInformationPageActions.getPostalCodeFieldTextFontSize());

        assertEquals("\"DM Sans\", sans-serif", checkoutYourInformationPageActions.getCancelButtonTextFont());
        assertEquals("16px", checkoutYourInformationPageActions.getCancelButtonTextFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformationPageActions.getContinueButtonTextFont());
        assertEquals("16px", checkoutYourInformationPageActions.getContinueButtonTextFontSize());

        checkoutYourInformationPageActions.clickContinueButton();
        assertEquals("Roboto, Arial, Helvetica, sans-serif", checkoutYourInformationPageActions.getErrorBlockTextFont());
        assertEquals("14px", checkoutYourInformationPageActions.getErrorBlockTextFontSize());
    }
}
