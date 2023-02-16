package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;
     @Before
     public void setup(){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         System.out.println("Setup Calıştı");
     }
    @After
    public void tearDown(){
        driver.close();
        System.out.println("Tear down Calıştı");
    }
    @Test
    public void test01(){


        driver.get("https://www.wisequarter.com");
        System.out.println("test 01 calıştı");
    }
    @Test
    public void test02(){
         driver.get("https://www.youtube.com");
        System.out.println("test02 calıştı");
    }

}
