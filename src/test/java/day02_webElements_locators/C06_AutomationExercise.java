package day02_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        //- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");
        //- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList=driver.findElements(By.tagName("a"));
        int expectedLinkSayisi=169;
        int actualLinkSayisi=linkElementleriList.size();
        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("link sayisi testi PASSED");
        }else {
            System.out.println("link sayisi testi Failed \nsayfada link sayisi: "+actualLinkSayisi);
        }
        //- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();
        //- special offer yazisinin gorundugunu test edin
        WebElement spacialOfferElementi=driver.findElement(By.id("sale_image"));
        if (spacialOfferElementi.isDisplayed()){
            System.out.println("SpecialOffer testi PASSED");
        }else {
            System.out.println("SpecialOffer testi FAILED");
        }
        //- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
