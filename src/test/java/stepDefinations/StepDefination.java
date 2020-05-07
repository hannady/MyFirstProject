package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.FirstPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.Base;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	public FirstPage fp; 

	@Given("^Initialize the browser$")
	public void initialize_the_browser() throws Throwable {
		driver = initializeDriver();

	}

	@When("^User enters (.+) and (.+)$")
	public void user_enters_and(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().click();

		lp.getEmail().sendKeys(username);
		lp.getPassword().click();
		lp.getPassword().sendKeys(password);
		lp.clickSubmit().click();
	}

	@Then("^User is successfully logged in$")
	public void user_is_successfully_logged_in() throws Throwable {
		portalHomePage ph = new portalHomePage(driver);
		Assert.assertTrue(ph.getSearchField().isDisplayed());
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^Click on Login$")
	public void click_on_login() throws Throwable {
		 fp = new FirstPage(driver);
		/*
		 * if(fp.getPopupSize().size()>0) { fp.getPopUp().click(); }
		 */
		fp.getLogin().click();
	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
		driver=null;
	}
	 @And("^Validate first title message$")
	    public void validate_first_title_message() throws Throwable {
		  fp = new FirstPage(driver);
		 String headerText=fp.getHeder().getText();
		Assert.assertEquals(headerText, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	    }

	    @And("^Validate second title message$")
	    public void validate_second_title_message() throws Throwable {
	    	  fp = new FirstPage(driver);
	    	String headerText=fp.getHeder().getText();
			Assert.assertEquals(headerText, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
			
	    }

	    @And("^Validate second email$")
	    public void validate_second_email() throws Throwable {
	    	 fp= new FirstPage(driver);
			 boolean emailIsDisplayed=fp.getEmail().isDisplayed();
			 if(emailIsDisplayed==true) {
				 String emailAdresse=fp.getEmail().getText();
			Assert.assertEquals(emailAdresse, "info@qaclickacademy.com"); 
			 }
	    }

	    @And("^Validate phoneNumber$")
	    public void validate_phonenumber() throws Throwable {
	    	 fp= new FirstPage(driver);
	         boolean numberisDispalyed=fp.getPhonenNumber().isDisplayed();
	    		if(	numberisDispalyed==true) {
	    			String phoneNumber= fp.getPhonenNumber().getText();
	    			Assert.assertEquals(phoneNumber, "(+1) 323-744-6780");
	    		}
	    }

	 

}