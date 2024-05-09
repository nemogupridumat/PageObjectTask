package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleComPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CloudGoogleComPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By googleCloudSearchButton = By.xpath("//div[@class='YSM5S' and @jsname='Ohx1pb']");
    private By googleCloudSearchField = By.xpath("//*[@jsname='vhZMvf']");

    public void open() {
        driver.get("https://cloud.google.com/");
    }

    public void searchForCalculator(String query) {
        wait.until(ExpectedConditions.elementToBeClickable(googleCloudSearchButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(googleCloudSearchField)).sendKeys(query, Keys.ENTER);
    }
}
