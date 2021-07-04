package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class ProjectPage extends PageUtility {
	WebDriver driver;
	JavascriptExecutor js;
	SoftAssert sa;
	@FindBy(xpath = "//a[@title='Projects']")
	WebElement eProjectMenu;
	@FindBy(xpath = "//a[@href='#create']")
	WebElement eNewProject;
	@FindBy(xpath = "//input[@data-parsley-id='6']")
	WebElement eProjectName;
	@FindBy(xpath = "//div[@data-original-title='New Client']/a")
	WebElement eNewClient;
	@FindBy(xpath = "//div[@class='chart tab-pane active']/div[1]/label/following-sibling::*/input")
	WebElement eCompanyName;
	@FindBy(xpath = "//input[@name='email']")
	WebElement eCompanyEmail;
	@FindBy(xpath = "//*[@id=\"update_client\"]/div/div[2]/button")
	WebElement eSave;
	@FindBy(xpath = "//textarea[@data-parsley-id='16']")
	WebElement eShortNote;
	@FindBy(xpath = "//div[8]/div/div[2]")
	WebElement eAddClientVerify;
	public ProjectPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		sa=new SoftAssert();
	}

	public void projectMenu() {
		click(eProjectMenu);

	}

	public void newProject() throws InterruptedException 
	{
		waitForLong();
		click(eNewProject);

	}

	public void projectName(String value) {
		js.executeScript("arguments[0].click();", eProjectName);
		act.moveToElement(eProjectName).click(eProjectName).sendKeys(eProjectName, value).build().perform();

	}

	public void newClient() {
		click(eNewClient);

	}
	

	public void companyName(String value) throws InterruptedException {
		waitForLong();
		js.executeScript("arguments[0].click();", eCompanyName);
		act.moveToElement(eCompanyName).click(eCompanyName).sendKeys(eCompanyName, value).build().perform();

	}
	
	public void companyEmail(String value) throws InterruptedException {
		waitForLong();
		js.executeScript("arguments[0].click();", eCompanyEmail);
		act.moveToElement(eCompanyEmail).click(eCompanyEmail).sendKeys(eCompanyEmail, value).build().perform();


	}
	public void shortNote(String value) throws InterruptedException {
		waitForLong();
		js.executeScript("arguments[0].click();", eShortNote);
		act.moveToElement(eShortNote).click(eShortNote).sendKeys(eShortNote, value).build().perform();


	}
	public void save() throws InterruptedException
	{
		
		waitForLong();
		js.executeScript("arguments[0].click();", eSave);
		
	}
	public void clientVerify()
	{
		waitToVisible(eAddClientVerify);
		String actualMsg = eAddClientVerify.getText();
		String expectedMsg = "Client updated successfully!";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
}
