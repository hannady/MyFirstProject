package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
public WebDriver driver; 

public CoursePage(WebDriver driver) {//Konstruktor
	this.driver=driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}

@FindBy(xpath="//div[@class='container-fluid']//h2//span[1]")
private WebElement validateText; 


public WebElement getValidateText() {
	
	return validateText;
}
}

