package com.taxi_application_automation.testscripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.ProfilePage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.verify.Verify;

/**
 * RegistrationTest class will verify that user is able to successfully register
 * to the taxi application and verify that user is registered or not.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RegistrationTest extends TestBase {
	public Logger logger = Logger.getLogger(RegistrationTest.class);

	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	ProfilePage profilePage = new ProfilePage();

	@Test
	public void registerationVerification() {
		logger.info("------------Registration Test------------------");
		System.out.println();

		try {
			loginPage.clickRegisterHereLink(driver);

			registrationPage.verifyFirstNamePopup(driver);

			registrationPage.verifyLastNamePopup(driver);

			registrationPage.verifyMobileNumberPopup(driver);

			registrationPage.verifyValidNumberPopup(driver);

			registrationPage.verifyEmailPopup(driver);

			registrationPage.verifyPasswordPopup(driver);

			registrationPage.verifyConfirmPasswordPopup(driver);

			registrationPage.verifyPasswordLengthPopup(driver);

			registrationPage.verifyPasswordNotMatchPopup(driver);

			registrationPage.verifySuccessPopup(driver);

			registrationPage.verifyAlreadyRegisteredPopup(driver);

			profilePage.verifyUserRegistration(driver);

			menuPage.clickMenu(driver);

			menuPage.clickLogout(driver);

		} catch (NoSuchElementException elementException) {
			logger.info("Check the webelement is correct");
		}
	}
}
