package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Framework:ortak calısma cercevesi
    Hangi dosyalari nerede olusturacgımız belirler ve boylece toplu calişmayi kolaylastırır
    Her Framework,dosya duzeni olusturmanin yaninda ,
    işlerimizi kolaylaştıran yeni ozellikler sunmustur

    JUnit framework en temel test framework'dur
    bize kazandirdıği en onemli ozellik @Test Annotation(Notasyon)'dir

    @Test notasyonu sayasinde her bir method bagımsız olarak calıstırılabilen test methodu olur

        @Test notasyonu sayesinde istersek herbir test methodunu bagımsız calıştırabiligimiz gibi istenirse
        classs level dan calıstırıp tum testlerin calısmasını saglayabiliriz

        Junit fremawork de test methodlarinin hangi sıra ile calışacagini ONGOREMEYİZ ve KONTROL EDEMEYİZ

     */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");
        driver.close();
    }
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
        driver.close();
    }
}
