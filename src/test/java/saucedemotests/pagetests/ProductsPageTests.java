package saucedemotests.pagetests;

import actions.HeaderAreaActions;
import actions.ProductsPageActions;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsPageTests extends BaseTest {

    private ProductsPageActions productsPageActions;
    private HeaderAreaActions headerAreaActions;

    private static final String DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    private static final String PICTURE = "/assets/sauce-backpack-1200x1500-CjRW-Djj.jpg";

    @BeforeEach
    public void setUpProductsPage() {
        navigateAndLoginStandardUser();

        productsPageActions = new ProductsPageActions(page);
        headerAreaActions = new HeaderAreaActions(page);
    }

    @Test
    public void productsPageTitleValidationTest() {
        assertEquals("Products", productsPageActions.getProductPageTitleText());
    }

    @Test
    public void verifyFeaturedProductContentAndButtonToggleTest() {
        assertEquals("Sauce Labs Backpack", productsPageActions.getSauceLabsBackpackTitleText());
        assertEquals(DESCRIPTION, productsPageActions.getSauceLabsBackpackDescriptionText());
        assertEquals(PICTURE, productsPageActions.getSauceLabsBackpackPictureUrl());
        assertEquals("$29.99", productsPageActions.getSauceLabsBackpackPriceText());
        assertEquals("Add to cart", productsPageActions.getSauceLabsBackpackAddToCartButtonText());

        productsPageActions.clickSauceLabsBackpackAddToCartButton();
        assertEquals("Remove", productsPageActions.getSauceLabsBackpackRemoveButtonText());
    }

    @Test
    public void productsGridLayoutSanityCheck() {
        assertTrue(productsPageActions.doAllProductsHaveTitle());
        assertTrue(productsPageActions.doAllProductsHaveDescription());
        assertTrue(productsPageActions.doAllProductsHavePicture());
        assertTrue(productsPageActions.doAllProductsHavePrice());
        assertTrue(productsPageActions.doAllProductsHaveAddToCartButton());
    }

    @Test
    public void functionalUsageOfAddToCartButtonTest() {
        productsPageActions.clickSauceLabsBackpackAddToCartButton();

        assertFalse(productsPageActions.isSauceLabsBackpackAddToCartButtonDisplayed());
        assertTrue(productsPageActions.isSauceLabsBackpackRemoveButtonDisplayed());
        assertTrue(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void functionalUsageOfRemoveButtonTest() {
        productsPageActions.clickSauceLabsBackpackAddToCartButton();

        productsPageActions.clickSauceLabsBackpackRemoveButton();
        assertFalse(productsPageActions.isSauceLabsBackpackRemoveButtonDisplayed());
        assertTrue(productsPageActions.isSauceLabsBackpackAddToCartButtonDisplayed());
        assertFalse(headerAreaActions.isBadgeDisplayedOnTheShoppingCartIcon());
    }

    @Test
    public void validateChangingOfTheNumberInTheBadgeOnTheCartIconTest() {
        productsPageActions.clickSauceLabsBackpackAddToCartButton();
        assertEquals(1, headerAreaActions.getShoppingCartBadgeNumber());

        productsPageActions.clickSauceLabsOnesieAddToCartButton();
        assertEquals(2, headerAreaActions.getShoppingCartBadgeNumber());

        productsPageActions.clickSauceLabsOnesieRemoveButton();
        assertEquals(1, headerAreaActions.getShoppingCartBadgeNumber());
    }

    @Test
    public void clickableProductTitleTest() {
        productsPageActions.clickSauceLabsBackpackTitle();

        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", page.url());
    }

    @Test
    public void clickableProductPictureTest() {
        productsPageActions.clickSauceLabsBackpackPicture();

        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", page.url());
    }

    @Test
    public void dropDownMenuOptionTextValidationTest() {
        assertEquals("Name (A to Z)", productsPageActions.getNameAToZSortOptionText());
        assertEquals("Name (Z to A)", productsPageActions.getNameZToASortOptionText());
        assertEquals("Price (low to high)", productsPageActions.getPriceLowToHighSortOptionText());
        assertEquals("Price (high to low)", productsPageActions.getPriceHighToLowSortOptionText());

    }

    @Test
    public void verifySortingZToATest() {
        List<String> expectedList = productsPageActions.getAllProductsText();

        expectedList.sort(Collections.reverseOrder());
        productsPageActions.dropDownMenuSortZToA();

        List<String> actualList = productsPageActions.getAllProductsText();

        assertEquals(expectedList, actualList);
    }

    @Test
    public void verifySortingAToZTest() {
        productsPageActions.dropDownMenuSortZToA();
        List<String> expectedList = productsPageActions.getAllProductsText();

        productsPageActions.dropDownMenuSortAToZ();
        List<String> actualList = productsPageActions.getAllProductsText();
        Collections.sort(expectedList);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void verifySortingPricesDescendingTest() {
        productsPageActions.dropDownMenuSortDescending();

        assertTrue(productsPageActions.areProductPricesDescending());
    }

    @Test
    public void verifySortingPricesAscendingTest() {
        productsPageActions.dropDownMenuSortAscending();

        assertTrue(productsPageActions.areProductPricesAscending());
    }

    @Test
    public void productPageTitleFontValidationTest() {
        assertEquals("\"DM Sans\", sans-serif", productsPageActions.getProductPageTitleTextFont());
        assertEquals("18px", productsPageActions.getProductPageTitleTextFontSize());
    }

    @Test
    public void productColorValidationTest() {
        assertEquals("#18583a", productsPageActions.getSauceLabsBackpackTitleColor());
        assertEquals("#3ddc91", productsPageActions.getSauceLabsBackpackTitleHoverColor());
    }

    @Test
    public void productFontValidationTest() {
        assertEquals("\"DM Mono\", sans-serif", productsPageActions.getSauceLabsBackpackTitleFont());
        assertEquals("20px", productsPageActions.getSauceLabsBackpackTitleFontSize());

        assertEquals("\"DM Sans\", sans-serif", productsPageActions.getSauceLabsBackpackDescriptionFont());
        assertEquals("14px", productsPageActions.getSauceLabsBackpackDescriptionFontSize());

        assertEquals("\"DM Mono\", sans-serif", productsPageActions.getSauceLabsBackpackPriceFont());
        assertEquals("20px", productsPageActions.getSauceLabsBackpackPriceFontSize());
    }

    @Test
    public void productButtonsColorValidationTest() {
        assertEquals("#132322", productsPageActions.getSauceLabsBackpackAddToCartButtonTextColor());
        assertEquals("#132322", productsPageActions.getSauceLabsBackpackAddToCartButtonBorderColor());
        assertEquals("#ffffff", productsPageActions.getSauceLabsBackpackAddToCartButtonBackgroundColor());

        productsPageActions.clickSauceLabsBackpackAddToCartButton();
        assertEquals("#e2231a", productsPageActions.getSauceLabsBackpackRemoveButtonTextColor());
        assertEquals("#e2231a", productsPageActions.getSauceLabsBackpackRemoveButtonBorderColor());
        assertEquals("#ffffff", productsPageActions.getSauceLabsBackpackRemoveButtonBackgroundColor());
    }

    @Test
    public void productButtonsFontValidationTest() {
        assertEquals("\"DM Sans\", sans-serif", productsPageActions.getSauceLabsBackpackAddToCartButtonTextFont());
        assertEquals("16px", productsPageActions.getSauceLabsBackpackAddToCartButtonTextFontSize());

        productsPageActions.clickSauceLabsBackpackAddToCartButton();
        assertEquals("\"DM Sans\", sans-serif", productsPageActions.getSauceLabsBackpackRemoveButtonTextFont());
        assertEquals("16px", productsPageActions.getSauceLabsBackpackRemoveButtonTextFontSize());
    }
}
