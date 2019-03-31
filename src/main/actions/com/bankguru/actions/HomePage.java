package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.HomePageUI;
import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class HomePage extends commonFunction{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	public String getWelcomeString()
	{
		waitVisible(HomePageUI.WELCOME_TXT);
		return getText(HomePageUI.WELCOME_TXT);
	}
	public NewCustomerPage ClickONCustomerMenu()
	{
		waitVisible(HomePageUI.NEWCUSTOMER_MENU);
		click(HomePageUI.NEWCUSTOMER_MENU);
		return PageFactory.initElements(driver, NewCustomerPage.class);
		
	}
	

}
