package com.taxi_application_automation.verify;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;

import com.taxi_application_automation.base.TestBase;

/**
 * Verify class contains verifying using assert class.
 * 
 * @author Santhoshkumar.S
 *
 */
public class Verify extends TestBase {
	public Logger logger = Logger.getLogger(Verify.class);

	public boolean verifyString(String actualText, String expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": FAIL :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	/**
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 * @return
	 */
	public boolean verifyBoolean(Boolean actualText, Boolean expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": FAIL :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	/**
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 * @return
	 */
	public boolean verifyBoolean(Integer actualText, Integer expectedText, String messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info(messageInfo + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return true;
		} catch (AssertionError assertionError) {

			logger.info(messageInfo + ": FAIL :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);
			return false;
		}
	}

	/**
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 */
	public void verifyBoolean(String actualText, String expectedText, Boolean messageInfo) {
		try {
			assertEquals(actualText, expectedText);
			logger.info("Same " + ": PASS :" + " Actual Result :: " + expectedText + " :: " + " Expected Result :: "
					+ actualText);

		} catch (Exception e) {

			logger.info("Different " + ": FAIL :" + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);

		}
	}

}
