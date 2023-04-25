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
        System.setProperty("webdriver.chrome.driver",
                "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // capture web elements into list
        List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

        // capture all webelements into original list with streams method
        List<String> originalList = rows.stream().map(s -> s.getText()).collect(Collectors.toList());

        // apply sorting
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original list with sorted list
        // Assert.assertTrue(originalList.equals(sortedList));

        // scan the name of column with get text, and print the price
        List<String> price;
        do {
            // Re-fetch rows
            rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getPrice(s))
                    .collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);

        driver.quit();
    }

    private static String getPrice(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
