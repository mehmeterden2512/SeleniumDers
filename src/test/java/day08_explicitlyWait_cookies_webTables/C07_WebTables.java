package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C07_WebTables extends TestBase {
    @Test
    public void test01() {
        //1. "https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // tum tablo verileri //div[@class='rt-td']
        // 1. satir index satirlar (//div[@class='rt-tr-group'])[1]
        // 1. satir (//div[@class='rt-tr-group'])[1]//div[@class='rt-td']
        // 3. satirin 1. datasi ((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[1]
        // tum veri hucreleri (//div[@class='rt-tr-group'])|(//div[@class='rt-td'])
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersListesi= driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        int siraNo=1;
        for (WebElement headerEach:headersListesi
        ) {
            System.out.println(siraNo+"--"+ headerEach.getText());
            siraNo++;
        }
        System.out.println("*************************");
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutunun basligini yazdirin: "+headersListesi.get(2).getText());
        // alternatif
        WebElement ucuncuSutunAdi= driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println(" altenatif: "+ ucuncuSutunAdi.getText());
        System.out.println("44444444444444444");
        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumList=driver.findElements(By.xpath("//div[@class='rt-td']"));
        siraNo=1;
        for (WebElement eachTum:tumList
        ) {
            System.out.println(siraNo+"=="+eachTum.getText());
            siraNo++;
        }
        System.out.println("===================");
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        siraNo=1;
        for (WebElement eachElement:tumList
        ) {
            if (!eachElement.getText().equals(" ")&&!eachElement.getText().equals("")){
                System.out.println(siraNo++ +"-->" +eachElement.getText());
            }
        }
        System.out.println("###############");
        siraNo=1;
        for (WebElement eachElement:tumList
        ) {
            if (!eachElement.getText().isBlank()){//isEmpty() methodu boslukları dolu olarak kabul edıyor.o yuzden isBlank()
                System.out.println(siraNo++ +"-->" +eachElement.getText());
            }
        }
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirSayisiList=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satir sayisini yazdirin: "+satirSayisiList.size());
        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisiList=driver.findElements(By.xpath(" (//div[@class='rt-tr-group'])[1]//div[@class='rt-td']"));
        System.out.println("Tablodaki sutun sayisini yazdirin:"+sutunSayisiList.size());
        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> kolonData= driver.findElements(By.xpath("//div//div[@class='rt-td'][3]"));
        siraNo=1;
        for (WebElement eachElement : kolonData) {
            System.out.println("Tablodaki 3.kolonu yazdirin : "+ siraNo++ +" " + eachElement.getText());
        }

        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 0; i < tumList.size()  ; i++) {
            if (tumList.get(i).getText().equals("Kierra")){
                System.out.println("Istenen kisinin maasi : " + tumList.get(i+4).getText());
            }
        }
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        findCellOfTable(2,2);

        System.out.println("Mehmet Bey metod : "+ dataYazdir(2, 2));

    }
    public void findCellOfTable(int satir,int sutun){
        //div[@class='rt-tbody']/div[3]/div[1]/div[5]
        System.out.println("Metod : "+driver
                .findElement(By.xpath(" //div[@class='rt-tbody']/div["+satir+"]/div[1]/div["+sutun+"]"))
                .getText());
    }
    public String dataYazdir(int satirNo,int sutunNo){

        String dinamikXpath="(//div[@class='rt-tr-group'])["+satirNo+"]//div[@class='rt-td']["+sutunNo+"]";

        return driver.findElement(By.xpath(dinamikXpath)).getText();
    }

}
