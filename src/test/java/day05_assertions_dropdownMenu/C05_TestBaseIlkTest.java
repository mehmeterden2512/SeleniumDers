package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_TestBaseIlkTest extends TestBase {

        @Test
        public void test(){
                //amazona git
                driver.get("https://www.amazon.com");
                //Nutella aratalim
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
                //Sonuclarin Nutella icerdiğini test edin
                WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
                        String expectedIcerik="Nutella";
                        String actualSonucYazisi=sonucYaziElementi.getText();
                Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        }
}
