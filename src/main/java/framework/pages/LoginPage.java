package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath = "//input[@type='email']")
	WebElement eMailID;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Forgot')]")
	WebElement forgotLink;
	
	@FindBy(xpath = "//div[@class='sc-gGLxEB dGJRan sc-gsWcmt klzvRB']")
	WebElement profileName;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate_Login_Page() {
		loginLink.click();
	}

	public void emailTxt(String mailID) {
		eMailID.sendKeys(mailID);

	}

	public void pwdTxt(String pwd) {
		password.sendKeys(pwd);
		
	}

	public void loginBtn() {
		submitBtn.click();;
	}
	
	public String verifyLogin(String expected) {
		
		String profileNM = profileName.getText();
		Assert.assertEquals(expected, profileNM);
		return "Login Successful";
	}

}
