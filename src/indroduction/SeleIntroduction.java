package indroduction;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleIntroduction {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver" );
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	//	driver.close();
		
		
		// firefox launch 
		
		//System.setProperty("webdriver.gecko.driver", "/Users/macbookpro/Downloads/geckodriver" );
	    //WebDriver driver=new FirefoxDriver();
       //	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	  //	System.out.println(driver.getTitle());
	  //	System.out.println(driver.getCurrentUrl());
		//driver.close();
		
		//edge launch
		
	//	System.setProperty("webdriver.edge.driver", "/Users/macbookpro/Downloads/msedgedriver" );
	//	WebDriver driver=new FirefoxDriver();
	//	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	//	System.out.println(driver.getTitle());
	//	System.out.println(driver.getCurrentUrl());
		//driver.close();
		

		
	}

}
