package _02_GlobalUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata 
{	
	@DataProvider(name = "logindata-Valid")
	public Object[][] getLoginDataValid(Method m) throws EncryptedDocumentException, IOException {
	    return getData(m, "Valid_UserLogin");
	}

	@DataProvider(name = "Logindata-Invalid")
	public Object[][] getSignUpDataInvalid (Method m) throws EncryptedDocumentException, IOException {
	    return getData(m, "Invalid_UserLogin");
	}
	 
	
	public Object [][] getData(Method m,String sheetName ) throws EncryptedDocumentException, IOException 
	{
		String excelSheetName = sheetName;
 
        System.out.println(sheetName);

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName1 = wb.getSheet(sheetName);

		int totalRows = sheetName1.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName1.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format = new DataFormatter();

		String testData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName1.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}

		return testData;
		
//		 return new Object [][] {
//		        // valid credentials
//		        {"validUser", "validPassword", true},
//		        // invalid credentials
//		        {"invalidUser", "invalidPassword", false}
//		    };

	}

}


