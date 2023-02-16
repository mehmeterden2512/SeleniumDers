package day03_xpathve_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class C08_Tekrar {
    public static void main(String[] args) {
      // 1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
      // 3- Category bolumundeki elementleri locate edin
        WebElement womenElementi= driver.findElement(By.xpath("//a[@href='#Women']"));
        WebElement menElementi= driver.findElement(By.xpath("//a[@href='#Men']"));
        WebElement kidsElementi= driver.findElement(By.xpath("//a[@href='#Kids']"));
        System.out.println(womenElementi.getText()+"\n"+menElementi.getText()+"\n"+kidsElementi.getText());
      // 4- Category bolumunde 3 element oldugunu test edin
        List<WebElement> catagoriElementListesi=driver.findElements(By.xpath("(//h4/a)[@data-toggle='collapse']"));
        int expectedElementSayisi=3;
        int actualElementSayisi=catagoriElementListesi.size();
       if (expectedElementSayisi==actualElementSayisi){
           System.out.println("catagori Element testi PASSED");
       }else {
           System.out.println("catagori Element testi FAILED");
       }
      // 5- Category isimlerini yazdirin
        int elementNo=1;
        for (WebElement eachElement:catagoriElementListesi
             ) {
            System.out.println(elementNo+"-->"+eachElement.getText());
            elementNo++;
        }

      // 6- Sayfayi kapatin
        driver.close();
    }
}
