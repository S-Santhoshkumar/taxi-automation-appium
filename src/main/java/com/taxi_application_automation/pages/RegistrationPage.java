package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParser;
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
	PropertyParser loadProperty = new PropertyParser();
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
				logger.info("Register page is Displayed");
				logger.info("Enter the First name");
				WebElement firstNametextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
				action.TextBox(firstNametextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));

				logger.info("Enter the Last name");
				WebElement lastNameTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
				action.TextBox(lastNameTextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));

				logger.info("Enter the MobileNumber");
				WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
				action.TextBox(mobileNumberTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.MOBILE_NUMBER_TEXT));

				logger.info("Enter the Valid Email id");
				WebElement emailTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
				action.TextBox(emailTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.EMAIL_ADDRESS_TEXT));

				logger.info("Enter the password");
				WebElement passwordTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
				action.TextBox(passwordTextBox,
						loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));

				logger.info("Enter the password again to confirm");
				WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
				action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
						RegistrationKeys.CONFIRM_PASSWORD_TEXT));

				logger.info("Click on Register button");
				WebElement registerButton = driver.findElement(By.id(
						loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
				action.clickButton(registerButton);

				logger.info("Click on Ok button");
				WebElement okButton = driver.findElement(
						By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
				action.clickButton(okButton);
			} catch (NoSuchElementException noSuchElementException) {
				logger.error("Check the webelement is correct");
			} catch (NullPointerException nullPointerException) {
				logger.error("Check the driver is null");
			} catch (StaleElementReferenceException referenceException) {
				logger.error("webpage refreshed");
			}

			logger.info(" User Registered Succcessfully ");

			logger.info("Page directed to Login page!!");

			return true;

		} catch (Exception exception) {
			logger.info("! User Registration failed !");
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
			logger.info("--------First Name Empty Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the first name");
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.FIRST_NAME_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.FIRST_NAME_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");

			verify.verifyString(getActualPopupText, expectedPopupText, "Verify First name popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the first name text");
			WebElement firstNametextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
			action.TextBox(firstNametextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Last Name Empty Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the last name");
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.LAST_NAME_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.LAST_NAME_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Last Name popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the last name text" + "\n");
			WebElement lastNameTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
			action.TextBox(lastNameTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Mobile Number Empty Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the mobile number");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.MOBILE_NUMBER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.MOBILE_NUMBER_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Mobile number popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the mobile number");
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox, loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.INVALID_MOBILE_NUMBER_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Invalid Mobile Number Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the valid mobile number");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.VALID_MOBILE_NUMBER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.INVALID_NUMBER__MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify valid number popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the valid mobile number");
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.MOBILE_NUMBER_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Invalid Email ID Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the valid email id");
			WebElement popUpElement = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.EMAIL_ID_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.EMAIL_ID_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Email popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the valid valid email id");
			WebElement emailTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
			action.TextBox(emailTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.EMAIL_ADDRESS_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Password Empty Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the password");
			WebElement popUpElement = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASSWORD_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the password upto 5 digits");
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS, RegistrationKeys.PASSWORD));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Comfirm Password Empty Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the Confrim password");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.CONFIRM_PASSWORD_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.CONFIRM_PASSWORD_EMPTY_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Confirm Password popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the password again upto 5 digits to confirm");
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS, RegistrationKeys.CONFIRM_PASSWORD));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Password less than 6 Digits Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the password greater than 6 digits");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_LENGTH_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASSWORD_LENGTH_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password length popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the valid password");
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			passwordTextBox.clear();
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Password Mismatch Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for not entering the password and confirm password same");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.PASSWORD_NOT_MATCH_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.PASWORD__NOTMATCH_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Password Mismatch popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Enter the valid password again to confirm");
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
					RegistrationKeys.CONFIRM_PASSWORD_TEXT));
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------Register Successful Pop Up---------");
			logger.info("Click register here");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for succesful register");
			WebElement popUpElement = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.SUCCESSFUL_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.SUCCESS_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify Success popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);
			System.out.println();
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
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
			logger.info("--------User Already Registered Pop Up---------");

			loginPage.clickRegisterHereLink(driver);

			logger.info("Enter the First name");
			WebElement firstNametextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.FIRST_NAME_TEXT_BOX)));
			action.TextBox(firstNametextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.FIRST_NAME_TEXT));

			logger.info("Enter the Last name");
			WebElement lastNameTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LAST_NAME_TEXT_BOX)));
			action.TextBox(lastNameTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.LAST_NAME_TEXT));

			logger.info("Enter the MobileNumber");
			WebElement mobileNumberTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.MOBILE_NUMBER_TEXT_BOX)));
			action.TextBox(mobileNumberTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.MOBILE_NUMBER_TEXT));

			logger.info("Enter the Valid Email id");
			WebElement emailTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.EMAIL_ADDRESS_TEXTBOX)));
			action.TextBox(emailTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.EMAIL_ADDRESS_TEXT));

			logger.info("Enter the password");
			WebElement passwordTextBox = driver.findElement(By.id(
					loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.PASSWORD_TEXT_BOX)));
			action.TextBox(passwordTextBox,
					loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL, RegistrationKeys.PASSWORD_TEXT));

			logger.info("Enter the password again to confirm");
			WebElement confirmPasswordTextBox = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.CONFIRM_PASSWORD_TEXT_BOX)));
			action.TextBox(confirmPasswordTextBox, loadProperty.getValue(FilePathConstants.REGISTRATION_DETAIL,
					RegistrationKeys.CONFIRM_PASSWORD_TEXT));

			logger.info("Click on Register button");
			WebElement registerButton = driver.findElement(By
					.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.REGISTER_BUTTON)));
			action.clickButton(registerButton);

			logger.info("Read and get the popup message for already register");
			WebElement popUpElement = driver.findElement(By.id(loadProperty
					.getValue(FilePathConstants.REGISTER_POPUP_PATH, RegistrationKeys.ALREADY_REGISTER_POPUP)));
			String getActualPopupText = action.Element_text(popUpElement);

			String expectedPopupText = loadProperty.getValue(FilePathConstants.REGISTER_POPUP_DETAILS,
					RegistrationKeys.ALREADY_REGISTER_MESSAGE);

			logger.info("Verifying the actual popup and expected popup");
			verify.verifyString(getActualPopupText, expectedPopupText, "Verify User Already registered popup :");

			logger.info("Click ok button");
			WebElement okButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info("Click on Back button");
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error("Check the webelement is correct");
		} catch (NullPointerException nullPointerException) {
			logger.error("Check the driver is null");
		} catch (StaleElementReferenceException referenceException) {
			logger.error("webpage refreshed");
		}
	}

}
