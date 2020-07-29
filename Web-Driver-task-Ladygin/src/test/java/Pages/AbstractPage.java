package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected abstract AbstractPage openPage();

    public void createNewTab() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open();");
    }

    public void switchTabByIndex(int index) {
        ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allTabs.get(index));
    }
}
