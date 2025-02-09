package _03_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import _02_GlobalUtils.Globalutil;

public class _02_SignupPage {

	WebDriver driver;
	Globalutil global = new Globalutil();

	// First Name
	@FindBy(id = ":R2b1tataf6:")
	private WebElement firstName;

	public void enterFirstName() {
		global.enterFirstName(firstName);
	}

	// Last Name
	@FindBy(id = ":R2d1tataf6:")
	private WebElement lastName;

	public void enterLasttName() {
		global.enterLastName(lastName);
	}

	// Email
	@FindBy(id = ":R4itataf6:")
	private WebElement email;

	public void enterEmail() {
		global.enterEmail(email);
	}

	// Password
	@FindBy(id = "auth-login-v2-password")
	private WebElement password;

	public void enterPassword() {
		global.enterPassword(password);
	}

	// Password view button
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement passwordViewButton;

	public void clickOnPasswordViewButton() {
		global.clickOnSignUpButton(passwordViewButton);
	}

	// Confirm Password
	@FindBy(id = "auth-login-v2-confoirm-password")
	private WebElement confirmPassword;

	public void enterConfirmPassword() {
		global.enterConfirmPassword(confirmPassword);
	}

	// Confirm Password view button
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement confirmPasswordViewButton;

	public void clickOnConfirmPasswordViewButton() {
		global.clickOnConfirmPasswordViewButton(confirmPasswordViewButton);
	}

//	Confirm checkbox
//	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
//	private WebElement confirmCheckbox;
//
//	public void clickOnCheckbox () 
//	{
//		global.clickOnConfirmCheckbox(confirmCheckbox);
//	}
//	

//	SignUp Button
	@FindBy(xpath = "(//button[@type='submit'])")
	private WebElement signUpButton;

	public void clickOnSignUpButton() {
		global.clickOnSignUpButton(signUpButton);
	}

	public _02_SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
