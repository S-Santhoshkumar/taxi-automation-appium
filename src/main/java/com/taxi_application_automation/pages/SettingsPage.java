package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.pages.keys.ChangePasswordKeys;
import com.taxi_application_automation.pages.keys.DeleteAccountKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;

/**
 * SettingsPage class contains pages for available options in settings
 * 
 * @author Santhoshkumar.S
 *
 */

public class SettingsPage {
	public Logger logger = Logger.getLogger(SettingsPage.class);
	PropertyParser loadProperty = new PropertyParser();
	ElementAction action = new ElementAction();

	/**
	 * clickChangePassword method checks that user able to click change password.
	 * 
	 * @param driver
	 */
	public void clickChangePassword(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info("Click on Change Password");
			WebElement changePasswordButton = driver.findElement(By.xpath(loadProperty
					.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.CHANGE_PASSWORD_BUTTON)));
			action.clickButton(changePasswordButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("Click on Delete My Account");
			WebElement deleteButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.DELETE_PATH, DeleteAccountKeys.DELETE_BUTTON)));
			action.clickButton(deleteButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}
}
