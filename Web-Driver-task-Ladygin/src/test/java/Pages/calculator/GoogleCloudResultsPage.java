package Pages.calculator;

import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCloudResultsPage extends AbstractPage {

    protected GoogleCloudResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorHomePage clickOnTheFirstTerm() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//a[@class='gs-title']"))));
        List<WebElement> searchResultList = driver.findElements(By.xpath("//a[@class='gs-title']"));
        searchResultList.get(0).click();
        return new CalculatorHomePage(driver);
    }

    @Override
    public GoogleCloudResultsPage openPage() {
        throw new RuntimeException("Please don't use open page() for GoogleCloudResultsPage!");
    }
}
