package stepDefinition;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.IndexPage;

public class BaseClass {
	public WebDriver driver;
	public Properties properties;
	public static Logger logger;
	public IndexPage indexPage;
	// public LoginPage loginPage;

	/*
	 * generating random emails.... public static String randomString() { String
	 * generatedString = RandomStringUtils.randomAlphabetic(5);
	 * 
	 * return generatedString;
	 * 
	 * }
	 */
}
