package TestSuite;

import java.io.IOException;

import org.apache.logging.log4j.*;

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
// Test case 1
public class HomePage extends Base {
	public static Logger Log=LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	
	
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavegation(String UserName,String Password) throws IOException, InterruptedException {
		
		// creating object to that class and invoke methods of it
				driver.get(prop.getProperty("url"));
		
		FirstPage fp= new FirstPage(driver);
		fp.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().click();
	
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().click();
		lp.getPassword().sendKeys(Password);
		lp.clickSubmit().click();
		Log.info("Successfully enerned test data");
		
		
	}
	
		

@AfterTest // clouse page 

public void teardown() {
	driver.close();
	driver=null;

}

	
	

		@DataProvider
		public Object[][] getData() {
			//Row stands for how many different data types test should run 
			Object [][] data= new Object[3][2];
			//1row
		   data [0][0]= "ira.maksumic@gmail.com";//first data
		   data [0][1]= "1234567";
		   //2row
		   data [1][0]= "ira.zildzo@gmail.com";//second data
		   data [1][1]= "33234567";
		   //3r0w
		   
		   data [2][0]= "ira.zildzo356@gmail.com";//third data
		   data [2][1]= "332343567";
		  
		  
			
			return data; 
			
		}
		
	
		
		
		
		
	
}

