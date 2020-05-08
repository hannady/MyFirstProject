package TestSuite;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Hompage;
import resources.Base;

public class ValidateHompage extends Base {
	public static Logger Log = LogManager.getLogger(ValidateHompage.class.getName());
	public Hompage fp;

	@BeforeTest // open URL
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Page is opened");

	}

	@Test()

	public void testingValidateTitle() throws IOException, InterruptedException {

		fp = new Hompage(driver);
		// compare text from browser with actual text
		String realText = fp.getTitle().getText();
		Assert.assertEquals(realText, "FEATURED COURSES");
		Log.info("Successfully validated tex massage");

	}

	@Test()
//validation heder
	public void validateHeder() {

		String headerText = fp.getHeder().getText();
		Assert.assertEquals(headerText, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		Log.info("Successfully validated tex massage");

	}

//Validation email
	@Test
	public void validateEmail() {
		fp = new Hompage(driver);
		boolean emailIsDisplayed = fp.getEmail().isDisplayed();
		if (emailIsDisplayed == true) {
			String emailAdresse = fp.getEmail().getText();
			Assert.assertEquals(emailAdresse, "info@qaclickacademy.com");
		}

		Log.info("Email is correctly ");

	}

//Validation phonuNumber
	@Test
	public void getPhoneNumber() {
		fp = new Hompage(driver);
		boolean numberisDispalyed = fp.getPhonenNumber().isDisplayed();
		if (numberisDispalyed == true) {
			String phoneNumber = fp.getPhonenNumber().getText();
			Assert.assertEquals(phoneNumber, "(+1) 323-744-6780");
		}

		Log.info("Phone number is correct ");
	}

//CheckNavigation Bar
	@Test() // Test case
	// Third test case
	public void testNavigateBar() throws IOException, InterruptedException {

		fp = new Hompage(driver);
		Assert.assertTrue(((WebElement) fp.getnavigateBar()).isDisplayed());
		Log.info("Navigation Bar is displayed");
	

	}
//Check  All courses 
	@Test()

	public void testAllCourses() throws IOException, InterruptedException {
		fp = new Hompage(driver);

		Assert.assertEquals(fp.getallCourses().size(), 10);
		Log.info("All courses are displayed");

	}
	//new letters
	@Test()
	public void testNewLetters() {
	fp = new Hompage (driver);
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated((By) fp.getnewsletter()));
	Assert.assertTrue(fp.getnewsletter().isDisplayed());
	Log.info("New Letters is  displayed");
	fp.getbuttonNoThenks().click();
	Log.info("Button No Thanks is clicked ");
	
	}
	@AfterTest // Close page

	public void teardown() {
		driver.close();
		driver = null;
		Log.info("Browser is closed");

	}

}
