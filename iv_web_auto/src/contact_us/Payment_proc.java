package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Payment_proc {
	
	public String baseUrl = "http://staging.irisvision.com/";
    String driverPath = "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe";
    public WebDriver driver ;
	
  @Test
  public void f() {
	  
	  driver.get(baseUrl);
		
		//Maximize Window
		driver.manage().window().maximize();
		
		// Buy Now
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-23\"]/a/span")).click();
		System.out.println("1");
//		driver.findElement(By.xpath("//*[@id=\"post-13503\"]/div/div/form/div/table/tbody/tr[1]/td[3]/div/input[3]")).click();
//		driver.findElement(By.xpath("//*[@id=\"post-13503\"]/div/div/div[3]/div[2]/div/a[2]")).click();
		driver.findElement(By.id("billing_first_name")).sendKeys("John");
		driver.findElement(By.id("billing_last_name")).sendKeys("Doe");
//		driver.findElement(By.id("billing_company")).sendKeys("CitusBits");
		
				
//	     Select Country = new Select(driver.findElement(By.id("select2-billing_country-container")));
//		
//	     Country.deselectAll();
//	     Country.selectByVisibleText("Ukraine");
//	     System.out.println("country");
		
		// Adding Address
		
		driver.findElement(By.id("billing_address_1")).sendKeys("87 E Green St #309, Pasadena, CA 91105, United States");
		
		driver.findElement(By.id("billing_address_2")).sendKeys("Green Garden CA");
		
		System.out.println("Address Added");
		
		// Adding City
		
		driver.findElement(By.id("billing_city")).sendKeys("Pasadena");
		
		// Selecting State
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 130);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"select2-billing_state-container\"]"))).click();
		
//		Select State = new Select(driver.findElement(By.id("select2-billing_state-container")));
//	    State.selectByVisibleText("California");
	    
		driver.findElement(By.id("billing_postcode")).sendKeys("91105");
	    driver.findElement(By.id("billing_phone")).sendKeys("1112223330");
	    driver.findElement(By.id("billing_email")).sendKeys("m.alikirmani@yahoo.com");
	    
	    // Adding Payment Details
	    
	    driver.findElement(By.id("card_connect-card-name")).sendKeys("Ali");
	    driver.findElement(By.id("card_connect-card-number")).sendKeys("1111222233334444");
	    driver.findElement(By.id("card_connect-card-expiry")).sendKeys("06/2020");
	    driver.findElement(By.id("card_connect-card-cvc")).sendKeys("1234");
	    
	    // Additional Information
	    
//	    driver.findElement(By.id("order_comments")).sendKeys("CB Test");
	    
	    //Place Order
	    System.out.println("Placed");
        //driver.findElement(By.id("place_order")).click();
    System.out.println("Placed");
	  
  }
  
  
  
  
  
  
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {

	  driver.quit();
	  
  }

}
