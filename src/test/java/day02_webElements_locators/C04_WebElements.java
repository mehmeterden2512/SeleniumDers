package day02_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // amazon ana sayfata gidin
        driver.get("https://www.amazon.com");
        // arama kutusunu locate edip webelement olarak kaydedin
        //id'si twotabsearchtextbox olan web element seklnde locate edecegizz.
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        /*
        driver'a webElement i tarif etmen islemine locate,bu tarifi yapabilmek icin kullanabilecegim degiskenlerede
        locator denir.
        Locator larin sekiz tane locator vardir.
        Locotarlarin 6 tanesi webElementin ozelliklerine baglıdır
        -id
        -className
        -name
        -tagName
        -linkText
        -partialLinkText

        geriye kalan iki locator ise herturlu webElementi locate etmek icin kullanilabilir
        -xpath
        -cssSelector
         */
        //arama kutusuna "Nutella" yazip aratın    //locate islemi
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        Thread.sleep(3000);
        driver.close();
    }
}
