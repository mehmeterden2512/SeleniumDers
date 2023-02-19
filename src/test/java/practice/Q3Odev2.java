package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3Odev2 {
    /* ...Exercise4...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
     */
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement girilecekIlkSayiKutuElementi= driver.findElement(By.id("number1"));
        girilecekIlkSayiKutuElementi.sendKeys("10");
        WebElement girilecekIkinciSayiKutuElementi=driver.findElement(By.id("number2"));
        girilecekIkinciSayiKutuElementi.sendKeys("12");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String result=driver.findElement(By.id("answer")).getText();
        System.out.println("result = " + result);
        driver.close();
    }
}
