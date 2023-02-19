package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3Odev3 {
    // .......Exercise5........
    /*
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */
  static   WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
    @Test
    public void test01(){
        //Under the ORIGINAL CONTENTS
        //    click on Alerts
        driver.findElement(By.xpath("//*[text()='Alerts']")).click();
        System.out.println("Alerts url: "+driver.getCurrentUrl());
        //navigate back
        //    print the URL
        driver.navigate().back();
        System.out.println("geri sonrasi url"+driver.getCurrentUrl());
        //Click on Basic Ajax
        driver.findElement(By.xpath("//a[@href='/basic_ajax.html']")).click();
        // print the URL
        System.out.println("Basic Ajax url: "+driver.getCurrentUrl());
        //enter value 20 and ENTER
        //    and then verify Submitted Values is displayed open page
        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);
        //and then verify Submitted Values is displayed open page
        Assert.assertTrue(driver.findElement(By.id("_language_id")).isDisplayed());
    }

}
