package com.taxi_application_automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.pages.keys.LoginLogoutKeys;
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;

/**
 * LoginPage class contains pages for login test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class LoginPage {
	public Logger logger = Logger.getLogger(LoginPage.class);
	PropertyParser loadProperty = new PropertyParser();
	ElementAction action = new ElementAction();

	/**
	 * clickRegisterHereLink method will clicks the register link and redirect it to
	 * the registration page.
	 * 
	 * @param driver
	 * @return true or false
	 */
	public boolean clickRegisterHereLink(AppiumDriver driver) {
		try {

			logger.info("Click on Register Here");
			WebElement newRegistration = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.NEW_REGISTRATION)));
			action.clickButton(newRegistration);
			return true;
		} catch (ElementClickInterceptedException clickInterceptedException) {
			logger.error("Check the link is clickable");
			return false;
		}
	}

	/**
	 * login method will verify that user is able to login or not.
	 * 
	 * @param driver
	 * @return true or false
	 */
	public boolean login(AppiumDriver driver) {
		try {
			logger.info("Enter the Mobile number");
			WebElement loginMobileNumber = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_MOBILE_NUMBER)));

			action.TextBox(loginMobileNumber,
					loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.MOBILE_NUMBER_TEXT));

			logger.info("Enter the Password");
			WebElement loginPassword = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_PASSWORD)));
			action.TextBox(loginPassword,
					loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.PASSWORD_TEXT));

			logger.info("Click on Login button");
			WebElement loginButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_BUTTON)));
			action.clickButton(loginButton);

			WebElement text = driver.findElement(By.xpath("com.atmecs.taxi:id/alertTitle"));
			action.isElementPresent(text);
			logger.info("! Log in Failed !");
			return false;

		} catch (Exception exception) {
			logger.info(" Logged In Successfully ");
			return true;
		}
	}
}
