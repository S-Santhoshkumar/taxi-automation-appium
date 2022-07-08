package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.pages.keys.RideLaterKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;

/**
 * RideLaterPage class contains pages for ride later test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RideLaterPage {
	public Logger logger = Logger.getLogger(RideLaterPage.class);
	PropertyParser loadProperty = new PropertyParser();
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
			logger.info("Click on ride later button");
			WebElement rideLaterButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.RIDE_LATER_BUTTON)));
			action.clickButton(rideLaterButton);

			logger.info("Click and enter the pickup location");
			WebElement pickupTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.PICK_UP_TEXT_BOX)));
			action.TextBox(pickupTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.PICK_UP_TEXT));

			logger.info("Click and enter the drop location");
			WebElement dropTextBox = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.DROP_TEXT_BOX)));
			action.TextBox(dropTextBox,
					loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.DROP_TEXT));

			logger.info("Click on date button");
			WebElement dateButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_DATE_BUTTON)));
			action.clickButton(dateButton);

			logger.info("Select the date using Calendar");
			WebElement selectDate = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_DATE)));
			action.clickButton(selectDate);

			logger.info("Click on Ok button");
			WebElement datePageOkButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.DATE_OK_BUTTON)));
			action.clickButton(datePageOkButton);

			logger.info("Click on time button");
			WebElement timeButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_TIME_BUTTON)));
			action.clickButton(timeButton);

			logger.info("Select hours from the clock");
			WebElement selectHours = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_HOUR)));
			action.clickButton(selectHours);

			logger.info("Select minutes from the clock");
			WebElement selectMinutes = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.SELECT_MINUTE)));
			action.clickButton(selectMinutes);

			logger.info("Click on Ok button");
			WebElement timePageOkButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.TIME_OK_BUTTON)));
			action.clickButton(timePageOkButton);

			logger.info("Read and Get the time text");
			WebElement getTimeText = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.GET_TIME)));
			TIME_TEXT = action.Element_text(getTimeText);

			logger.info("Click on Confirm button");
			WebElement confirmButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.CONFIRM_BUTTON)));
			action.clickButton(confirmButton);

			logger.info("Click on Ok Button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Ride is Booked successfully");
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}
}
