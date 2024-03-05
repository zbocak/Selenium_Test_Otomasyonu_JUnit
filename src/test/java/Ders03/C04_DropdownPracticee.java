package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPracticee {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void Test(){
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@class=\"a-button a-button-base\"]")).click();
        WebElement ddmList = driver.findElement(By.xpath("//*[@class='nav-search-scope nav-sprite']"));
        List<WebElement> ddm=driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());
        for (WebElement w:ddm) {
            System.out.println(w.getText());
        }
        int actualDropdown = ddm.size();
        int expectedDropdown = 40;
        Assert.assertNotEquals(expectedDropdown,actualDropdown);

        WebElement ddmlist=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(ddmlist);
        select.selectByVisibleText("Kitaplar");

        WebElement searchBox =driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);

        WebElement sonucText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucText.getText());

        String actualText = sonucText.getText();
        String expectedText = "Java";
        Assert.assertTrue(actualText.contains(expectedText));



    }

    //amazon adresine gidiniz
    //cerezleri kabul etmeden devam et secenegine tıklayınız
    //arama kutusunun yanındaki kategori menusunun kategori sayisinin 40 old test ediniz
    //kategori menusunden Books secenegini seciniz
    //arama kutusuna Java yazın ve aratın
    //bulunan sonu sayısını yazdırın
    //sonucun Java kelimesini icerdigini test edin


}
