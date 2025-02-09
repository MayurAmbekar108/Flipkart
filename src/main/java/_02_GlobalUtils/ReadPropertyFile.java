package _02_GlobalUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		FileReader fr = new FileReader(
				"C:\\Users\\ASZ\\eclipse-workspace\\Automation_Testing1\\src\\test\\resources\\configfiles\\config.properties");

		Properties p = new Properties();
		p.load(fr);
		
		System.out.println("browser");
		System.out.println("testurl");

	}

	public String getBrowser() {
		Properties p = new Properties();
		return p.getProperty("browser");
	}

	public String getUrl() {
		Properties p = new Properties();
		return p.getProperty("baseUrlLogin");
	}

}
