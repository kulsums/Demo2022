package practiceFiles;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import framework.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPageTest {
	private WebDriver driver;
	private RegisterPage regPage;
	@BeforeMethod
	public void navigate() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.saloodo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}


	@Test
	public void registerTest() {
		regPage = PageFactory.initElements(driver, RegisterPage.class);
		regPage.navigate_Register_Page();
		regPage.selectCountry();
		regPage.companyTxt("ABCXYZ");
		regPage.firstNMTxt("Bhavin");
		regPage.lastNMTxt("Panchal");
		regPage.phoneTxt("123456");
		regPage.emailTxt("morekiran769@gmail.com");
		regPage.pwdTxt("Demo@123");
		regPage.checkReceive();
		regPage.checkVATID();
		regPage.regBtn();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
