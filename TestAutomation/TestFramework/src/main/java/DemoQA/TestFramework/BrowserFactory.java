package DemoQA.TestFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory 
{
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public static WebDriver getDriver(String browserName)
	{
		WebDriver driver = null;
		
		switch(browserName.toLowerCase()){
		case "firefox":
			driver = drivers.get("firefox");
			if(driver == null){
				driver = new FirefoxDriver();
				drivers.put("firefox", driver);
				break;
			}
			
		case "chrome":
			driver = drivers.get("chrome");
			if(driver == null){
				driver = new ChromeDriver();
				drivers.put("chrome", driver);
				break;
			}
			
		case "safari":
			driver = drivers.get("safari");
			if(driver == null){
				driver = new SafariDriver();
				drivers.put("safari", driver);
				break;
			}
			
		case "phantomjs":
			driver = drivers.get("phantomjs");
			if(driver == null){
				driver = new PhantomJSDriver();
				drivers.put("phantomjs", driver);
				break;
			}
		default:
			driver = drivers.get("firefox");
			if(driver == null){
				driver = new FirefoxDriver();
				drivers.put("firefox", driver);
				break;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void main(String args[]){
		System.out.println(drivers);
		WebDriver d = getDriver("firefox");
		System.out.println(drivers);
	}
	
}
