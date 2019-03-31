package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.LoginPageUI;

import CommonPage.commonFunction;

public class LoginPage extends commonFunction{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//	public void clickHereLink()
//	{
//		waitVisible(LoginPageUI.HERE_LINK);
//		click(LoginPageUI.HERE_LINK);
//		
//	}
	public RegisterPage clickHereLink()
	{
		waitVisible(LoginPageUI.HERE_LINK);
		click(LoginPageUI.HERE_LINK);
		return PageFactory.initElements(driver, RegisterPage.class);
		
	}
	public void inputUserID(String value)
	{
		waitVisible(LoginPageUI.USERNAME_LOGIN_TXT);
		input(LoginPageUI.USERNAME_LOGIN_TXT, value);
	}
	public void inputPassword(String value)
	{
		waitVisible(LoginPageUI.PASSWORD_LOGIN_TXT);
		input(LoginPageUI.PASSWORD_LOGIN_TXT, value);
	}
	public HomePage clickLogin()
	{
		waitVisible(LoginPageUI.LOGIN_BTN);
		click(LoginPageUI.LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);
	}
	

}
