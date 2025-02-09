package _03_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import _02_GlobalUtils.Globalutil;

public class _01_LoginPage 
{

	WebDriver driver;
	Globalutil global = new Globalutil();

	// Email
	@FindBy(id="email") private WebElement email; //:r0:
	
	public void sendEmail() 
	{
		global.sendEmail(email);
	} 

	// Password
	@FindBy(id = "pass") private WebElement password;

	public void sendPassword() 
	{
		global.sendPassword(password);
	}

	// LogIn button 
	@FindBy(xpath = "(//button[@type='submit'])")  private WebElement LogInButton;

	public void clickOnLogIn () 
	{
		global.clickOnLogIn(LogInButton);
	}

	public _01_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
}
