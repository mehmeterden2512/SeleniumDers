package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.otto.de");
        String sayfaBasligi= driver.getTitle();
        String sayfaUrl= driver.getCurrentUrl();
        String expectedIcerik="OTTO";
        if (sayfaBasligi.contains(expectedIcerik)&&sayfaUrl.contains(expectedIcerik)){
            System.out.println("OTTO testi PASSED");


        }else {
            System.out.println("OTTo testi FAILED");
        }
        driver.navigate().to("https://wisequarter.com/");

        String expectedIcerik2="Quarter";
        String actualTitleWiseQuarter=driver.getTitle();
        if (actualTitleWiseQuarter.contains(expectedIcerik2)){
            System.out.println("Quarter testi PASSED");
            System.out.println("actualTitleWiseQuarter = " + actualTitleWiseQuarter);
        }else {
            System.out.println("Quarter testi FAILED");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.close();
        driver.quit();



    }
}
