package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.IndexPage;

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

}
