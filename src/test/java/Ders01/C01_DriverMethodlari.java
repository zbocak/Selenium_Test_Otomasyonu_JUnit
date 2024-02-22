package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C01_DriverMethodlari {
    public static void main(String[] args) {
        //Chromedriver ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // "www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr");

        //sayfayi maksimum boyuta getiriniz
        driver.manage().window().maximize();

        //sayfanin basligini yazdiriniz
        System.out.println("Sitenin Basligi: " + driver.getTitle());

        //Sayfanin url adresini yazdiriniz
        System.out.println("Sayfanin URL Adresi: " + driver.getCurrentUrl());

        //Sayfanin kaynak kodlarini yazdiriniz
        System.out.println("Sayfanin Kaynak Kodlari: " + driver.getPageSource());

        //Kaynak Kodlarının içinde "Gateway" kelimesinin olduğunu test ediniz
        String actualData = driver.getPageSource();
        String expectedData = "Gateway";

        if(actualData.contains(expectedData)){
            System.out.println("TEST PASSED");
        }
        else{
            System.out.println("TEST FAILED");
        }

        //Sayfanin window handle kodunu yazdirin
        System.out.println("Window Handle: " + driver.getWindowHandle());

        //Sayfayi kapatalim
        driver.close();

    }

}
