package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
    @BeforeClass
    public static void setup(){
        System.out.println("Before class cslıştı");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("After clas");
    }
    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }

        @Test
    public void ahmet(){

            System.out.println("Ahmet");}
    @Test
    public void bekir(){System.out.println("Bekir");}
    @Test
    public void cengiz(){System.out.println("Cengiz");}
}
