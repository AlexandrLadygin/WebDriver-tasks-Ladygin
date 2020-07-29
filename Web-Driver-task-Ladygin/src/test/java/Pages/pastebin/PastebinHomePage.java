package Pages.pastebin;

import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private String baseXpath = "//*[@class='select2-results__option' and text()='%s']";

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement textAreaField;
    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingField;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationField;
    @FindBy (xpath = "//*[@id='postform-name']")
    private WebElement pasteTitleField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteButton;

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='postform-text']")));
        return this;
    }

    public PastebinHomePage pasteNewCode(String codeText){
        textAreaField.sendKeys(codeText);
        return this;
    }

    public PastebinHomePage pasteExpirationForm(String time){
        pasteExpirationField.click();
        String fullXpathForElement = String.format(baseXpath, time);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public PastebinHomePage pasteSyntaxHighlighting(String syntax){
        syntaxHighlightingField.click();
        String fullXpathForElement = String.format(baseXpath, syntax);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public PastebinHomePage pasteTitleName(String name){
        pasteTitleField.sendKeys(name);
        return this;
    }

    public PastebinResultPage clickCreateNewPaste (){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(createNewPasteButton));
        createNewPasteButton.click();
        return new PastebinResultPage(driver);
    }
}