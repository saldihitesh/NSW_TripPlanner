package com.qa.ahq.nswtripplanner.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class NswTripPlannerTestUtils {
	
	
	public static WebDriver driver;	
	static String driverPath = ".\\src\\test\\resources\\Drivers\\";
	String propFilepath=".\\src\\test\\resources\\TestData\\testdatafile.properties";

	//Method to get the WebDriver object.
	public WebDriver getDriver( ){
		return driver;
	}
		
		
	/*
	 * This method will fetch the Browser detail and Application URL from the TestNG.xml 
	 * file using @Parameter annotation and launch the browser with the given URL.
	 *  
	 */
		
	@Parameters({"browser", "appURL"})
	@BeforeMethod
	public void initializeTestBaseSetup(String browser, String appURL){
		setDriver(browser,appURL);
	}
		
	//Method to launch the browser based on the user input in the testng.xml file.
	private void setDriver(String browserType, String appURL){
			
		if(browserType.equalsIgnoreCase("CH"))
			driver = initChromeDriver(appURL);
			
		else if (browserType.equalsIgnoreCase("FF"))
			driver = initFirefoxDriver(appURL);
			
		else if (browserType.equalsIgnoreCase("IE"))
			driver = initIEDriver(appURL);
			
		else{ 
			System.out.println("Browser : "+ browserType + "is invaild");
			System.out.println("launching the Chrome browser as default..");
			driver = initChromeDriver(appURL);
			}
			
	}	
		
	//Method to initiate Chrome Browser
	private static WebDriver initChromeDriver(String appURL){
			
		System.out.println("Launching google chrome...");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.navigate().to(appURL);
		return driver;
    }
			
	//Method to initiate IE Browser
	private WebDriver initIEDriver(String appURL) {
		System.out.println("Launching Internet Explorer...");
	    System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
	    WebDriver driver = new InternetExplorerDriver();
	    driver.manage().deleteAllCookies(); // delete all the cookies
	    driver.navigate().to(appURL);
	    return driver;
	}

	//Method to initiate FireFox Browser
	private WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox with new profile..");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		@SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(cap);
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.navigate().to(appURL);	
		return driver;
	}
		
	//Implicit wait method
	public void implicitWaitForPageLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	//Explicit wait method
	public void explicitWaitForElement(WebDriver driver){
		try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	

	public Properties LoadPropertiesfile(){
		FileInputStream fileIn;
		Properties prop = new Properties();
		try{
			fileIn = new FileInputStream(propFilepath);
			try {
				prop.load(fileIn);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException fileex){
			System.out.println("Properties File was not found " + fileex.getMessage());
		}
		return prop;	
	}	
	
	public void enterStationName(String Station,WebElement webElementStation){
		webElementStation.clear();
		Actions action =new Actions(driver);
		action.moveToElement(webElementStation)
		      .click()
		      .sendKeys(Station)
		      .click()
		      .build()
		      .perform();
	}

}
