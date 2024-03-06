package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BasicAuthentication {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void basicAuthentication(){
        /*
        https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        asagıdaki yöntem ve test datalarını kullanarak auth yapin

        html komutu: https://username:password@URL
        Username : admin
        Password : admin

        başarılı bir şekilde sayfaya girildiğini doğrulayın
         */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
