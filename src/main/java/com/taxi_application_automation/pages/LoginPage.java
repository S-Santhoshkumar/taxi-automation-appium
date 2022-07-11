package com.taxi_application_automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.keys.LoginLogoutKeys;
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParsers;

import io.appium.java_client.AppiumDriver;

/**
 * LoginPage class contains pages for login test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class LoginPage {
	public Logger logger = Logger.getLogger(LoginPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
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

			logger.info(InfoMessages.CLICK_REGITERHERE_LINK_MESSAGE);
			WebElement newRegistration = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.NEW_REGISTRATION)));
			action.clickButton(newRegistration);
			return true;
		} catch (ElementClickInterceptedException clickInterceptedException) {
			logger.error(ErrorMessages.ELEMENT_CLICKABLE_MESSAGE);
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
			logger.info(InfoMessages.ENTER_MOBILE_NUMBER_MESSAGE);
			WebElement loginMobileNumber = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_MOBILE_NUMBER)));

			action.TextBox(loginMobileNumber,
					loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.MOBILE_NUMBER_TEXT));

			logger.info(InfoMessages.ENTER_PASSWORD_MESSAGE);
			WebElement loginPassword = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_PASSWORD)));
			action.TextBox(loginPassword,
					loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.PASSWORD_TEXT));

			logger.info(InfoMessages.CLICK_LOGIN_MESSAGE);
			WebElement loginButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_BUTTON)));
			action.clickButton(loginButton);

			WebElement text = driver.findElement(By.xpath("com.atmecs.taxi:id/alertTitle"));
			action.isElementPresent(text);
			logger.error(ErrorMessages.LOGIN_FAILED_MESSAGE);
			return false;

		} catch (Exception exception) {
			logger.info(InfoMessages.LOGIN_SUCCESSFUL_MESSAGE);
			return true;
		}
	}
}
