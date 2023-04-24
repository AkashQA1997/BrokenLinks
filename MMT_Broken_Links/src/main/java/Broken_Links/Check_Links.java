package Broken_Links;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URL;
import java.net.HttpURLConnection;

public class Check_Links {
	
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://magicminds.io/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
	List <WebElement> LinkList= driver.findElements(By.tagName("a"));
	
	System.out.println(LinkList.size());
	
	List<WebElement> Proper_Links = new ArrayList<WebElement>(10000);
		
		for (int i = 0; i<LinkList.size(); i++) {
			if (LinkList.get(i).getAttribute("href") != null) {
				Proper_Links.add(LinkList.get(i));
				//String Links = LinkList.get(i).getAttribute("href");
				//if (Links.contains("tel") ) {
				
				//System.out.println("Links are ---" + Links);
				//}
				
			}
		}
		   
		    
			System.out.println("Proper links size ---  " + Proper_Links.size());
			System.out.println("Total Link Size ---" + LinkList.size());
			

			
			
			for (int i = 0; i<LinkList.size(); i++) {
			
				
				if(LinkList.get(i).getAttribute("href") != null) {
					
				
				String Check_URL = LinkList.get(i).getAttribute("href");
				if(Check_URL.contains("https")){
					
					
					URL url = new URL(Check_URL);


					HttpURLConnection httCon = (HttpURLConnection)url.openConnection();
					httCon.connect();
					int rescode = httCon.getResponseCode();
					String res_message = httCon.getResponseMessage();
					
					
					
					
				
			
				if(rescode>=400) {
				
					System.out.println(Check_URL + "  -  "+ "Link is broken      " + res_message);
				
				} else {
					System.out.println(Check_URL + "  --  " +"Code is wiorking     " + res_message);
				}
				}
				}
				
				
			}
		
	
			
			
			

	

	}
}

