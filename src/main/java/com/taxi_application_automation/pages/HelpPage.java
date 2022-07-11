package com.taxi_application_automation.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.taxi_application_automation.actions.ElementAction;
import com.taxi_application_automation.constants.FilePathConstants;
import com.taxi_application_automation.messages.ErrorMessages;
import com.taxi_application_automation.messages.InfoMessages;
import com.taxi_application_automation.messages.VerifyMessages;
import com.taxi_application_automation.pages.keys.CommonKeys;
import com.taxi_application_automation.pages.keys.HelpPageKeys;
import com.taxi_application_automation.utility.PropertyParsers;

import io.appium.java_client.AppiumDriver;

/**
 * HelpPage class contains pages for help support test.
 * 
 * @author Santhoshkumar.S
 *
 */
public class HelpPage {
	public Logger logger = Logger.getLogger(HelpPage.class);
	PropertyParsers loadProperty = new PropertyParsers();
	ElementAction action = new ElementAction();

	/**
	 * verifyHelpPopup method will verify that help support popup with successful
	 * message is displayed or not.
	 * 
	 * @param driver
	 * @return true or false
	 */
	public boolean verifyHelpPopup(AppiumDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			logger.info(InfoMessages.CLICK_CALLSUPPORT_BUTTON);
			WebElement callSuppportButton = driver.findElement(
					By.id(loadProperty.getValue(FilePathConstants.HELP_PATH, HelpPageKeys.CALL_SUPPPORT_BUTTON)));
			action.clickButton(callSuppportButton);

			logger.info(InfoMessages.GET_POPUP_TEXT_MESSAGE);
			WebElement verifyPopUp = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.HELP_PATH, HelpPageKeys.VERIFY_SUPPORT)));
			String verifyPopup = action.Element_text(verifyPopUp);

			logger.info(verifyPopup);
			logger.info(VerifyMessages.VERIFY_POPPUP_MESSAGE);
			Assert.assertEquals(
					verifyPopup.contains(loadProperty.getValue(FilePathConstants.HELP_PATH, HelpPageKeys.PASS_MESSAGE)),
					true);
			logger.info(InfoMessages.SUCCESSFUL_POPUP_MESSAGE);

			logger.info(InfoMessages.CLICK_OK__BUTTON_MESSAGE);
			WebElement okButton = driver
					.findElement(By.xpath(loadProperty.getValue(FilePathConstants.HELP_PATH, CommonKeys.OK_BUTTON)));
			action.clickButton(okButton);

			logger.info(InfoMessages.CLICK_BACK_MESSAGE);
			WebElement backButton = driver.findElement(
					By.xpath(loadProperty.getValue(FilePathConstants.MENU_PAGE_PATH, CommonKeys.BACK_BUTTON)));
			action.clickButton(backButton);
			return true;
		} catch (Exception exception) {
			logger.error(ErrorMessages.FAILED_POPUP_MESSAGE);
			return false;
		}
	}
}
