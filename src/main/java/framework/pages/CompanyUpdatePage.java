package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyUpdatePage {
	
	WebDriver driver;

	@FindBy(xpath = "//button[@class='sc-bdnxRM pkkDT']")
	WebElement nextBtn;

	@FindBy(xpath = "//label[contains(text(),'Address Line 1')]/preceding::input[1]")
	WebElement address;

	@FindBy(xpath = "//label[contains(text(),'City')]/preceding::input[1]")
	WebElement city;
	
	@FindBy(xpath = "//label[contains(text(),'Postal')]/preceding::input[1]")
	WebElement postalCode;
	
	@FindBy(xpath = "//label[contains(text(),'VAT')]/preceding::input[1]")
	WebElement taxID;
	
	@FindBy(xpath = "//button[contains(text(),'Ask me later')]")
	WebElement askMeLaterBtn;

	public CompanyUpdatePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void profileUpdateNxt() {
		nextBtn.click();
	}

	public void addressTxt(String add) {
		address.sendKeys(add);

	}

	public void cityTxt(String cityText) {
		city.sendKeys(cityText);
	}

	public void postalCodeTxt(String postcode) {
		postalCode.sendKeys(postcode);
	}
	
	public void taxIDTxt(String taxIDText) {
		taxID.sendKeys(taxIDText);
	}

	public void askMeLaterButton() {
		askMeLaterBtn.click();;
	}
	

}
