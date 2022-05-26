package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.pages.CompanyUpdatePage;
import io.cucumber.java.en.Then;

public class CompanyUpdatePage_Steps {
	
	public CompanyUpdatePage companyUpdate;
	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	
	@Then("should able to update Company profile")
	public void should_able_to_update_company_profile() {
		companyUpdate = PageFactory.initElements(driver, CompanyUpdatePage.class);
		companyUpdate.profileUpdateNxt();
		companyUpdate.addressTxt(prop.getProperty("address"));
		companyUpdate.cityTxt(prop.getProperty("city"));
		companyUpdate.postalCodeTxt(prop.getProperty("pinCode"));
		companyUpdate.taxIDTxt(prop.getProperty("taxIDNo"));
		companyUpdate.profileUpdateNxt();
	}

}
