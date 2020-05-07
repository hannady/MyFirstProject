package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class portalHomePage {
	public WebDriver driver;
	public portalHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//*[@id=\'search-courses\']")
	private WebElement searchField;
	
	public WebElement getSearchField() {
		
		return searchField;
	}

}
