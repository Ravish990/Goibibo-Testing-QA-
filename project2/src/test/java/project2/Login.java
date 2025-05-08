package project2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	@Test
	public void login() {
    	
   	 WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/flights/");
     // Wait for the page to load and close any popups if present
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
   	
   	WebElement login = driver.findElement(By.xpath("//div[@data-id=\"user-info-tab\"]"));
   	
   	Actions action = new Actions(driver);
   	action.moveToElement(login).click().perform();

   	
   	WebElement loginAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=\"loginCont__input\"]")));
   	loginAccount.click();
   	
   	
   	
   	loginAccount.sendKeys("9905534207");
   	
   	WebElement button = driver.findElement(By.xpath("//button[text() = \"Continue\"]"));
   	
   	button.click();
   	
   	driver.quit();
   }
   
 
   
}
