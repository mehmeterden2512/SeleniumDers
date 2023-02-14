package day02_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Locators {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");
       //- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

       //- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucYaziElementi=driver.findElement(By.className("rush-component"));
        System.out.println(sonucYaziElementi.getText());
       //- Listeden ilk urunun resmine tıklayın.



        driver.close();
    }
}
