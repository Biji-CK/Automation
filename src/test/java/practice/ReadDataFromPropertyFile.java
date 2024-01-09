package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		
		//1.OPEN THE DOCUMENT IN JAVA READABLE FORMAT
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//2.CREATE OBJECT OF PROPERTIES CLASS FROM JAVA.UTIL
		Properties p=new Properties();
		
		//3.LOAD THE FILE INPUT STREAM TO PROPERTIES FILE
		p.load(fis);
		
		//4.PROVIDE KEY AND READ THE VALUE
		String value=p.getProperty("username");
		System.out.println(value);
		
		

	}

}
