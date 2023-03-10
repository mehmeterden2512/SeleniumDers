package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1Hoca {
    public static void main(String[] args) {
        // Set Path
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe"); // Bu satirda sisteme driver'imizi tanitiyoruz// Driver'imizin yolunu gosteriyoruz
        // Create chrome driver
        WebDriver driver = new ChromeDriver();//bu adimda hangi tarayici da calıştıracagimizi belirliyoruz
                                                //
        // Maximize the window
        driver.manage().window().maximize();
        // Open google home page https://www.google.com/.
        driver.get("https://www.google.com"); // Ilk etapta navigate mi get mi nasil karar veriyoruz?// Get metodu daha hizli calisir, navigate ise daha cok bagimli senaryolarda tercih edilir
        // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com"); // navigate ise daha cok bagimli senaryolarda tercih edilir
        // Navigate back to google
        driver.navigate().back();
        // Navigate forward to amazon
        driver.navigate().forward();
        // Refresh the page
        driver.navigate().refresh();
        // Close/Quit the browser
        driver.quit(); // Close bulunulan son sayfayi , Quit ise tum sayfalari kapatir
        // And last step : print "All Ok" on console
        System.out.println("All OK");

    }
}
