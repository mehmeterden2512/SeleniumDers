package day07_ActionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";
        bekle(3);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
