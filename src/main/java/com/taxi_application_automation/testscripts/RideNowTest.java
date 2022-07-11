package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.BookTaxiPage;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.pages.YourTripPage;
import com.taxi_application_automation.verify.Verify;

/**
 * RideNowTest class will verify that user able to book the ride now trip and
 * verify that status of the trip is same or not. From and to location is same
 * as user given inputs.
 * 
 * @author Santhoshkumar.S
 *
 */
public class RideNowTest extends TestBase {
	public Logger logger = Logger.getLogger(RideNowTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	YourTripPage yourTripPage = new YourTripPage();
	BookTaxiPage rideNowPage = new BookTaxiPage();

	@Test
	public void verifyRideNowdetails() {

		logger.info("\n" + InfoMessages.RIDE_NOW_TITLE_MESSAGE + "\n");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		loginPage.clickRegisterHereLink(driver);

		registrationPage.registerUser(driver);

		loginPage.login(driver);

		rideNowPage.rideNowDetails(driver);

		menuPage.clickMenu(driver);

		menuPage.clickYourTrip(driver);

		yourTripPage.rideNowTripDetails(driver);

		yourTripPage.verifyfromAndTo(driver);

		yourTripPage.verifyRideNowTripTime(driver);

		yourTripPage.verifyRideNowTripStatus(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);
	}
}
