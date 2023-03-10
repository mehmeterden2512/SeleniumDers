package day03_xpath_ve_cssSeloctor.day03_xpathve_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Tekrar {
    public static void main(String[] args) {
      // 1. http://zero.webappsecurity.com sayfasina gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
      // 2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
      // 3. Login alanine “username” yazdirin
        WebElement loginButtonu= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginButtonu.sendKeys("username");
      // 4. Password alanine “password” yazdirin
        WebElement paswordKutusu= driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        paswordKutusu.sendKeys("password");
      // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
      // 6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
      // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountElement=driver.findElement(By.xpath("//*[@id=\"sp_amount\"]"));
        amountElement.sendKeys("50");
      // 8. tarih kismina “2020-09-10” yazdirin
        WebElement tarihElementi=driver.findElement(By.id("sp_date"));
        tarihElementi.sendKeys("2020-09-10");
      // 9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
      // 10. “The payment was successfully submitted.” mesajinin
        // ciktigini test edin
        WebElement basariliYazisi=driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));
        if (basariliYazisi.isDisplayed()){
            System.out.println("The payment was successfully submitted testi PASSED");
        }else {
            System.out.println("The payment was successfully submitted testi FAILED");
        }
            driver.close();
    }
}
