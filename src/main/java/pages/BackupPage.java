package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class BackupPage extends PageUtility {
	WebDriver driver;
	SoftAssert sa;
	JavascriptExecutor js;
	@FindBy(xpath = "//a[@title='Backup Database']")
	WebElement eBackupMenu;
	@FindBy(xpath = "//a[@class='btn btn-xs btn-purple']")
	WebElement eBackupDatabase;
	@FindBy(xpath = "//header[@class='panel-heading  ']")
	WebElement eBackupVerify;

	public BackupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		sa=new SoftAssert();
	}

	public void backUpMenu() {
		click(eBackupMenu);

	}

	public void backupDatabase() {
		actionClick(eBackupDatabase);
	}

	public void backupVerify() {
		String expectedTitle="Backup Database";
		String actualTitle="Backup Database";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}