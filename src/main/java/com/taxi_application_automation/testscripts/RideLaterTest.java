package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.pages.RideLaterPage;
import com.taxi_application_automation.pages.YourTripPage;
import com.taxi_application_automation.verify.Verify;

/**
 * RideLaterTest class will verify that user able to book the ride later trip
 * and verify that status of the trip is same or not. From and to location is
 * same as user given inputs.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RideLaterTest extends TestBase {
	public Logger logger = Logger.getLogger(RideLaterTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	RegistrationPage registrationPage = new RegistrationPage();
	Verify verify = new Verify();
	RideLaterPage rideLaterPage = new RideLaterPage();
	YourTripPage yourTripPage = new YourTripPage();

	@Test
	public void rideNowdetailsVerification() {
		System.out.println();
		logger.info("------------RideLater Test------------------");
		System.out.println();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		loginPage.clickRegisterHereLink(driver);

		registrationPage.registerUser(driver);

		loginPage.login(driver);

		rideLaterPage.rideLater(driver);

		menuPage.clickMenu(driver);

		menuPage.clickYourTrip(driver);

		yourTripPage.rideLaterTripDetails(driver);

		yourTripPage.verifyFromAndToLocation(driver);

		yourTripPage.verifyRideLaterTripTime(driver);

		yourTripPage.verifyRideLaterTripStatus(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);
	}
}
