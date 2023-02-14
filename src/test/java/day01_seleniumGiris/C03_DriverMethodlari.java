package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chorome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //amazon ana sayfaya gidin
        //gittiğiniz sayfada ki title ve url yazdirin
        //amazon ana sayfaya gittiğinizi test edin
        driver.get("https://www.amazon.com");
        System.out.println("Url: "+driver.getCurrentUrl());
        System.out.println("Tittle: "+ driver.getTitle());
        driver.close();
        // test expected result ile actual result'in karsilastirilmasi
        // ornegin url amazon iceriyorsa diyebiliriz
        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){//amazon anasayfaya gittiysek
            System.out.println("Test Passed");
        }else {
            System.out.println("Test FAİLED");
        }
        driver.close();
    }
}
