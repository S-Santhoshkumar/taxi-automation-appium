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
import com.taxi_application_automation.messages.VerifyMessages;
import com.taxi_application_automation.pages.keys.ChangePasswordKeys;
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.LoginLogoutKeys;
import com.taxi_application_automation.utility.PropertyParsers;
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
	PropertyParsers loadProperty = new PropertyParsers();
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

			logger.info(InfoMessages.ENTER_CONFIRM_PASSWORD_MESSAGE);
			WebElement reEnterPasswordTextBox = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.REENTER_TEXT_BOX)));
			action.TextBox(reEnterPasswordTextBox,
					loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS, ChangePasswordKeys.REENTER_TEXT));

			logger.info(InfoMessages.CLICK_CHANGE_MESSAGE);
			WebElement changeButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.CHANGE_BUTTON)));
			action.clickButton(changeButton);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement passwordOkButton = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.PASSWORD_OK_BUTTON)));
			action.clickButton(passwordOkButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			logger.info(InfoMessages.CLICK_BACK_MESSAGE);
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
			Thread.sleep(2000);
		} catch (InterruptedException exception) {
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
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
				logger.info(InfoMessages.ENTER_MOBILE_NUMBER_MESSAGE);
				WebElement loginMobileNumber = driver.findElement(By
						.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_MOBILE_NUMBER)));
				action.TextBox(loginMobileNumber,
						loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.MOBILE_NUMBER_TEXT));

				logger.info(InfoMessages.ENTER_NEW_PASSWORD_MESSAGE);
				WebElement loginPassword = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_PASSWORD)));
				action.TextBox(loginPassword, loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD_DETAILS,
						ChangePasswordKeys.RESET_PASSWORD_TEXT));

				logger.info(InfoMessages.CLICK_LOGIN_MESSAGE);
				WebElement loginButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.LOGIN_PATH, LoginLogoutKeys.LOGIN_BUTTON)));
				action.clickButton(loginButton);

				logger.info(InfoMessages.HOME_PAGE_ENTERED_MESSAGE);
				WebElement homePage = driver.findElement(By
						.xpath(loadProperty.getValue(FilePathConstants.CHANGE_PASSWORD, ChangePasswordKeys.HOME_PAGE)));
				Boolean isDisplayed = action.isElementPresent(homePage);

				logger.info(VerifyMessages.VERIFY_HOMEPAGE_MESSAGE);

				verify.verifyBoolean(isDisplayed, homePage.isDisplayed(), "Verify Home page is Displayed : ");
				logger.info(InfoMessages.PASSWORD_CHANGED_SUCCESSSFUL_MESSAGE);

			} catch (NoSuchElementException noSuchElementException) {
				logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
			} catch (NullPointerException nullPointerException) {
				logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
			} catch (StaleElementReferenceException referenceException) {
				logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
			}
		} catch (Exception exception) {
			logger.error(ErrorMessages.PASSWORD_NOT_CHANGED_MESSAGE);
		}
	}
}
