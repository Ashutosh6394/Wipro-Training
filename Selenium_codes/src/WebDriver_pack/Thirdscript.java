package WebDriver_pack;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class Thirdscript {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        driver.findElement(By.id("name")).sendKeys("Ashutosh Pandey");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("ashu@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        Thread.sleep(3000);
        driver.findElement(By.id("textarea")).sendKeys("Lucknow, Uttar Pradesh");

        driver.findElement(By.id("male")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("monday")).click();
        driver.findElement(By.id("tuesday")).click();
        driver.findElement(By.id("friday")).click();

        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByVisibleText("India");
        Thread.sleep(3000);

        Select colorSelect = new Select(driver.findElement(By.id("colors")));
        colorSelect.selectByVisibleText("Blue");
        Thread.sleep(3000);

        Select animalSelect = new Select(driver.findElement(By.id("animals")));
        animalSelect.selectByVisibleText("Dog");
        Thread.sleep(3000);

        driver.findElement(By.id("datepicker")).sendKeys("05/16/2026");
        Thread.sleep(3000);

        driver.findElement(By.id("txtDate")).click();
        driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).sendKeys("2026");
        driver.findElement(By.xpath("//a[text()='16']")).click();
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,700)");

        WebElement singleFile = driver.findElement(By.id("singleFileInput"));
        singleFile.sendKeys("C:\\Users\\91639\\Desktop\\ASHUPHOTO.jpg");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();
        Thread.sleep(3000);

        WebElement multipleFile = driver.findElement(By.id("multipleFilesInput"));
        multipleFile.sendKeys("C:\\Users\\91639\\Desktop\\ASHUPHOTO.jpg\nC:\\Users\\91639\\Desktop\\practice_screenshot.png");

        driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click();
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,700)");
        

        driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Confirmation Alert']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Ashutosh");
        promptAlert.accept();

        js.executeScript("window.scrollBy(0,700)");

        driver.findElement(By.id("field1")).clear();
        driver.findElement(By.id("field1")).sendKeys("Selenium Testing");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        action.doubleClick(doubleClickButton).perform();
        Thread.sleep(3000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        action.dragAndDrop(source, target).perform();
        
        Thread.sleep(3000);

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']//span"));
        action.dragAndDropBy(slider, 80, 0).perform();

        js.executeScript("window.scrollBy(0,700)");

        File screenshotSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshotDestination = new File("C:\\Users\\91639\\Desktop\\practice_screenshot.png");

        FileHandler.copy(screenshotSource, screenshotDestination);
        
        System.out.println("All fields completed successfully");
        System.out.println("Screenshot saved at: " + screenshotDestination.getAbsolutePath());

        Thread.sleep(3000);

        driver.quit();
    }
}