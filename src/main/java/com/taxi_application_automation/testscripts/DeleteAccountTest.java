package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.DeleteAccountPage;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.pages.SettingsPage;
import com.taxi_application_automation.verify.Verify;

/**
 * DeleteAccountTest class will first delete the account added by the user.
 * After deleting the account user verifies that able to login with the
 * credentials.
 * 
 * @author Santhoshkumar.S
 *
 */

public class DeleteAccountTest extends TestBase {
	public Logger logger = Logger.getLogger(DeleteAccountTest.class);
	LoginPage loginPage = new LoginPage();

	MenuPage menuPage = new MenuPage();
	SettingsPage settingsPage = new SettingsPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	SettingsPage settingsPage2 = new SettingsPage();
	DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

	@Test
	public void deleteVerification() {

		logger.info("\n" + InfoMessages.DELETE_ACCOUNT_TITLE_MESSAGE + "\n");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			loginPage.clickRegisterHereLink(driver);

			registrationPage.registerUser(driver);

			loginPage.login(driver);

			menuPage.clickMenu(driver);

			menuPage.clickSettings(driver);

			settingsPage2.clickDeleteMyAccount(driver);

			deleteAccountPage.deleteAccount(driver);

			loginPage.login(driver);

			verify.verifyBoolean(deleteAccountPage.deleteAccountVerify(driver), false, "Verify account is deleted : ");

			menuPage.clickMenu(driver);

			menuPage.clickLogout(driver);
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		} catch (NullPointerException nullPointerException) {
			logger.error(ErrorMessages.DRIVER_EMPTY_MESSAGE);
		} catch (StaleElementReferenceException referenceException) {
			logger.error(ErrorMessages.WEBPAGE_REFRESH_MESSSAGE);
		}

	}
}
