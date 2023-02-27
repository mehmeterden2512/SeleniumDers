package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void tumSayfaScreensShot(WebDriver driver)  {
        TakesScreenshot ts= (TakesScreenshot) driver;


        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String dinamikDosyaYolu="target/tumSayfaSs"+ldt.format(dtf)+".png";
        //dosya yolu "target/tumSayfaSs202302272339"tarihsaat
        File tumSayfaSs=new File(dinamikDosyaYolu);

        File geciciFile=ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciFile,tumSayfaSs);
        } catch (IOException e) {

        }


    }
    public static void webelementScreenshot(WebElement istenenElement){

        //

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String dinamikDosyaYolu="target/tumSayfaSs"+ldt.format(dtf)+".png";
        //dosya yolu "target/tumSayfaSs202302272339"tarihsaat

        File elementSs=new File(dinamikDosyaYolu);

        File geciciDosya=istenenElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,elementSs);
        } catch (IOException e) {

        }
    }
}
