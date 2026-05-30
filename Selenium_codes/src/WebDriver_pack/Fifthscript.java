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

public class Fifthscript {

    static WebDriver driver;
    static JavascriptExecutor js;

    public static void takeScreenshot(String fileName) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("C:\\Users\\91639\\Desktop\\" + fileName + ".png");
        FileHandler.copy(source, destination);

        System.out.println("Screenshot saved: " + destination.getAbsolutePath());
    }

    public static void main(String[] args) throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        js = (JavascriptExecutor) driver;

        driver.get("https://www.amazon.in/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(2000);
        takeScreenshot("01_search_mobile_phones");

        WebElement samsung = driver.findElement(By.xpath("//span[text()='Samsung']"));
        js.executeScript("arguments[0].scrollIntoView(true);", samsung);
        Thread.sleep(1000);
        samsung.click();

        Thread.sleep(3000);
        takeScreenshot("02_brand_samsung");

        WebElement rating = driver.findElement(By.xpath("//section[@aria-label='4 Stars & Up']"));
        js.executeScript("arguments[0].scrollIntoView(true);", rating);
        Thread.sleep(1000);
        rating.click();

        Thread.sleep(3000);
        takeScreenshot("03_rating_4_and_above");

        WebElement black = driver.findElement(By.xpath("//span[text()='Black']"));
        js.executeScript("arguments[0].scrollIntoView(true);", black);
        Thread.sleep(1000);
        black.click();

        Thread.sleep(3000);
        takeScreenshot("04_colour_black");

        WebElement minPrice = driver.findElement(By.id("low-price"));
        js.executeScript("arguments[0].scrollIntoView(true);", minPrice);
        Thread.sleep(1000);

        minPrice.sendKeys("15000");

        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys("30000");

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        Thread.sleep(4000);
        takeScreenshot("05_price_15000_to_30000");

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result']//h2//span)[1]"));
        System.out.println("First Product: " + firstProduct.getText());

        Thread.sleep(3000);
        driver.quit();
    }
}