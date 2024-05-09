package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By numberOfInstancesField = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");
    private By whatAreTheseInstancesForField = By.xpath("//input[@ng-model='listingCtrl.computeServer.label']");
    private By operatingSystemSoftwareDropdown = By.xpath("//*[@id='select_value_label_92']");
    private By operatingSystemSoftwareOption = By.id("select_option_102");
    private By provisioningModelDropdown = By.xpath("//*[@ng-model='listingCtrl.computeServer.class']");
    private By provisioningModelOption = By.xpath("//*[@id=\"select_option_115\"]");
    private By machineFamilyDropdown = By.id("select_value_label_94");
    private By machineFamilyOption = By.id("select_option_119");
    private By seriesDropdown = By.id("select_value_label_95");
    private By seriesOption = By.id("select_option_224");
    private By machineTypeDropdown = By.id("select_value_label_96");
    private By machineTypeOption = By.id("select_option_474");
    private By addGPUsCheckbox = By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']");
    private By gpuTypeDropdown = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");
    private By gpuTypeOption = By.id("select_option_517");
    private By numberOfGPUsDropdown = By.id("select_value_label_509");
    private By numberOfGPUsOption = By.id("select_option_520");
    private By localSSDropdown = By.id("select_value_label_468");
    private By localSSDOption = By.id("select_option_495");
    private By datacenterLocationDropdown = By.id("select_value_label_98");
    private By datacenterLocationOption = By.id("select_option_268");
    private By committedUsageDropdown = By.id("select_value_label_99");
    private By committedUsageOption = By.id("select_option_138");
    private By addToEstimateButton = By
            .xpath("(//button[contains(@class, 'md-raised') and contains(@class, 'md-primary') and contains(text(), 'Add to Estimate')])[1]");
    private By totalCostLocator = By.xpath("//b[contains(text(), 'Total Estimated Cost:')]");
    private By emailEstimateButton = By.id("Email Estimate");
    private By inputEmailField = By.id("input_620");
    private By sendEmailButton = By.xpath("//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']");


    public void fillForm(String instances, String instancesFor) {
        driver.get("https://cloudpricingcalculator.appspot.com/");

        wait.until(ExpectedConditions.elementToBeClickable(numberOfInstancesField)).sendKeys(instances);
        wait.until(ExpectedConditions.elementToBeClickable(whatAreTheseInstancesForField)).sendKeys(instancesFor);

        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemSoftwareDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemSoftwareOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemSoftwareDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemSoftwareOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(provisioningModelDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(provisioningModelOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(machineFamilyDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(machineFamilyOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(seriesDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(seriesOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(machineTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(addGPUsCheckbox)).click();

        wait.until(ExpectedConditions.elementToBeClickable(gpuTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(gpuTypeOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(numberOfGPUsDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(numberOfGPUsOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(localSSDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(localSSDOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(datacenterLocationDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datacenterLocationOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(committedUsageDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(committedUsageOption)).click();
    }

    public void clickAddToEstimateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
    }

    public String getTotalCostText() {
        WebElement totalCostElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalCostLocator));
        String totalCostText = totalCostElement.getText();
        return totalCostText;

    }

    public void emailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
    }

    public void inputEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(inputEmailField)).click();
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
    }
}