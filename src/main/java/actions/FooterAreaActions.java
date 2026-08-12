package actions;

import com.microsoft.playwright.Page;
import components.FooterArea;

public class FooterAreaActions extends FooterArea {

    public FooterAreaActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK AND SWITCH ACTIONS
    // ==========================================
    public String clickIconAndChangeToTwitter() {
        return clickElementAndChangeToANewTab(twitterIcon);
    }

    public String clickIconAndChangeToFacebook() {
        return clickElementAndChangeToANewTab(facebookIcon);
    }

    public String clickIconAndChangeToLinkedin() {
        return clickElementAndChangeToANewTab(linkedinIcon);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getFooterPrivacyPolicyText() {
        return getElementText(footerPrivacyPolicyText);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getFooterPrivacyPolicyTextColor() {
        return getColorAsHex(footerPrivacyPolicyText, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getFooterPrivacyPolicyTextFont() {
        return getCssValue(footerPrivacyPolicyText, FONT);
    }

    public String getFooterPrivacyPolicyTextFontSize() {
        return getCssValue(footerPrivacyPolicyText, FONT_SIZE);
    }
}
