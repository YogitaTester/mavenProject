package com.demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baseclass {
	WebDriver driver;
	@Parameters("browser")
		@BeforeClass
		public void openBrowser(String Browsername) {
			if(Browsername.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(Browsername.endsWith("edge")) {
				driver=new EdgeDriver();
			}
			
		}
		@BeforeMethod
		public void openApp() {
			driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
		@AfterMethod
		public void testMethodResult(ITestResult result) {
			if(result.getStatus()==1)
			{
				Reporter.log(result.getName()+"exicution is pass",true);
			}
			else if(result.getStatus()==2)
			{
				Reporter.log(result.getName()+"execution is fail",true);
			}
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}
}
