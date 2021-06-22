package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class LoginPage extends PageUtility {
	WebDriver driver;
	SoftAssert sa;
	@FindBy(xpath = "//input[@name='user_name']")
	WebElement eUserName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement ePassWord;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement eSignUp;
	@FindBy(xpath = "//*[@class='btn btn-block btn-default']")
	WebElement eGetNewAccount;
	@FindBy(xpath = "//input[@type='text']")
	WebElement eCompanyName;
	@FindBy(linkText = "Dashboard")
	WebElement eDashBoard;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	public void enterUsername(String Header) {
		sendKeys(eUserName, Header);
	}

	public void enterPassword(String Header) {
		sendKeys(ePassWord, Header);
	}

	public void signIn() {
		eSignUp.click();
	}

	public void verifySuccessfulLogDashBoard() {
		Assert.assertTrue(eDashBoard.isDisplayed(), "Dashboard is not displayed");

	}

}
