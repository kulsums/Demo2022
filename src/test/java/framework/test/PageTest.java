package framework.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import framework.pages.CompanyUpdatePage;
import framework.pages.LoginPage;
import framework.pages.RegisterPage;

public class PageTest extends BaseTest {
	
	
	private LoginPage logPage;
	private CompanyUpdatePage companyUpdate;
	private RegisterPage regPage;
	

	@Test
	public void registerTest() {
		regPage = PageFactory.initElements(driver, RegisterPage.class);
		regPage.navigate_Register_Page();
		regPage.selectCountry();
		regPage.companyTxt(prop.getProperty("companyName"));
		regPage.firstNMTxt(prop.getProperty("firstName"));
		regPage.lastNMTxt(prop.getProperty("lastName"));
		regPage.phoneTxt(prop.getProperty("phoneNo"));
		regPage.emailTxt(prop.getProperty("emailID"));
		regPage.pwdTxt(prop.getProperty("password"));
		regPage.checkReceive();
		regPage.checkVATID();
		regPage.regBtn();
		System.out.println("Registration Successful");
	}

	@Test(dependsOnMethods = "registerTest")
	public void loginTest() {
		logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.navigate_Login_Page();
		logPage.emailTxt(prop.getProperty("emailID"));
		logPage.pwdTxt(prop.getProperty("password"));
		logPage.loginBtn();
		System.out.println(logPage.verifyLogin(prop.getProperty("expectedProfileName")));
		
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void CompanyUpdateTest() {
		loginTest();
		companyUpdate = PageFactory.initElements(driver, CompanyUpdatePage.class);
		companyUpdate.profileUpdateNxt();
		companyUpdate.addressTxt(prop.getProperty("address"));
		companyUpdate.cityTxt(prop.getProperty("city"));
		companyUpdate.postalCodeTxt(prop.getProperty("pinCode"));
		companyUpdate.taxIDTxt(prop.getProperty("taxIDNo"));
		companyUpdate.profileUpdateNxt();
		//companyUpdate.askMeLaterButton();
	}
	
	


}
