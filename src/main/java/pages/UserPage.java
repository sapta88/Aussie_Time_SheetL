package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UserPage extends PageUtility {
	WebDriver driver;
	JavascriptExecutor js;
	@FindBy(xpath = "//a[@title=\"User\"]")
	WebElement eUserMenu;
	@FindBy(xpath = "//a[@href='#create']")
	WebElement eNewProject;
	@FindBy(xpath = "//input[@data-parsley-id='6']")
	WebElement eProjectName;
	@FindBy(xpath = "//div[@data-original-title='New Client']/a")
	WebElement eNewClient;
	@FindBy(xpath = "//div[@class='chart tab-pane active']/div[1]/label/following-sibling::*/input")
	WebElement eCompanyName;
	@FindBy(xpath = "//img[@class='img-xs user-image']")
	WebElement eImageIcon;
	@FindBy(xpath = "//a[text()='My Details']")
	WebElement eMyDetails;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/settings/update_profile']")
	WebElement eUpdateProfile;
	@FindBy(xpath = "//input[@id='change_email_password']")
	WebElement eEmailPassword;
	@FindBy(xpath = "//input[@id='check_email_addrees']")
	WebElement eNewEmailUpdate;
	@FindBy(xpath = "//button[@id='new_uses_btn']")
	WebElement eChangeEmail;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement ePhoneField;
	@FindBy(xpath = "//button[text()='Update Profile']")
	WebElement eUpdateProfilePhn;
	@FindBy(xpath = "//button[text()='Update Profile']")
	WebElement eContacPerson;

	public UserPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void userMenu() {
		click(eUserMenu);

	}

	public void imageIcon() {
		click(eImageIcon);

	}

	public void myDetails() {
		click(eMyDetails);

	}

	public void scrollDown() {

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}

	public void updateDetails() {
		click(eUpdateProfile);

	}

	public void passwordUpdate(String value) {
		js.executeScript("arguments[0].click();", eEmailPassword);
		act.moveToElement(eEmailPassword).click(eEmailPassword).sendKeys(eEmailPassword, value).build().perform();
		
	}

	public void newEmailUpdate(String value) {
		js.executeScript("arguments[0].click();", eNewEmailUpdate);
		act.moveToElement(eNewEmailUpdate).click(eNewEmailUpdate).sendKeys(eNewEmailUpdate, value).build().perform();
		
	}

	public void changeEmailupdate() {

		js.executeScript("arguments[0].click();", eChangeEmail);
		
	}

	public void phoneUpdate(String value) {
		js.executeScript("arguments[0].click();", ePhoneField);
		act.moveToElement(ePhoneField).click(ePhoneField).sendKeys(ePhoneField, value).build().perform();

	}

	public void updateProfile() {

		js.executeScript("arguments[0].click();", eUpdateProfilePhn);
		
	}

}
