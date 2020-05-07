package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage {
	WebDriver driver;
	ElementUtil elementUtil;

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
	By closeButton = By.cssSelector("body > div:nth-child(17) > div > div > div > div > header > div > div > svg");
	By createAndAddAnother = By.xpath("/html/body/div[6]/div/div/div/div/footer/div/div/div/div/ul/li[2]/button/span/i18n-string");
	By cancelButton = By.xpath("/html/body/div[6]/div/div/div/div/footer/div/div/div/div/ul/li[3]/button/span");
	
	
	By email = By.id("UIFormControl-28");
	By firstName = By.id("UIFormControl-30");
	By lastName = By.id("UIFormControl-34");
	By jobTitle = By.id("UIFormControl-42");
	
	//constructor of page class:
		public ContactsPage(WebDriver driver) {
			//i won't create default constructor
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}
		
		public String getContactsPageTitle() {
			return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
		}
		
		public void createNewContact(String emailID, String FN, String LN, String jobTitleVal) {
			elementUtil.doClick(createContactButton);
			elementUtil.doSendKeys(email, emailID);
			elementUtil.doSendKeys(firstName, FN);
			elementUtil.doSendKeys(lastName, LN);
			elementUtil.doSendKeys(jobTitle, jobTitleVal);
			
			elementUtil.doClick(createContactFormButton);
			//elementUtil.doClick(closeButton);
			
			
			//elementUtil.doClick(createAndAddAnother);
			//elementUtil.doClick(cancelButton);
		}
	
	
	
}
