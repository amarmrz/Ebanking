package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import pageObjects.AddAccountPage;
import pageObjects.IndexPage;
import pageObjects.MangerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {
		properties = new Properties();
		FileInputStream ip = new FileInputStream("config.properties");
		properties.load(ip);

		logger = Logger.getLogger("GurroBank");
		PropertyConfigurator.configure("Log4j.properties");
		String br = properties.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("Firefox.Driver", properties.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		logger.info("..........Lunching Browser.....");
		driver.manage().window().maximize();
	}

	// ************Steps for Login *********************

	@Given("^User Launch Chrome browser$")
	public void user_launch_chrome_browser() {

		indexPage = new IndexPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String Url) {
		driver.get(Url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String UserId, String Password) throws InterruptedException {
		indexPage.setUserName(UserId);
		indexPage.setPassword(Password);
		Thread.sleep(1000);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		indexPage.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String PageTitle) {

		Assert.assertEquals(PageTitle, driver.getTitle());

	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	// *************Steps for register ****************

	@When("User cliks on here link")
	public void user_cliks_on_here_link() throws InterruptedException {
		indexPage.clickOnHereLink();

		WebElement frame2 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("dismiss-button")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(3000);
	}

	@Then("User should see message displayed")
	public void user_should_see_message_like() {
		Assert.assertTrue(indexPage.getmessage());

	}

	@When("User enter email address {string}")
	public void user_enter_email_address(String email) {
		indexPage.setEmail(email);
	}

	@When("Clicks on submit")
	public void clicks_on_submit() throws InterruptedException {
		indexPage.clickOnSubmit();
		Thread.sleep(3000);
	}

	@Then("User should see sucsess message like {string}")
	public void user_should_see_sucsess_message_like(String sucessmsm) {
		Assert.assertEquals(sucessmsm, indexPage.getsucmessage().toString());
	}

	// ***********Logout steps **********************

	@When("User clicks on Logout")
	public void user_clicks_on_logout() throws InterruptedException {
		mangerPage = new MangerPage(driver);
		mangerPage.clickOnLogout();
		Thread.sleep(2000);
	}

	@Then("User should see an alert with {string}")
	public void user_should_see_an_alert_with(String alert) {
		String Actual = driver.switchTo().alert().getText();
		Assert.assertTrue(Actual.contains(alert));
		driver.switchTo().alert().accept();
	}

	// *******************AddAccount******************

	@When("User clicks on add new account")
	public void user_clicks_on_add_new_account() throws InterruptedException {
		mangerPage = new MangerPage(driver);
		mangerPage.clickOnNewAccount();
		Thread.sleep(3000);
		WebElement frame2 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("dismiss-button")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(3000);
	}

	@Then("User should see an message like {string}")
	public void user_should_see_an_message_like(String string) {
		accountPage = new AddAccountPage(driver);
		// Assert.assertTrue(accountPage.getTitle().contains(string));
		Assert.assertEquals(accountPage.getTitle(), string);
	}

	@When("User enter CustomerId as {string} and AccountType as {string} and initialDeposit as {string}")
	public void user_enter_customer_id_as_and_account_type_as_current_and_initial_deposit_as(String id, String type,
			String deposit) throws InterruptedException {
		accountPage.setCustomerId(id);
		accountPage.setType(type);
		accountPage.setInitialDeposit(deposit);
		Thread.sleep(3000);
	}

	@And("User cliks on Submit")
	public void User_cliks_on_Submit() {
		accountPage.clikOnSubmit();
	}

	@Then("Page Url should be {string}")
	public void page_url_should_be(String string) {
		// Assert.assertTrue(accountPage.getUrl().contains(string));
		Assert.assertEquals(accountPage.getUrl(), string);
	}
	// ******************EndToEnd************

	@When("user cliks on change password")
	public void user_cliks_on_change_password() throws InterruptedException {
		indexPage = new IndexPage(driver);
		indexPage.clickOnChangePassword();
		Thread.sleep(2000);
	}

	@Then("User should see a message like {string}")
	public void user_should_see_a_message_like(String string) {
		Assert.assertEquals(indexPage.getTitle(), string);
	}

	@When("User enter required info")
	public void user_enter_required_info() {
		indexPage.setOldPassword("hello");
		indexPage.setNewPassword("hellohello");
		indexPage.setConfirmPassword("hellohello");

	}

	@When("User clicks on submit")
	public void user_clicks_on_submit() {
		indexPage.clickOnSubmitTochangePassword();
	}

	// need some validation

}
