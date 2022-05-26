package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registerLink;

	@FindBy(css = "input#country")
	WebElement country;

	@FindBy(css = "input[name=company]")
	WebElement company;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='undefined-number']")
	WebElement phoneNo;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailID;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='sc-eWnToP fEDxD' and contains(text(),'I would like')]")
	WebElement checkbkReceive;

	@FindBy(xpath = "//div[@class='sc-eWnToP fEDxD' and contains(text(),'I have a VAT')]")
	WebElement checkbkVATID;

	@FindBy(xpath = "//button[@class='sc-bdnxRM ipXSeA']")
	WebElement registerBtn;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate_Register_Page() {
		registerLink.click();
	}

	public void selectCountry() {
		country.click();

	}

	public void companyTxt(String cmp) {

		company.sendKeys(cmp);
	}

	public void firstNMTxt(String FN) {
		firstName.sendKeys(FN);
	}

	public void lastNMTxt(String LN) {
		lastName.sendKeys(LN);
	}

	public void phoneTxt(String PN) {
		phoneNo.sendKeys(PN);
	}

	public void emailTxt(String eID) {
		emailID.sendKeys(eID);
	}

	public void pwdTxt(String pwd) {
		password.sendKeys(pwd);
	}

	public void checkReceive() {
		checkbkReceive.click();
	}

	public void checkVATID() {
		checkbkVATID.click();
	}

	public void regBtn() {
		registerBtn.click();
	}

}
