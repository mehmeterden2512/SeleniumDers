package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersList=driver.findElements(By.xpath("//div/div[@role='columnheader']"));
        int baslikNo=1;
        for (WebElement eachelement:headersList
             ) {
            System.out.println(baslikNo++ + "-->"+eachelement.getText());
        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.Sutun Başlıgı: "+headersList.get(3).getText());
        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalarListi=driver.findElements(By.xpath("//div/div[@class='rt-td']"));
        int dataNo=1;
        for (WebElement eachElement:tumDatalarListi
             ) {
            System.out.println(dataNo++ + "-->"+eachElement.getText());
        }
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        dataNo=1;
        for (WebElement eachElement:tumDatalarListi
        ) {
           if (!eachElement.getText().equals(" ")&&!eachElement.getText().equals("")){
               System.out.println(dataNo++ + "-->>"+eachElement.getText());
           }
        }
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tablodaki satirsayisi: "+satirlarList.size());
        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("tablodaki sutun sayisi: "+headersList.size());
        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncukKolonelementlerList=driver.findElements(By.xpath("//div/div[@class='rt-td'][3]"));
        dataNo=1;
        for (WebElement eachElement:ucuncukKolonelementlerList
             ) {
            System.out.println(dataNo++ +"== "+eachElement.getText());
        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        int index;
        for (WebElement eachHead:headersList
             ) {
            if (eachHead.getText().equals("Salary")){
               index=headersList.indexOf(eachHead);
            }
        }

        for (WebElement each:tumDatalarListi
             ) {
            if (each.getText().equals("Kierra")){
                System.out.println(driver.findElement(By.xpath("//div[@class='rt-td']["+index+"]")).getText());
            }
        }
        //10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(dataYazdir(2, 3));
    }

    public String dataYazdir(int satirNo,int sutunNo){

        String dinamikXpath="(//div[@class='rt-tr-group'])["+satirNo+"]//div[@class='rt-td']["+sutunNo+"]";

        return driver.findElement(By.xpath(dinamikXpath)).getText();
    }
}
