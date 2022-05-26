package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {
	
	public WebDriver driver;
	public LoginPage logPage;
	public FileInputStream fis;
	public Properties prop;
	
	@When("I click on Login link")
	public void i_click_on_login_link() {
		logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.navigate_Login_Page();
	}
	@When("After entering username and password I click on Login In button")
	public void after_entering_username_and_password_i_click_on_login_in_button() {
		logPage.emailTxt(prop.getProperty("emailID"));
		logPage.pwdTxt(prop.getProperty("password"));
		logPage.loginBtn();
	}
	@Then("successfull login validated with profile initials")
	public void successfull_login_validated_with_profile_initials() {
		System.out.println(logPage.verifyLogin(prop.getProperty("expectedProfileName")));
	}

}
