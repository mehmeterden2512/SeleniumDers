package day03_xpath_ve_cssSeloctor.day03_xpathve_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XpathText {
    static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        WebElement deleteTusu= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteTusu.isDisplayed()){
            System.out.println("delete tusu testi PASSED");
        }else {
            System.out.println("delete tusu testi FAILLED");
        }
        WebElement addRemoveElementsYazisi=driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));
        if (addRemoveElementsYazisi.isDisplayed()){
            System.out.println("addRemoveElementsYazisi  testi PASSED");
        }else {
            System.out.println("addRemoveElementsYazisi  testi FAILLED");
        }
        driver.close();
    }
}
