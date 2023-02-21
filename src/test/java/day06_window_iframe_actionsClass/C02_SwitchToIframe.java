package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SwitchToIframe extends TestBase {

    //https://the-internet.herokuapp.com/iframe adresine gidin
    //Your content goes here. yazisinin gorunur oldugunu test edin
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        /*
        html tag uzerinde bir iframe tagı varsa bunu locate
        ederken dikkat etmek gerekir cunku bu iframe baska bir html
        icerisine konmuştur dolayısıyla dogrudan locate edemeyiz etsekde calısmaz

       Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz
            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin
            4-

         */
        WebElement frameElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);
        WebElement yaziElementi= driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        //Elemental Selenium elementine clik yapin
        /*
        Bii frame geciş yaptiktan sonra oradan cıkıncaya veya baska bir frame....
        notlari ekle
         */
        //driver.switchTo().parentFrame();//ic ice framelerde bir üst seviyeye cıkar
        driver.switchTo().defaultContent();//direk anasayfaya geciş yapar.
        driver.findElement(By.linkText("Elemental Selenium"));
        bekle(3);
    }
}
