package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class YOPMailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public YOPMailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofSeconds(10));
    }

    private By emailGeneratorButton = By.xpath("//a[@href='email-generator']");
    private By copyEmailButton = By.id("cprnd");
    private By checkMailButton = By.xpath("//button[@onclick='egengo();']");
    private By refreshButton = By.id("refresh");
    private By mailButton = By.xpath("//button[@onclick='g(this);']");
    private By totalCostLocator = By.xpath("//tr[td/h3[text() = 'Total Estimated Monthly Cost']]/td[last()]/h3");
    private By dismissAdButton = By.xpath("//div[@id='dismiss-button']");

    public void open(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }

    public void generateEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailGeneratorButton)).click();
    }

    public void copyEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(copyEmailButton)).click();
    }

    public void checkMail() {
        wait.until(ExpectedConditions.elementToBeClickable(checkMailButton)).click();
    }


    public void refreshMail() {
        wait.until(ExpectedConditions.elementToBeClickable(refreshButton)).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();
    }

    public String getTotalCost() {
        driver.switchTo().frame("ifmail");
        WebElement totalCostElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalCostLocator));
        String totalCostText = totalCostElement.getText();
        return totalCostText;
    }
}
