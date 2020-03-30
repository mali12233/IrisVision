package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;

public class Console_Errors_P2 {
	
	private WebDriver driver;
	String driverpath = "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe";
	String baseURL = "http://staging.irisvision.com/";
	private int index = 0;
	private List<String> urls;
	private JSONObject jsonObjectUrl;
	private JSONArray jsonObjectUrls = new JSONArray();
	
  @Test
  public void f() {
	  
	  driver.get(baseURL);
	  
	  readJSONData();

//	  List<WebElement> urls = driver.findElements(By.tagName("a")); 
		if (urls != null && urls.size() > 0) {

			driver.get(urls.get(index));
			driver.manage().window().maximize();

			checkLinksImages();
		
		}
  }
	  
//	  List<String> urls = driver.findElements(By.tagName("a"));
//	  System.out.println("Total number of links are " + urls.size());
	  
	  
	  public void readJSONData() {

			urls = new ArrayList<String>();
//
			FileReader reader = null;
			try {
				reader = new FileReader("urls.json");
			} catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException");
				e.printStackTrace();
			}

			JSONParser parser = new JSONParser();

			try {
				JSONObject jsonObject = (JSONObject) parser.parse(reader);
				JSONObject jsonObjectUrlSet = (JSONObject) jsonObject.get("urlset");
				JSONArray jsonArrayUrls = (JSONArray) jsonObjectUrlSet.get("url");

				for (int i = 0; i < jsonArrayUrls.size(); i++) {
					JSONObject url = (JSONObject) jsonArrayUrls.get(i);
					String link = (String) url.get("loc");
					urls.add(link);
				}

			} catch (IOException | ParseException e) {
				System.out.println("ParseException");
				e.printStackTrace();
			}

			
		} 
	  
	  
	  private void checkLinksImages() {

			String url = urls.get(index);
			driver.get(url);

			jsonObjectUrl = new JSONObject();
			jsonObjectUrl.put("Url", url);
			System.out.println("\n" + (index + 1) + ". Url: " + url + "\n");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			analyzeLog();
		}
	  
		
////	  
		
	  
	  
	  
	  
	  
  
  
  
  @BeforeTest
  
  
  public void beforeTest() {
  
	  System.setProperty("webdriver.chrome.driver", driverpath );
	  ChromeOptions caps = new ChromeOptions();
      LoggingPreferences logPrefs = new LoggingPreferences();
      logPrefs.enable(LogType.BROWSER, Level.ALL);
      caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
      driver = new ChromeDriver(caps);  
  
  }

  @AfterTest
  public void teardown() {
  
  
	  driver.quit();
  }
  

  public void analyzeLog() {
	  
		JSONArray imagesSrc = new JSONArray();

	  
      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
      for (LogEntry entry : logEntries) {
          System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
          
        
          
          jsonObjectUrl.put("Images", imagesSrc);
    		jsonObjectUrls.add(jsonObjectUrl);

    		index++;
    		if (index < urls.size())
    		checkLinksImages();
    		
    		else {

    			//writeJsonData();
    			System.out.println("Completed");
    		}
          
  
    }
  
  
  
  
  }
  
//  private void writeJsonData() {
//		PrintWriter printWriter = null;
//		try {
//			printWriter = new PrintWriter("url_images.json");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		printWriter.write(jsonObjectUrls.toJSONString());
//
//		printWriter.flush();
//		printWriter.close(); 
//  
}


