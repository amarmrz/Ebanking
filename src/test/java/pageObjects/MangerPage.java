package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MangerPage {
	public WebDriver Gdriver;

	public MangerPage(WebDriver driver) {

		Gdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement btnLogout;

	@FindBy(xpath = "//a[normalize-space()='New Account']")
	@CacheLookup
	WebElement btnNewAccount;

	public void clickOnLogout() {
		btnLogout.click();
	}

	public void clickOnNewAccount() {
		btnNewAccount.click();
	}

}
