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

public class C02_Assertions {
    WebDriver driver = new ChromeDriver();
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com.tr");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest(){
        WebElement logo = driver.findElement(By.xpath("(//*[@class=\"style-scope yt-icon\"])[5]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search-form\"]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    //https://www.youtube.com.tr adresine gidin
    //aşağıdaki adları kullanarak 4 test methodu  oluşturun ve gerekli testleri yapın
    //titleTest: sayfa baslıgının youtube olduğunu test edin
    //imageTest: youtube resminin goruntulendigini test edin
    //searchBox in erişilebilir old test edin
    //wrongTitleTest : sayfa baslıgının youtube olmadıgını tst edin
}
