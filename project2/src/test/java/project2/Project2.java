package project2;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project2 {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); 
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.goibibo.com/flights/");
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]"));
        element.click();

        Thread.sleep(1000);
        element = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-2 eTBlJr fswFld \"])[1]"));
        element.click();

        element = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-24 bDSkOK\"])/div/input"));
        element.sendKeys("Bengaluru");

        Thread.sleep(1000);
        element = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-29 gEpyDY\"])[1]"));
        element.click();

        element = driver.findElement(By.xpath("//div[@class=\"sc-12foipm-25 fbAAhv\"]/input"));
        element.sendKeys("Patna");

        Thread.sleep(1000);
        element = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-29 gEpyDY\"])[1]"));
        element.click();

        Thread.sleep(3000);
        Actions action = new Actions(driver);
        element = driver.findElement(By.xpath("//div[@class=\"sc-zdy0j7-4 dBaZvf\"]"));
        action.moveToElement(element).perform();

        Thread.sleep(3000);
        element = driver.findElement(By.xpath("//span[@class=\"sc-12foipm-72 ezNmSh\"]"));
        element.click();

        Thread.sleep(15000);
        element = driver.findElement(By.xpath("//span[@class=\"button buttonPrimary pushRight widthFitContent\"]"));
        element.click();

        Thread.sleep(2000);
        element = driver.findElement(By.xpath("(//span[text()=\"VIEW FARES\"])[1]"));
        element.click();

        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//button[@class=\"lato-black button buttonPrimary buttonBig fontSize14\"][1]"));
        element.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
