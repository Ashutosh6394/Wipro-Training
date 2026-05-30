package WebDriver_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstscript {

    public static void main(String[] args) throws InterruptedException {

    	//System.setProperty("webdriver.chrome.driver","D:\\java Selenium 2\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        Thread.sleep(3000);

        driver.close();
    }
}