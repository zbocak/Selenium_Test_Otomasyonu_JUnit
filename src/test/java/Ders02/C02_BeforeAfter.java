package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Tests(){
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void Test1(){
        driver.get("https://www.facebook.com.tr");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
