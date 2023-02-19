package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2Hoca {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.otto.de");
        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);

        String ottoUrl= driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);
        if (ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
            System.out.println("OTTO yazisi vardir");
        }else System.out.println("OTTO yazisi icermiyor");
        driver.navigate().to("https://wisequarter.com/");
        String wqTitle = driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);
        boolean isTrue = wqTitle.contains("Quarter");
        if (isTrue)
            System.out.println("TEST PASSED");
        else System.out.println("TEST FAILED");

    }
}
