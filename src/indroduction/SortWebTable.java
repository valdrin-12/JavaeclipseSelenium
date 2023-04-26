package indroduction;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortWebTable {

	public static void main(String[] args) throws InterruptedException {
	    
	    // Setting up the webdriver path
	    System.setProperty("webdriver.chrome.driver",
	            "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
	    
	    // Creating a new instance of ChromeDriver
	    WebDriver driver = new ChromeDriver();
	    
	    // Setting implicit wait for 10 seconds
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    // Navigating to the specified URL
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	    // Clicking on the first column to sort the table
	    driver.findElement(By.xpath("//tr/th[1]")).click();

	    // Capturing all the rows of the table in a list
	    List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

	    // Converting the list of WebElements to a list of strings using stream method
	    List<String> originalList = rows.stream().map(s -> s.getText()).collect(Collectors.toList());

	    // Sorting the originalList and creating a new sorted list
	    List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

	    // Comparing the original list with the sorted list (this line is commented out)
	    // Assert.assertTrue(originalList.equals(sortedList));

	    // Scanning the name of column with getText() method and printing the price
	    List<String> price;
	    do {
	        // Re-fetching rows
	        rows = driver.findElements(By.xpath("//tr/td[1]"));
	        
	        // Filtering out only those rows that contain "Strawberry" and mapping them to their corresponding price
	        price = rows.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getPrice(s))
	                .collect(Collectors.toList());
	        
	        // Printing the prices of strawberries
	        price.forEach(a -> System.out.println(a));
	        
	        // If the size of the price list is less than 1, click on the "Next" button to fetch the next set of rows
	        if (price.size() < 1) {
	            driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	        }
	    } while (price.size() < 1);
	    
	    

	    // Quitting the driver
	    driver.quit();
	}

	// A private helper method that returns the price of a given row
	private static String getPrice(WebElement s) {
	    String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	    return priceValue;
	}
}
