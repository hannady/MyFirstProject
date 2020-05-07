package TestSuite;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoursePage;
import pageObjects.FirstPage;

import resources.Base;

public class Course extends Base {
	public FirstPage fp;
	public CoursePage cp; 

	public WebDriver driver; 
	String currenturi = "https://www.rahulshettyacademy.com/#/index";
	
	public static Logger Log = LogManager.getLogger(Course.class.getName());
	@BeforeTest // open URL
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Page is Open ");

	}
	
	@Test()
   public void clickOnCoursesButton() {
	 fp = new FirstPage(driver);
      fp.getCoursesButton().click();
	  Log.info("Click on Courses Buttion ");
	  }
	@Test
	public void getUri() {
    cp= new CoursePage(driver);
	String url = driver.getCurrentUrl();
	if(url==currenturi) {
		Log.info("Open new page ");	
	}
	
	}
	@Test()
	public void validateText() {
		 cp= new CoursePage(driver);
		String text= cp.getValidateText().getText();
		Assert.assertEquals(text, "An Academy to Learn Earn & Shine  in your QA Career");
		
		
		
	}
	@AfterTest // Close page

	public void teardown() {
		driver.close();
		driver = null;
		Log.info("Browser is closed");

	}
	

}
