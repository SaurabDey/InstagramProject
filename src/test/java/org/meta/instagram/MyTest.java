package org.meta.instagram;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MyTest {
	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		WebElement pass= driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");

		WebElement logbut=	driver.findElement(By.id("btnLogin"));
		logbut.click();
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
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
