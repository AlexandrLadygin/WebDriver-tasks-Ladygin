package Pages.calculator;

import Pages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorHomePage extends AbstractPage {

    protected CalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait =  new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    private JavascriptExecutor executor = (JavascriptExecutor)driver;
    private String baseXpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[contains(text(), '%s')]";

    @FindBy(xpath = "//div[@title='Compute Engine']")
    private WebElement xpathComputeEngine;
    @FindBy(xpath = "//*[@name='quantity']")
    private WebElement xpathNumberOfInstanceField;
    @FindBy(xpath = "//*[@name='label']")
    private WebElement xpathWhatAreTheseInstancesForField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.os']")
    private WebElement  xpathOperatingSystemSoftwareField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.class']")
    private WebElement  xpathMachineClassField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.instance']")
    private WebElement  xpathMachineTypeField;
    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement xpathAddGPUs;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.gpuCount']")
    private WebElement  xpathNumberOfGPUsField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.gpuType']")
    private WebElement  xpathGPUTypeField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.ssd']")
    private WebElement  xpathLocalSSDField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.location']")
    private WebElement  xpathDataCenterLocationField;
    @FindBy(xpath = "//*[@ng-model = 'listingCtrl.computeServer.cud']")
    private WebElement  xpathCommittedUsageField;
    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement xpathAddToEstimateBtn;
    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement xpathEmailEstimateBtn;
    @FindBy(xpath = "//*[@name = 'emailForm']")
    private WebElement xpathEmailForm;
    @FindBy(xpath = "//input[@name='description' and @type='email']")
    private WebElement xpathEmailField;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement xpathSendEmailBtn;

    @FindBy(xpath = "//*[contains(@class, 'md-list-item-text ng-binding') and contains(text(), 'VM class:')]")
    private WebElement VMClassInfoLine;
    @FindBy(xpath = "//*[contains(@class, 'md-list-item-text ng-binding') and contains(text(), 'Instance type:')]")
    private WebElement InstanceTypeInfoLine;
    @FindBy(xpath = "//*[contains(@class, 'md-list-item-text ng-binding') and contains(text(), 'Region:')]")
    private WebElement RegionInfoLine;
    @FindBy(xpath = "//*[contains(@class, 'md-list-item-text ng-binding') and contains(text(), 'local SSD')]")
    private WebElement LocalSSDInfoLine;
    @FindBy(xpath = "//*[contains(@class, 'md-list-item-text ng-binding') and contains(text(), 'Commitment term:')]")
    private WebElement CommitmentTermInfoLine;
    @FindBy(xpath = "//*[contains(@class, 'ng-binding') and contains(text(), 'Total Estimated Cost')]")
    private WebElement TotalEstimatedCostInfoLine;


    public CalculatorHomePage activateComputeEngine() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//section[@class='devsite-wrapper']//iframe")));
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.elementToBeClickable(xpathComputeEngine));
        xpathComputeEngine.click();
        return this;
    }

    public CalculatorHomePage pasteNumberOfInstance(String number) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathNumberOfInstanceField));
        xpathNumberOfInstanceField.click();
        xpathNumberOfInstanceField.sendKeys(number);
        return this;
    }

    public CalculatorHomePage pasteWhatAreTheseInstancesFor(String reason) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathWhatAreTheseInstancesForField));
        xpathWhatAreTheseInstancesForField.click();
        xpathWhatAreTheseInstancesForField.sendKeys(reason);
        return this;
    }

    public CalculatorHomePage chooseOperatingSystemSoftware(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathOperatingSystemSoftwareField));
        xpathOperatingSystemSoftwareField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseMachineClass(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathMachineClassField));
        xpathMachineClassField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseMachineType(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathMachineTypeField));
        xpathMachineTypeField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage addGPUs() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathAddGPUs));
        xpathAddGPUs.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//md-checkbox[@aria-label='Add GPUs' and @aria-checked='true']")));
        return this;
    }

    public CalculatorHomePage chooseNumberOfGPUs(String choice) {
        executor.executeScript("arguments[0].scrollIntoView();", xpathMachineTypeField);
        wait.until(ExpectedConditions.elementToBeClickable(xpathNumberOfGPUsField));
        xpathNumberOfGPUsField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseGPUType(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathGPUTypeField));
        xpathGPUTypeField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseLocalSSD(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocalSSDField));
        xpathLocalSSDField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseDataCenterLocation(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathDataCenterLocationField));
        xpathDataCenterLocationField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage chooseCommittedUsage(String choice) {
        wait.until(ExpectedConditions.elementToBeClickable(xpathCommittedUsageField));
        xpathCommittedUsageField.click();
        String fullXpathForElement = String.format(baseXpath, choice);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(fullXpathForElement))));
        driver.findElement(By.xpath(fullXpathForElement)).click();
        return this;
    }

    public CalculatorHomePage clickAddToEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathAddToEstimateBtn));
        xpathAddToEstimateBtn.click();
        executor.executeScript("arguments[0].scrollIntoView();", xpathNumberOfInstanceField);
        return this;
    }
    
    public CalculatorHomePage clickEmailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathEmailEstimateBtn));
        xpathEmailEstimateBtn.click();
        executor.executeScript("arguments[0].scrollIntoView();", xpathEmailForm);
        wait.until(ExpectedConditions.visibilityOf(xpathEmailForm));
        return this;
    }

    public CalculatorHomePage pasteEmailAddress(String tempEmailAddressText) {
        executor.executeScript("arguments[0].scrollIntoView();", xpathEmailForm);
        xpathEmailField.click();
        xpathEmailField.sendKeys(tempEmailAddressText);
        return this;
    }

    public CalculatorHomePage clickSendEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathSendEmailBtn));
        xpathSendEmailBtn.click();
        return this;
    }


    public String getVMClassInfo(){
        return VMClassInfoLine.getText();
    }

    public String getInstanceTypeInfo(){
        return InstanceTypeInfoLine.getText();
    }

    public String getRegionInfo(){
        return RegionInfoLine.getText();
    }

    public String getLocalSSDInfo(){
        return LocalSSDInfoLine.getText();
    }

    public String getCommitmentTermInfo(){
        return CommitmentTermInfoLine.getText();
    }

    public String getTotalEstimatedCostInfo(){
        return TotalEstimatedCostInfoLine.getText();
    }

    @Override
    public CalculatorHomePage openPage() {
        throw new RuntimeException("Please don't use  openPage() for CalculatorHomePage!");
    }
}
