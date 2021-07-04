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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class DraftMailPage extends PageUtility {
	JavascriptExecutor js;
	WebDriver driver;
	SoftAssert sa;
	@FindBy(xpath = "//a[text()='Mailbox']")
	WebElement eMailBoxV;
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
	@FindBy(xpath = "//a[@href='https://erp.buffalocart.com/admin/mailbox/index/draft']")
	WebElement eDrafts;
	@FindBy(linkText = "Are we able to draft the compose mail")
	WebElement eDraftSubText;
	@FindBy(xpath = "//a[@href='#attendance']")
	WebElement From;
	@FindBy(xpath = "//div[@class='dz-default dz-message']//strong")
	WebElement To;
	@FindBy(xpath = "//div[@class='dz-default dz-message']//span[@class='block']")
	WebElement eAttachFile;
	@FindBy(xpath = "//button[@type='submit']/i")
	WebElement eSend;
	@FindBy(xpath = "//div[8]/div/div[2]")
	WebElement eSendSuccessMsg;
	

	public DraftMailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa=new SoftAssert();
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

	public void darftSubText() {
		eDraftSubText.click();
	}

	public void fileAttachmt() throws AWTException, InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(eAttachFile).click(eAttachFile).build().perform();
	}
	public void fileUpload() throws AWTException
	{
		fileUploading("C:\\Users\\sapta\\OneDrive\\Desktop\\TestcaseCurrentStatus.xlsx");
	}
	


	public void sendfutn() {
		Actions act = new Actions(driver);
		act.moveToElement(eSend).click(eSend).build().perform();
	}
	public void waitForFileAttach()
	{
		waitToClick(eAttachFile) ;
	}
	public void waitForDraftToClick()
	{
		waitToVisible(eDrafts) ;
	}
	public void waitFor() throws InterruptedException {
		waitForLong();
	}
	public void verifyMailBoxPage()
	{
		String actualText="Mailbox";
		String expectedText="Mailbox";
		sa.assertEquals(actualText, expectedText,"Main text us not present");
		sa.assertAll();
	}
	public void verifyDraftMail()
	{
		String actualText="Are we able to draft the compose mail";
		String expectedText="Are we able to draft the compose mail";
		sa.assertEquals(actualText, expectedText,"Draft mail is  not present");
		sa.assertAll();
	}
	public void scrool()
	{
		scrollDown(eAttachFile);
	}
	public void waitToClickSend()
	{
		waitToClick(eSend);
	}
	public void verifyMailSendNotification()
	{
		String actualMsg=eSendSuccessMsg.getText();
		String expectedMsg="Your message has been sent.!";
		sa.assertEquals(actualMsg, expectedMsg, "No validation message is displayed");
		
		
	}
	public void waitToBeVisible()
	{
		waitToVisible(eSendSuccessMsg);
	}
	

}
