package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e.sectiğiniz radio butonun secili otekilerinde secili olmadiğini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        // a. Verilen web sayfasına gidin.
        //     https://facebook.com
        driver.get("https://facebook.com");
      driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();
      WebElement kadinRadioButtonelementi=  driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
      WebElement erkekRadioButtonelementi=  driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
      WebElement ozelradioButtonelementi=  driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
     erkekRadioButtonelementi.click();
        //Sectiğini gormek icin beklesin
        Thread.sleep(3000);
        // e.sectiğiniz radio butonun secili otekilerinde secili olmadiğini test edin
        Assert.assertFalse(kadinRadioButtonelementi.isSelected());
        Assert.assertTrue(erkekRadioButtonelementi.isSelected());
        Assert.assertFalse(ozelradioButtonelementi.isSelected());

    }
}
