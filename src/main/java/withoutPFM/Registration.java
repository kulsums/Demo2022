package withoutPFM;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.saloodo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		
		driver.findElement(By.cssSelector("input#country")).click();
		
		//driver.findElement(By.cssSelector("input#country")).sendKeys("angola");
		//Actions actions = new Actions(driver);
		//actions.keyDown().build().perform();
		
		
		driver.findElement(By.cssSelector("input[name=company]")).sendKeys("Demo");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Bhavin");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Panchal");
		
		
		driver.findElement(By.xpath("//input[@name='undefined-number']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test420@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Demo@123");
		
		driver.findElement(By.xpath("//div[@class='sc-eWnToP fEDxD' and contains(text(),'I would like')]")).click();
		driver.findElement(By.xpath("//div[@class='sc-eWnToP fEDxD' and contains(text(),'I have a VAT')]")).click();
		
		//driver.findElement(By.xpath("//span[contains(text(),'REGISTER')]")).click();
		driver.findElement(By.xpath("//button[@class='sc-bdnxRM ipXSeA']")).click();
		String verification = driver.findElement(By.xpath("//div[@class='sc-iiKPOH guCnyJ']")).getText();
		
		Assert.assertEquals(verification, "Verify your email address");
		System.out.println("Registration successful");
		driver.quit();
	}

}
