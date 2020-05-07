package TestSuite;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FirstPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public static Logger Log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	public FirstPage fp;

	@BeforeTest // open URL
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Page is opened");

	}

	@Test() // Test case
	// Third test case
	public void testNavigateBar() throws IOException, InterruptedException {

		fp = new FirstPage(driver);
		Assert.assertTrue(fp.getnavigateBar().isDisplayed());
		Log.info("Navigation Bar is displayed");
	}

	@Test()
	// Third 4th case
	public void testAllCourses() throws IOException, InterruptedException {
		fp = new FirstPage(driver);
		Assert.assertEquals(fp.getallCourses().size(), 10);
		Log.info("All coureses is displayed");
	}

	@AfterTest // Close page

	public void teardown() {
		driver.close();
		driver = null;
		Log.info("Browser is closed");

	}

}
