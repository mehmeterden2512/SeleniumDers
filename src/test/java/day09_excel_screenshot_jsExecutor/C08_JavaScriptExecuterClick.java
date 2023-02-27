package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavaScriptExecuterClick extends TestBase {
    @Test
    public void test01(){
        //wisequarter ana sayfaya  a gidin
        driver.get("https://www.wisequarter.com");
        //refresh diyerek reklami gecin
        driver.navigate().refresh();

        //Java Test otamation tanitimina kadar asagi inin
        WebElement otamasyonElementi= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));
        bekle(2);
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",otamasyonElementi);
        //ve resmi click yapin ?
        bekle(2);
        jse.executeScript("arguments[0].click();",otamasyonElementi);
        // ekrana "JUnit bitti" yazdirin
        bekle(2);

        jse.executeScript("alert('JUnit bitti')");
        bekle(3);
    }
}
