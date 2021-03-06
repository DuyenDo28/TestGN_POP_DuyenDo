package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.RegisterPageUI;

import CommonPage.commonFunction;

public class RegisterPage extends commonFunction {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void inputEmailToRegister(String value)
	{
		waitVisible(RegisterPageUI.EMAIL_REGISTER_TXT);
		input(RegisterPageUI.EMAIL_REGISTER_TXT, value);
	}
	public void clickSubmit()
	{
		waitVisible(RegisterPageUI.SUBMIT_BTN);
		click(RegisterPageUI.SUBMIT_BTN);
	}
	public String getUserName()
	{
		waitVisible(RegisterPageUI.USERNAME_LBL);
		return getText(RegisterPageUI.USERNAME_LBL);		
	}
	public String getPassword()
	{
		waitVisible(RegisterPageUI.PASSWORD_LBL);
		return getText(RegisterPageUI.PASSWORD_LBL);		
	}
	public LoginPage navigateToLoginPage(String url)
	{
		openUrl(url);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	

}
