package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.keys.ChangePasswordKeys;
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.LoginLogoutKeys;
import com.taxi_application_automation.utility.PropertyParser;
import com.taxi_application_automation.verify.Verify;

import io.appium.java_client.AppiumDriver;

/**
 * ChangePasswordPage class contains the pages for change password verification
 * test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class ChangePasswordPage {
	public Logger logger = Logger.getLogger(ChangePasswordPage.class);
	PropertyParser loadProperty = new PropertyParser();
	ElementAction action = new ElementAction();
	Verify verify = new Verify();

	/**
	 * changePassword method will perform changing the existing password with the
	 * new password.
	 * 
	 * @param driver
	 */
	public void changePassword(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			logger.info(InfoMessages.ENTER_OLD_PASSWORD_MESSAGE);
			WebElement oldPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.OLD_PASSWORD_TEXT_BOX)));
			action.TextBox(oldPasswordTextBox, loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS,
					ChangePasswordKeys.OLD_PASSWOR_TEXT));

			logger.info(InfoMessages.ENTER_NEW_PASSWORD_MESSAGE);
			WebElement newpasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.NEW_PASSWORD_TEXT_BOX)));
			action.TextBox(newpasswordTextBox, loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS,
					ChangePasswordKeys.NEW_PASSWORD_TEXT));

			logger.info("Enter the Password again to confirm");
			WebElement reEnterPasswordTextBox = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.REENTER_TEXT_BOX)));
			action.TextBox(reEnterPasswordTextBox,
					loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS, ChangePasswordKeys.REENTER_TEXT));

			logger.info("Click on Change Button");
			WebElement changeButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.CHANGE_BUTTON)));
			action.clickButton(changeButton);

			logger.info("Click on Ok button");
			WebElement passwordOkButton = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.PASSWORD_OK_BUTTON)));
			action.clickButton(passwordOkButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				logger.info("Check the click menu");
			}
			logger.info("Click on Back button");
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
			Thread.sleep(2000);
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
	 * verifyChangePassword method will verify that the new password is changed by
	 * the user is able to log in to the application.
	 * 
	 * @param driver
	 */
	public void verifyChangePassword(AppiumDriver driver) {
		try {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				logger.info("Enter the mobile number");
				WebElement loginMobileNumber = driver.findElement(By
						.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_MOBILE_NUMBER)));
				action.TextBox(loginMobileNumber,
						loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.MOBILE_NUMBER_TEXT));

				logger.info("Enter the New password");
				WebElement loginPassword = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_PASSWORD)));
				action.TextBox(loginPassword, loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS,
						ChangePasswordKeys.RESET_PASSWORD_TEXT));

				logger.info("Click on login Button");
				WebElement loginButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_BUTTON)));
				action.clickButton(loginButton);

				logger.info("Home Page is entered");
				WebElement homePage = driver.findElement(By
						.xpath(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.HOME_PAGE)));
				Boolean isDisplayed = action.isElementPresent(homePage);

				logger.info("Verify Home is entered");

				verify.verifyBoolean(isDisplayed, homePage.isDisplayed(), "Verify Home page is Displayed : ");
				logger.info("Password Changed successfull!!");

			} catch (NoSuchElementException noSuchElementException) {
				logger.error("Check the webelement is correct");
			} catch (NullPointerException nullPointerException) {
				logger.error("Check the driver is null");
			} catch (StaleElementReferenceException referenceException) {
				logger.error("webpage refreshed");
			}
		} catch (Exception exception) {
			logger.info("Password is not changed");
		}
	}
}
