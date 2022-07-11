package com.taxi_application_automation.pages;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.messages.VerifyMessages;
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.RideLaterKeys;
import com.taxi_application_automation.pages.keys.RideNowKeys;
import com.taxi_application_automation.utility.PropertyParsers;
import com.taxi_application_automation.verify.Verify;

import io.appium.java_client.AppiumDriver;

/**
 * YourTripPage class contains pages for your trip verification.
 * 
 * @author Santhoshkumar.S
 *
 */
public class YourTripPage {
	String DATE_TO_FORMAT, DATE_STRING;
	String TRIP_TEXT;
	List<String> RIDE_NOW_TEXT_VERIFY;
	String TRIP_DETAILS_RIDE_LATER;
	List<String> RIDE_LATER_TEXT_VERIFY;
	public Logger logger = Logger.getLogger(YourTripPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();
	Verify verify = new Verify();
	RideLaterPage rideLaterPage = new RideLaterPage();

	/**
	 * rideNowTripDetails method will get the text from the trip details
	 * 
	 * @param driver
	 */
	public void rideNowTripDetails(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.GET_RIDE_NOW_TRIP_DETAILS_MESSAGE);
			WebElement verifytext = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, RideNowKeys.VERIFY_TRIP_BUTTON)));
			TRIP_TEXT = action.Element_text(verifytext);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyfromAndTo method will verify the from and to location
	 * 
	 * @param driver
	 */
	public void verifyfromAndTo(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info(VerifyMessages.VERIFY_FROM_AND_TO_MATCHING_MESSAGE);
		RIDE_NOW_TEXT_VERIFY = new ArrayList<String>();

		try (Scanner checkText = new Scanner(TRIP_TEXT)) {
			while (checkText.hasNextLine()) {
				String ecahLineCheck = checkText.nextLine();
				RIDE_NOW_TEXT_VERIFY.add(ecahLineCheck);
			}
		}
		String fromToString = RIDE_NOW_TEXT_VERIFY.get(0); // getting the first index in the trip details page.

		String[] splitFromToWords = fromToString.split("\\s"); // split the words in the from and To

		String fromText = splitFromToWords[0];

		String toText = splitFromToWords[2];

		logger.info(VerifyMessages.VERIFY_FROM_LOCATION_MESSAGE);
		verify.verifyString(fromText,
				loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.PICK_UP_TEXT),
				"Verify From text : ");

		logger.info(VerifyMessages.VERIFY_TO_LOCATION_MESSAGE);
		verify.verifyString(toText, loadProperty.getValue(FilePathConstants.RIDE_NOW_DETAILS, RideNowKeys.DROP_TEXT),
				"Verify To text : ");
	}

	/**
	 * verifyRideNowTripTime will verify the trip time.
	 * 
	 * @param driver
	 */
	public void verifyRideNowTripTime(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info(VerifyMessages.VERIFY_TIME_MESSAGE);
		String timeString = RIDE_NOW_TEXT_VERIFY.get(1);
		String[] strArray = timeString.split(",");
		String time = strArray[1].toString().trim();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		Date dates = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
		DATE_TO_FORMAT = dateFormat.format(dates);
		DATE_STRING = String.valueOf(DATE_TO_FORMAT);

		String[] systemTime = DATE_STRING.split(",");
		String systemtimeString = systemTime[1].toString().trim();

		logger.info(VerifyMessages.VERIFY_ARRIVAL_TIME_MESSAGE);
		verify.verifyString(systemtimeString, time, "Verify time : ");
	}

	/**
	 * verifyRideNowTripStatus verify the trip status
	 * 
	 * @param driver
	 */
	public void verifyRideNowTripStatus(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String tripStatus = RIDE_NOW_TEXT_VERIFY.get(4);
		String[] splitStatus = tripStatus.split("\\s");
		String status = splitStatus[1];

		logger.info(VerifyMessages.VERIFY_TRIP_STATUS_MESSAGE);
		verify.verifyString(status, "Upcoming", "Verify Status : ");

		logger.info(InfoMessages.CLICK_BACK_MESSAGE);
		WebElement backButton = driver
				.findElement(By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
		action.clickButton(backButton);
	}

	/**
	 * rideLaterTripDetails will get the ride later trip details
	 * 
	 * @param driver
	 */
	public void rideLaterTripDetails(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info(InfoMessages.GET_RIDELATER_TRIP_DETAILS_MESSAGE);
		WebElement tripDetails = driver.findElement(
				By.xpath(loadProperty.getValue(FilePathConstants.RIDE_LATER_PATH, RideLaterKeys.TRIP_DETAILS)));
		TRIP_DETAILS_RIDE_LATER = action.Element_text(tripDetails);

	}

	/**
	 * verifyfromAndTo method will verify the from and to location
	 * 
	 * @param driver
	 */
	public void verifyFromAndToLocation(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info(VerifyMessages.VERIFY_FROM_AND_TO_MATCHING_MESSAGE);
		RIDE_LATER_TEXT_VERIFY = new ArrayList<String>();
		try (Scanner textCheck = new Scanner(TRIP_DETAILS_RIDE_LATER)) {
			while (textCheck.hasNextLine()) {
				String ecahLineCheck = textCheck.nextLine();
				RIDE_LATER_TEXT_VERIFY.add(ecahLineCheck);
			}
		}
		String fromToString = RIDE_LATER_TEXT_VERIFY.get(0); // getting the first index in the trip details page.

		String[] splitFromToWords = fromToString.split("\\s"); // split the words in the from and To

		String fromText = splitFromToWords[0];
		String toText = splitFromToWords[2];

		logger.info(VerifyMessages.VERIFY_FROM_LOCATION_MESSAGE);
		verify.verifyString(fromText,
				loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.PICK_UP_TEXT),
				"Verifying From text");

		logger.info(VerifyMessages.VERIFY_TO_LOCATION_MESSAGE);
		verify.verifyString(toText,
				loadProperty.getValue(FilePathConstants.RIDE_LATER_DETAILS, RideLaterKeys.DROP_TEXT),
				"Verifying To text : ");
	}

	/**
	 * verifyRideNowTripTime will verify the trip time.
	 * 
	 * @param driver
	 */
	public void verifyRideLaterTripTime(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String time = rideLaterPage.TIME_TEXT;
		String timeString = RIDE_LATER_TEXT_VERIFY.get(1);
		String[] strArray = timeString.split(",");
		String systemTime = strArray[1].toString().trim();
		logger.info(systemTime);

		logger.info(VerifyMessages.VERIFY_TIME_MESSAGE);
		verify.verifyString(systemTime, time, "Time Verification : 	");

	}

	/**
	 * verifyRideNowTripStatus verify the trip status
	 * 
	 * @param driver
	 */
	public void verifyRideLaterTripStatus(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String statusText = RIDE_LATER_TEXT_VERIFY.get(4);

		String[] splitStatus = statusText.split("\\s");

		String status = splitStatus[1];

		logger.info(VerifyMessages.VERIFY_TRIP_STATUS_MESSAGE);
		verify.verifyString(status, "Upcoming", "Verify Status");

		logger.info(InfoMessages.CLICK_BACK_MESSAGE);
		WebElement backButton = driver
				.findElement(By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
		action.clickButton(backButton);
	}

	/**
	 * verifyDriverDetails method verifies the driver details when user books the
	 * ride trip.
	 */
	public void verifyDriverDetails(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Map<String, String> name = new TreeMap<String, String>();
		name.put("FIRST_TRIP_DETAILS", RideNowKeys.FIRST_TRIP_DETAILS);
		name.put("SECOND_TRIP_DETAILS", RideNowKeys.SECOND_TRIP_DETAILS);
		name.put("THIRD_TRIP_DETAILS", RideNowKeys.THIRD_TRIP_DETAILS);
		name.put("FOURTH_TRIP_DETAILS", RideNowKeys.FOURTH_TRIP_DETAILS);
		name.put("FIFTH_TRIP_DETAILS", RideNowKeys.FIFTH_TRIP_DETAILS);

		List<String> driverList = new ArrayList<String>();
		for (String data : name.values()) {
			WebElement TripDetails = driver
					.findElement(By.xpath(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, data)));
			String TripText = action.Element_text(TripDetails);
			List<String> textVerification = new ArrayList<String>();
			try (Scanner textCheck = new Scanner(TripText)) {
				while (textCheck.hasNextLine()) {
					String ecahLineCheck = textCheck.nextLine();
					textVerification.add(ecahLineCheck);
				}
			}

			String fromToString = textVerification.get(2);
			driverList.add(fromToString);
		}
		for (String driverName : driverList) {
			logger.info(InfoMessages.DISPLAY_DRIVER_LIST_MESSAGE + driverName);
		}

		String originalDriverString = String.valueOf(driverList.size());
		Set<String> removeDuplicate = new HashSet<String>();

		for (String duplicates : driverList) {
			removeDuplicate.add(duplicates);
		}
		logger.info(InfoMessages.DISPLAY_REPEATED_NAMES_MESSAGE + removeDuplicate);

		String removingDuplicateString = String.valueOf(removeDuplicate.size());

		logger.info(VerifyMessages.VERIFY_NAME_DIFFERENT_MESSAGE);

		verify.verifyBoolean(originalDriverString, removingDuplicateString, true);

		logger.info(InfoMessages.CLICK_BACK_MESSAGE);
		WebElement backButton = driver
				.findElement(By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
		action.clickButton(backButton);
	}
}
