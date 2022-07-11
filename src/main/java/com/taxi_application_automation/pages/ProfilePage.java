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
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.LoginLogoutKeys;
import com.taxi_application_automation.pages.keys.ProfileKeys;
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParsers;
import com.taxi_application_automation.verify.Verify;

import io.appium.java_client.AppiumDriver;

/**
 * ProfilePage class contains pages for profile test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class ProfilePage {
	public Logger logger = Logger.getLogger(ProfilePage.class);

	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();
	Verify verify = new Verify();
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();

	/**
	 * verifyUserRegistration method checks that mobile number registered is
	 * available in the profile page.
	 * 
	 * @param driver
	 */
	public void verifyUserRegistration(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			loginPage.login(driver);

			menuPage.clickMenu(driver);

			menuPage.clickProfile(driver);

			logger.info(InfoMessages.DISPLAY_PROFILE_PAGE_MESSAGE);

			logger.info(InfoMessages.GET_MOBILE_NUMBER_MESSAGE);

			WebElement getMobileNumber = driver.findElement(By.xpath(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.GET_MOBILE_NUMBER)));
			String getMobileString = action.Element_text(getMobileNumber);

			logger.info(VerifyMessages.VERIFY_NUMBER_IS_SAME_MESSAGE);

			verify.verifyString(getMobileString,
					loadProperty.getValue(FilePathConstants.LOGIN_DETAIL, LoginLogoutKeys.MOBILE_NUMBER_TEXT),
					"Verify mobileNumber : ");

			logger.info(InfoMessages.CLICK_BACK_MESSAGE);
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * updateProfile method perform updating the profile in the profile page by
	 * changing the name and email id.
	 * 
	 * @param driver
	 */
	public void updateProfile(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.ENTER_UPDATED_FIRST_NAME_MESSAGE);
			WebElement updateFirstNameTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_FIRST_NAME_TEXT_BOX)));
			updateFirstNameTextBox.clear();
			action.TextBox(updateFirstNameTextBox, loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS,
					ProfileKeys.UPDATE_FIRST_NAME_TEXT));

			logger.info(InfoMessages.ENTER_UPDATED_LAST_NAME_MESSAGE);
			WebElement updateLastNameTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_LAST_NAME_TEXT_BOX)));
			updateLastNameTextBox.clear();
			action.TextBox(updateLastNameTextBox,
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS, ProfileKeys.UPDATE_LAST_NAME_TEXT));

			logger.info(InfoMessages.ENTER_UPDATED_EMAIL_MESSAGE);
			WebElement updateEmailTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_EMAIL_TEXT_BOX)));
			updateEmailTextBox.clear();
			action.TextBox(updateEmailTextBox,
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS, ProfileKeys.UPDATE_EMAIL_TEXT));

			logger.info(InfoMessages.CLICK_SAVE_BUTTON_MESSAGE);
			WebElement saveButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.SAVE_BUTTON)));
			action.clickButton(saveButton);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.CLICK_BACK_MESSAGE);
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyProfileUpdate method verifies that profile is updated with new
	 * credentials or not.
	 * 
	 * @param driver
	 */
	public void verifyProfileUpdate(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			logger.info(InfoMessages.READ_FIRSTNAME_TEXT_MESSAGE);
			WebElement verifyFirstName = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_FIRST_NAME_TEXT_BOX)));
			String verifyFirstNameText = action.Element_text(verifyFirstName);

			logger.info(VerifyMessages.VERIFY_FIRSTNAME_SAME_MESSAGE);
			verify.verifyString(verifyFirstNameText,
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS, ProfileKeys.UPDATE_FIRST_NAME_TEXT),
					"Verify First Name : ");

			logger.info(InfoMessages.READ_LASTNAME_TEXT_MESSAGE);
			WebElement verifyLastName = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_LAST_NAME_TEXT_BOX)));
			String verifyLastNameText = action.Element_text(verifyLastName);

			logger.info(VerifyMessages.VERIFY_LASTNAME_SAME_MESSAGE);
			verify.verifyString(verifyLastNameText,
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS, ProfileKeys.UPDATE_LAST_NAME_TEXT),
					"Verify Last Name : ");

			logger.info(InfoMessages.READ_EMAIL_TEXT_MESSAGE);
			WebElement verifyEmail = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_PATH, ProfileKeys.UPDATE_EMAIL_TEXT_BOX)));
			String verifyEmailText = action.Element_text(verifyEmail);

			logger.info(VerifyMessages.VERIFY_EMAIL_SAME_MESSAGE);
			verify.verifyString(verifyEmailText,
					loadProperty.getValue(FilePathConstants.PROFILE_UPDATE_DETAILS, ProfileKeys.UPDATE_EMAIL_TEXT),
					"Verify Email Id : ");

			logger.info(InfoMessages.CLICK_BACK_MESSAGE);
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}

	}
}
