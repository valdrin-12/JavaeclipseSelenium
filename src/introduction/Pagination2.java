package introduction;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

            // Click on the first column to sort
            driver.findElement(By.xpath("//tr/th[1]")).click();

            // Capture all the web elements of the first column
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            // Store the values of the first column in a list
            List<String> originalList = rows.stream().map(WebElement::getText).collect(Collectors.toList());

            // Sort the list in ascending order
            List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

            // Compare the original list with the sorted list
            if (originalList.equals(sortedList)) {
                System.out.println("The table is sorted correctly.");
            } else {
                System.out.println("The table is not sorted correctly.");
            }

            // Print the prices of the products containing the word "Rice"
            List<String> prices;
            do {
                prices = rows.stream()
                        .filter(row -> row.getText().contains("Rice"))
                        .map(Pagination2::getPrice)
                        .collect(Collectors.toList());

                prices.forEach(System.out::println);

                if (prices.isEmpty()) {
                    driver.findElement(By.cssSelector("[aria-label='Next']")).click();
                    rows = driver.findElements(By.xpath("//tr/td[1]"));
                }
            } while (prices.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static String getPrice(WebElement row) {
        return row.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
