package indroduction;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;



public class ActionClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.com/");
		//Actions a=new Actions(driver);
		

		
		
		Actions a=new Actions(driver);
		WebElement move=(driver.findElement(By.cssSelector("#nav-link-accountList ")));
		a.moveToElement
		(driver.findElement(By.cssSelector("#nav-link-accountList "))).build().perform();

		a.moveToElement
		(driver.findElement(By.id("twotabsearchtextbox"))).
		click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    //    Files.copy(src, new File("/Users/macbookpro/Desktop/sel/screenshot2.jpg"));

		a.moveToElement(move).contextClick().build().perform();
	}

	
}
