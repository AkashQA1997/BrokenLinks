package Base_Package;

import java.time.Duration;

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

			        WebDriverManager.chromedriver().setup();
			        driver = new ChromeDriver();
			        driver.manage().window().maximize();
			        driver.manage().deleteAllCookies();
			        driver.get(links);
			        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			        Thread.sleep(1000);
		}else
			    if (Browser.equalsIgnoreCase("Edge")) {
	
				    WebDriverManager.edgedriver().setup();
				    driver = new EdgeDriver();
				    driver.manage().window().maximize();
				    driver.manage().deleteAllCookies();
				    driver.get(links);
			        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				    Thread.sleep(1000);
				
		}else
				if (Browser.equalsIgnoreCase("Firefox")) {
					
					
			
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.get(links);
			        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					Thread.sleep(1000);
		}
		
		
		
	}
	
	
	

}
