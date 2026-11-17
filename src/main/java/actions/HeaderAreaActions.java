package actions;

import com.microsoft.playwright.Page;
import components.HeaderArea;

public class HeaderAreaActions extends HeaderArea {

    public HeaderAreaActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void openBurgerMenu() {
        clickElement(openBurgerMenuOption);
    }

    public void closeBurgerMenu() {
        clickElement(closeBurgerMenuOption);
    }

    public void clickBurgerMenuAllItemsOption() {
        clickElement(burgerMenuAllItemsOption);
    }

    public void clickBurgerMenuAboutOption() {
        clickElement(burgerMenuAboutOption);
    }

    public void clickBurgerMenuLogoutOption() {
        clickElement(burgerMenuLogoutOption);
    }

    public void clickBurgerMenuResetAppStateOption() {
        clickElement(burgerMenuResetAppStateOption);
    }

    public void clickCartIcon() {
        clickElement(cartIcon);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isBurgerMenuOpened() {
        return isElementVisible(closeBurgerMenuOption);
    }

    public boolean isBurgerMenuClosed() {
        return isElementVisible(openBurgerMenuOption);
    }

    public boolean isBadgeDisplayedOnTheShoppingCartIcon() {
        return isElementVisible(badgeOnTheShoppingCart);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getHeaderTitleText() {
        return getElementText(headerAreaTitle);
    }

    public String getBurgerMenuAllItemsOptionText() {
        return getElementText(burgerMenuAllItemsOption);
    }

    public String getBurgerMenuAboutOptionText() {
        return getElementText(burgerMenuAboutOption);
    }

    public String getBurgerMenuLogoutOptionText() {
        return getElementText(burgerMenuLogoutOption);
    }

    public String getBurgerMenuResetAppStateOptionText() {
        return getElementText(burgerMenuResetAppStateOption);
    }

    // ==========================================
    // GET NUMBER ACTIONS
    // ==========================================
    public int getShoppingCartBadgeNumber() {
        return getElementNumber(badgeOnTheShoppingCart);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getBurgerMenuAllItemsOptionColor() {
        return getColorAsHex(burgerMenuAllItemsOption, COLOR);
    }

    public String getBurgerMenuAboutOptionColor() {
        return getColorAsHex(burgerMenuAboutOption, COLOR);
    }

    public String getBurgerMenuLogoutOptionColor() {
        return getColorAsHex(burgerMenuLogoutOption, COLOR);
    }

    public String getBurgerMenuResetAppStateOptionColor() {
        return getColorAsHex(burgerMenuResetAppStateOption, COLOR);
    }

    // ==========================================
    // HOVER COLOR ACTIONS
    // ==========================================
    public String getBurgerMenuAllItemsOptionHoverColor() {
        hoverElement(burgerMenuAllItemsOption);

        return getColorAsHex(burgerMenuAllItemsOption, COLOR);
    }

    public String getBurgerMenuAboutOptionHoverColor() {
        hoverElement(burgerMenuAboutOption);

        return getColorAsHex(burgerMenuAboutOption, COLOR);
    }

    public String getBurgerMenuLogoutOptionHoverColor() {
        hoverElement(burgerMenuLogoutOption);

        return getColorAsHex(burgerMenuLogoutOption, COLOR);
    }

    public String getBurgerMenuResetAppStateOptionHoverColor() {
        hoverElement(burgerMenuResetAppStateOption);

        return getColorAsHex(burgerMenuResetAppStateOption, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getHeaderAreaTitleFont() {
        return getCssValue(headerAreaTitle, FONT);
    }

    public String getHeaderAreaTitleFontSize() {
        return getCssValue(headerAreaTitle, FONT_SIZE);
    }

    public String getBurgerMenuAllItemsOptionFont() {
        return getCssValue(burgerMenuAllItemsOption, FONT);
    }

    public String getBurgerMenuAllItemsOptionFontSize() {
        return getCssValue(burgerMenuAllItemsOption, FONT_SIZE);
    }

    public String getBurgerMenuAboutOptionFont() {
        return getCssValue(burgerMenuAboutOption, FONT);
    }

    public String getBurgerMenuAboutOptionFontSize() {
        return getCssValue(burgerMenuAboutOption, FONT_SIZE);
    }

    public String getBurgerMenuLogoutOptionFont() {
        return getCssValue(burgerMenuLogoutOption, FONT);
    }

    public String getBurgerMenuLogoutOptionFontSize() {
        return getCssValue(burgerMenuLogoutOption, FONT_SIZE);
    }

    public String getBurgerMenuResetAppStateOptionFont() {
        return getCssValue(burgerMenuResetAppStateOption, FONT);
    }

    public String getBurgerMenuResetAppStateOptionFontSize() {
        return getCssValue(burgerMenuResetAppStateOption, FONT_SIZE);
    }
}
