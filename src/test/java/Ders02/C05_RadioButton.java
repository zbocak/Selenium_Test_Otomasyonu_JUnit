package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/* facebook sayfasına gidin
varsa cookies kabul edin
"create an account" buttonuna basın
"radio button"elementlerini locate edin
seçili değilse cinsiyet buttonundan size uygun olanını seçin
 */

public class C05_RadioButton {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement createNewButton = driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
        createNewButton.click();
        WebElement firstName= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        WebElement lastName= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]"));
        WebElement mail= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]"));
        WebElement remail= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]"));
        WebElement password= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]"));
        WebElement day= driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month= driver.findElement(By.xpath("//*[@id='month']"));
        WebElement year= driver.findElement(By.xpath("//*[@id='year']"));
        WebElement genderF= driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
        WebElement genderM= driver.findElement(By.xpath("(//*[@name='sex'])[2]"));


        firstName.sendKeys("berire");
        lastName.sendKeys("ocak");
        mail.sendKeys("bo@gmail.com");
        remail.sendKeys("bo@gmail.com");
        password.sendKeys("!bo@gmail.com");
        day.sendKeys("30");
        month.sendKeys("Tem");
        year.sendKeys("1997");
        if (!genderM.isSelected()){
            genderM.click();
        }
        Thread.sleep(1000);
        genderF.click();





    }

}
