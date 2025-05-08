package project2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowsHandler {
	
	@Test
	
	public void windowHandle() throws InterruptedException {
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
        
        WebElement window2 = driver.findElement(By.xpath("//a[@href=\"/giholidays/\"]"));
       window2.click();
      
       Thread.sleep(3000);
       
       Set<String> tabs = driver.getWindowHandles();
       
       Iterator<String> itr = tabs.iterator();
       
       String tab1 = itr.next();
       
       String tab2 = null;
       
       if (itr.hasNext()) {
    	   tab2 = itr.next();
    	   
    	   driver.switchTo().window(tab2);
    	   
    	   WebElement search = driver.findElement(By.id("search_button"));
    	   
    	   search.click();
    	   
    	   driver.switchTo().window(tab1);
    	   
    	   driver.close();
    	   
    	   
       }
       
       driver.quit();
         
    }
    

}
