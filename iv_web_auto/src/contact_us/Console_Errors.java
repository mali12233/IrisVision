package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.Date;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;

public class Console_Errors {
	
    private WebDriver driver;
    


	
  @Test
  public void testMethod() throws InterruptedException 
  {
      driver.get("http://www.irisvision.com/");
      driver.manage().window().maximize();
      analyzeLog();
      WebDriverWait wait = new WebDriverWait(driver, 27000);

       
      
      // Benefits
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-5872\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-5872\"]/a/span")).click();
      analyzeLog();
      
      // Product
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-5878\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-5878\"]/a/span")).click();
      analyzeLog();
      
      // Pricing
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-5873\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-5873\"]/a/span")).click();
      analyzeLog();
      
      // For EyeCare Professionals 
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-5871\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-5871\"]/a/span")).click();
	  analyzeLog();
	  
	  // FAQs
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-5870\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-5870\"]/a/span")).click();
	  analyzeLog();
	  
	  //About 
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-22\"]/a/span"))).click();
      //driver.findElement(By.xpath("//*[@id=\"menu-item-22\"]/a/span")).click();
	  analyzeLog();
	  
	  
	  //Contact US
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-5886\"]/a/span"))).click();
	  //driver.findElement(By.xpath("//*[@id=\"menu-item-5886\"]/a/span")).click();
	  analyzeLog();
	  
	  // Buy Now
     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu-item-23 > a > span"))).click();
     //driver.findElement(By.xpath("//*[@id=\"menu-item-23\"]/a/span")).click();
	  analyzeLog();
	  
	  // Free Consultation
//	  driver.navigate().to("https://staging.irisvision.com/");
//	  wait.until(ExpectedConditions.elementToBeClickable(By.id("cons_button"))).click();
//	  analyzeLog();
	  
	  // Learn More
 	  driver.navigate().to("https://www.irisvision.com/");
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#improve-vision > div > div.fusion-layout-column.fusion_builder_column.fusion_builder_column_1_2.fusion-one-half.fusion-column-last.\\31 _2 > div > div.fusion-button-wrapper.fusion-alignleft > a"))).click();
	  analyzeLog();
	  
	  //See More Customer Stories
	  driver.navigate().back();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-13068\"]/div/div[17]/div/div[2]/div/div[1]/div/div[3]/a"))).click();
	  analyzeLog();
	  
	  //LeaderShip
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Leadership"))).click();
	  analyzeLog();
	  
	  // PressRoom
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Press Room"))).click();
	  analyzeLog();
	  
	  //Careers
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Careers"))).click();
	  analyzeLog();
	  
	  //Partners
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Partners"))).click();
	  analyzeLog();
	  
	  //FAQ
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FAQ"))).click();
	  analyzeLog();
	  
	  //Contact Us
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us"))).click();
	  analyzeLog();
	  
	  //Shipping and Returns
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shipping and Returns"))).click();
	  analyzeLog();
	  
	  //Warranty
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Warranty"))).click();
	  analyzeLog();
	  
	  //Blog
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Blog"))).click();
	  analyzeLog();
	  
	  //Events
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Events"))).click();
	  analyzeLog();
	  
	  //Refer a Friend
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Refer a Friend"))).click();
	  analyzeLog();
	  
	  //IrisVision for Veterans
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("IrisVision for Veterans"))).click();
	  //analyzeLog();
	  
	  //Newsletter
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Newsletter"))).click();
	  //analyzeLog();
	  
	  //OtherPages
	  driver.navigate().back();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  //Living with Vision Loss
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Living with Vision Loss"))).click();
	  analyzeLog();
	   
	  //Visually Impaired Product
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Visually Impaired Product"))).click();
	  analyzeLog();
	  
	  //World’s Best Low Vision Aids
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("World’s Best Low Vision Aids"))).click();
	  analyzeLog();
	  
	  //Macular Degeneration Glasses
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Macular Degeneration Glasses"))).click();
	  analyzeLog();
	  
	  //Low Vision Assistive Technology
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Low Vision Assistive Technology"))).click();
	  analyzeLog();
	  
	  //Low Vision Magnifiers
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Low Vision Magnifiers"))).click();
	  analyzeLog();
	  
	  //Best Esight Alternative
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordian-1\"]/div/div[1]/h4/a/div[2]"))).click();
	  analyzeLog();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Best Esight Alternative"))).click();
	  analyzeLog();
	  
	  
	  
	  
	  
  }
  
  @BeforeMethod
  	  
	  
	  public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe");        
	        ChromeOptions caps = new ChromeOptions();
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	        driver = new ChromeDriver(caps);
	        
	        
  }

  @AfterMethod
  public void tearDown() {
      driver.quit();
  }

  public void analyzeLog() {
      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
      for (LogEntry entry : logEntries) {
          System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
          //do something useful with the data
      }
  }



}
