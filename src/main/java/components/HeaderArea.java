package components;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderArea extends BasePage {

    public HeaderArea (Page page) {
        super(page);

        headerAreaTitle = page.locator(".app_logo");
        openBurgerMenuOption = page.locator("#react-burger-menu-btn");
        cartIcon = page.locator(".shopping_cart_link");
        badgeOnTheShoppingCart = page.locator(".shopping_cart_badge");
        closeBurgerMenuOption = page.locator("#react-burger-cross-btn");
        burgerMenuAllItemsOption = page.locator("#inventory_sidebar_link");
        burgerMenuAboutOption = page.locator("#about_sidebar_link");
        burgerMenuLogoutOption = page.locator("#logout_sidebar_link");
        burgerMenuResetAppStateOption = page.locator("#reset_sidebar_link");
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    protected final Locator headerAreaTitle;
    protected final Locator openBurgerMenuOption;
    protected final Locator cartIcon;
    protected final Locator badgeOnTheShoppingCart;
    protected final Locator closeBurgerMenuOption;
    protected final Locator burgerMenuAllItemsOption;
    protected final Locator burgerMenuAboutOption;
    protected final Locator burgerMenuLogoutOption;
    protected final Locator burgerMenuResetAppStateOption;
}
