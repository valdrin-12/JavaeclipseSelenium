package indroduction;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// 1. Give me the count of links on the page.
		// 2. Count of footer section-
		
		System.setProperty("webdriver.chrome.driver",
                "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// 3.
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		// 4. Click on each link in the column and check if the pages are opening-
		for(int i=0;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000L);
		}
		
		
		// Opens all the tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
	}

}
