package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class SettingsPage extends PageUtility
{
	WebDriver driver;
	JavascriptExecutor js;
	SoftAssert sa;
	@FindBy(xpath = "//a[@title='Settings']")
	WebElement eSettingsMenu;
	@FindBy(xpath = "//input[@name='contact_person']")
	WebElement eContacPerson;
	@FindBy(xpath = "//button[text()='Save Changes']")
	WebElement eSaveChanges;
	@FindBy(xpath = "//div[8]/div/div[2]")
	WebElement eSaveVerify;
	
	public SettingsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
		sa=new SoftAssert();
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
	public void saveVerify()
	{
	waitToVisible(eSaveVerify);
	String actualMsg = eSaveVerify.getText();
	String expectedMsg = "Genaral Settings Information Successfully Updated !";
	sa.assertEquals(actualMsg, expectedMsg);
	sa.assertAll();
	}
}
