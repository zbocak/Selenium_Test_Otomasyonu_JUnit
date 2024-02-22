package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethodlari {
    public static void main(String[] args){
        //Chromedriver ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Amazon adresş-ine gidiniz
        driver.get("https://www.amazon.com.tr");

        //Sayfanin konumunu ve boyutlarını yazdırınız
        System.out.println("Sayfanin konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutu: " + driver.manage().window().getSize());

        //Sayfayi simge durumuna getiriniz
        driver.manage().window().minimize();


        //Simge durumunda 2 saniye bekleyip sayfayi maximize yapınız
        driver.manage().window().maximize();

        //Sayfayi fullscreen yapın
        driver.manage().window().fullscreen();

        //Sayfanın konumunu ve boyutlatıtını fullscreen durumunda yazdırın
        System.out.println("Sayfanin fullscreen konumu:" + driver.manage().window().getPosition());
        System.out.println("Sayfanin fullscreen boyutu:" + driver.manage().window().getSize());

        //Sayfanın konumunu ve boyutlarını istediğini sekilde ayarlayın
        driver.manage().window().setPosition(new Point(20,20));
        driver.manage().window().setSize(new Dimension(800,400));

        //Sayfanın istenilen konum boyutta ayarlandigini test ediniz
        System.out.println("Sayfanin istenilen konumu: "+ driver.manage().window().getPosition());
        System.out.println("Sayfanin istenilen boyutu: " + driver.manage().window().getSize());

        //Sayfayi kapatiniz
        driver.close();

    }
}
