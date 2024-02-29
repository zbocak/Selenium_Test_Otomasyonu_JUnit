package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_CssLocator {
    public static void main(String[] args) {
        /*cssSelectorde sadece id ve class attributeleri için locate alınabilir
        id için başına # işareti,
        class için başına . işareti konur
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        WebElement deleteButton = driver.findElement(By.cssSelector(".added-manually"));
        if(deleteButton.isDisplayed()){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        //Thread.sleep(1000);
        deleteButton.click();

        if(driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed())
        {
            System.out.println("Test PASSED YAZI GORUNDU");}
        else {
            System.out.println("Test FAILED YAZI GORUNMMUYOR");}

        driver.close();
    }
}
