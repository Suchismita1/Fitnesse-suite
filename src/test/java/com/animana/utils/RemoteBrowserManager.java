package com.animana.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteBrowserManager {
	
	//ThreadLocal will keep local copy of the driver
		public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
		
		public static void initializeRemoteDriver(String myBrowser) throws MalformedURLException{
			RemoteWebDriver driver = null;
			
			if(myBrowser.equalsIgnoreCase("chrome")){
				DesiredCapabilities capability = new DesiredCapabilities().chrome();
				capability.setBrowserName("chrome");
				//capability.setVersion("55.0.2883.87");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			}
			
			else if(myBrowser.equalsIgnoreCase("firefox")){
				DesiredCapabilities capability = new DesiredCapabilities().firefox();
				
				capability.setBrowserName("firefox");
				capability.setVersion("ANY");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			}
			
			else if(myBrowser.equalsIgnoreCase("ie")){
				DesiredCapabilities capability =new DesiredCapabilities().edge();
				capability.setBrowserName("ie");
				capability.setVersion("ANY");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			}
			
			setRemoteDriver(driver);
			
			getRemoteDriver();
		}

		public static WebDriver getRemoteDriver() {
			return dr.get();
			
			
		}

		public static void setRemoteDriver(RemoteWebDriver driver) {
			dr.set(driver);
			
		}
		
		public static void closeRemoteDriver(){
			getRemoteDriver().quit();
			dr.set(null);
		}
			

}
