package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q3Odev {
    /* ...Exercise3...
     go to url : https://www.techlistic.com/p/selenium-practice-form.html
     fill the firstname
     fill the lastname
     check the gender
     check the experience
     fill the date
     choose your profession -> Automation Tester
     choose your tool -> Selenium Webdriver
     choose your continent -> Antartica
     choose your command  -> Browser Commands
     click submit button
  */
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32");

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mehmet");
        //fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Erdo");
        //check the gender


        driver.findElement(By.id("sex-0")).click();
        //check the experience
        driver.findElement(By.id("exp-1")).click();
        //fill the date
        WebElement tarihKusu= driver.findElement(By.id("datepicker"));
        tarihKusu.sendKeys("14.11.2022");
        //choose your profession -> Automation Tester
        driver.findElement(By.id("profession-1")).click();
        //choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();
        //choose your continent -> Antartica
        WebElement kitalarKutusu=driver.findElement(By.id("continents"));
        kitalarKutusu.click();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement ddm0= driver.findElement(By.xpath("//select[@id='continents']"));
        Select select0=new Select(ddm0);
        select0.selectByVisibleText("Antartica");
       // driver.findElement(By.xpath("(//select/option)[text()='Antartica']")).click();
        //choose your command  -> Browser Commands
        WebElement ddm= driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select select=new Select(ddm);
        //driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        // click submit button
        select.selectByVisibleText("//option[text()='Browser Commands']");
        Thread.sleep(3000);
       // driver.navigate().refresh();
     WebElement buttonElementi=   driver.findElement(By.xpath("//button[@class='btn btn-info']"));
            buttonElementi.submit();
        driver.close();
    }
}
