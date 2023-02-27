package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_TumSayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        //Nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //Sonuclarin nutella icerdiğini test edin
        String expectedIcerik="Nutella";
        String actualIcerik=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        //ve rapora eklenmek icin tum sayfanin fotografini cekin
        //Tum sayfa screenshot icin
        //1-TakeScreenshot objesiolustur
        TakesScreenshot ts= (TakesScreenshot) driver;

        //2-screenshot'i kaydedecegimiz bir dosya olusturalim

        File tumSayfaSs=new File("target/screenShot.png");

        //3-gecici bir dosya olusturup ts objesi ile cekilen fotografi dosya kaydediyoruz

        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi tumSayfaSs dosyasina kopyayalayyalim

        FileUtils.copyFile(geciciResim,tumSayfaSs);
        bekle(3);

    }
}
