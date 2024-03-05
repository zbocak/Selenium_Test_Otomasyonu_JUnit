package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.close();
    }

    //https://the-herokuapp.com/dropdown adresine gidin
    //Index kullanarak option1i seçin ve yazdırın
    //Value kullanarak option 2 i seçin ve yazdırın
    //visible text kullanarak option 1 i ve option 2 i secin ve yazdırın
    //tum dropdown degerlerini yazdırın
    //Dropdown un boyutunu bulun, dropdown da 4 oge varsa konsolda true değilse false yazdırın

    @Test
    public void dropdownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(1000);
        WebElement ddmList=driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        Select select = new Select(ddmList);
        select.selectByIndex(1);
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("-----------------------------------");
        select.selectByValue("2");
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("-----------------------------------");
        select.selectByVisibleText("Option 1");
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===================================");
        select.selectByVisibleText("Option 2");
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===================================");

        List<WebElement> tumddm=driver.findElements(By.xpath("//option"));
        for(WebElement w:tumddm){
            System.out.println(w.getText());
        }
        System.out.println("Dropdowndaki eleman sayisi : " + tumddm.size());
        if (tumddm.size()==4){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
