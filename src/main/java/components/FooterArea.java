package components;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FooterArea extends BasePage {

    public FooterArea (Page page) {
        super(page);

        footerPrivacyPolicyText = page.locator(".footer_copy");
        twitterIcon = page.locator(".social_twitter");
        facebookIcon = page.locator(".social_facebook");
        linkedinIcon = page.locator(".social_linkedin");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator footerPrivacyPolicyText;
    protected final Locator twitterIcon;
    protected final Locator facebookIcon;
    protected final Locator linkedinIcon;
}
