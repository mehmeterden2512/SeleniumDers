package day04_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertions {
    /*
    JUnit testlerin passed veya failed olduguna
    kodlari caliştirirken sorun olup oluşmamasna gore kara verir
     */

    String str1="Ali";
    String str2="ali";

    @Test
    public void test01(){
        //str1 in str2 ye eşit oldugunu test edin
        Assert.assertEquals("karşılaştırlan degerler farklı",str1,str2);
       //if (str1.equals(str2)){
       //    System.out.println("esitlik testi passed");
       //}else {
       //    System.out.println("esitlik testi Failed");
       //}
    }
    @Test
    public void  test02(){
        //str1 A harfini icerdiğini test edin
        Assert.assertTrue(str1.contains("A"));
     // if (str1.contains("A")){
     //     System.out.println("olumlu test passed");
     // }else {
     //     System.out.println("olumlu tesst failed");
     // }
    }
    @Test
    public  void test03(){
        //str2 nin c harfini icermediğini test edin
        Assert.assertFalse(str2.contains("c"));
      // if (!str2.contains("c")){
      //     System.out.println("negatif test passed");
      // }else {
      //     System.out.println("negatif test failed");
      // }
    }
}
