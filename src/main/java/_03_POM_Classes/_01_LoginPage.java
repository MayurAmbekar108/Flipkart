package _03_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import _02_GlobalUtils.Globalutil;

public class _01_LoginPage 
{

	WebDriver driver;
	Globalutil global = new Globalutil();

	// Email or Phone Number manually
	@FindBy(xpath = "(//input[@type='text'])[2]") 
	private WebElement email; //:r0:
	
	public void sendEmail() 
	{
		global.sendEmail(email);
	} 
	
	//Request to send OTP
	@FindBy(xpath = "(//button)[2]")  
	private WebElement requestOtp;

	public void clickOnRequestOtp() 
	{
		global.clickOnRequestOtp(requestOtp);
	}


	// Click on Verify button
	@FindBy(xpath = "(//button[@type='submit'])[2]")  
	private WebElement verrifyButton;

	public void clickOnVerifyButton () 
	{
		global.clickOnVerifyButton(verrifyButton);
	}
	

	public _01_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
}
