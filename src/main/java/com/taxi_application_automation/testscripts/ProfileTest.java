package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.ProfilePage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.verify.Verify;

/**
 * ProfileTest class verify that user able to update the profile with new user
 * input names and email id and verify that names and email id is changed or
 * not.
 * 
 * @author Santhoshkumar.S
 *
 */
public class ProfileTest extends TestBase {
	public Logger logger = Logger.getLogger(ProfileTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	ProfilePage profilePage = new ProfilePage();

	@Test
	public void updateProfileVerification() {

		logger.info("\n" + InfoMessages.PROFILE_TITLE_MESSAGE + "\n");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		loginPage.clickRegisterHereLink(driver);

		registrationPage.registerUser(driver);

		loginPage.login(driver);

		menuPage.clickMenu(driver);

		menuPage.clickProfile(driver);

		profilePage.updateProfile(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);

		loginPage.login(driver);

		menuPage.clickMenu(driver);

		menuPage.clickProfile(driver);

		profilePage.verifyProfileUpdate(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);
	}
}
