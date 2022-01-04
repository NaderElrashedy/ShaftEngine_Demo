package home;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import result.ResultPage;

public class HomePage {
    //variables
    private WebDriver driver;
    private final String url = System.getProperty("googleUrl");

    //locators
    public static By getGoogleLogo_image() {
        return By.xpath("//img[@alt='Google']");
    }

    private static By getSearch_Field() {
        return By.name("q");
    }

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //
    public HomePage navigation() {
        BrowserActions.navigateToURL(driver, url);
        return this;
    }

    /**
     * Search for giver query
     *
     * @param query that you will search
     * @return self reference
     */
    public ResultPage searchQuery(String query) {
        (new ElementActions(driver)).type(getSearch_Field(), query).keyPress(getSearch_Field(), Keys.ENTER);
        return new ResultPage(driver);
    }

}
