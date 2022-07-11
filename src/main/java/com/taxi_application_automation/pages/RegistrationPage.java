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
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParsers;
import com.taxi_application_automation.verify.Verify;

import io.appium.java_client.AppiumDriver;

/**
 * RegistrationPage class contains pages for registration test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RegistrationPage {

	public Logger logger = Logger.getLogger(RegistrationPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();
	LoginPage loginPage = new LoginPage();
	Verify verify = new Verify();

	/**
	 * registerUser method verifies that user able to register to the application or
	 * not.
	 * 
	 * @param driver
	 * @return true or false
	 */
	public boolean registerUser(AppiumDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			try {
				logger.info(InfoMessages.REGISTRATION_PAGE_DISPLAY_MESSAGE);
				logger.info(InfoMessages.ENTER_FIRSTNAME_MESSAGE);
				WebElement firstNametextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
				action.TextBox(firstNametextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));

				logger.info(InfoMessages.ENTER_LASTNAME_MESSAGE);
				WebElement lastNameTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
				action.TextBox(lastNameTextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));

				logger.info(InfoMessages.ENTER_MOBILE_NUMBER_MESSAGE);
				WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
				action.TextBox(mobileNumberTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.MOBILE_NUMBER_TEXT));

				logger.info(InfoMessages.ENTER_EMAILID_MESSAGE);
				WebElement emailTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
				action.TextBox(emailTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.EMAIL_ADDRESS_TEXT));

				logger.info(InfoMessages.ENTER_PASSWORD_MESSAGE);
				WebElement passwordTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
				action.TextBox(passwordTextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));

				logger.info(InfoMessages.ENTER_CONFIRM_PASSWORD_MESSAGE);
				WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
				action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.CONFIRM_PASSWORD_TEXT));

				logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
				WebElement registerButton = driver.findElement(By.id(
						loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
				action.clickButton(registerButton);

				logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
				WebElement okButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
				action.clickButton(okButton);
			} catch (NoSuchElementException noSuchElementException) {
				logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
			} catch (NullPointerException nullPointerException) {
				logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
			} catch (StaleElementReferenceException referenceException) {
				logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
			}

			logger.info(InfoMessages.REGISTRATION_SUCCESSFUL_MESSAGE);

			logger.info(InfoMessages.PAGE_DIRECTED_TO_LOGIN_MESSAGE);

			return true;

		} catch (Exception exception) {
			logger.error(ErrorMessages.REGISTRATION_FAILED_MESSAGE);
			return false;
		}

	}

	/**
	 * verifyFirstNamePopup method verifies popup is displayed when user lefts the
	 * firstName text box empty. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyFirstNamePopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.FIRSTNAME_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_FIRSTNAME_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.FIRST_NAME_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.FIRST_NAME_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_FIRSTNAME_POPUP_MESSAGE);

			verify.verifyString(getActualPopupText, expectedPopupText, "Verify First name popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_FIRSTNAME_MESSAGE);
			WebElement firstNametextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
			action.TextBox(firstNametextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyLastNamePopup method verifies popup is displayed when user lefts the
	 * lastName text box empty. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyLastNamePopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.LASTNAME_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_LASTNAME_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.LAST_NAME_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.LAST_NAME_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_LASTNAME_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Last Name popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_LASTNAME_MESSAGE + "\n");
			WebElement lastNameTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
			action.TextBox(lastNameTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyMobileNumberPopup method verifies popup is displayed when user lefts
	 * the mobile number text box empty. Verify actual and expected popup is equal
	 * or not.
	 * 
	 * @param driver
	 */
	public void verifyMobileNumberPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.MOBILENUMBER_EMPTY_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_MOBILENUMBER_EMPTY_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.MOBILE_NUMBER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.MOBILE_NUMBER_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_NUMBER_EMPTY_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Mobile number popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_INVALID_MOBILE_NUMBER_MESSAGE);
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox, loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.INVALID_MOBILE_NUMBER_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyValidNumberPopup method verifies popup is displayed when user enters
	 * invalid mobile number. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyValidNumberPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.MOBILENUMBER_INVALID_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_MOBILENUMBER_INVALID_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.VALID_MOBILE_NUMBER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.INVALID_NUMBER__MESSAGE);

			logger.info(VerifyMessages.VERIFY_NUMBER_INVALID_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify valid number popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_MOBILE_NUMBER_MESSAGE);
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.MOBILE_NUMBER_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyEmailPopup method verifies popup is displayed when user lefts the email
	 * id text box empty. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyEmailPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.EMAIL_INVALID_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_EMAIL_INVALID_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.EMAIL_ID_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.EMAIL_ID_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_EMAIL_INVALID_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Email popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_EMAILID_MESSAGE);
			WebElement emailTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
			action.TextBox(emailTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.EMAIL_ADDRESS_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyPasswordPopup method verifies popup is displayed when user lefts the
	 * password text box empty. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyPasswordPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.PASSWORD_EMPTY_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_PASSWORD_EMPTY_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASSWORD_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_PASSWORD_EMPTY_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_PASSWORD_UPTO_5_DIGIT_MESSAGE);
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS, RegistrationKeys.PASSWORD));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyConfirmPasswordPopup method verifies popup is displayed when user lefts
	 * the confirm password text box empty. Verify actual and expected popup is
	 * equal or not.
	 * 
	 * @param driver
	 */
	public void verifyConfirmPasswordPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.CONFIRM_PASSWORD_EMPTY_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_CONFIRM_PASSWORD_EMPTY_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.CONFIRM_PASSWORD_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.CONFIRM_PASSWORD_EMPTY_MESSAGE);

			logger.info(VerifyMessages.VERIFY_CONFIRM_PASSWORD_EMPTY_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Confirm Password popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_CONFIRM_PASSWORD_UPTO_5_DIGIT_MESSAGE);
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS, RegistrationKeys.CONFIRM_PASSWORD));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyPasswordLengthPopup method verifies popup is displayed when user enters
	 * the password less than 6 digits.Verify actual and expected popup is equal or
	 * not.
	 * 
	 * @param driver
	 */
	public void verifyPasswordLengthPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.PASSWORD_LENGTH_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_PASSWORD_LENGTH_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_LENGTH_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASSWORD_LENGTH_MESSAGE);

			logger.info(VerifyMessages.VERIFY_PASSWORD_LENGTH_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password length popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_PASSWORD_MESSAGE);
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			passwordTextBox.clear();
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyPasswordNotMatchPopup method verifies popup is displayed when user
	 * enters the password and confirm password with different inputs .Verify actual
	 * and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifyPasswordNotMatchPopup(AppiumDriver driver) {
		try {
			logger.info("\n" + InfoMessages.PASSWORD_MISMATCH_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_PASSWORD_MISMATCH_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_NOT_MATCH_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASWORD__NOTMATCH_MESSAGE);

			logger.info(VerifyMessages.VERIFY_PASSWORD_MISMATCH_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password Mismatch popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.ENTER_CONFIRM_PASSWORD_MESSAGE);
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
					RegistrationKeys.CONFIRM_PASSWORD_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifySuccessPopup method verifies popup is displayed when user click on
	 * register button. Verify actual and expected popup is equal or not.
	 * 
	 * @param driver
	 */
	public void verifySuccessPopup(AppiumDriver driver) {
		try {
			logger.info(InfoMessages.REGISTRATION_SUCCESSFUL_POPUP_TITLE_MESSAGE);
			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_REGISTRATION_SUCCESS_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.SUCCESSFUL_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.SUCCESS_MESSAGE);

			logger.info(VerifyMessages.VERIFY_REGISTRATION_SUCCESS_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Success popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}
	}

	/**
	 * verifyAlreadyRegisteredPopup method verifies popup is displayed when user
	 * registers with the same credentials.Verify actual and expected popup is equal
	 * or not.
	 * 
	 * @param driver
	 */
	public void verifyAlreadyRegisteredPopup(AppiumDriver driver) {
		try {
			logger.info(InfoMessages.ALREADY_REGISTERED_POPUP_TITLE_MESSAGE);

			loginPage.clickRegisterHereLink(driver);

			logger.info(InfoMessages.ENTER_FIRSTNAME_MESSAGE);
			WebElement firstNametextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
			action.TextBox(firstNametextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));

			logger.info(InfoMessages.ENTER_LASTNAME_MESSAGE);
			WebElement lastNameTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
			action.TextBox(lastNameTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));

			logger.info(InfoMessages.ENTER_MOBILE_NUMBER_MESSAGE);
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.MOBILE_NUMBER_TEXT));

			logger.info(InfoMessages.ENTER_EMAILID_MESSAGE);
			WebElement emailTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
			action.TextBox(emailTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.EMAIL_ADDRESS_TEXT));

			logger.info(InfoMessages.ENTER_PASSWORD_MESSAGE);
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));

			logger.info(InfoMessages.ENTER_CONFIRM_PASSWORD_MESSAGE);
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
					RegistrationKeys.CONFIRM_PASSWORD_TEXT));

			logger.info(InfoMessages.CLICK_REGISTER_BUTTON);
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info(InfoMessages.GET_ALREADY_REGISTERED_POPUP_MESSAGE);
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.ALREADY_REGISTER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.ALREADY_REGISTER_MESSAGE);

			logger.info(VerifyMessages.VERIFY_REGISTERED_ALREADY_POPUP_MESSAGE);
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify User Already registered popup :");

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
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

}
