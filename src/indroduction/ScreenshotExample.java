
package indroduction;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

//import org.apache.commons.io.FileUtils;

public class ScreenshotExample {

    public static void main(String[] args) throws IOException {
        
        // Set the path to the chromedriver executable on your system
    	System.setProperty("webdriver.chrome.driver",
	            "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");        
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Navigate to a webpage
        driver.get("https://www.google.com");

        // Take a screenshot and save it to a file
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("/Users/macbookpro/Desktop/sel/screenshot.jpg"));
        
        // Quit the driver
        driver.quit();
    }
}

