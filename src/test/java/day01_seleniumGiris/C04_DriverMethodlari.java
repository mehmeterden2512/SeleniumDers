package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chorome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());

        //close ve quit ikiside sayfa kapatmmak icin kullanilir
        //close sadece bir sayfa kapatirken
        //quit test sirasinda acilan tum sayfalari kapatir
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
