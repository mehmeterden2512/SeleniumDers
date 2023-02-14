package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageMethotlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Max Size: "+driver.manage().window().getSize());
        System.out.println("maximeze position : "+driver.manage().window().getPosition());

        driver.manage().window().fullscreen();
        System.out.println("fullscrean Size: "+driver.manage().window().getSize());
        System.out.println("fullscrean position : "+driver.manage().window().getPosition());

    }
}
