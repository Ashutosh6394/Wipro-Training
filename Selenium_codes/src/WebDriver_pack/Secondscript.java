package WebDriver_pack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class Secondscript {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("firstName")).sendKeys("Ashutosh");

        driver.findElement(By.id("lastName")).sendKeys("Pandey");

      
        driver.findElement(By.id("userEmail")).sendKeys("ashu@gmail.com");

     
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");

       
        driver.findElement(By.id("dateOfBirthInput")).click();

     
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));

       
        Select monthSelect = new Select(month);

 
        monthSelect.selectByVisibleText("May");


        WebElement yr = driver.findElement(By.className("react-datepicker__year-select"));

   
        Select yearSelect = new Select(yr);

 
        yearSelect.selectByVisibleText("2000");
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='15']")).click();

      
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        js.executeScript("arguments[0].scrollIntoView(true);", subject);
        Thread.sleep(1000);

        // Subjects
        subject.sendKeys("Maths");
        subject.sendKeys(Keys.ENTER);

        // Scroll to Hobbies
        WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
        js.executeScript("arguments[0].scrollIntoView(true);", sports);
        Thread.sleep(1000);

        
        js.executeScript("arguments[0].click();", sports);

        
        driver.findElement(By.id("uploadPicture"))
                .sendKeys("C:/Users/91639/Desktop/ASHUPHOTO.jpg");

       
        driver.findElement(By.id("currentAddress"))
                .sendKeys("Lucknow, Uttar Pradesh");

        
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("react-select-3-input"))
                .sendKeys("Uttar Pradesh");
        driver.findElement(By.id("react-select-3-input"))
                .sendKeys(Keys.ENTER);

       
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("react-select-4-input"))
                .sendKeys("Lucknow");
        driver.findElement(By.id("react-select-4-input"))
                .sendKeys(Keys.ENTER);


        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(1000);

        submit.click();
        
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Save file
        File dest = new File("C:\\Users\\91639\\Desktop\\screenshot.png");
        FileHandler.copy(src, dest);
        
        Thread.sleep(5000);
        driver.quit();
    }
}