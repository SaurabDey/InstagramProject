package org.meta.instagram;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
	ExtentReports extent ;
	ExtentTest test;
	@Test
	public void f() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		WebElement pass= driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");

		WebElement logbut=	driver.findElement(By.id("btnLogin"));
		logbut.click();
		test.log(Status.PASS, "My Login was successfully!!!");
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String value) {
		
		extent= new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Resource/Selenium.html");
		//spark.config().setTheme(Theme.DARK);
		
		extent.attachReporter(spark);
		
		test= extent.createTest("Saurab Selenium");
		

		String browserName=value;
		
		if ("chrome".equals(browserName)) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver= new ChromeDriver();
			test.log(Status.INFO, "My Chrome browser is opening successfully!!");
		}
		else if ("edge".equals(browserName)) {
			System.setProperty("webdriver.edge.driver", "Resource/msedgedriver.exe");
			driver= new EdgeDriver();
			test.log(Status.INFO, "My Chrome edge is opening successfully!!");
		}
		else {
			throw new RuntimeException("The browserName provided doesnot exsist");
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
		test.log(Status.INFO, "I am opening automation practice site!!");
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
		test.log(Status.INFO, "I am closing the browser!!!");
		
		extent.flush();
	}

}
