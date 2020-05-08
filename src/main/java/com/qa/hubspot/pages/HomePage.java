package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;
/**
 * 
 * @author Fuadkhan
 *
 */
public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("body > div.page > div > div > div > div > section > div > div > main > div.OnboardingPage__StyledContentWrapper-sc-10znqdh-0.fWClUS > div > div > div.UISection__ScrollWrapper-hm68fz-0.cPFEUP.text-center.is--module.namespaced-hack-section > h2 > i18n-string");
	By contactMenu = By.id("account-menu");
	By contactsMainTab = By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	By signOutBtn = By.id("signout");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public String getHomePageeHeaderValue() {
		return elementUtil.doGetText(header);
	}
	
	public void clickOnContactMenu() {
		elementUtil.doClick(contactMenu);
	}
	
	private void clickOnContacts() {
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(contactsChildTab);
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	public String signOutButtonIsVisible() {
		return elementUtil.doGetText(signOutBtn);
		//String signOutText = signOutBtn.toString();
	}

	
}
