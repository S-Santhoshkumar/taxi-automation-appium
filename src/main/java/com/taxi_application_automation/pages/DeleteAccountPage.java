package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.keys.DeleteAccountKeys;
import com.taxi_application_automation.utility.PropertyParsers;

import io.appium.java_client.AppiumDriver;

/**
 * DeleteAccountPage class contains pages for delete account test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class DeleteAccountPage {
	public Logger logger = Logger.getLogger(DeleteAccountPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();

	/**
	 * deleteAccount method will delete the account performed by the user.
	 * 
	 * @param driver
	 */
	public void deleteAccount(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement deleteOkButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.DELETE_PATH, DeleteAccountKeys.DELETE_OK_BUTTON)));
			action.clickButton(deleteOkButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * deleteAccountVerify method verifies that the account is deleted or not.
	 * 
	 * @param driver
	 * @return true or false
	 */
	public boolean deleteAccountVerify(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.HOME_PAGE_ENTERED_MESSAGE);
			logger.info(InfoMessages.ACCOUNT_NOT_DELETED_MESSAGE);
			WebElement homePage = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.DELETE_PATH, DeleteAccountKeys.HOME_PAGE)));

			Assert.assertEquals(homePage.isDisplayed(), false);

			return true;
		} catch (Exception exception) {
			logger.error(ErrorMessages.ACCOUNT_DELETED_MESSAGE);
			return false;
		}
	}
}
