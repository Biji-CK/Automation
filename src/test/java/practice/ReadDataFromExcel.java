package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//STEP1: OPEN THE DOCUMENT IN JAVA READABLE FORMAT
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//STEP2:CREATE A WORKBOOK
		Workbook wb=WorkbookFactory.create(fis);
		//STEP3:NAVIGATE TO REQUIRED SHEET
		Sheet sh=wb.getSheet("Contacts");
		//STEP4:NAVIGATE TO REQUIRED ROW
		Row rw= sh.getRow(1);
		//STEP 5:NAVIGATE TO REQUIRED CELL
		Cell cl=rw.getCell(2);
		//STEP 6:CAPTURE THE DATA INSIDE THE CELL
		String value=cl.getStringCellValue();
		System.out.println(value);
		//STEP 7:CLOSE THE WORKBOOK
		wb.close();
	}

}
