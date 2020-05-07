package TestSuite;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.FirstPage;
import pageObjects.LoginPage;
import resources.Base;


public class validateTitle extends Base {
	public static Logger Log=LogManager.getLogger(validateTitle.class.getName());
	public FirstPage fp;
	
	@BeforeTest 
	
	// open URL 
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Page is open");
		
	}
	@Test() 
	
	//Secon test case 
public void testingValidateTitle() throws IOException, InterruptedException {
		
		
	    fp= new FirstPage(driver);
		//compare text from browser with actual text 
		String realText=fp.getTitle().getText();
		Assert.assertEquals(realText, "FEATURED COURSES");
		Log.info("Successfully validated tex massage");
		
		
		
	}@Test()
	
	public void validateHeder() {
		
		String headerText=fp.getHeder().getText();
		Assert.assertEquals(headerText, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		Log.info("Successfully validated tex massage");
		
		
	}
	@Test
	public void validateEmail() {
		 fp= new FirstPage(driver);
		 boolean emailIsDisplayed=fp.getEmail().isDisplayed();
		 if(emailIsDisplayed==true) {
			 String emailAdresse=fp.getEmail().getText();
		Assert.assertEquals(emailAdresse, "info@qaclickacademy.com"); 
		 }
	    
		Log.info("Email is correctly ");
		
	
	}
	@Test
	public void getPhoneNumber() {
		 fp= new FirstPage(driver);
     boolean numberisDispalyed=fp.getPhonenNumber().isDisplayed();
		if(	numberisDispalyed==true) {
			String phoneNumber= fp.getPhonenNumber().getText();
			Assert.assertEquals(phoneNumber, "(+1) 323-744-6780");
		}
		
		Log.info("Phone number is correct "); 
		
	}
	@AfterTest // clouse page 

	public void teardown() {
		driver.close();
		driver=null;
		Log.info("Browser is closed");

	}

}
