package Pages.calculator;

import Pages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchButton;

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchButton));
        return this;
    }

    public GoogleCloudResultsPage searchResultsForTerms(String term) {
        searchButton.click();
        searchButton.sendKeys(term + Keys.ENTER);
        return new GoogleCloudResultsPage(driver);
    }
}
