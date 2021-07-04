package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

public class PageUtility {
	protected WebDriver driver;
	WebDriverWait wait;
	Select dropDown;
	public Actions act;
	Alert al;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;

	}

	// *************************************click******************************************
	public void click(WebElement e) {
		e.click();
	}

	// ***********************************sendKeys******************************************
	public void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	// *************************************wait********************************************

	public void waitToClick(WebElement e) {

		wait.until(ExpectedConditions.elementToBeClickable(e));

	}

	public void waitToVisible(WebElement e) {

		wait.until(ExpectedConditions.visibilityOf(e));

	}

	public void waitForAlertPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	// *****************************************wait*********************************************
	public void waitForLong() throws InterruptedException {
		Thread.sleep(3000);
	}

	// ****************************************Select class***************************************
	public void selectByIndex(WebElement e, int index) {
		dropDown = new Select(e);
		dropDown.selectByIndex(index);

	}

	// *******************************************Actions class*************************************
	public void actionSendKeys(WebElement e, String value) {
		act.sendKeys(value).build().perform();
	}

	public void actionClick(WebElement e) {
		act.moveToElement(e).click(e).build().perform();
	}

	// **********************************************Alert********************************************
	public void alertAccept() {
		al = driver.switchTo().alert();
		al.accept();
	}

	public void alertDismiss() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	// ************************************************JavascriptExecutor***************************************
	public void jsClick(WebElement e) {
		js.executeScript("arguments[0].click();", e);
		
	}

	public void jsSendKeys(WebElement e, String value) {

		act.moveToElement(e).click(e).sendKeys(e, value).build().perform();
	}
	// *****************************************************Scroll down*****************************************

	public void scrollDown(WebElement e) {
		js.executeScript("arguments[0].scrollIntoView();", e);

	}

	public void scrollDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	//********************************************************Maximize Window*************************************
	public void windowMax() {
		driver.manage().window().maximize();
	}

	// ********************************************************file upload****************************************
	public void fileUploading(String path) throws AWTException {
		StringSelection strSelection = new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);
		Robot robot = new Robot();
		robot.delay(400);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(400);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
