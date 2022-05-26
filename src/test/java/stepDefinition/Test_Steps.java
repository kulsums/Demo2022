package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import framework.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Steps {
	
	public WebDriver driver;
	public RegisterPage regPage;
	public FileInputStream fis;
	public Properties prop;
	
	@Given("I am on demo.saloodo website")
	public void i_am_on_demo_saloodo_website() throws IOException {
		fis = new FileInputStream("C:\\Users\\bhavinp\\Documents\\eclipseWorkspace\\com.DemoProject\\src\\test\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	@When("I click on Register link")
	public void i_click_on_register_link() {
		regPage = PageFactory.initElements(driver, RegisterPage.class);
		regPage.navigate_Register_Page();
	}
	
	@When("after filling details I click on Register Now button")
	public void after_filling_details_i_click_on_register_now_button() {
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
		
	}
	@Then("Registration successful message displayed")
	public void registration_successful_message_displayed() {
	    System.out.println("Registration successful");
	}

}
