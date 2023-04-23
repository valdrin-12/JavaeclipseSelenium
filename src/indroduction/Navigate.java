package indroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver" );
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");

		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.navigate().back();
		driver.navigate().forward();


	}

}
