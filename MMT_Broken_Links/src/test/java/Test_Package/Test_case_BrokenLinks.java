package Test_Package;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.net.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base_Package.Base_Class;
import Broken_Links.Check_Link;
import Excel_Data.Excel_data;

public class Test_case_BrokenLinks extends Base_Class {
	


	
	
	@DataProvider (name = "Links")
	public Object [][] Links() throws Throwable{
		
		Object  data [][] = Excel_data.Data("Link");
		return data;
		
	}
	
	
	
@Test (priority = 1 ,dataProvider = "Links", description = "To test the correct links Number")
	
	public void Test_link_Number_check(String Page_Name, String Links, String Browser) throws Throwable {
		Intialization(Browser, Links);
		//LinkClass.CheckNumber(Page_Name, Links);
		System.out.println(Links);
		List<WebElement> LinkList1  = driver.findElements(By.tagName("a"));
		Thread.sleep(2000);
		LinkList1.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> Actual_Link = new ArrayList<WebElement>();
	    for(int i = 0; i<LinkList1.size();i++) {
			if(LinkList1.get(i).getAttribute("href") != null) {
			Actual_Link.add(LinkList1.get(i));
			
			}
			Thread.sleep(2000);
			
			
		}
		
		
		System.out.println("Total Links are ------  " + LinkList1.size());
		System.out.println("Actual Links are ------  " + Actual_Link.size());
		
	}

	
@Test (priority = 2 ,dataProvider = "Links", description = "To test the correct Image links Number")
	
	public void Test_Image_Number_check(String Page_Name, String Links, String Browser) throws Throwable {
		Intialization(Browser, Links);
		List<WebElement> LinkList2  = driver.findElements(By.tagName("img"));
		Thread.sleep(2000);
		List<WebElement> Actual_ImgLink = new ArrayList<WebElement>();
		for(int i = 0; i<LinkList2.size(); i++) {
			if(LinkList2.get(i).getAttribute("img")!= null) {
				Actual_ImgLink.add(LinkList2.get(i));
				
			}
			Thread.sleep(2000);
		}
		System.out.println("Total Image Links are ------  " + LinkList2.size());
		System.out.println("Actual Image Links are ------  " + Actual_ImgLink.size());
}

@Test (priority = 3 ,dataProvider = "Links", description = "To test the correct Image links Number")

public void Test_href_Number_check(String Page_Name, String Links, String Browser) throws Throwable {
	   Intialization(Browser, Links);
	   List<WebElement> LinkList3  = driver.findElements(By.tagName("href"));
	   Thread.sleep(2000);
	   List<WebElement> Actual_hrefLink = new ArrayList<WebElement>();
	    for(int i = 0; i<LinkList3.size(); i++) {
		   if(LinkList3.get(i).getAttribute("href")!= null) {
			    Actual_hrefLink.add(LinkList3.get(i));
			   
		} 
		   Thread.sleep(2000);
	}
	    
		System.out.println("Total href Links are ------  " + LinkList3.size());
		System.out.println("Actual href Links are ------  " + Actual_hrefLink.size());
}

@Test (priority = 4 ,dataProvider = "Links", description = "To test the correct links Number")

public void Test_link_Responce_check(String Page_Name, String Links, String Browser) throws Throwable {
	Intialization(Browser, Links);
	//LinkClass.CheckNumber(Page_Name, Links);
	
	List<WebElement> LinkList4  = driver.findElements(By.tagName("a"));
	LinkList4.addAll(driver.findElements(By.tagName("img")));
	List<WebElement> Actual_Link4 = new ArrayList<WebElement>();
    for(int i = 0; i<LinkList4.size();i++) {
		if(LinkList4.get(i).getAttribute("href") != null) {
		Actual_Link4.add(LinkList4.get(i));	
		}	
		Thread.sleep(2000);
		
	}
    
    for(int j = 0; j<Actual_Link4.size();j++) 
    {
    	
    	
     if(Actual_Link4.get(j).getAttribute("href")!= null) 
      {
    	 
    	 String Hreflink = Actual_Link4.get(j).getAttribute("href");
    	 Thread.sleep(2000);
    	 if(Hreflink.contains("https")) 
    	 {
    		 
    		 URL httpurl = new URL(Hreflink);
    		 HttpURLConnection http = (HttpURLConnection) httpurl.openConnection();
    		 Thread.sleep(2000);
    		 http.connect();
    		 Thread.sleep(2000);
    		 String responce = http.getResponseMessage();
    		 System.out.println("Link Responce ------>  " + Hreflink + "--->  " + responce );
    		 System.out.println();
    		  
    	  }
    	 
        }
     Thread.sleep(2000);
	
      }
    System.out.println();
    System.out.println();
    System.out.println("The total links Are present ------   " + LinkList4.size());
    System.out.println();
    System.out.println();
    System.out.println("The total links to be checked ------ " + Actual_Link4.size());
    

}


@AfterMethod
public void teardown() {
	
	driver.close();
}


}
