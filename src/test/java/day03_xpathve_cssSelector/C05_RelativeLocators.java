package day03_xpathve_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement berlinElementi = driver.findElement(By.xpath("//*[@*='pid7_thumb']"));
        WebElement nycElementi = driver.findElement(By.xpath("//*[@*='pid3_thumb']"));
        WebElement bostonElementi = driver.findElement(By.xpath("//*[@*='pid6_thumb']"));
        WebElement sailorElementi = driver.findElement(By.xpath("//*[@*='pid11_thumb']"));
        /*
        selenium4 ile yeni gelen bir ozellik
        olurda bir elementi locate edemezseniz 2 sey ile o elementi
        locate edebiliriz
        1-etrafından bir webelement(sağ-sol-alt-ust-yakin)
        2-locate edemediğiniz webelemente ait bir ozellik tag veya atrıbute

         */
        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElementi));
        System.out.println("berlin1 id: "+berlin1.getAttribute("id"));


        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));

        System.out.println("berlin2 id: "+berlin2.getAttribute("id"));

        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));
        System.out.println("berlin3 id: "+berlin3.getAttribute("id"));
        driver.close();
    }
}
