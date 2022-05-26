package frameworkDesign2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.pages.CompanyUpdatePage;
import framework.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CompanyUpdatePageTest{
	
	public CompanyUpdatePage companyUpdate;
	public LoginPage logPage;
	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	
	@BeforeTest
	public void initTest() throws IOException {
		fis = new FileInputStream("C:\\Users\\bhavinp\\Documents\\eclipseWorkspace\\com.DemoProject\\src\\test\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		companyUpdate = PageFactory.initElements(driver, CompanyUpdatePage.class);

	}
	
	@Test
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
		
		companyUpdate = PageFactory.initElements(driver, CompanyUpdatePage.class);
		companyUpdate.profileUpdateNxt();
		companyUpdate.addressTxt(prop.getProperty("address"));
		companyUpdate.cityTxt(prop.getProperty("city"));
		companyUpdate.postalCodeTxt(prop.getProperty("pinCode"));
		companyUpdate.taxIDTxt(prop.getProperty("taxIDNo"));
		companyUpdate.profileUpdateNxt();
		//companyUpdate.askMeLaterButton();
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
