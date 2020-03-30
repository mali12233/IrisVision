package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class img_source {

	public String baseUrl = "http://www.irisvision.com/";
	String driverPath = "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe";
	public WebDriver driver;

	private List<WebElement> links;
	private List<String> urls;
	private int index = 0;

	private JSONObject jsonObjectUrl;
	private JSONArray jsonObjectUrls = new JSONArray();

	@Test
	public void f() {

		readJSONData();

		if (urls != null && urls.size() > 0) {

			driver.get(urls.get(index));
			driver.manage().window().maximize();

			checkLinksImages();
		}

	}

	private void readJSONData() {

		urls = new ArrayList<String>();

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
		printImageSrc();
	}

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();

	}

	@AfterMethod

	public void aftermethod() {

		driver.quit();
	}

	public void printImageSrc() {

		List<WebElement> images = driver.findElements(By.tagName("img"));

		JSONArray imagesSrc = new JSONArray();

		System.out.println("Total number of images = " + images.size());
		for (int i = 0; i < images.size(); i++) {
			WebElement ele = images.get(i);
			String url = ele.getAttribute("src");
			System.out.println(url);
			imagesSrc.add(url);
		}

		jsonObjectUrl.put("Images", imagesSrc);
		jsonObjectUrls.add(jsonObjectUrl);

		index++;
		if (index < urls.size())
			checkLinksImages();
		else {

			writeJsonData();
			System.out.println("Completed");
		}
	}

	private void writeJsonData() {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("url_images.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.write(jsonObjectUrls.toJSONString());

		printWriter.flush();
		printWriter.close();

	}
}