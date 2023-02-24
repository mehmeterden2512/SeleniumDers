package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q7 {

    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.
     */
   static WebDriver driver;
    WebElement googleAramaKutusu;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Before
    public void before(){
        driver.get("https://www.google.com");
    }
    @Test
    public void test01(){

         googleAramaKutusu= driver.findElement(By.xpath("//input[@aria-autocomplete='both']"));
        googleAramaKutusu.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement aramaSonucYaziElementi= driver.findElement(By.id("result-stats"));
        System.out.println("The Lord of the Rings arama sonucu : "+aramaSonucYaziElementi.getText());
        //input[@aria-autocomplete='both']



    }
    @Test
    public void test02(){
       googleAramaKutusu= driver.findElement(By.xpath("//input[@aria-autocomplete='both']"));
        googleAramaKutusu.click();
        googleAramaKutusu.sendKeys("Brave Heart"+Keys.ENTER);
        WebElement aramaSonucYaziElementi= driver.findElement(By.id("result-stats"));
        System.out.println("Brave Heart arama sonucu : "+aramaSonucYaziElementi.getText());
    }
    @Test
    public void test03(){
       googleAramaKutusu= driver.findElement(By.xpath("//input[@aria-autocomplete='both']"));
        googleAramaKutusu.click();
        googleAramaKutusu.sendKeys("Harry Potter"+Keys.ENTER);
        WebElement aramaSonucYaziElementi= driver.findElement(By.id("result-stats"));
        System.out.println("Harry Potter arama sonucu : "+aramaSonucYaziElementi.getText());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
