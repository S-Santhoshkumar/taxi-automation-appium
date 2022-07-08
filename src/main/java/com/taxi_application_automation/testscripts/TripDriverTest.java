package com.taxi_application_automation.testscripts;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.taxi_application_automation.base.TestBase;
import com.taxi_application_automation.pages.BookTaxiPage;
import com.taxi_application_automation.pages.LoginPage;
import com.taxi_application_automation.pages.MenuPage;
import com.taxi_application_automation.pages.RegistrationPage;
import com.taxi_application_automation.pages.YourTripPage;
import com.taxi_application_automation.verify.Verify;

/**
 * TripDriverTest class will verify that user able to book the ride now trip and
 * verify that driver details for the 5 trips are different or same.
 * 
 * @author Santhoshkumar.S
 *
 */
public class TripDriverTest extends TestBase {
	public Logger logger = Logger.getLogger(TripDriverTest.class);
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	Verify verify = new Verify();
	RegistrationPage registrationPage = new RegistrationPage();
	BookTaxiPage rideNowPage = new BookTaxiPage();
	YourTripPage tripPage = new YourTripPage();

	@Test
	public void tripDriverVerification() throws InterruptedException {

		System.out.println();
		logger.info("------------Trip Driver Test------------------");
		System.out.println();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		loginPage.clickRegisterHereLink(driver);

		registrationPage.registerUser(driver);

		loginPage.login(driver);

		rideNowPage.bookRide(driver);

		menuPage.clickMenu(driver);

		menuPage.clickYourTrip(driver);

		tripPage.verifyDriverDetails(driver);

		menuPage.clickMenu(driver);

		menuPage.clickLogout(driver);
	}

}