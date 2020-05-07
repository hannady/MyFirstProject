package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id= 'user_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id= 'user_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type= 'submit']")
	private WebElement submit;
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmail() {

		return email;

	}

	public WebElement getPassword() {

		return password;
	}

	public WebElement clickSubmit() {
		return submit;

	}
	
}
