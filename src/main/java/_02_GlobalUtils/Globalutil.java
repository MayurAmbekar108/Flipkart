package _02_GlobalUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebElement;

public class Globalutil {

	// Login Functionality Enter Email or Phone Number
	public void sendEmail(WebElement email) {
		email.sendKeys("9766990462"); 
	}
	
	// Click on Request OTP button
	public void clickOnRequestOtp(WebElement requestOtp) {
		requestOtp.click();
	}
	
	// Enter OTP manually
	public void sendOtpNumbers(WebElement OtpNumber) {
		OtpNumber.sendKeys("");
	}

	public void clickOnVerifyButton(WebElement verrifyButton) {
		verrifyButton.click();
	}
 
	// SignUp Functionality

	public void enterFirstName(WebElement firstName) {
		firstName.sendKeys();
	}

	public void enterLastName(WebElement lastName) {
		lastName.sendKeys();
	}

	public void enterEmail(WebElement email) {
		email.sendKeys();
	}

	public void enterPassword(WebElement password) {
		password.sendKeys();
	}

	public void clickOnPasswordViewButton(WebElement passwordViewButton) {
		passwordViewButton.click();
	}

	public void enterConfirmPassword(WebElement confirmPassword) {
		confirmPassword.sendKeys();
	}

	public void clickOnConfirmPasswordViewButton(WebElement confirmPasswordViewButton) {
		confirmPasswordViewButton.click();
	}

	public void clickOnConfirmCheckbox(WebElement confirmCheckbox) {
		confirmCheckbox.click();
	}

	public void clickOnSignUpButton(WebElement signUpButton) {
		signUpButton.click();
	}

	public void clickOnSignupInstead(WebElement signupInstead) {
		signupInstead.click();
	}

	// String genearation with length
	public static String generateRandomString(int length) {

		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}

	// Generate Random Number
	public static int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(10000);
	}

	// Generate Random String
	public static String generateRandomString() {
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*()";
		String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
		Random random = new Random();
		char[] password = new char[8];

		password[0] = upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length()));
		password[1] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[2] = numbers.charAt(random.nextInt(numbers.length()));
		password[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));

		for (int i = 4; i < 8; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}

		List<Character> pwdList = Arrays.asList(ArrayUtils.toObject(password));
		Collections.shuffle(pwdList);

		StringBuilder sb = new StringBuilder();
		for (Character ch : pwdList) {
			sb.append(ch);
		}
		return sb.toString();
	}

	// Generate 4 digit number
	public int generateFourDigitNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(9000) + 1000; // This will always result in a 4 digit number
		return randomNumber;
	}

	// Generate 10 digit number
	public long generateTenDigitNumber() {
		Random rand = new Random();
		long randomNumber = (long) (rand.nextDouble() * 9000000000L) + 1000000000L; // This will always result in a 10
																					// digit number
		return randomNumber;
	}

	// Generate 5 digit number
	public int generateFiveDigitNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(90000) + 10000; // This will always result in a 5 digit number
		return randomNumber;
	}

	// Ipv4 geneartion
	public static String generateRandomIpv4() {
		Random random = new Random();
		int first = random.nextInt(256);
		int second = random.nextInt(256);
		int third = random.nextInt(256);
		int fourth = random.nextInt(256);
		return first + "." + second + "." + third + "." + fourth;
	}
	
	public String generateRandomCharacter() {
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    StringBuilder result = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 5; i++) {
	        int index = random.nextInt(characters.length());
	        result.append(characters.charAt(index));
	    }
	    return result.toString();
	}
	
	public String generateRandomNumberWithLength(int length) {
        // Ensure length is positive
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        // Create a Random instance
        Random random = new Random();

        // Generate a random number with the specified length
        StringBuilder randomNumber = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Generate a digit from 0 to 9
            int digit = random.nextInt(10);
            // Append the digit to the random number
            randomNumber.append(digit);
        }

        return randomNumber.toString();
    }


}
