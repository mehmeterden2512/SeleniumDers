package day02_webElements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethotlari {
    public static void main(String[] args) {



        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        }else {
            System.out.println("facebook title testi FAILED"+"\nGercekleşen Tittle: "+actualTitle);
        }
        String expectedIcerik="facebook";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Facebook url testi Passed");
        }else {
            System.out.println("facebook url testi FAILED"+"\nGercekleşen actualUrl: "+actualUrl);
        }
        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String wallmartExpectedIcerik="Walmart.com";
        String wallmartActual=driver.getTitle();

        if (wallmartActual.contains(wallmartExpectedIcerik)){
            System.out.println("wallmart title testi PASSED");
        }else {
            System.out.println("Walllmart title Testi Failed");
        }
        // Tekrar “facebook” sayfasina donun,
        driver.navigate().back();
        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //Browser’i kapatin
            driver.close();
    }
}
