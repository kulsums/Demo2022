package framework.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
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
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
