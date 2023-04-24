package Excel_Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_data {

	
	 public static  Object[][] Data(String Sheet_Name) throws IOException  {
		 
	   FileInputStream Excelfile = null;
	try {
		Excelfile = new FileInputStream(".\\src\\main\\resources\\Excel_File\\Test_Links.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	
		XSSFWorkbook workBook = new XSSFWorkbook(Excelfile);
	
	    Sheet sheet = workBook.getSheet(Sheet_Name);
	   
	  
	   Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  
	   for (int i = 0; i < sheet.getLastRowNum(); i++) {
		   
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
			
		}
	    return data;
	    
	   
	   
}
}
