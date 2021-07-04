package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class BugPage extends PageUtility {
	WebDriver driver;
	JavascriptExecutor js;
	SoftAssert sa;
	@FindBy(xpath = "//a[@title='Bugs']")
	WebElement eBugMenu;
	@FindBy(xpath = "//a[@href='#assign_task']")
	WebElement eNewtask;
	@FindBy(xpath = "//input[@data-parsley-id='6']")
	WebElement eBugTitle;
	@FindBy(id = "check_related")
	WebElement eRelatedTo;
	@FindBy(xpath = "//button[@data-id=\"related_to\"]")
	WebElement eSelectOpportunities;
	@FindBy(xpath = "//select[@class='select_box select2-hidden-accessible']")
	WebElement eReporter;
	@FindBy(xpath = "//select[@data-parsley-id='12']")
	WebElement ePriority;
	@FindBy(xpath = "//select[@data-parsley-id='14']")
	WebElement eSeverity;
	@FindBy(xpath = "//*[@id=\"assign_task\"]/div/div/form/div[8]/div/div/div[6]")
	WebElement eDescription;
	@FindBy(xpath = "//*[@id=\"assign_task\"]/div/div/form/div[9]/div/div/div[6]")
	WebElement eReproducibility;
	@FindBy(xpath = "//select[@data-parsley-id='20']")
	WebElement eBugStatus;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
	WebElement eSave;
	@FindBy(xpath = "//a[text()='Edit Opportunities']")
	WebElement eEditOpportunity;
	@FindBy(xpath = "//input[@data-parsley-id='16']")
	WebElement eAddNewLink;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
	WebElement eUpdateButton;
	@FindBy(xpath = "//a[@title='Bugs']")
	WebElement eBugMainMenu;
	@FindBy(xpath = "//a[@class='dt-button buttons-print btn btn-danger btn-xs mr']")
	WebElement ePrintOutIcon;
	@FindBy(xpath = "//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]")
	WebElement ePrintButton;
	@FindBy(xpath = "//a[@class='dt-button buttons-excel buttons-html5 btn btn-purple mr btn-xs']")
	WebElement eAllBugxlsx;
	@FindBy(xpath = "//a[@class='dt-button buttons-csv buttons-html5 btn btn-primary mr btn-xs']")
	WebElement eAllBugcsv;
	@FindBy(xpath = "//a[@class='dt-button buttons-pdf buttons-html5 btn btn-info mr btn-xs']")
	WebElement eAllBugpdf;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement eSearchBox;
	@FindBy(xpath = "//table[@id='DataTables']/tbody/tr[@id='table_8']/td[3]/div/button")
	WebElement eChangeIcon;
	@FindBy(xpath = "//table[@id='DataTables']/tbody/tr[@id='table_8']/td[3]/div/button/following-sibling::ul/li[4]")
	WebElement eStatusProgress;
	@FindBy(xpath = "//*[@id=\"table_0\"]/td[7]/strong")
	WebElement eDelete;
	@FindBy(xpath = "//*[@id=\"table_0\"]/td[6]/span/a")
	WebElement eAssignTo;
	@FindBy(xpath = "//div[@class='pl-sm pr-sm pb-sm']/strong/a[text()='Unconfirmed']")
	WebElement eUnConfrimed;
	@FindBy(xpath = "//a[text()='Opportunity Details']")
	WebElement eSaveVerify;
	@FindBy(xpath = "//a[text()='Opportunity Details']")
	WebElement eSaveVerifytrial;
	@FindBy(xpath = "//div[@id='toast-container']/div")
	WebElement eUpdateMsgVerify;
	@FindBy(xpath = "//tbody/tr[8]/td[3]/span")
	WebElement eStatusUpdateVerify;
	@FindBy(xpath = "//div[8]/div/div[2]")
	WebElement eBugDeleteVerify;

	public BugPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		sa = new SoftAssert();
	}

	public void bugMenu() {
		click(eBugMenu);

	}

	public void newTask() {

		jsClick(eNewtask);

	}

	public void bugTitle(String value) {

		jsClick(eBugTitle);
		jsSendKeys(eBugTitle, value);
	}

	public void relatedTo(int index) {
		selectByIndex(eRelatedTo, index);

	}

	public void selectOpportunities(int index) {
		selectByIndex(eSelectOpportunities, index);

	}

	public void reporter(int index) {
		selectByIndex(eReporter, index);

	}

	public void priority(int index) {
		selectByIndex(ePriority, index);

	}

	public void severity(int index) {
		selectByIndex(eSeverity, index);

	}

	public void description(String value) {
		sendKeys(eDescription, value);

	}

	public void reproducibility(String value) {
		sendKeys(eReproducibility, value);

	}

	public void bugStatus(int index) {
		selectByIndex(eBugStatus, index);
	}

	public void save() {

		click(eSave);

	}

	public void editopportunity() {

		click(eEditOpportunity);

	}

	public void addNewLink(String value) {
		sendKeys(eAddNewLink, value);

	}

	public void updatesButton() {

		click(eUpdateButton);

	}

	public void printIcon() {

		click(ePrintOutIcon);

	}

	public void bugMainMenu() {

		click(eBugMainMenu);

	}

	public void print() {

		click(ePrintButton);

	}

	public void scroolDown() {

		scrollDown();

	}

	public void allBugXl() {

		click(eAllBugxlsx);

	}

	public void allBugCsv() {

		click(eAllBugcsv);

	}

	public void allBugPdf() {

		click(eAllBugpdf);

	}

	public void searchBox(String value) {

		actionClick(eSearchBox);
		sendKeys(eSearchBox, value);
	}

	public void clearSearchBoxResult() {
		eSearchBox.clear();
	}

	public void changeProgressStatusIcon() throws InterruptedException {

		waitForLong();
		actionClick(eChangeIcon);
		waitForLong();
	}

	public void statusProgressUpdate() {

		actionClick(eStatusProgress);

	}

	public void deleteBug() {
		waitToVisible(eDelete);

		click(eDelete);

	}

	public void assignTo() {

		click(eAssignTo);

	}

	public void unConfirmed() {

		click(eUnConfrimed);

	}

	public void bugAssignVerify() {
		String expectedTitle = "Opportunity Details";
		String actualTitle = "Opportunity Details";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public void updateSuccessVerify() {
		String actualMsg = eUpdateMsgVerify.getText();
		String expectedMsg = "Update Opportunity information successfully";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}

	public void statusUpdateVerify() {
		String actualMsg = eStatusUpdateVerify.getText();
		String expectedMsg = "Confirmed";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();

	}

	public void deleteAlertHandle() {
		alertAccept();
	}
	public void deleteVerify()
	{
		waitToVisible(eBugDeleteVerify);
		String actualMsg = eBugDeleteVerify.getText();
		String expectedMsg = "Bugs infromation successfully Deleted";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();

	}

}