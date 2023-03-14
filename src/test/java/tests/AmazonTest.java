package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.dnd.DragGestureEvent;

public class AmazonTest {
  private static WebDriver driver;
    @BeforeClass
    public void setUp(){
      //    FIX FOR: Invalid Status code=403 text=Forbidden in Selenium ChromeDriver
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver(options);
  }
//      1. test amazon title kontrol = --> test01
//      2. test amazonda belirli bir ürün arama = --> test02
  @Test
  public  void test01(){
      driver.get("https://amazon.com/");
      String currenttitle = driver.getTitle();
      Assert.assertEquals(currenttitle,driver.getTitle());
  }
  @Test
  public  void test02(){
     WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
     aramaKutusu.sendKeys("Nutella",Keys.ENTER);
     WebElement nutellaKontrol = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"][1]"));
     Assert.assertTrue(nutellaKontrol.isDisplayed());
  }

  @AfterClass
    public static void tearDown(){
      driver.quit();
  }
}
