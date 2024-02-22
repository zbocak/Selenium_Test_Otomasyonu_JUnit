package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class C04_Locators {
    public static void main(String[] args) {
        //Chromedriver ı setup ediniz ve "www.amazon.com.tr" adresine gidiniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr");

        //Amazonda notebook aratınız
        WebElement cerezler=driver.findElement(By.id("sp-cc-accept"));
        cerezler.click();

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("notebook" +  Keys.ENTER);

        //Amazon sayfasindaki taglarin a olanlarinin sayisini yazdiriniz
        List<WebElement> tag=driver.findElements(By.tagName("a"));
        System.out.println("Tag a olanlarin sayisi: " + tag.size());
        List<WebElement> label=driver.findElements(By.tagName("label"));
        System.out.println("Tag label olanlarin sayisi: " +label.size());

        //Sayfayi kapatiniz
        driver.close();
    }
}
