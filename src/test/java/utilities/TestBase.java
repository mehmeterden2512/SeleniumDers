package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;//heryerden kullanmak icin public
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("zamanlama hatasi");
        }
    }
}
