package withoutPFM;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.saloodo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("restapi.ashwini@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Demo@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String profile = driver.findElement(By.xpath("//div[@class='sc-gGLxEB dGJRan sc-gsWcmt klzvRB']")).getText();
		Assert.assertEquals("BP", profile);
		System.out.println("Login successful");
		
		

	}

}
