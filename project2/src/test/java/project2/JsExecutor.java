package project2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExecutor {
	
	@Test
	public void jsExecutor() {
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
        JavascriptExecutor js;
        js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]); console.log('scroll down');", 0,1000);
	
		js.executeScript("window.scrollBy(arguments[0], arguments[1]); console.log('scroll up')", 0,-500);
		
		js.executeScript("document.body.style.zoom='170%'; console.log('zoomed in')");
		
		js.executeScript("document.body.style.zoom='40%';console.log('zoomed up')");
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight); console.log('scrolled down')");
		
		driver.quit();
		   
    }

}
