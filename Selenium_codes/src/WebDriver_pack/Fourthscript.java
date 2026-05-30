package WebDriver_pack;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Fourthscript {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.in/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wireless headphones under 2000");

        driver.findElement(By.id("nav-search-submit-button")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);
        

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result']//h2//span)[1]"));
        System.out.println("First Product: " + firstProduct.getText());

        WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
        System.out.println("Price: ₹" + price.getText());

        //TakesScreenshot ts = (TakesScreenshot) driver;
        //File source = ts.getScreenshotAs(OutputType.FILE);

        //File destination = new File("C:\\Users\\91639\\Desktop\\amazon_screenshot.png");
        //FileHandler.copy(source, destination);

        //System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

        Thread.sleep(3000);
        driver.quit();
    }
}