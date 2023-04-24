package Broken_Links;

import org.openqa.selenium.support.PageFactory;

import Base_Package.Base_Class;

public class Check_Link extends Base_Class {
	
	
	
	public Check_Link() {
		PageFactory.initElements(driver, this);
	}
	
	public void CheckNumber(String Page_Name, String Links) {
		
		driver.get(Links);
		
	}
	
	

}
