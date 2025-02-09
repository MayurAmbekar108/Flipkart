package _02_GlobalUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Office365MailReader {
    private WebDriver driver;

//    public Office365MailReader(String driverPath)
//    {
//    	WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		System.out.println("Chrome browser launched");
////        System.setProperty("webdriver.chrome.driver", driverPath);
////        this.driver = new ChromeDriver();
//    }

//    public void loginToOffice365Mail(String username, String password) {
//        driver.get("https://outlook.office.com/mail/");
//        WebElement usernameField = driver.findElement(By.id("i0116"));
//        usernameField.sendKeys(username);
//        usernameField.submit();
//        
//        WebElement nextButton = driver.findElement(By.id("idSIButton9"));
//        nextButton.click();
//        nextButton.submit();
//
//        WebElement passwordField = driver.findElement(By.id("i0118"));
//        passwordField.sendKeys(password);
//        passwordField.submit();
//        
//        WebElement signInButton = driver.findElement(By.id("idSIButton9"));
//        signInButton.sendKeys(password);
//        signInButton.submit();
//    }

    public void navigateToInbox() {
        driver.get("https://outlook.office365.com/mail/inbox");
    }

    public String readOTPFromEmail(String cssSelector) {
        WebElement email = driver.findElement(By.cssSelector(cssSelector));
        String emailText = email.getText();
        return extractOTP(emailText);  // Implement this method based on your OTP format
    }

    public void close() {
        driver.quit();
    }

    private String extractOTP(String emailText) {
        // Implement this method based on your OTP format
        // For example, if the OTP is a 6-digit number at the end of the email:
        int otpStartIndex = emailText.length() - 6;
        return emailText.substring(otpStartIndex);
    }
}