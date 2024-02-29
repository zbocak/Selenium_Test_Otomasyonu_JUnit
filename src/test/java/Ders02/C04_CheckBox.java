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

public class C04_CheckBox {
        WebDriver driver = new ChromeDriver();

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public void tearDown(){
            //driver.quit();
        }
         //Verilen web sayfasına gidiniz
        //https://the-interner.herokuapp.com/checkboxes
        //checkbox1 ve checkbox2 elementlerini locate edin
        //Checkbox1 seçili değilse onay kutusunu tıklayın
        //Checkbox2 seçili değilse onay kutusunu tıklayın

        @Test
        public void Tests() {
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
            WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

            if (!checkBox1.isSelected()){
                checkBox1.click();
            }
            if (checkBox2.isSelected()){
                checkBox2.click();
            }

        }
    }