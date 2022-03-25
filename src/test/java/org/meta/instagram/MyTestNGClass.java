package org.meta.instagram;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class MyTestNGClass {
  @Test(priority = 2)
  public void login() {
	  System.out.println("===========test====login=======");
  }
  
  @Test(priority = 1)
  public void registration() {
	  System.out.println("===========test====registration=======");
  }
  
  @Test(priority = 3)
  public void shipping() {
	  System.out.println("===========test====shipping=======");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("==Before Method===========");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("==After Method===========");
  }

}
