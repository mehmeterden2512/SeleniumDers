package day02_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        //aramaKutusu.submit();
        //arama sonuclarında cıkan yazılari aratıyoru
        List<WebElement> aramaSonuclariElementList=driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElementList.size());

        //bu elementleri yazdiralim
        int elementNo=1;
        for (WebElement each:aramaSonuclariElementList
             ) {
            System.out.println(elementNo+"---"+each.getText());
            elementNo++;
        }

        Thread.sleep(3000);
        driver.close();
    }
}
