package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.HelpPage;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.verify.Verify;

/**
 * The HelpPageTest class will verify after selecting the call support key ,
 * successful pop up message is displayed or not.
 * 
 * @author Santhoshkumar.S
 *
 */
public class HelpPageTest extends TestBase {
	public Logger logger = Logger.getLogger(HelpPageTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	HelpPage helpPage = new HelpPage();

	@Test
	public void popUpVerification() {

		logger.info("\n" + InfoMessages.HELP_PAGE_TITLE_MESSAGE + "\n");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			loginPage.clickRegisterHereLink(driver);

			registrationPage.registerUser(driver);

			loginPage.login(driver);

			menuPage.clickMenu(driver);

			menuPage.clickHelp(driver);

			verify.verifyBoolean(helpPage.verifyHelpPopup(driver), true, "Verify help page popup :");

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
