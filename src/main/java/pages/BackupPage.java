package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class BackupPage extends PageUtility
{
	WebDriver driver;
	JavascriptExecutor js;
	@FindBy(xpath = "//a[@title='Backup Database']")
	WebElement eBackupMenu;
	@FindBy(xpath = "//a[@class='btn btn-xs btn-purple']")
	WebElement eBackupDatabase;
	
	public BackupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	public void backUpMenu() {
		click(eBackupMenu);

	}
	public void backupDatabase() {
		actionClick(eBackupDatabase);
	}

}
