package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.pages.ChangePasswordPage;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.pages.SettingsPage;
import com.taxi_application_automation.verify.Verify;

public class ChangePasswordTest extends TestBase {

	/**
	 * Change password verification class will verifies after changing the existing
	 * password User able to login with the new password credentials.
	 * 
	 * @author Santhoshkumar.S
	 * @exception InterruptedException
	 * @throws InterruptedException
	 */

	public Logger logger = Logger.getLogger(ChangePasswordTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	SettingsPage settingsPage = new SettingsPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	ChangePasswordPage changePasswordPage = new ChangePasswordPage();

	@Test
	public void changePasswordVerification() {
		logger.info("\n");
		logger.info("------------ChangePassword Test------------------");
		logger.info("\n");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		loginPage.clickRegisterHereLink(driver);

		registrationPage.registerUser(driver);

		loginPage.login(driver);

		menuPage.clickMenu(driver);

		menuPage.clickSettings(driver);

		settingsPage.clickChangePassword(driver);

		changePasswordPage.changePassword(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);

		changePasswordPage.verifyChangePassword(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);
	}
}
