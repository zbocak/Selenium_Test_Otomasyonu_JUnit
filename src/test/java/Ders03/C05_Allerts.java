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

import static org.junit.Assert.assertEquals;

public class C05_Allerts {
    /* Bir web sitesine girdiğimizde karşımıza bir uyarı mesajı ya da bir buttona tıkladıgımızda bit uyarı çıkabilir
    eğer bu uyarıya incele yapabiliyorsal bu tür allertler HTML alerttir ve istedigimiz locatei alabiliriz.
    Ama gelen uyarı kutusuna müdahele edemiyrsak bu tür allertlere JS allert denir. Müdahale etmek için
    - tamam ya da ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() kullanılır
    - Allert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Allert bizden mesaj istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
     */

    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    //Bir metod oluşturun : acceptAllert
    //1.butona tıklayın, uyrıdaki ok butonuna tıklayın ve result mesajının "you succesfully clicked an alert" old test edin
    //Bir metod olusturun : dismissAllert
    //2.butona tıklayın uyarıdaki cancel butonuna tıklayın ve result mesajının "succesfully" içermedigini test edin
    //Alert üzerindeki mesajı yazdırın
    //Bir metod olusturun: sendKeysAlert
    //3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazın, ok butonuna
    //tıklayın ve result mesajında isminizin görüntülendigini dogrulayın

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
    public void acceptAllert() throws InterruptedException {
        //Bir metod oluşturun : acceptAllert
        //1.butona tıklayın, uyrıdaki ok butonuna tıklayın ve result mesajının "you succesfully clicked an alert" old test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement resultText = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualText = resultText.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void dismissAllert() throws InterruptedException {
        //Bir metod olusturun : dismissAllert
        //2.butona tıklayın uyarıdaki cancel butonuna tıklayın
        //result mesajının "succesfully" içermedigini test edin.Alert üzerindeki mesajı yazdırın
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        System.out.println("Allertin içindeki mesaj : " + driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expectedText = "successfully";
        Assert.assertFalse(actualText.contains(expectedText));
    }
    @Test
    public void sendKeysAllert() throws InterruptedException {
        //Bir metod olusturun: sendKeysAlert
        //3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazın, ok butonuna
        //tıklayın ve result mesajında isminizin görüntülendigini dogrulayın
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        System.out.println("Allertin içindeki mesaj : " + driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Berire");
        driver.switchTo().alert().accept();

        String actualText=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "Berire";
        Assert.assertTrue(actualText.contains(expectedText));


    }





}
