package com.qa.hubspot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Fuadkhan
 *
 */
public class BasePage {
	
	//for every page we need a driver
	public WebDriver driver;
	public Properties prop;
	public static String flash;
	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * @return this method returns webdriver instance
	 */
	
	public WebDriver initialize_driver(Properties prop) {		
		//String browser = "chrome";	
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		flash = prop.getProperty("elementFlash");
		
		if(browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "F:\\NaveenLabProjects\\chromedriver_win32_3\\chromedriver.exe");
			if(headless.equalsIgnoreCase("yes")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			}else {
				driver = new ChromeDriver();
			}
			
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(headless.equalsIgnoreCase("yes")) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			}else {
				driver = new FirefoxDriver();
			}
	}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	/**
	 * This method is used to define the properties
	 * @return this method returns prop reference
	 */
	public Properties initialize_properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/config/qa/hubspot/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public void quitBrowser() {
		try {
			driver.quit();
		}catch(Exception e) {
			System.out.println("Some exception occured while quitting the browser");
		}
		
	}
	
	public void closeBrowser() {
		try {
			driver.close();
		}catch(Exception e) {
			System.out.println("Some exception occured while closing the browser");
		}
	}
	
}
