package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links_verification {
	
	public String baseUrl = "http://staging.irisvision.com/";
    String driverPath = "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe";
    public WebDriver driver ;	
  
	
  @Test
  public void f() {
			
				
	  driver.get(baseUrl);				
	  driver.manage().window().maximize();
				
			
				
				List<WebElement> links=driver.findElements(By.tagName("a"));
				
				System.out.println("Total links are "+links.size());
				
				for(int i=0;i<links.size();i++)
				{
					
					WebElement ele= links.get(i);
					
					String url=ele.getAttribute("href");
					
					verifyLinkActive(url);
					
				}
				
			}
			
			public static void verifyLinkActive(String linkUrl)
			{
		        try 
		        {
		           URL url = new URL(linkUrl);
		           
		           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		           
		           httpURLConnect.setConnectTimeout(3000);
		           
		           httpURLConnect.connect();
		           
		           if(httpURLConnect.getResponseCode()==200)
		           {
		               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
		            }
		          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
		           {
		               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
		            }
		        } catch (Exception e) {
		           
		        }

			}

  
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  
  }
  }

