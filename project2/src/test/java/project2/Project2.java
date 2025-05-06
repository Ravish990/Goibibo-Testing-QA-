package project2;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class Project2 {

    public void bookFlight(String fromCity, String toCity) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.goibibo.com/flights/");

            // Close popup if present
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
                closePopup.click();
            } catch (Exception e) {
                System.out.println("Popup not found or already closed.");
            }
            
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//     
//    		js.executeScript("window.scrollBy(arguments[0], arguments[1])", 0,1000);
//    		Thread.sleep(1000);
//    		js.executeScript("window.scrollBy(arguments[0], arguments[1])", 0,-500);
//    		Thread.sleep(1000);
//    		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    		


            WebElement fromField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[1]")));
            fromField.click();

            WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sc-12foipm-24 bDSkOK'])/div/input")));
            fromInput.sendKeys(fromCity);

            WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='sc-12foipm-33 kUcHKT'])[1]")));
            fromSuggestion.click();

            WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-12foipm-25 fbAAhv']/input")));
            toInput.sendKeys(toCity);

            WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-29 gEpyDY'])[1]")));
            toSuggestion.click();
            
            WebElement dateField = driver.findElement(By.xpath("(//p[@class=\"sc-12foipm-4 czGBLf fswWidgetTitle\"])[3]"));

//             action 
            
            Actions action = new Actions(driver);
            
            action.moveToElement(dateField).click().perform();
            
            

            WebElement dateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class=\"fsw__date\"])[30]")));
            dateSelect.click();
            
            
            
            WebElement userSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class=\"sc-12foipm-4 czGBLf fswWidgetTitle\"])[4]")));
            userSelect.click();
           

    
         WebElement addUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='sc-12foipm-51 kZvHQU'])[2]")));
         WebElement checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));

         while (true) {
             String beforeText = checkLimit.getText();
             addUser.click();
             checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));
             String afterText = checkLimit.getText();

             if (afterText.equals(beforeText)) {
                 break;
             }
         }


         WebElement deleteUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='sc-12foipm-51 kZvHQU'])[1]")));

      
         while (true) {
             String beforeText = checkLimit.getText();
             deleteUser.click();
             checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));
             String afterText = checkLimit.getText();

             if (afterText.equals(beforeText)) {
                 break;
             }
         }

        
         WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Done']")));
         done.click();


            WebElement searchFlights = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"sc-12foipm-72 ezNmSh\"]")));
            searchFlights.click();
            
            WebElement gotIt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = \"GOT IT\"]")));
            
            gotIt.click();
            WebElement viewFares = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='VIEW FARES'])[1]")));
            viewFares.click();

            WebElement bookNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize14'][1]")));
            bookNow.click();

            System.out.println(" Flight booking test passed for: " + fromCity + " to " + toCity);

        } catch (Exception e) {
            System.out.println(" Flight booking failed for: " + fromCity + " to " + toCity);
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testBangaloreToPatna() {
        bookFlight("Bengaluru", "Patna");
    }

    @Test(priority = 2)
    public void testMumbaiToDelhi() {
        bookFlight("Mumbai", "Delhi");
    }

    @Test(priority = 6)
    public void testHomePageElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.goibibo.com/");

            // Wait for the page to load and close any popups if present
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
                closePopup.click();
            } catch (Exception e) {
                System.out.println("Popup not found or already closed.");
            }

            // Check visibility and interactability of tabs (Flights, Hotels, Trains, etc.)
            
            String[] xpaths = {
                "//a[@href='/flights/']",
                "//a[@href='/hotels/']",
                "//a[@href='/trains/']",
                "//a[@href='/cars/']",
                "//a[@href='/bus/']",
                "//a[@href='https://tripmoney.goibibo.com/partners/gi/forex/listing?utm_source=header_goibibo&utm_medium=desktop']",
                "//a[@href='/giholidays/']",
                "//a[@href='/insurance?cmp=desktop_header']",
                "//a[@href='/travelhistory']",
                
               
            };

            for (int i = 0; i < xpaths.length; i++) {
                try {
                    WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths[i])));
                    if (el.isDisplayed() && el.isEnabled()) {
                        System.out.println(" " + el.getText() + " tab is visible and clickable.");
                    } else {
                        System.out.println(" " + el.getText() + " tab is not interactable.");
                    }
                } catch (Exception e) {
                    System.out.println(" " + xpaths[i] + " tab failed due to: " + e.getMessage());
                }
            }

            // Check Login button
            try {
                WebElement loginBtn = driver.findElement(By.id("get_sign_in"));
                if (loginBtn.isDisplayed()) {
                    System.out.println(" Login button is visible.");
                } else {
                    System.out.println(" Login button is not visible.");
                }
            } catch (Exception e) {
                System.out.println(" Login button is not visible: " + e.getMessage());
            }

         

            // Check footer links
            try {
                List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));
                System.out.println(" Footer contains " + footerLinks.size() + " links.");
            } catch (Exception e) {
                System.out.println(" Footer links check failed: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(" Homepage elements test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
    }
