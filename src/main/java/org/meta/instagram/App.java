package org.meta.instagram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{

    WebDriver driver;
	public static void main( String[] args )
	{
		App ref= new App();
		ref.setup();
		ref.login();
		ref.teardown();
	}
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void login()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		WebElement pass= driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");
		
		WebElement logbut=	driver.findElement(By.id("btnLogin"));
		logbut.click();
	}
	public void teardown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
