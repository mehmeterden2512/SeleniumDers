package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class T01_HandleDropDown extends TestBaseClass {
    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
            driver.findElement(By.xpath("//i[@class='icon-signin']")).click();
        //3. Login kutusuna “username” yazin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");
        //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        //6. online banking Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDownMenuElementi= driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropDownMenuElementi);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("20");
        //10. “US Dollars” in secilmedigini test edin
       boolean radioButtonSecilimi= driver.findElement(By.xpath("//input[@value='true']")).isSelected();
        Assert.assertFalse(radioButtonSecilimi);
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();

        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        WebElement yaziElementi=driver.findElement(By.id("alert_content"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
