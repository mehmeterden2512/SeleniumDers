package day07_ActionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MoveToElement extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
        WebElement accountListsElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);

        //   mouse'u bu menunun ustune getirin
        actions.moveToElement(accountListsElementi).perform();
        //3- "Create a list" butonuna basin
        WebElement createAListElementi=driver.findElement(By.xpath("//*[text()='Create a List']"));
        createAListElementi.click();
        //4- Acilan sayfada "Your Lists" yazisi oldugunu test edin
        WebElement yourListElementi= driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListElementi.isDisplayed());
    }
}
