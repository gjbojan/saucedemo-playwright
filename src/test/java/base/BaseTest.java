package base;

import actions.LoginPageActions;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected static Playwright playwright;
    protected Page page;
    protected static Browser browser;
    protected BrowserContext browserContext;

    protected LoginPageActions loginPageActions;

    private static final String BASE_URL = "https://www.saucedemo.com/";

    @BeforeAll
    public static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    public void setUpBrowser() {
        browserContext = browser.newContext();
        page = browserContext.newPage();

        loginPageActions = new LoginPageActions(page);
    }

    public void navigateToPage() {
        page.navigate(BASE_URL);
    }

    public void navigateToPage(String relativePath) {
        page.navigate(BASE_URL + relativePath + ".html");
    }

    public void navigateAndLoginStandardUser() {
        navigateToPage();
        loginPageActions.login("standard_user", "secret_sauce");
    }

    @AfterEach
    public void tearDownTest() {
        browserContext.close();
    }

    @AfterAll
    public static void tearDownSuite() {
        browser.close();
        playwright.close();
    }
}
