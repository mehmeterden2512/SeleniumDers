package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void tittleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTittle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTittle,actualTitle);
    }
    @Test
    public void imgTest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeResimElementi= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeResimElementi.isDisplayed());
    }
    @Test
    public void serachboxTest(){
        //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement serachboxElementi= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(serachboxElementi.isDisplayed());
    }
    @Test
    public void wrongTitleTest(){
        //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectetBaslikTitle="youtube";
        String actualBaslikTittle= driver.getTitle();
        Assert.assertNotEquals(unexpectetBaslikTitle,actualBaslikTittle);

    }
}
