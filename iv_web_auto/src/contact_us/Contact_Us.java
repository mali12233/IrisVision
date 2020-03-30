package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Actions;

public class Contact_Us {
	
	public String baseUrl = "http://staging.irisvision.com/";
    String driverPath = "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe";
    public WebDriver driver ;
	public WebDriverWait wait;
	public Actions builder;
  @Test
  public void f() {
	  
	  
	  driver.get(baseUrl);
	  driver.manage().window().maximize();  
	  
	  
	  
	  //Fill Data in form 
	  driver.findElement(By.cssSelector("#menu-item-5886 > a > span")).click();	
	  driver.findElement(By.name("firstname")).sendKeys("John");
	  driver.findElement(By.name("lastname")).sendKeys("Doe");
      driver.findElement(By.name("email")).sendKeys("muhammad.ali@citrusbits.com");
      driver.findElement(By.name("phone")).sendKeys("1112223334");
      driver.findElement(By.id("message")).sendKeys("Hi, helo IV. This is automated script.");

      ////	  driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
  
    ////      WebElement chkbox = driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-borderAnimation"));
    ////      chkbox.click();
   //      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#recaptcha-anchor"))).click();
      
   
      //WebElement captcha = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span"));
      //builder.moveToElement(captcha, 50, 50).click().build().perform();
      
      
      
      //driver.findElement(By.id("2345")).click();

	  
  }
  
  
  @BeforeTest
  public void beforeTest() {

	 System.setProperty("webdriver.chrome.driver", driverPath);
	 driver = new ChromeDriver();
     wait = new WebDriverWait (driver, 120);
     builder = new Actions(driver);
  }

  
  @AfterTest
  public void afterTest() {
	  
driver.quit();
	  
	  
  }

}
