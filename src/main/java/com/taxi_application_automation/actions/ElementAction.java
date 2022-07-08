package com.taxi_application_automation.actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.taxi_application_automation.base.TestBase;

/**
 * This class contains different reusable methods for UI elements
 */
public class ElementAction extends TestBase {
	/**
	 * Check whether the web element is present or not
	 *
	 * @return true or false
	 */
	public Logger logger = Logger.getLogger(ElementAction.class);

	public boolean isElementPresent(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException noSuchElementException) {
			logger.info("Web element is not present");
		} catch (NullPointerException exception) {
			logger.info("Web element is null");
		}
		return false;
	}

	/**
	 * Check whether the web element is selected or not
	 *
	 * @return true or false
	 */
	public boolean isElementSelected(WebElement element) {

		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the web element is Enabled or not
	 *
	 * @return true or false
	 */
	public boolean isElementEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method used to get actual page title of web page
	 *
	 * @return Current page title
	 */
	public String getPageTitle() {

		return driver.getTitle();
	}

	/**
	 * Check whether the web element is present or not Sending the value for text
	 * box
	 */
	public void TextBox(WebElement element, String Value) {

		try {
			if (isElementPresent(element)) {
				element.sendKeys(Value);
			}
		} catch (NoSuchElementException noSuchElementException) {
			logger.info("Elements is not present");
		}
	}

	/**
	 * Check whether the web element is selected or not Clicking web elements
	 */
	public void clickButton(WebElement element) {

		executor = (JavascriptExecutor) driver;
		try {
			if (!isElementSelected(element)) {
				element.click();
			} else {
				logger.info("WebElement is already selected");
			}
		} catch (ElementClickInterceptedException exception) {
			executor.executeScript("arguments[0].click();", element);
		} catch (StaleElementReferenceException exception) {
			logger.info("Web page get refreshed");
		}
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements counts
	 */
	public static int Elements_Count(List<WebElement> element) {

		return element.size();
	}

	/**
	 * Getting web element Handling alert popups Accepts alert
	 */
	public void alert_Accept(WebElement element) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException exception) {
			logger.info("No such alert is present");
		} catch (NoSuchElementException noSuchElementException) {
			logger.info("Web element is not present");
		}
	}

	/**
	 * Getting web element Handling alert popups Cancelling the alert
	 */
	public void alert_Dismiss(WebElement element) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException exception) {

			logger.info("No such alert is present");
		}
	}

	/**
	 * Getting web element Check whether the web element is present or not
	 *
	 * @return Web elements text
	 */
	public String Element_text(WebElement element) {

		if (isElementPresent(element)) {
			return element.getText();
		} else {
			return null;
		}
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements text
	 */
	public String Elements_text(List<WebElement> elements) {
		StringBuilder builder = new StringBuilder();
		for (WebElement element : elements) {
			builder.append(element.getText());
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements text
	 */
	public static List<String> Elements_text1(List<WebElement> elements) {

		List<String> stringList = new ArrayList<>();
		for (WebElement element : elements) {
			stringList.add(element.getText());
		}
		return stringList;
	}

	/**
	 * This Method is used to take screenshot when exception occurs It stores image
	 * in file and png format.
	 */
	public void screenShot(WebDriver driver, String filepath) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(filepath);
		try {
			FileHandler.copy(source, file);
		} catch (IOException e) {
			logger.info("Image is not captured");
		}
	}

	/**
	 * This method is used to check whether element is interactable or not
	 */
	public void waitForElementInteractable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException exception) {
			logger.info("Element is not clickable");
		}
	}

}
