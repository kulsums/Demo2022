package frameworkDesign2;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import framework.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPageTest {
	public WebDriver driver;
	public RegisterPage regPage;
	public FileInputStream fis;
	public Properties prop;
	
	@BeforeMethod
	public void navigate() throws IOException {
		fis = new FileInputStream("C:\\Users\\bhavinp\\Documents\\eclipseWorkspace\\com.DemoProject\\src\\test\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}


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
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
