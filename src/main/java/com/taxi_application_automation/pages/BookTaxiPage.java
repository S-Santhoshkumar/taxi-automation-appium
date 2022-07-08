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
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.RideNowKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;

/**
 * BookTaxiPage class contains pages for ride now test
 * 
 * @author Santhoshkumar.S
 *
 */
public class BookTaxiPage {
	public Logger logger = Logger.getLogger(BookTaxiPage.class);
	PropertyParser loadProperty = new PropertyParser();
	ElementAction action = new ElementAction();

	/**
	 * rideNowDetails method verifies that user able to enter the details for book a
	 * ride now.
	 * 
	 * @param driver
	 */
	public void rideNowDetails(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			logger.info(InfoMessages.ENTER_PICKUP_LOCATION_MESSAGE);
			WebElement pickupTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.PICK_UP_TEXT_BOX)));
			action.TextBox(pickupTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.PICK_UP_TEXT));

			logger.info(InfoMessages.ENTER_DROP_LOCATION_MESSAGE);
			WebElement dropTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.DROP_TEXT_BOX)));
			action.TextBox(dropTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.DROP_TEXT));

			logger.info(InfoMessages.RIDE_NOW_CLICK_MESSAGE);
			WebElement rideNowButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.RIDE_NOW_BUTTON)));
			action.clickButton(rideNowButton);

			logger.info(InfoMessages.CLICK_OK_MESSAGE);
			WebElement okButton = driver
					.findElement(By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.RIDE_NOW_SUCCESSFUL_MESSAGE);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * bookRide method verifies that user able to book taxi for five times
	 * 
	 * @param driver
	 */
	public void bookRide(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			for (int index = 1; index <= 5; index++) {
				logger.info("Trip Detail : " + index + ".........");

				logger.info(InfoMessages.ENTER_PICKUP_LOCATION_MESSAGE);
				WebElement pickupTextBox = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.PICK_UP_TEXT_BOX)));
				action.TextBox(pickupTextBox,
						loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.PICK_UP_TEXT));

				logger.info(InfoMessages.ENTER_DROP_LOCATION_MESSAGE);
				WebElement dropTextBox = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.DROP_TEXT_BOX)));
				action.TextBox(dropTextBox,
						loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.DROP_TEXT));

				logger.info(InfoMessages.RIDE_NOW_CLICK_MESSAGE);
				WebElement rideNowButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.RIDE_NOW_BUTTON)));
				action.clickButton(rideNowButton);

				logger.info(InfoMessages.CLICK_OK_MESSAGE);
				WebElement okButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, CommonKeys.OK_BUTTON)));
				action.clickButton(okButton);
				System.out.println();

			}
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

}
