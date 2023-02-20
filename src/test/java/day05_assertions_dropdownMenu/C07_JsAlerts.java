package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class C07_JsAlerts extends TestBaseClass {
    @Test
    public void  test01(){
        // Gerekli ayarlamalari yapip
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1.alert'e tiklayalim
        // 3 test method'u olusturup her method'da bir JsAlert'e basin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        driver.switchTo().alert().accept();
        bekle(2);

        // Ilgili method'lari kullanin
    }
    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
            driver.findElement(By.xpath("/*[text()='Click for JS Confirm']")).click();
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
            driver.switchTo().alert().dismiss();
            String expectedSonucYazisi="You clicked: Cancel";
            String actualSonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
            Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void test03(){
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id=‘result’]")).getText();
        String expectedSonucSayisi="Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucSayisi));
    }

    // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    // OK tusuna basip alert'i kapatalim


}
