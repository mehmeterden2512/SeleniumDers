package day07_ActionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
        // bilgisayarimizin temel dosya yolu user.home
        //"C:\Users\LENOVO\Desktop\TheDelta.docx"bilgisyar masa ustu dosya yolu

        // icinde bulundugumuz projenin temel dosya yolu user.dir

        // icinde bulundugumuz projenin temel dosya yolu user.dir
        String dosyaYolu="C:\\Users\\LENOVO\\Desktop\\TheDelta.docx";
        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);
        /*
        Bilgisayarimizda bir dosyanin var oldugunu test etmek icin dosya yoluna ihtiyacimiz var

        Ancak herkesin bilgisayarindaki dosya yollari farkliliklar gosterir
        herkesin bilgisayarina göre farkli olan kismi
        java ddan bir komutla alabiliriz
         */

        System.out.println(System.getProperty("user.home"));
        dosyaYolu=System.getProperty("user.home")+"\\Desktop\\TheDelta.docx";
        //Projede ayni olan kısım
        System.out.println(System.getProperty("user.dir"));

    }
}
