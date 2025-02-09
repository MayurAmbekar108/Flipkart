package _02_GlobalUtils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TakeScreenShot {
	public static String captureSceenShot1(WebDriver driver, String screenshotName) throws IOException, AWTException {
		String date = getdatetime();

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath = new File("src/../Screenshot/DCP- " + date + ".png");
		String absolutePathLocation = destinationFilePath.getAbsolutePath();
		FileUtils.copyFile(srcFile, destinationFilePath);

		return absolutePathLocation;   
		 
	}
 
	public static String getdatetime() {
		Date currentdate = new Date(); 
		DateFormat d1 = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
		String date = d1.format(currentdate);
		return date;
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

	}

}
