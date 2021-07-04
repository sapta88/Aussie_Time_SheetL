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
	@FindBy(xpath="//a[text()='Dashboard']")
	WebElement eDashBoard;
	@FindBy(xpath="//input[@id='s-menu']")
	WebElement eSearchMenu;

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

	public void waitForVisibility()
	{
		waitToVisible(eUserName);
	}
	public void verifySuccessfulLogDashBoard() 
	{
		
		String expectedTitle="Dashboard";
		String actualTitle="Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	public void verifySearchMenu() 
	{
		
		String actualText="Search in menu...";
		String expectedText="Search in menu...";
		sa.assertEquals(actualText, expectedText, "Search in menu is not present");
		sa.assertAll();
		

	}
	
	

}
