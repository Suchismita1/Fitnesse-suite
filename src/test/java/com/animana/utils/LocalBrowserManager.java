package com.animana.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalBrowserManager {
	public static WebDriver localDriver;
	
	public static WebDriver initializeDriver(String browser){
		try{
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\testdriver\\chromedriver.exe");
			localDriver = new ChromeDriver();
			return localDriver;
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\testdriver\\MicrosoftWebDriver.exe");
			localDriver = new InternetExplorerDriver();
			return localDriver;
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\testdriver\\geckodriver.exe");
			localDriver = new FirefoxDriver();
			return localDriver;
		}}
		catch(WebDriverException e){
			System.out.println("illigal browser type");
			localDriver = startChromeDriver(browser);
			
		}
		return localDriver;
		
	}
	
	private static WebDriver startChromeDriver(String browser) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\testdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public static WebDriver getLocalDriver(){
		return localDriver;
	}
	
	public static void closeLocalDriver(){
		localDriver.close();
	}

}
