package saucedemotests.componenttests;

import actions.FooterAreaActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooterAreaTests extends BaseTest {

    private FooterAreaActions footerAreaActions;

    @BeforeEach
    public void setUpFooterArea() {
        navigateAndLoginStandardUser();

        footerAreaActions = new FooterAreaActions(page);
    }

    @Test
    public void footerAreaPrivacyPolicyTextValidationTest() {
        assertEquals("© 2026 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", footerAreaActions.getFooterPrivacyPolicyText());
    }

    @Test
    public void clickableTwitterIconTest() {
        assertEquals("https://x.com/saucelabs", footerAreaActions.clickIconAndChangeToTwitter());
    }

    @Test
    public void clickableFacebookIconTest() {
        assertEquals("https://www.facebook.com/saucelabs", footerAreaActions.clickIconAndChangeToFacebook());
    }

    @Test
    public void clickableLinkedinIcon() {
        assertEquals("https://www.linkedin.com/company/sauce-labs/", footerAreaActions.clickIconAndChangeToLinkedin());
    }

    @Test
    public void footerAreaPrivacyPolicyTextStylesTest() {
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", footerAreaActions.getFooterPrivacyPolicyTextFont());
        assertEquals("14px", footerAreaActions.getFooterPrivacyPolicyTextFontSize());
        assertEquals("#ffffff", footerAreaActions.getFooterPrivacyPolicyTextColor());
    }
}
