package day04_JUnitFramework;

import org.junit.*;

public class C05_BirlikteKullanim {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class calıştş \n============");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("============= \nAfterclass calıştıı");
    }
    @Before
    public void before(){
        System.out.println("\nBefore method'calişti");
    }
    @After
    public void after(){
        System.out.println("After method' calıştı");
    }
    @Test
    public void  test01(){
        System.out.println("test01 calıştı");
    }
    @Test
    public void  test02(){
        System.out.println("test02 calıştı");
    }
    @Test
    public void  test03(){
        System.out.println("test03 calıştı");
    }
}
