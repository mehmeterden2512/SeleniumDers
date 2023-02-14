package day02_webElements_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        System.out.println("ilk size: "+driver.manage().window().getSize());
        System.out.println("ilk position"+driver.manage().window().getPosition());

        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(800,800));
        driver.manage().window().setPosition(new Point(40,100));
        System.out.println(" size: "+driver.manage().window().getSize());
        System.out.println(" position"+driver.manage().window().getPosition());



        Thread.sleep(2000);
        driver.close();
    }
}
