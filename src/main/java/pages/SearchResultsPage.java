package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By calculatorSearchResult = By.xpath("//a[@href='https://cloud.google.com/products/calculator-legacy']");

    public void clickCalculatorSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(calculatorSearchResult)).click();
    }
}
