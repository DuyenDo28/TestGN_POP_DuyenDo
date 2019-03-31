package com.bankguru.actions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.LoginPageUI;
import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class NewCustomerPage extends commonFunction{

	public NewCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void inputKeyCustomerName(Keys value)
	{
		waitVisible(NewCustomerUI.CUSTOMER_NAME_TXT);
		inputKeys(NewCustomerUI.CUSTOMER_NAME_TXT,value);	
				
	}
	public void inputKeyDateOfBirth(Keys value)
	{
		waitVisible(NewCustomerUI.DATEOFBILRTH);
		inputKeys(NewCustomerUI.DATEOFBILRTH,value);	
				
	}
	
	public String getTextCustomerLBL()
	{
		waitVisible(NewCustomerUI.CUSTOMER_NAME_LBL);
		return getText(NewCustomerUI.CUSTOMER_NAME_LBL);
			
	}
	public String getTextDateOfBirthLBL()
	{
		waitVisible(NewCustomerUI.DATEOFBIRTH_LBL);
		return getText(NewCustomerUI.DATEOFBIRTH_LBL);
			
	}
	public void inputNumbericToCustomer()
	{
		input(NewCustomerUI.CUSTOMER_NAME_TXT, "123");
	}
	public void inputSpecialToCustomer()
	{
		input(NewCustomerUI.CUSTOMER_NAME_TXT, "@");
	}
	public void inputFirstSpaceToCustomer()
	{
		input(NewCustomerUI.CUSTOMER_NAME_TXT, " abc123");
	}
	
	
	

}
