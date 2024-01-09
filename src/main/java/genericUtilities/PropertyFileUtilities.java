package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtilities 
{
	/**
	 * This method will read data from property file and return value to the caller
	 * @author Biji
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String ReadDataFroPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
