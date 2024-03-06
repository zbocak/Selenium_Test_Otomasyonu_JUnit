package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Target;
import java.time.Duration;

public class C01_IFrame {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void IFrameTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe adresine gidin
        //bir metot oluşturun: iframeTest
        //"An IFrame containing... ." textinin erişilebilir oldugunu test edin ve konsola yazdırın
        //Textbox a merhaba dunya yazdırın
        //Textboxin altında bulunan "Elemental Selenium" linkini textinin gorunur old dogrulayın ve konsola yazdırın

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeText.isDisplayed());
        System.out.println(iframeText.getText());

        WebElement iFrametextBox = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrametextBox);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(1000);
        textBox.sendKeys("Merhaha Dünya!");

        // driver.switchTo().parentFrame(); //iç içe ıframe varsa sadece 1 üst seviyedeki framee geciş yapıyor
        driver.switchTo().defaultContent(); // En üst seviye frame çıkmak için kullanılır

        WebElement seleniumText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumText.isDisplayed());
        System.out.println(seleniumText.getText());



    }

}
