package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Q1 {
    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
       // System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");//bu satirda sisteme driver i tanitıyoruz
        WebDriver driver=new ChromeDriver();                                            //driver in yolunu gosteriyoruz
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");//ilk etapta navigate().to() mi get() mi nasil karar veriyoruz
                                            //get methodu daha hizli calişir ,navigate ise bagımlı senaryolarda tercih edilir
        driver.navigate().to("https://www.amazon.com/");
        //driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();//close bulunan sekmeyi quit() ise butun driveri kapatir
        System.out.println("All ok");
    }
}
