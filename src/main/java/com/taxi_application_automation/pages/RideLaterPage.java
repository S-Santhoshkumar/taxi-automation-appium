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
import com.taxi_application_automation.pages.keys.RideLaterKeys;
import com.taxi_application_automation.utility.PropertyParsers;

import io.appium.java_client.AppiumDriver;

/**
 * RideLaterPage class contains pages for ride later test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RideLaterPage {
	public Logger logger = Logger.getLogger(RideLaterPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();

	public String TIME_TEXT;

	/**
	 * RideLater method verifies that user able to successfully book ride later
	 * trip.
	 * 
	 * @param driver
	 */
	public void rideLater(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			logger.info(InfoMessages.CLICK_RIDElATER_MESSAGE);
			WebElement rideLaterButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.RIDE_LATER_BUTTON)));
			action.clickButton(rideLaterButton);

			logger.info(InfoMessages.ENTER_PICKUP_LOCATION_MESSAGE);
			WebElement pickupTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.PICK_UP_TEXT_BOX)));
			action.TextBox(pickupTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.PICK_UP_TEXT));

			logger.info(InfoMessages.ENTER_DROP_LOCATION_MESSAGE);
			WebElement dropTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.DROP_TEXT_BOX)));
			action.TextBox(dropTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.DROP_TEXT));

			logger.info(InfoMessages.CLICK_DATE_MESSAGE);
			WebElement dateButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_DATE_BUTTON)));
			action.clickButton(dateButton);

			logger.info(InfoMessages.SELECT_DATE_MESSAGE);
			WebElement selectDate = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_DATE)));
			action.clickButton(selectDate);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement datePageOkButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.DATE_OK_BUTTON)));
			action.clickButton(datePageOkButton);

			logger.info(InfoMessages.CLICK_TIME_MESSAGE);
			WebElement timeButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_TIME_BUTTON)));
			action.clickButton(timeButton);

			logger.info(InfoMessages.SELECT_HOURS_MESSAGE);
			WebElement selectHours = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_HOUR)));
			action.clickButton(selectHours);

			logger.info(InfoMessages.SELECT_MINUTE_MESSAGE);
			WebElement selectMinutes = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_MINUTE)));
			action.clickButton(selectMinutes);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement timePageOkButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.TIME_OK_BUTTON)));
			action.clickButton(timePageOkButton);

			logger.info(InfoMessages.GET_TIME_MESSAGE);
			WebElement getTimeText = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.GET_TIME)));
			TIME_TEXT = action.Element_text(getTimeText);

			logger.info(InfoMessages.CLICK_CONFIRM_MESSAGE);
			WebElement confirmButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.CONFIRM_BUTTON)));
			action.clickButton(confirmButton);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.RIDE_LATER_SUCCESSFUL_MESSAGE);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}
}
