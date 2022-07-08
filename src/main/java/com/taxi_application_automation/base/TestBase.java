package com.taxi_application_automation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.pages.keys.CapabilityKeys;
import com.taxi_application_automation.pages.keys.RegistrationKeys;
import com.taxi_application_automation.utility.PropertyParser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * TestBase class contains setup for launching the appium server and taxi
 * application.
 * 
 * @author Santhoshkumar.S
 *
 */
public class TestBase {
	public static AppiumDriver driver;
	public URL appiumUrl = null;
	String TEST_PATH = FilePathConstants.CAPABILITIES_DETAIL;
	public JavascriptExecutor executor;

	public Logger logger = Logger.getLogger(TestBase.class);
	PropertyParser loadProperty = new PropertyParser();

	/**
	 * VerifyLaunchApplication method contains the keys and values and launching the
	 * application.
	 * 
	 */
	@BeforeClass
	public void verifyLaunchApplication() {
		PropertyConfigurator.configure(FilePathConstants.LOG4J_PROPERTY);

		String appiumServerURL = loadProperty.getValue(TEST_PATH, CapabilityKeys.LAUNCH_APPIUM_URL);

		try {
			appiumUrl = new URL(appiumServerURL);
		} catch (MalformedURLException malformedURLException) {
			malformedURLException.printStackTrace();
		}

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				loadProperty.getValue(TEST_PATH, CapabilityKeys.PLATFORM_NAME));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				loadProperty.getValue(TEST_PATH, CapabilityKeys.PLATFORM_VERSION));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				loadProperty.getValue(TEST_PATH, CapabilityKeys.DEVICE_NAME));
		capabilities.setCapability("appPackage", loadProperty.getValue(TEST_PATH, CapabilityKeys.APP_PACKAGE));
		capabilities.setCapability("appActivity", loadProperty.getValue(TEST_PATH, CapabilityKeys.APP_ACTIVITY));
		try {
			if (appiumUrl != null) {
				driver = new AndroidDriver(appiumUrl, capabilities);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				ElementAction action = new ElementAction();

				logger.info(InfoMessages.SMS_ALLOW_MESSAGE);

				WebElement smsAlert = driver.findElement(By.xpath(
						loadProperty.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.SMS_PERMISSION)));
				action.alert_Accept(smsAlert);

				logger.info(InfoMessages.LOCATION_ALLLOW_MESSAGE);
				WebElement locationAlert = driver.findElement(By.xpath(loadProperty
						.getValue(FilePathConstants.REGISTRATION_PATH, RegistrationKeys.LOCATION_PERMISSION)));
				action.alert_Accept(locationAlert);
			} else {
				logger.info(ErrorMessages.FAILED_TO_LOAD_MESSAGE);
			}
		} catch (NoSuchElementException noSuchElementException) {
			logger.error(ErrorMessages.MISSING_WEBELEMENT_MESSAGE);
		}

	}

	/**
	 * Terminate method will close the application after every test is completed.
	 */
	@AfterClass
	public void terminate() {
		driver.quit();
	}

}