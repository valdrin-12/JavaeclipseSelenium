package indroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;


import org.junit.Assert; // Correct import statement for Assert

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;


public class Alerts {
	

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Rahul";

        // Enter the text in the input field
        driver.findElement(By.id("name")).sendKeys(text);

        // Click the "Alert" button to display an alert box
        driver.findElement(By.cssSelector("#alertbtn")).click();

        // Get the text of the alert box and print it to console
        System.out.println(driver.switchTo().alert().getText());

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("/Users/macbookpro/Desktop/sel/screenshot4.jpg"));
        // Click the "OK" button on the alert box
        driver.switchTo().alert().accept();

        // Click the "Confirm" button to display a confirmation box
        driver.findElement(By.id("confirmbtn")).click();

        // Get the text of the confirmation box and print it to console
        System.out.println(driver.switchTo().alert().getText());

        // Click the "Cancel" button on the confirmation box
        driver.switchTo().alert().dismiss();

        driver.quit();
        
        
    }
}
