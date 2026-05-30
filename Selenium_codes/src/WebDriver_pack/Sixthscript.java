package WebDriver_pack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sixthscript {

    public static void main(String[] args) throws Exception {

        WebDriver browser = new ChromeDriver();

        browser.manage().window().maximize();

        browser.get("https://www.flipkart.com");

        Thread.sleep(3000);

        WebElement lb = browser.findElement(By.xpath("//a[contains(text(),'Login')]"));
        lb.click();

        Thread.sleep(2000);

        WebElement mobileNumber = browser.findElement(By.xpath("//input[@type='text']"));
        mobileNumber.sendKeys("6394704842");

        WebElement requestOtpButton = browser.findElement(By.xpath("//button[contains(text(),'Request OTP')]"));
        requestOtpButton.click();

        System.out.println("Enter OTP manually in browser");

        Thread.sleep(20000);

 
        
        browser.quit();
    }
}