package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class HomePage extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='s-menu']")
	WebElement eSearchBox;
	@FindBy(xpath = "//*[@title='Mailbox']")
	WebElement eMailBox;
	SoftAssert sa;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	public void searchBox(String ca) {
		sendKeys(eSearchBox, ca);
	}

	public void mailBoxSearch() {
		eMailBox.click();
	}
	public void verifySearchMenu() 
	{
		
		String actualText="Search in menu...";
		String expectedText="Search in menu...";
		sa.assertEquals(actualText, expectedText, "Search in menu is not present");
		sa.assertAll();
		

	}
}
