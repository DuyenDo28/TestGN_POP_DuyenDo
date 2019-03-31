package com.bankguru.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import CommonPage.CommonTestCase;

public class LogInScript extends CommonTestCase {
	WebDriver driver;
	LoginPage logInPage;
	RegisterPage registerPage;
	HomePage homepage;
	String email, emailLogin, passwordLogin, welcomeString;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);

		email = "DuyenDo" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01() {
		//logInPage = new LoginPage(driver);
        logInPage= PageFactory.initElements(driver, LoginPage.class);
		registerPage = logInPage.clickHereLink();
//		registerPage = new RegisterPage(driver);
		registerPage.inputEmailToRegister(email);
		registerPage.clickSubmit();
		emailLogin = registerPage.getUserName();
		passwordLogin = registerPage.getPassword();
		logInPage = registerPage.navigateToLoginPage("http://demo.guru99.com/v4/");
		 
		logInPage.inputUserID(emailLogin);
		logInPage.inputPassword(passwordLogin);
		//homepage = new HomePage(driver);
		homepage = logInPage.clickLogin();
		welcomeString = homepage.getWelcomeString();

		verifyEqual(homepage.getWelcomeString(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@AfterClass
	public void afterClass()

	{
		closeBrowser();

	}

}
