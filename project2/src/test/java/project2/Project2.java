package project2;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Project2 {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.goibibo.com/flights/");

            // Close popup
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
            closePopup.click();

            // Click on 'From' field
            WebElement fromField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[1]")));
            fromField.click();

            // Enter 'Bengaluru' in from city
            WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sc-12foipm-24 bDSkOK'])/div/input")));
            fromInput.sendKeys("Bengaluru");

            // Select the first suggestion
            WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='sc-12foipm-33 kUcHKT'])[1]")));
            fromSuggestion.click();

            // Enter 'Patna' in to city
            WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-12foipm-25 fbAAhv']/input")));
            toInput.sendKeys("Patna");

            // Select the first suggestion
            WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-29 gEpyDY'])[1]")));
            toSuggestion.click();

            // Hover over departure date
            Actions action = new Actions(driver);
            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-zdy0j7-4 dBaZvf']")));
            action.moveToElement(dateField).perform();

            // Select a date
            WebElement dateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='sc-12foipm-72 ezNmSh']")));
            dateSelect.click();

            // Click on search flights
            WebElement searchFlights = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='button buttonPrimary pushRight widthFitContent']")));
            searchFlights.click();

            // Wait for the results to load and click on 'View Fares'
            WebElement viewFares = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='VIEW FARES'])[1]")));
            viewFares.click();

            // Click on 'Book Now'
            WebElement bookNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize14'][1]")));
            bookNow.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
