package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Practice {
    public static void main(String[] args) {
        /*
        Facebook sayfasina gidin ve sayfa basliginin(title) "Facebook" oldugunu dogrulayin
        Sayfa basligi dogru degilse basligi yazdirin
        Sayfa URL inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL i yazdirin
        "https://www.walmart.com/" sayfasina gidin
        Sayfa basliginin "Walmart.com" oldugunu dogrulayın
        Tekrar "facebook" sayfasina donun
        Sayfayi yenileyin
        Sayfayi maximize yapın
        Browseri kapatin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        String actualData = driver.getTitle();
        String expectedData = "facebook";
        if(actualData == expectedData){
        System.out.println("Sayfanin basligi TRUE");
        }
        else{
            System.out.println("Sayfanin basligi: " + actualData);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if(actualUrl.contains(expectedUrl)){
            System.out.println("Facebook URL: TRUE");
        }else{
            System.out.println("Facebook URL FALSE : " + actualUrl);
        }

        driver.navigate().to("https://www.walmart.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Walmart.com";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Walmart URL TRUE");
        }else{
            System.out.println("Walmart URL: " + actualTitle);
        }

        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.close();
    }
}
