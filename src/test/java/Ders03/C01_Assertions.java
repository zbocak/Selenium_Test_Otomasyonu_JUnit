package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*Amazon sayfasına gidelim
    4 farklı test methodu oluşturalım
    a-URLin amazon içerdiğini test edelim
    b-Tittlein facebook içerdiğini test edelim
    c-sol üst kosede amazon logosunun gorundugunu test edelim
    d- URLin www.facebook.com olduğunu test edelim
     */

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
    }
    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void Test1(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void Test2(){
        String actualTitle =driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void Test3(){
        WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void Test4(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "www.facebook.com";
        Assert.assertFalse(actualUrl.contains(expectedUrl));
    }

}
