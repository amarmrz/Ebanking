package pageObjects;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage {
	public WebDriver Gdriver;

	public AddAccountPage(WebDriver driver) {

		Gdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='cusid']")
	@CacheLookup
	WebElement txtCustomerId;

	@FindBy(xpath = "//input[@name='inideposit']")
	@CacheLookup
	WebElement txtInitialDeposit;

	@FindBy(xpath = "//input[@name='button2']")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(xpath = "//p[@class='heading3']")
	@CacheLookup
	WebElement actualTitle;

	By drpAccountType = By.xpath("//select[@name='selaccount']");

	public void setCustomerId(String CustomerId) {
		txtCustomerId.clear();
		txtCustomerId.sendKeys(CustomerId);
	}

	public void setInitialDeposit(String deposit) {
		txtInitialDeposit.clear();
		txtInitialDeposit.sendKeys(deposit);
	}

	public void setType(String value) {
		Select drp = new Select(Gdriver.findElement(drpAccountType));
		drp.selectByVisibleText(value);
	}

	public String getTitle() {
		String title = actualTitle.getText();
		return title;
	}

	public String getUrl() {
		String url = Gdriver.getCurrentUrl();
		return url;
	}

	public void clikOnSubmit() {
		btnSubmit.click();
	}

}
