package day02_webElements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       /*
       driver bir web uygulamasina gonderdiğimizde o sayfanın acılması,
       orada istediğimiz işlemleri yapmak elementleri bulmak icin beklemesi gerekir


       implicitlywait butur zaman isteyen islemler icin driver'in max. ne kadar bekleyecegin belirler
        */
    }
}
