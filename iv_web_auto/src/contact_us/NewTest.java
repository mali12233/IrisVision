package contact_us;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
import org.testng.annotations.AfterMethod;

public class NewTest {

	private WebDriver driver;
	private int index = 1;
	private List<WebElement> linksWithText = new ArrayList<WebElement>();

	@Test
	public void f() {
		
		
		//This is Commit by Ali

		driver.get("http://staging.irisvision.com/");
		driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#improve-vision > div > div.fusion-layout-column.fusion_builder_column.fusion_builder_column_1_2.fusion-one-half.fusion-column-last.\\31 _2 > div > div.fusion-button-wrapper.fusion-alignleft > a")).click();
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		// List<WebElement> linksWithText = new ArrayList<WebElement>();

		// System.out.println("Total links are " + totalLinks.size());

		// ele.click();

		/*
		 * for (int i = 0; i < totalLinks.size(); i++) {
		 * 
		 * WebElement ele = totalLinks.get(i);
		 * 
		 * // String url=ele.getAttribute("href");
		 * 
		 * String text = totalLinks.get(i).getText(); if (!text.isEmpty()) {
		 * System.out.println("" + text); linksWithText.add(ele); }
		 * 
		 * }
		 */

		// System.out.println("Total Links with text are " + linksWithText.size());

		int numberOfElementsFound = getNumberOfElementsFound(By.tagName("a"));
		System.out.println("Total Links with text are " + numberOfElementsFound);
		for (int pos = 1; pos < 4; pos++) {

			WebElement webElement = getElementWithIndex(By.tagName("a"), pos);
			if (webElement != null) {
				webElement.click();
				analyzeLog();
			}

		}

		// startAnalyzing();
	}

	public int getNumberOfElementsFound(By by) {
		return driver.findElements(by).size();
	}

	public WebElement getElementWithIndex(By by, int pos) {
		if (pos < driver.findElements(by).size())
			return driver.findElements(by).get(pos);
		else
			return null;
	}

	private void startAnalyzing() {

		String text = linksWithText.get(index).getText();
		driver.findElement(By.linkText(text)).click();
		analyzeLog();

	}

	public static void verifyLinkActive(String linkurl) {
		try {

			URL url = new URL(linkurl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

		} catch (Exception e) {

		}

	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\softwares\\lastest driver\\chromedriver.exe");
		ChromeOptions caps = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		driver = new ChromeDriver(caps);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	public void analyzeLog() {

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}

		/*
		 * index++; if (index < 3) startAnalyzing(); else
		 * System.out.println("Completed");
		 */
	}
}
