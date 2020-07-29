package Tests.com.pastebinTests;

import Pages.calculator.CalculatorHomePage;
import Pages.calculator.GoogleCloudHomePage;
import Pages.calculator.TempEmailPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CalculatorTests {

    private WebDriver driver;

    @Before
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //Hurt me plenty

    @Test
    public void GoogleCloudCalculatorTest (){
        CalculatorHomePage calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchResultsForTerms("Google Cloud Platform Pricing Calculator")
                .clickOnTheFirstTerm()
                .activateComputeEngine()
                .pasteNumberOfInstance("4")
                .pasteWhatAreTheseInstancesFor("")
                .chooseOperatingSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .chooseMachineClass("Regular")
                .chooseMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .addGPUs()
                .chooseNumberOfGPUs("1")
                .chooseGPUType("NVIDIA Tesla V100")
                .chooseLocalSSD("2x375 GB")
                .chooseDataCenterLocation("Frankfurt (europe-west3)")
                .chooseCommittedUsage("1 Year")
                .clickAddToEstimate();

        Assert.assertEquals("VM Class is wrong!", "VM class: regular", calculatorPage.getVMClassInfo());
        Assert.assertEquals("Instance type is wrong!", "Instance type: n1-standard-8", calculatorPage.getInstanceTypeInfo());
        Assert.assertEquals("Region is wrong!", "Region: Frankfurt", calculatorPage.getRegionInfo());
        Assert.assertEquals("Local SSD is wrong!", "Total available local SSD space 2x375 GiB", calculatorPage.getLocalSSDInfo());
        Assert.assertEquals("Commitment term is wrong!", "Commitment term: 1 Year", calculatorPage.getCommitmentTermInfo());
        Assert.assertEquals("Estimate is wrong!", "Total Estimated Cost: USD 1,082.77 per 1 month", calculatorPage.getTotalEstimatedCostInfo());
    }

    //HardCore

    @Test
    public void GoogleCloudCalculatorTestWithSendingEmail () throws IOException, UnsupportedFlavorException {
        CalculatorHomePage calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchResultsForTerms("Google Cloud Platform Pricing Calculator")
                .clickOnTheFirstTerm()
                .activateComputeEngine()
                .pasteNumberOfInstance("4")
                .pasteWhatAreTheseInstancesFor("")
                .chooseOperatingSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .chooseMachineClass("Regular")
                .chooseMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .addGPUs()
                .chooseNumberOfGPUs("1")
                .chooseGPUType("NVIDIA Tesla V100")
                .chooseLocalSSD("2x375 GB")
                .chooseDataCenterLocation("Frankfurt (europe-west3)")
                .chooseCommittedUsage("1 Year")
                .clickAddToEstimate()
                .clickEmailEstimate();

        TempEmailPage tempEmailPage = new TempEmailPage(driver);
        tempEmailPage.createNewTab();
        tempEmailPage.switchTabByIndex(1);
        String tempEmailAddress = tempEmailPage.openPage().copyTempEmailAddress();

        calculatorPage. switchTabByIndex(0);
        calculatorPage.pasteEmailAddress(tempEmailAddress).clickSendEmail();

        tempEmailPage.switchTabByIndex(1);
        String totalCostInfo = tempEmailPage.getMessageWithEstimatedCost().getTextFromMessage();

        Assert.assertEquals("Total Cost Is WRONG!", "Estimated Monthly Cost: USD 1,082.77", totalCostInfo);
    }

    @After
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
