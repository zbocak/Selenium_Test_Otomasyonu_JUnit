package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Practice {
    public static void main(String[] args) {
        /*https://www.heroku.com/home adresine gidiniz
        sign up butonuna basiniz
        firstname textbox, lastname textbox, company elementlerini locate ediniz
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.heroku.com/home");

        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();

        driver.findElement(By.id("first_name")).sendKeys("Berire");
        driver.findElement(By.id("last_name")).sendKeys("Ocak");
        driver.findElement(By.id("email")).sendKeys("zberirekoc@gmail.com");
        driver.findElement(By.id("company")).sendKeys("empty");

    }
}
