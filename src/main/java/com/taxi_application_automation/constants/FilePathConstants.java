package com.taxi_application_automation.constants;

/*	
  C:\Users\santhoshkumar.s\eclipse-workspace\taxi_Application_Automation\src\main\resources\locators\hepl.prop
*/

import java.io.File;

/**
 * FilePathConstants class contains the property file path and test data for all
 * property files and test data files.
 * 
 * @author Santhoshkumar.S
 *
 */
public class FilePathConstants {

	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	public static final String MAIN_HOME = USER_HOME + "src" + File.separator + "main" + File.separator;
	public static final String RESOURCE_HOME = MAIN_HOME + "resources" + File.separator;
	public static final String LOCATORS_HOME = RESOURCE_HOME + "locators" + File.separator;
	public static final String REGISTRATION_PATH = LOCATORS_HOME + "registeration.properties";
	public static final String LOGIN_PATH = LOCATORS_HOME + "login.properties";
	public static final String LOGOUT_PATH = LOCATORS_HOME + "logout.properties";
	public static final String MENU_PAGE_PATH = LOCATORS_HOME + "menupage.properties";
	public static final String HELP_PATH = LOCATORS_HOME + "helppage.properties";
	public static final String CHANGE_PASSWORD = LOCATORS_HOME + "change-password.properties";
	public static final String DELETE_PATH = LOCATORS_HOME + "delete-account.properties";
	public static final String PROFILE_UPDATE_PATH = LOCATORS_HOME + "profile.properties";
	public static final String RIDE_NOW_PATH = LOCATORS_HOME + "ridenow.properties";
	public static final String RIDE_LATER_PATH = LOCATORS_HOME + "ridelater.properties";
	public static final String TEST_DATA_HOME = RESOURCE_HOME + "testdata" + File.separator;
	public static final String CAPABILITIES_DETAIL = RESOURCE_HOME + "capabilities.properties";
	public static final String REGISTRATION_DETAIL = TEST_DATA_HOME + "registration-details.properties";
	public static final String LOGIN_DETAIL = TEST_DATA_HOME + "logindetails.properties";
	public static final String CHANGE_PASSWORD_DETAILS = TEST_DATA_HOME + "change-password-details.properties";
	public static final String PROFILE_UPDATE_DETAILS = TEST_DATA_HOME + "profile-details.properties";
	public static final String RIDE_NOW_DETAILS = TEST_DATA_HOME + "ridenowdetails.properties";
	public static final String RIDE_LATER_DETAILS = TEST_DATA_HOME + "ridelaterdetails.properties";
	public static final String LOG4J_HOME = RESOURCE_HOME + "log4j" + File.separator;
	public static final String LOG4J_PROPERTY = LOG4J_HOME + "log4j.properties";
	public static final String REGISTER_POPUP_PATH = LOCATORS_HOME + "popup.properties";
	public static final String REGISTER_POPUP_DETAILS = TEST_DATA_HOME + "popups.properties";

}