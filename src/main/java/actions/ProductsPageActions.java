package actions;

import com.microsoft.playwright.Page;
import pages.ProductsPage;

import java.util.List;

public class ProductsPageActions extends ProductsPage {

    public ProductsPageActions (Page page) {
        super(page);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickSauceLabsBackpackAddToCartButton() {
        clickElement(sauceLabsBackpackAddToCartButton);
    }

    public void clickSauceLabsBackpackRemoveButton() {
        clickElement(sauceLabsBackpackRemoveButton);
    }

    public void clickSauceLabsOnesieAddToCartButton() {
        clickElement(sauceLabsOnesieAddToCartButton);
    }

    public void clickSauceLabsOnesieRemoveButton() {
        clickElement(sauceLabsOnesieRemoveButton);
    }

    public void clickSauceLabsBackpackTitle() {
        clickElement(sauceLabsBackpackTitle);
    }

    public void clickSauceLabsBackpackPicture() {
        clickElement(sauceLabsBackpackPicture);
    }

    // ==========================================
    // SORTING ACTIONS
    // ==========================================
    public void dropDownMenuSortZToA() {
        sortProductsBy(dropDownMenu, Z_TO_A_SORT);
    }

    public void dropDownMenuSortAToZ() {
        sortProductsBy(dropDownMenu, A_TO_Z_SORT);
    }

    public void dropDownMenuSortDescending() {
        sortProductsBy(dropDownMenu, PRICES_HIGH_TO_LOW_SORT);
    }

    public void dropDownMenuSortAscending() {
        sortProductsBy(dropDownMenu, PRICES_LOW_TO_HIGH_SORT);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isSauceLabsBackpackRemoveButtonDisplayed() {
        return isElementVisible(sauceLabsBackpackRemoveButton);
    }

    public boolean isSauceLabsBackpackAddToCartButtonDisplayed() {
        return isElementVisible(sauceLabsBackpackAddToCartButton);
    }

    public boolean doAllProductsHaveTitle() {
        return areAllElementsTextVisible(allProductTitles);
    }

    public boolean doAllProductsHaveDescription() {
        return areAllElementsTextVisible(allProductDescriptions);
    }

    public boolean doAllProductsHavePrice() {
        return areAllElementsTextVisible(allProductPrices);
    }

    public boolean doAllProductsHavePicture() {
        return areAllElementsPictureVisible(allProductPictures);
    }

    public boolean doAllProductsHaveAddToCartButton() {
        return areAllElementsTextVisible(allProductAddToCartButtons);
    }

    public boolean areProductPricesDescending() {
        return areElementsSortedByPriceDescending(allProductPrices);
    }

    public boolean areProductPricesAscending() {
        return areElementsSortedByPriceAscending(allProductPrices);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getProductPageTitleText() {
        return getElementText(productsPageTitle);
    }

    public String getSauceLabsBackpackTitleText() {
        return getElementText(sauceLabsBackpackTitle);
    }

    public String getSauceLabsBackpackDescriptionText() {
        return getElementText(sauceLabsBackpackDescription);
    }

    public String getSauceLabsBackpackPriceText() {
        return getElementText(sauceLabsBackpackPrice);
    }

    public String getSauceLabsBackpackAddToCartButtonText() {
        return getElementText(sauceLabsBackpackAddToCartButton);
    }

    public String getSauceLabsBackpackRemoveButtonText() {
        return getElementText(sauceLabsBackpackRemoveButton);
    }

    public List<String> getAllProductsText() {
        return getAllElementsText(allProductTitles);
    }

    public String getNameAToZSortOptionText() {
        return getElementOptionsTextByIndex(dropDownMenu, 0);
    }

    public String getNameZToASortOptionText() {
        return getElementOptionsTextByIndex(dropDownMenu, 1);
    }

    public String getPriceLowToHighSortOptionText() {
        return getElementOptionsTextByIndex(dropDownMenu, 2);
    }

    public String getPriceHighToLowSortOptionText() {
        return getElementOptionsTextByIndex(dropDownMenu, 3);
    }

    // ==========================================
    // GET IMAGE ACTIONS
    // ==========================================
    public String getSauceLabsBackpackPictureUrl() {
        return getElementPicture(sauceLabsBackpackPicture);
    }

    // ==========================================
    // COLOR ACTIONS
    // ==========================================
    public String getSauceLabsBackpackTitleColor() {
        return getColorAsHex(sauceLabsBackpackTitle, COLOR);
    }

    public String getSauceLabsBackpackAddToCartButtonTextColor() {
        return getColorAsHex(sauceLabsBackpackAddToCartButton, COLOR);
    }

    public String getSauceLabsBackpackAddToCartButtonBorderColor() {
        return getColorAsHex(sauceLabsBackpackAddToCartButton, BORDER_COLOR);
    }

    public String getSauceLabsBackpackAddToCartButtonBackgroundColor() {
        return getColorAsHex(sauceLabsBackpackAddToCartButton, BACKGROUND_COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonTextColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonBorderColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, BORDER_COLOR);
    }

    public String getSauceLabsBackpackRemoveButtonBackgroundColor() {
        return getColorAsHex(sauceLabsBackpackRemoveButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // HOVER COLOR ACTIONS
    // ==========================================
    public String getSauceLabsBackpackTitleHoverColor() {
        hoverElement(sauceLabsBackpackTitle);

        return getColorAsHex(sauceLabsBackpackTitle, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getProductPageTitleTextFont() {
        return getCssValue(productsPageTitle, FONT);
    }

    public String getProductPageTitleTextFontSize() {
        return getCssValue(productsPageTitle, FONT_SIZE);
    }

    public String getSauceLabsBackpackTitleFont() {
        return getCssValue(sauceLabsBackpackTitle, FONT);
    }

    public String getSauceLabsBackpackTitleFontSize() {
        return getCssValue(sauceLabsBackpackTitle, FONT_SIZE);
    }

    public String getSauceLabsBackpackDescriptionFont() {
        return getCssValue(sauceLabsBackpackDescription, FONT);
    }

    public String getSauceLabsBackpackDescriptionFontSize() {
        return getCssValue(sauceLabsBackpackDescription, FONT_SIZE);
    }

    public String getSauceLabsBackpackPriceFont() {
        return getCssValue(sauceLabsBackpackPrice, FONT);
    }

    public String getSauceLabsBackpackPriceFontSize() {
        return getCssValue(sauceLabsBackpackPrice, FONT_SIZE);
    }

    public String getSauceLabsBackpackAddToCartButtonTextFont() {
        return getCssValue(sauceLabsBackpackAddToCartButton, FONT);
    }

    public String getSauceLabsBackpackAddToCartButtonTextFontSize() {
        return getCssValue(sauceLabsBackpackAddToCartButton, FONT_SIZE);
    }

    public String getSauceLabsBackpackRemoveButtonTextFont() {
        return getCssValue(sauceLabsBackpackRemoveButton, FONT);
    }

    public String getSauceLabsBackpackRemoveButtonTextFontSize() {
        return getCssValue(sauceLabsBackpackRemoveButton, FONT_SIZE);
    }
}
