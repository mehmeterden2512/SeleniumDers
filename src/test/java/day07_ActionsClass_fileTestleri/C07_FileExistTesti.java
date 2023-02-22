package day07_ActionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistTesti {
    @Test
    public void test01(){
        //Caliştiğimiz package icerisinde
        //text.txt isimli bir file oldugunu test edin
                                                                //dosya uzerine git sağ click yap+ copy Path/Reference +pathFromContentRoot
        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day07_ActionsClass_fileTestleri/text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
