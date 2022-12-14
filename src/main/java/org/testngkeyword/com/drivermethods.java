package org.testngkeyword.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drivermethods {
	
	WebDriver driver;
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12345));
		
	}
	public void enterdata()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
	}
	public void validatelogin()
	{
		boolean a=driver.findElement(By.xpath("//h6")).isDisplayed();
		if(a==true)
		{
			System.out.println("Login successful done");	
		}
		else
		{
			System.out.println("Login failure");	
		}
		
	}
	public void logout()
	{
		System.out.println("going to logout hello");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.close();
		
	}

}
