package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hompage {
	public  WebDriver driver; 
	
	//Hompage qaclicacdemy
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement login; 
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Courses')]")
	private WebElement coursesButtion;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	private WebElement title; 
	
	@FindBy(xpath="//*[@id='homepage']/header/div[2]/div/nav/ul/li")
	private WebElement navigatorBar;
	
	
	@FindBy(xpath="//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3")
	private WebElement heder;
	
	@FindBy(xpath="//body[@id='homepage']/section[1]/div[1]/ul[1]/li")
	private List<WebElement> allcourses;
	@FindBy(xpath="//ul[@class='pull-left']//li[2]/a/span")
	private WebElement email;
	@FindBy (xpath="//ul[@class='pull-left']//li[1]/a/span")
	private WebElement phoneNumber; 
	@FindBy(xpath="//p[contains(text(),'Join Our Newsletter')]")
	private WebElement newsletter;
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	private WebElement buttonNoThanx;
	
	
	public Hompage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getLogin() {
		
		return login;

}
	public WebElement getCoursesButton() {
		return coursesButtion;
	}
	public WebElement getTitle() {
		
		return title; 
	}
	

	public WebElement getnavigateBar() {
		
		return navigatorBar; 
	}
	
	public WebElement getHeder() {
		
		return heder;
	}
	
	public List<WebElement> getallCourses() {
		
		return  allcourses;
	}
	public WebElement getEmail() {
		
		return email; 
	}
	


	public WebElement getPhonenNumber() {
		
		return phoneNumber;
	}
	public WebElement getnewsletter() {
		
		return  newsletter;
	}
	public WebElement getbuttonNoThenks() {
		return  buttonNoThanx;
	}
	
}