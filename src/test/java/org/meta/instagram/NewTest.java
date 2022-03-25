package org.meta.instagram;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	@Test
	public void f() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		WebElement pass= driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");

		WebElement logbut=	driver.findElement(By.id("btnLogin"));
		logbut.click();
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String value) {

		String browserName=value;
		
		if ("chrome".equals(browserName)) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if ("edge".equals(browserName)) {
			System.setProperty("webdriver.edge.driver", "Resource/msedgedriver.exe");
			driver= new EdgeDriver();
		}
		else {
			throw new RuntimeException("The browserName provided doesnot exsist");
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
