package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.pages.keys.MenuPageKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;

/**
 * MenuPage class contains pages for menu option available in the application.
 * 
 * @author Santhoshkumar.S
 *
 */
public class MenuPage {
	public Logger logger = Logger.getLogger(MenuPage.class);
	PropertyParser loadProperty = new PropertyParser();
	ElementAction action = new ElementAction();

	/**
	 * clickMenu method will perform clicking the menu option.
	 * 
	 * @param driver
	 */
	public void clickMenu(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			Thread.sleep(2000);

			logger.info("Click on the Menu Dashboard");
			WebElement menuSelect = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, MenuPageKeys.MENU_SCROLL_BAR)));
			action.clickButton(menuSelect);
		} catch (InterruptedException exception) {

		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

	/**
	 * clickProfile method checks that user able to click the profile.
	 * 
	 * @param driver
	 */
	public void clickProfile(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			Thread.sleep(2000);

			logger.info("Click on the Profile button");
			WebElement profileButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, MenuPageKeys.PROFILE_BUTTON)));
			action.clickButton(profileButton);
		} catch (InterruptedException exception) {
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

	/**
	 * clickYourTrip method checks that user able to click the your trip.
	 * 
	 * @param driver
	 */
	public void clickYourTrip(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info("Click on the Your Trip button");
			WebElement yourTripButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.RIDE_NOW_PATH, MenuPageKeys.YOUR_TRIP_BUTTON)));
			action.clickButton(yourTripButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

	/**
	 * clickHelp method checks that user able to click the help support.
	 * 
	 * @param driver
	 */
	public void clickHelp(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info("Click on the Help button");
			WebElement helpButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.HELP_PATH, MenuPageKeys.HELP_BUTTON)));
			action.clickButton(helpButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

	/**
	 * clickSettings method checks that user able to click the settings.
	 * 
	 * @param driver
	 */
	public void clickSettings(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info("Click on the Settings button");
			WebElement settingButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.DELETE_PATH, MenuPageKeys.SETTINGS_BUTTON)));
			action.clickButton(settingButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

	/**
	 * clickLogout method checks that user able to logout or not.
	 * 
	 * @param driver
	 * 
	 * @return true or false
	 */
	public boolean clickLogout(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			try {
				logger.info("Click on the Logout button");
				WebElement logout = driver.findElement(
						By.xpath(loadProperty.getValue(FilePathConstants.LOGOUT_PATH, MenuPageKeys.LOGOUT)));
				action.clickButton(logout);
			} catch (NoSuchElementException noSuchElementException) {
				logger.error("Check the webelement is correct");
			} catch (NullPointerException nullPointerException) {
				logger.error("Check the driver is null");
			}
			logger.info("(: User logged Out Successfully (:");

			logger.info("Page returned to Login Page");

			return true;
		} catch (Exception e) {
			logger.info("!Logout Failed!");
			return false;
		}
	}
}
