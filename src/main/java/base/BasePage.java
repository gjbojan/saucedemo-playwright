package base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public abstract class BasePage {

    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected final String FONT = "font-family";
    protected final String FONT_SIZE = "font-size";
    protected final String COLOR = "color";
    protected final String BACKGROUND_COLOR = "background-color";
    protected final String BORDER_BOTTOM_COLOR = "border-bottom-color";
    protected final String BORDER_COLOR = "border-color";
    protected final String PLACEHOLDER = "placeholder";
    protected final String VALUE = "value";
    protected final String zToASort = "za";
    protected final String aToZSort = "az";
    protected final String pricesLowToHighSort = "lohi";
    protected final String pricesHighToLowSort = "hilo";

    protected void clickElement(Locator locator) {
        locator.click();
    }

    protected void hoverElement(Locator locator) {
        locator.hover();
    }

    protected void type(Locator locator, String text) {
        locator.fill(text);
    }

    protected String getElementText(Locator locator) {
        return locator.innerText();
    }

    protected List<String> getAllElementsText(Locator locator) {
        return locator.allInnerTexts();
    }

    protected int getElementNumber(Locator locator) {
        String numberText = locator.innerText();

        return Integer.parseInt(numberText);
    }

    protected String getPlaceHolderValue(Locator locator, String propertyName) {
        return locator.getAttribute(propertyName);
    }

    protected String getCssValue(Locator locator, String propertyName) {
        return locator.evaluate("element => getComputedStyle(element).getPropertyValue('" + propertyName + "')").toString().trim();
    }

    protected String getColorAsHex(Locator locator, String propertyName) {
        String rgb = getCssValue(locator, propertyName);

        String[] values = rgb.replace("rgb(","").replace(")", "").split(",");

        int red = Integer.parseInt(values[0].trim());
        int green = Integer.parseInt(values[1].trim());
        int blue = Integer.parseInt(values[2].trim());

        return String.format("#%02x%02x%02x", red, green, blue);
    }

    protected boolean isElementVisible(Locator locator) {
        return locator.isVisible();
    }

    protected String clickElementAndChangeToANewTab(Locator locator) {
        Page newTab = page.waitForPopup(() -> {
            clickElement(locator);
        });

        newTab.waitForLoadState();

        return newTab.url();
    }

    protected String getElementPicture(Locator locator) {
        return locator.getAttribute("src");
    }

    protected boolean areAllElementsTextVisible(Locator locator) {
        List<Locator> elementList = locator.all();

        if(elementList.isEmpty()) {
            return false;
        }

        for(int i=0; i<elementList.size(); i++) {
            String text = elementList.get(i).innerText();

            if(text == null || text.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    protected boolean areAllElementsPictureVisible(Locator locator) {
            List<Locator> elementList = locator.all();

            if(elementList.isEmpty()) {
                return false;
            }

            for (int i=0; i<elementList.size(); i++) {
                String srcValue = elementList.get(i).getAttribute("src");

                if(srcValue == null || srcValue.trim().isEmpty()) {
                    return false;
                }
            }
            return true;
    }

    public void sortProductsBy(Locator locator, String sortValue) {
        locator.selectOption(sortValue);
    }

    public boolean areElementsSortedByPriceDescending(Locator locator) {
        List<String> elementList = locator.allInnerTexts();

        for(int i=0; i<elementList.size()-1; i++) {
            double currentPrice = Double.parseDouble(elementList.get(i).replace("$", ""));
            double nextPrice = Double.parseDouble(elementList.get(i+1).replace("$", ""));

            if(currentPrice < nextPrice) {
                return false;
            }
        }
        return true;
    }

    public boolean areElementsSortedByPriceAscending(Locator locator) {
        List<String> elementList = locator.allInnerTexts();

        for(int i=0; i<elementList.size()-1; i++) {
            double currentPrice = Double.parseDouble(elementList.get(i).replace("$", ""));
            double nextPrice = Double.parseDouble(elementList.get(i+1).replace("$", ""));

            if(currentPrice > nextPrice) {
                return false;
            }
        }
        return true;
    }

    public String getElementOptionsTextByIndex(Locator dropDownLocator, int index) {
        List<String> optionsTextList = dropDownLocator.locator("option").allInnerTexts();

        return optionsTextList.get(index);
    }
}
