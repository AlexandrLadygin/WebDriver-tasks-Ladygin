package Tests.com.pastebinTests;

import Pages.pastebin.PastebinHomePage;
import Pages.pastebin.PastebinResultPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PastebinTests {

    private WebDriver driver;

    @Before
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //Can Win

    @Test
    @Ignore

    public void creatingNewPaste() {
        String newPasteCodeText = "Hello from WebDriver";
        String newPasteNameText = "helloweb";
        String newExpirationText = "10 Minutes";
        new PastebinHomePage(driver).openPage()
                .pasteNewCode(newPasteCodeText)
                .pasteExpirationForm(newExpirationText)
                .pasteTitleName(newPasteNameText);
    }

    //Bring It On

    @Test

    public void creatingNewPasteWithBashSyntax() {
        String newPasteCodeText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String newPasteNameText = "how to gain dominance among developers";
        String newSyntaxText = "Bash";
        String newExpirationText = "10 Minutes";

        PastebinResultPage resultPage = new PastebinHomePage(driver).openPage()
                .pasteNewCode(newPasteCodeText)
                .pasteSyntaxHighlighting(newSyntaxText)
                .pasteExpirationForm(newExpirationText)
                .pasteTitleName(newPasteNameText).clickCreateNewPaste();

        Assert.assertEquals("Invalid value of text area!", newPasteCodeText, resultPage.getTextFromRAWPasteData());
        Assert.assertEquals("Invalid value of paste title!", newPasteNameText, resultPage.getTextFromTitle());
        Assert.assertEquals("Invalid value of bash syntax!", newSyntaxText, resultPage.getTextFromSyntax());
    }

    @After
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}