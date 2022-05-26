package withoutPFM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfileUpdate {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.saloodo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("restapi.ashwini@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Demo@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.findElement(By.xpath("//div[@class='sc-gGLxEB dGJRan sc-gsWcmt klzvRB']")).click();
		
		driver.findElement(By.xpath("//button[@class='sc-bdnxRM pkkDT']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Address Line 1')]/preceding::input[1]")).sendKeys("Test123");

		driver.findElement(By.xpath("//label[contains(text(),'City')]/preceding::input[1]")).sendKeys("Mumbai");
		
		driver.findElement(By.xpath("//label[contains(text(),'Postal')]/preceding::input[1]")).sendKeys("400615");
		driver.findElement(By.xpath("//label[contains(text(),'VAT')]/preceding::input[1]")).sendKeys("DE123246782");
		driver.findElement(By.xpath("//button[@class='sc-bdnxRM pkkDT']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Ask me later')]")).click();
		//class
		//sc-ibZbwP fgRkRV
		
	}

}
