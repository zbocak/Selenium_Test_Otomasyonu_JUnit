package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethodlari {
    public static void main(String[] args) {
        //Chromedriver ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Amazon adresine gidiniz (get fonksiyonuna göre biraz daha hızlı)
        driver.navigate().to("https://www.amazon.com.tr");

        //google anasayfasina gidiniz
        driver.navigate().to("https://www.google.com");

        //Tekrar amazon sayfasina gidiniz
        driver.navigate().back();

        //Tekrar google sayfasina gidiniz
        driver.navigate().back();

        //Sayfayi yenileyiniz
        driver.navigate().refresh();

        //Sayfayi kapatiniz (close ile farkı : açılan bütün browserları aynı anda kapatır)
        driver.quit();

    }
}
