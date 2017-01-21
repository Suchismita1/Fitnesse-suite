package com.animana.scenario;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.animana.Pages.Animana_HomePage;
import com.animana.utils.LocalBrowserManager;
import com.animana.utils.PageDetail;
import com.animana.utils.RemoteBrowserManager;

public class Animana {
	public static WebDriver driver;
	Animana_HomePage homePage = new Animana_HomePage();
	@BeforeClass
	@Parameters({"Browser","envType"})
	public void setupDriver(String Browser, String envType) throws MalformedURLException{
		if(envType.equalsIgnoreCase("local")){
		   LocalBrowserManager.initializeDriver(Browser);
		}
		else if(envType.equalsIgnoreCase("remote")){
			RemoteBrowserManager.initializeRemoteDriver(Browser);
		}
	}
	
	@Test
	@Parameters({"envType"})
	public void login(String envType)
	{
		if(envType.equalsIgnoreCase("local")){
		driver = LocalBrowserManager.getLocalDriver();
		
		driver.get(PageDetail.appURL);
		}
		else if(envType.equalsIgnoreCase("remote")){
			driver = RemoteBrowserManager.getRemoteDriver();
			driver.get(PageDetail.appURL);
		}
		
		
	}
	
	@AfterTest
	@Parameters({"envType"})
	public void tearDown(String envType){
		if(envType.equalsIgnoreCase("local")){
			LocalBrowserManager.closeLocalDriver();
		}
		else if(envType.equalsIgnoreCase("remote")){
			RemoteBrowserManager.closeRemoteDriver();
		}
	}

}
