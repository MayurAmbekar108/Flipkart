package _03_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import _02_GlobalUtils.Globalutil;

public class _02_Flipkart_Homepage 
{

	WebDriver driver;
	Globalutil global = new Globalutil();
	
	//After login Hover on Profile 
		@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div") 
		private WebElement Profile;
		
		public void hoverOverProfileAndClick(Actions actions ) throws InterruptedException {
	        // Move the cursor over the Profile element
	        actions.moveToElement(Profile).perform();
	       }
		
		// Click on logout 
		
		@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/ul/a[9]")
		private WebElement LogOut;
		
		public void clickOnlogout()
		{
			LogOut.click();
		}

		
		
		
		
		
		
		
		
		
		
		
		public _02_Flipkart_Homepage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	
}
