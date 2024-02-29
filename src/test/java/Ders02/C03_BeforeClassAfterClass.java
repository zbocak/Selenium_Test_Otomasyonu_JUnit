package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void Test(){
        driver.get("https://www.amazon.com.tr");
    }

   @Test
   public void Test1(){
        driver.get("https://www.facebook.com.tr");
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
