package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DraftMailPage extends PageUtility {
	JavascriptExecutor js;
	WebDriver driver;
	@FindBy(xpath = "//*[@class='btn btn-danger btn-xs mr-sm']")
	WebElement eCompose;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement eToSubject;
	@FindBy(xpath = "//*[@role='treeitem']")
	WebElement eToSubjectList;
	@FindBy(xpath = "//*[@class='form-control']")
	WebElement eSubject;
	@FindBy(xpath = "//*[@contenteditable='true']")
	WebElement eMesgBody;
	@FindBy(xpath = "//button[@name='draf']")
	WebElement eDraft;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/draft']")
	WebElement eDrafts;
	@FindBy(linkText = "Are we able to draft the compose mail")
	WebElement eDraftLinkText;
	@FindBy(xpath = "//a[@href='#attendance']")
	WebElement From;
	@FindBy(xpath = "//div[@class='dz-default dz-message']//strong")
	WebElement To;
	@FindBy(xpath = "//div[@class='dz-default dz-message']//span[@class='block']")
	WebElement eAttachFile;
	@FindBy(xpath = "//button[@type='submit']/i")
	WebElement eSend;

	public DraftMailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void draftMail() {
		eCompose.click();

	}

	public void enterToSub(String to) {
		eToSubject.sendKeys(to);
	}

	public void toSub() {
		eToSubjectList.click();
	}

	public void subject(String Subject) {
		eSubject.click();
		eSubject.sendKeys(Subject);
	}

	public void mainMessageBodyClick() {
		eMesgBody.click();

	}

	public void mainMessageBodyText(String messagebody) {

		eMesgBody.sendKeys(messagebody);
	}

	public void draftfunct() {
		eDraft.click();

	}

	public void draftsClick() {
		eDrafts.click();
	}

	public void darftVerify() {
		eDraftLinkText.click();
	}

	public void fileAttachmt() throws AWTException, InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(eAttachFile).click(eAttachFile).build().perform();
		waitForLong();
		fileUploading("C:\\Users\\sapta\\OneDrive\\Desktop\\TestcaseCurrentStatus.xlsx");
		waitForLong();
	}

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

	public void sendfutn() {
		click(eSend);
	}
	public void waitForFileAttach()
	{
		waitToClick(eAttachFile) ;
	}
	public void waitForDraftToClick()
	{
		waitToClick(eDrafts) ;
	}
	public void waitForLong() throws InterruptedException {
		waitForLong();
	}
	

}
