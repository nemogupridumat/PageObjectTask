import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CalculatorPage;
import pages.CloudGoogleComPage;
import pages.YOPMailPage;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private static WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void checkTotalEstimatedCostAfterCalculationTest() {
        CloudGoogleComPage cloudGoogleComPage = new CloudGoogleComPage(driver);
        cloudGoogleComPage.open();
        cloudGoogleComPage.searchForCalculator("Google Cloud Platform Pricing Calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillForm("4", "leave blank");
        calculatorPage.clickAddToEstimateButton();

        calculatorPage.getTotalCostText();
        Assertions.assertEquals("Total Estimated Cost: USD 1,081.20 per 1 month", calculatorPage.getTotalCostText());

        calculatorPage.emailEstimate();
    }

    @Test
    @Order(2)
    public void checkTotalEstimatedCostInEmailTest() {
        YOPMailPage yopMailPage = new YOPMailPage(driver, wait);

        yopMailPage.open("https://yopmail.com/");

        yopMailPage.generateEmail();
        yopMailPage.copyEmail();

        Set<String> windowHandles = driver.getWindowHandles();
        String firstTabHandle = windowHandles.toArray()[0].toString();
        String secondTabHandle = windowHandles.toArray()[1].toString();

        driver.switchTo().window(firstTabHandle);

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.inputEmail();

        driver.switchTo().window(secondTabHandle);
        yopMailPage.checkMail();

        yopMailPage.refreshMail();
        String total = "Total Estimated Cost: USD 1,081.20 per 1 month";
        Assertions.assertTrue(total.contains(yopMailPage.getTotalCost()));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
