package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import utility.TimeUtils;

public class BaseAmazonClass {
	
	public static Properties prop  = new Properties();
	public static WebDriver driver;
	
	//Constructor
	public BaseAmazonClass()
	{
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Selvaraha\\eclipse-workspace\\AmazonAutomation\\src\\test\\java\\environmentvariables\\Config.properties");
			prop.load(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
		
	public static void initiate() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
}
