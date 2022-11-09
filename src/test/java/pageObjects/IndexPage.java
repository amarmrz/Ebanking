package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	public WebDriver Gdriver;

	public IndexPage(WebDriver driver) {

		Gdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtId;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[normalize-space()='here']")
	@CacheLookup
	WebElement hereLink;

	@FindBy(xpath = "//tbody//tr//h2")
	@CacheLookup
	WebElement Message;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(xpath = "//h2[normalize-space()='Access details to demo site.']")
	@CacheLookup
	WebElement sucMessage;

	public void setUserName(String username) {
		txtId.clear();
		txtId.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickOnHereLink() {
		hereLink.click();
	}

	public boolean getmessage() {
		boolean message = Message.isDisplayed();
		return message;
	}

	public String getsucmessage() {
		String message = sucMessage.getText();
		return message;
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void clickOnSubmit() {
		btnSubmit.click();
	}

}
