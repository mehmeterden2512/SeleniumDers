package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterClass {
  static WebDriver driver;
    // 3 test method'u olusturun
    // 1.amazon anasayfaya gidip, amazona gittiginizi test edin
    // 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
    // 3.Ilk urune tiklayip, urun isminde Nutella gectigini test edin

    //Eger her bir test methodu icin driver olusturup ,sonunda kapatmamız gerekmiyorsa
    //class basinda bir kez driver olusturup ,class'in sonunda driver'kapatabiliriz
    //@BeforeClass ve @AfterClass notasyonu kullanan methodlari STATİC olmalıdır
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void   tearDown(){
        driver.close();

    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl)){
            System.out.println("amazon testi PASSSED");
        }else {
            System.out.println("Url amazon icermiyor, test FAILED");
        }
    }
    @Test
    public void test02(){
        // 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
        WebElement aramaKusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
    String expectedIcerik="Nutella";
    String actualIcerik=aramaSonucElementi.getText();

        if (expectedIcerik.contains(actualIcerik)) {
            System.out.println("nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
        }

    }
    @Test@Ignore
    public void test03(){
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        WebElement urunIsimElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedIcerik="Nutella";
        String actualExpectedIsim=urunIsimElementi.getText();

        if (actualExpectedIsim.contains(expectedIcerik)){
            System.out.println("ilk urun test PASSED");
        }else {
            System.out.println("ilk urun test FAILLED");
        }
    }
}
