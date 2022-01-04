package testpackage;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import home.HomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import result.ResultPage;

public class TestClass {
    private WebDriver driver;
    private JSONFileManager testData = new JSONFileManager("src/test/resources/testDataFiles/googleSearch.json");

    @Description("Given that browser is opened when I am on goodle and tybe nader then google still appear")
    @Test
    public void testGoogleImage() {
        new HomePage(driver).navigation();
        Validations.assertThat().element(driver, HomePage.getGoogleLogo_image()).matchesReferenceImage().withCustomReportMessage("check that goodle img is displayed").perform();
    }

    @Description("Given that browser is opened when I search for shaft then result status should appear ")

    @Test
    public void checkResultStatus() {

        new HomePage(driver).navigation().searchQuery(testData.getTestData("query"));
        Validations.assertThat().element(driver, ResultPage.getResultStatus()).text().doesNotEqual("").perform();

    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();

    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }

}
