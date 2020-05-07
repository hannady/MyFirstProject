package resources;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public  WebDriver driver;
	public Properties prop;
	public ChromeOptions options;

	// method
	public WebDriver initializeDriver() throws IOException {

// koji browser ce se koristiti (chrome, firefox ili IE )kreiramo Properties File

		prop = new Properties();

		// System.getProperty("user.dir")

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// mvn test -Dbrowser=chrome
		String browserName = System.getProperty("browser");

		// String browserName = prop.getProperty("browser");
		// String urlName=prop.getProperty("url");

		// CHROME BROWSER
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\iram\\Desktop\\SELENIUM\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

			//options = new ChromeOptions();
			//options.addArguments("headless");
			//driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			// driver.get(urlName);
			// Execute in CHROME browser
		} else if (browserName.equals("fireforx")) {

			// execute in FIREFOX
		} else if (browserName.equals("internetExplorer")) {

			// EXECUTE in IE
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy");
		FileUtils.copyFile(src, new File("C:\\Users\\iram\\screenshot.png\\" + result +" "+formater.format(calendar.getTime())+ " " + ".png"));
		
	}
	
	

	
	

}
