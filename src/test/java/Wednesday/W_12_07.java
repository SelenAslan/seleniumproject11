package Wednesday;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class W_12_07 {

    public static void main(String[] args) {

        openBrowser();

    }

    public static void openBrowser() {

        Scanner scan  = new Scanner(System.in);

        System.out.println("Enter a browser type");
        String browser = scan.next();

        WebDriver driver = null;


        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new  FirefoxDriver();
        }else {
            WebDriverManager.safaridriver().setup();
            driver = new  SafariDriver();
        }

        driver.get("https://www.etsy.com/");

        WebElement searchButton = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchButton.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        } else {
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("Title verification FAİLED!!");
        }






    }
}
