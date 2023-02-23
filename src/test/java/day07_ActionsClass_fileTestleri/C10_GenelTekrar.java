package day07_ActionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class C10_GenelTekrar extends TestBaseClass {
    static WebElement dropDownMenu;
    static Select select;
    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
         select=new Select(dropDownMenu);
        List<WebElement> ddmElementList=select.getOptions();
        int elementNo=1;

        for (WebElement eachElement:ddmElementList
             ) {
            System.out.println(elementNo++ +"-->"+eachElement.getText());
        }
        //3- dropdown menude 40 eleman olmadıgını doğrulayın
        int expectedDDEsize=40;
        int actualDDEsize=ddmElementList.size();
        Assert.assertNotEquals(expectedDDEsize,actualDDEsize);
    }
    @Test
    public void test02(){
        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonuYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="iphone";
        String actualIcerik=sonuYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun=driver.findElement(By.xpath("(//*[@data-image-latency='s-product-image'])[1]"));
        driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(birinciUrun)).click();
        bekle(3);
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunTitle=driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
        String urunFiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

    }
    @Test
    public void test03(){
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        //2-dropdown’dan bebek bölümüne secin
        dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropDownMenu);
        select.selectByVisibleText("Baby");
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("bebek puset"+ Keys.ENTER);
        //4-sonuç yazsının puset içerdiğini test edin
        WebElement sonuYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="puset";
        String actualIcerik=sonuYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(birinciUrun)).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urunTitle=driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
        String urunFiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();
    }
    //Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    @Test
    public void test04(){

    }
}
