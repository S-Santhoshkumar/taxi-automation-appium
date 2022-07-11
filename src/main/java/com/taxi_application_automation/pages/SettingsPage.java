package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.keys.ChangePasswordKeys;
import com.taxi_application_automation.pages.keys.DeleteAccountKeys;
import com.taxi_application_automation.utility.PropertyParsers;

import io.appium.java_client.AppiumDriver;

/**
 * SettingsPage class contains pages for available options in settings
 * 
 * @author Santhoshkumar.S
 *
 */

public class SettingsPage {
	public Logger logger = Logger.getLogger(SettingsPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();

	/**
	 * clickChangePassword method checks that user able to click change password.
	 * 
	 * @param driver
	 */
	public void clickChangePassword(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.CLICK_CHANGE_PASSWORD_MESSAGE);
			WebElement changePasswordButton = driver.findElement(By.xpath(loadProperty
					.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.CHANGE_PASSWORD_BUTTON)));
			action.clickButton(changePasswordButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * clickDeleteMyAccount method checks that user able to click delete my account.
	 * 
	 * @param driver
	 */
	public void clickDeleteMyAccount(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.CLICK_DELETE_ACCOUNT_MESSAGE);
			WebElement deleteButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.DELETE_PATH, DeleteAccountKeys.DELETE_BUTTON)));
			action.clickButton(deleteButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}
}
