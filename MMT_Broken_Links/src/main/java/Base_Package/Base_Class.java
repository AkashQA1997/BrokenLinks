package Base_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;


public class Base_Class {
	
	
	public WebDriver driver;
	
	public void Intialization(String Browser, String links) throws Throwable {
		
	

		
		        if (Browser.equalsIgnoreCase("Chrome")) {
			       ChromeOptions options = new ChromeOptions();
			       options.addArguments("--remote-allow-origins=*");
			        WebDriverManager.chromedriver().setup();
			        driver = new ChromeDriver(options);
			        driver.manage().window().maximize();
			        driver.manage().deleteAllCookies();
			        driver.get(links);
			        Thread.sleep(3000);
		}else
			    if (Browser.equalsIgnoreCase("Edge")) {
			    	EdgeOptions options = new EdgeOptions();
				    options.addArguments("--remote-allow-origins=*");
				    WebDriverManager.edgedriver().setup();
				    driver = new EdgeDriver(options);
				    driver.manage().window().maximize();
				    driver.manage().deleteAllCookies();
				    driver.get(links);
				    Thread.sleep(3000);
				
		}else
				if (Browser.equalsIgnoreCase("Firefox")) {
					
					
					FirefoxOptions options = new FirefoxOptions();
				    options.addArguments("--remote-allow-origins=*");
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(options);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.get(links);
					Thread.sleep(3000);
		}
		
		
		
	}
	
	
	

}
