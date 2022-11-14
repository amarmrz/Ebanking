package stepDefinition;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddAccountPage;
import pageObjects.IndexPage;
import pageObjects.MangerPage;

public class BaseClass {
	public WebDriver driver;
	public Properties properties;
	public static Logger logger;
	public IndexPage indexPage;
	public MangerPage mangerPage;
	public AddAccountPage accountPage;
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
