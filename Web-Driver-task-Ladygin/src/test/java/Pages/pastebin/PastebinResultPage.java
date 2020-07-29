package Pages.pastebin;

import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinResultPage extends AbstractPage {

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@class='textarea']")
    private WebElement textFromRAWPasteData;
    @FindBy(xpath = "//*[@class='info-top']")
    private WebElement title;
    @FindBy(xpath = "//a[text() = 'Bash']")
    private WebElement syntaxInfo;

    public String getTextFromRAWPasteData (){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='notice -success -post-view']")));
        return textFromRAWPasteData.getAttribute("value");
    }

    public String getTextFromTitle(){
        return title.getText();
    }

    public String getTextFromSyntax(){
        return syntaxInfo.getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please don't use method OPEN PAGE here!");
    }
}


