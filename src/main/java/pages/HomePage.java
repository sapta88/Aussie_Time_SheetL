package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='s-menu']")
	WebElement eSearchBox;
	@FindBy(xpath = "//*[@title='Mailbox']")
	WebElement eMailBox;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchBox(String ca) {
		sendKeys(eSearchBox, ca);
	}

	public void mailBoxSearch() {
		eMailBox.click();
	}
}
