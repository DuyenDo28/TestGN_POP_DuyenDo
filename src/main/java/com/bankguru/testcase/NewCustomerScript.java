package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomerPage;
import com.bankguru.actions.RegisterPage;
import com.bankguru.ui.NewCustomerUI;

import CommonPage.CommonTestCase;

public class NewCustomerScript extends CommonTestCase {
	WebDriver driver;
	LoginPage logInPage;
	RegisterPage registerPage;
	HomePage homepage;
	NewCustomerPage newCustomerPage;
	String emailLogin, passwordLogin, welcomeString;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass

	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		String email = "DuyenDo" + randomEmail() + "@gmail.com";

		// logInPage = new LoginPage(driver);
		logInPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = logInPage.clickHereLink();
//		registerPage = new RegisterPage(driver);
		registerPage.inputEmailToRegister(email);
		registerPage.clickSubmit();
		emailLogin = registerPage.getUserName();
		passwordLogin = registerPage.getPassword();
		logInPage = registerPage.navigateToLoginPage("http://demo.guru99.com/v4/");

		logInPage.inputUserID(emailLogin);
		logInPage.inputPassword(passwordLogin);
		// homepage = new HomePage(driver);
		homepage = logInPage.clickLogin();
		welcomeString = homepage.getWelcomeString();

		verifyEqual(homepage.getWelcomeString(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@BeforeMethod
	public void beforeMethod() {
		newCustomerPage = homepage.ClickONCustomerMenu();

	}

	@Test
	public void TC_CustomerCannotBlank_01() {
		newCustomerPage.inputKeyCustomerName(Keys.TAB);
		verifyEqual(newCustomerPage.getTextCustomerLBL(), "Customer name must not be blank");
	}
	@Test
	public void TC_DateFieldCannotBlank_02() {
		newCustomerPage.inputKeyDateOfBirth(Keys.TAB);
		verifyEqual(newCustomerPage.getTextDateOfBirthLBL(), "Date Field must not be blank");
	}
	@Test
	public void TC_NameCannotNumberic_03() {		
		newCustomerPage.inputNumbericToCustomer();
		verifyEqual(newCustomerPage.getTextCustomerLBL(), "Numbers are not allowed");
	}
	@Test
	public void TC_NameCannotSpecialText_04() {		
		newCustomerPage.inputSpecialToCustomer();
		verifyEqual(newCustomerPage.getTextCustomerLBL(), "Special characters are not allowed");
	}
	@Test
	public void TC_NameCannotFirstSpace_05() {		
		newCustomerPage.inputFirstSpaceToCustomer();
		verifyEqual(newCustomerPage.getTextCustomerLBL(), "First character can not have space");
	}

	@AfterClass
	public void afterClass()

	{
		// closeBrowser();

	}

}
