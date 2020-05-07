package com.qa.hubspot.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilPF {
	
	WebDriver driver;
	
	public ElementUtilPF(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void waitForElementPresent(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
