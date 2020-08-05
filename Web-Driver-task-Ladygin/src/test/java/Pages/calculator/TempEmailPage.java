package Pages.calculator;

import Pages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempEmailPage extends AbstractPage {

    public TempEmailPage(WebDriver driver) {
        super(driver);
    }
    private static final String HOMEPAGE_URL = "https://dropmail.me/ru/";

    @FindBy(xpath = "//span[@class='email']")
    private WebElement xpathMailAddressField;
    @FindBy(xpath = "//pre[contains(@data-bind, 'html')]")
    private WebElement xpathTextOfMessage;
    @FindBy(xpath = "//a[contains(@class, 'btn btn-default btn-xs')]")
    private WebElement xpathHTMLFormButton;
    @FindBy(xpath = "//h2")
    private WebElement xpathCostField;


    public TempEmailPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(xpathMailAddressField));
        return this;
    }

    public String copyTempEmailAddress() {
        new WebDriverWait(driver,20000).until(ExpectedConditions.elementToBeClickable(xpathMailAddressField));
        String textEmail = xpathMailAddressField.getText();
        return textEmail;
    }

    public TempEmailPage getMessageWithEstimatedCost() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//pre[contains(@data-bind, 'html')]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", xpathHTMLFormButton);
        xpathHTMLFormButton.click();
        return  this;
    }

    public String getTextFromMessage(){
        driver.switchTo().frame(0);
        return xpathCostField.getText();
    }
}
