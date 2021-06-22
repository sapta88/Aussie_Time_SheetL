package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SettingsPage extends PageUtility
{
	WebDriver driver;
	JavascriptExecutor js;
	@FindBy(xpath = "//a[@title='Settings']")
	WebElement eSettingsMenu;
	@FindBy(xpath = "//input[@name='contact_person']")
	WebElement eContacPerson;
	@FindBy(xpath = "//button[text()='Save Changes']")
	WebElement eSaveChanges;
	
	public SettingsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	public void settingsMenu() {
		click( eSettingsMenu);

	}
	public void contactPersonUpdate(String value) 
	{
		
		jsClick(eContacPerson);
		act.moveToElement(eContacPerson).click(eContacPerson).sendKeys(eContacPerson,value).build().perform();

	}
	public void saveChanges() {
		click( eSaveChanges);

	}
	
}
