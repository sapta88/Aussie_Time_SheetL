package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class TaskPage extends PageUtility {

	SoftAssert sa;
	JavascriptExecutor js;
	@FindBy(linkText = "Tasks")
	WebElement eTaskHeading;
	@FindBy(linkText = "New Task")
	WebElement eNewTask;
	@FindBy(xpath = " //input[@data-parsley-id='4']")
	WebElement eTaskName;
	@FindBy(name = "related_to")
	WebElement eRelatedTo;
	@FindBy(xpath = "//input[@name='task_start_date']")
	WebElement eStartDate;
	@FindBy(xpath = "//input[@name='due_date']")
	WebElement eDueDate;
	@FindBy(xpath = "//input[@name='hourly_rate']")
	WebElement eHourlyRate;
	@FindBy(xpath = "//input[@name='task_hour']")
	WebElement eTaskHour;
	@FindBy(id = "through_sub_tasks")
	WebElement eCheckBoxThroughSubTasks;
	@FindBy(name = "task_status")
	WebElement eCheckBoxTasksStatus;
	@FindBy(xpath = "//div[@class='note-editable']")
	WebElement eTaskDescription;
	@FindBy(xpath = "//label[contains(@class,'btn btn-success toggle-on')]")
	WebElement eBill;
	@FindBy(xpath = "//input[@name='permission']")
	WebElement eAssignTo;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
	WebElement eSaveButton;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/tasks/all_task']")
	WebElement eTasksIcon;
	@FindBy(xpath = "//a[text()='Import Tasks']")
	WebElement eImportTask;
	@FindBy(xpath = "//span[@class='btn btn-default btn-file']")
	WebElement eChooseFile;
	@FindBy(name = "task_status")
	WebElement eTaskStatus;
	@FindBy(xpath = "//input[@value='everyone']")
	WebElement eAssign;
	@FindBy(xpath = "//button[text()=' Upload']")
	WebElement eUpload;
	@FindBy(xpath = "//tbody/tr/td[6]/a[@title='Edit']")
	WebElement eEdit;
	@FindBy(xpath = "//button[text()='Updates']")
	WebElement eUpdates;
	@FindBy(xpath = "//a[@data-original-title='Export Report']")
	WebElement eExport;
	@FindBy(xpath = "//tr[1]/td[6]/child::a/span")
	WebElement eViewTask;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/tasks/all_task']")
	WebElement eTaskMenu;
	@FindBy(xpath = "//input[@value='custom_permission']/following-sibling::span")
	WebElement eCustom;
	@FindBy(xpath = "//div[@class='checkbox c-checkbox needsclick']//input[@data-parsley-id='14']")
	WebElement eList;
	@FindBy(xpath = "//input[@id='select_all']/following-sibling::*")
	WebElement eSelectTaskname;
	@FindBy(xpath = "//a[@class='dt-button btn btn-xs btn-default custom-bulk-button']")
	WebElement eBulkDelete;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement eSearch;
	@FindBy(xpath = "//*[@id=\"DataTables_wrapper\"]/div[2]/a[3]")
	WebElement eDownloadxlsx;
	@FindBy(xpath = "//a[@class='btn btn-xs btn-danger pull-right']")
	WebElement eSwitchToKanban;
	@FindBy(xpath = "//a[@class='btn btn-xs btn-purple pull-right']")
	WebElement eSwitchToList;
	@FindBy(xpath = "//h3[text()='faisa                            ']")
	WebElement eTaskNameVerify;
	@FindBy(xpath = "//div[@class='toggle-group']/label[1]")
	WebElement eBillable;
	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement eTask;
	@FindBy(xpath = "//div[@id='toast-container']/div/div[2]")
	WebElement eBulkDeleteVerify;
	@FindBy(xpath = "//*[@id=\"table-tasks\"]/tbody/tr[1]/td[6]/a[1]")
	WebElement eViewEditTask;
	@FindBy(xpath = "//*[@id=\"task_details\"]/div/div[2]/div[9]/div/p")
	WebElement eViewEditHourRate;
	public TaskPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
		js = (JavascriptExecutor) driver;

	}

	public void verifyIfTaskPageIsPresent() {
		String expectedTitle = "Tasks";
		String actualTitle = eTaskHeading.getText();
		sa.assertEquals(actualTitle, expectedTitle);
		sa.assertAll();
	}

	public void clickNewTask() {
		click(eNewTask);
	}

	public void enterTaskName(String value) {
		js.executeScript("arguments[0].click();", eTaskName);
		act.moveToElement(eTaskName).click(eTaskName).sendKeys(eTaskName, value).build().perform();
		
	}

	public void selectRelatedTo() {

		selectByIndex(eRelatedTo, 1);

	}

	public void startDate(String value) {
		sendKeys(eStartDate, value);
	}

	public void dueDate(String value) {
		sendKeys(eDueDate, value);
	}

	public void hourlyRate(String value) {
		waitToClick(eHourlyRate);
		act.moveToElement(eHourlyRate).click(eHourlyRate).sendKeys(eHourlyRate, value).build().perform();
	}

	public void taskHour(String value) {
		sendKeys(eTaskHour, value);
	}

	public void checkBoxTaskHoursSelect() {
		click(eCheckBoxThroughSubTasks);
	}

	public void taskStatusSelect() {
		selectByIndex(eCheckBoxTasksStatus, 1);
	}

	public void taskDescription(String value) {
		sendKeys(eTaskDescription, value);
	}

	public void billable()
	{
		actionClick(eBillable);
	}

	public void assignTo() {
		click(eAssignTo);

	}

	public void saveButton() {
		click(eSaveButton);

	}

	public void taskIconSelection() {
		click(eTasksIcon);

	}

	public void importTask() {
		click(eImportTask);

	}

	public void fileAttachment() throws AWTException, InterruptedException {
		js.executeScript("arguments[0].click();", eChooseFile);
		
		waitForLong();
		fileUploading("C:\\Users\\sapta\\Desktop\\TestcaseCurrentStatus.xlsx");
		Thread.sleep(3000);
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

	public void taskStatus() {
		selectByIndex(eTaskStatus, 1);
	}

	public void assigNTo() {
		click(eAssign);
	}

	public void upload() {
		click(eUpload);
	}

	public void taskEdit() {
		waitToClick(eEdit);
		actionClick(eEdit);
	}

	public void taskUpdates() {
		actionClick(eUpdates);
	}

	public void exportReport() {
		
		jsClick(eExport);
	}

	public void scrollDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void viewTask() {
		click(eViewTask);

	}

	public void taskLink() {
		click(eTaskMenu);
	}

	public void assignToCustom() {
		click(eCustom);
	}

	public void listsSelection() {
		
		actionClick(eList);
	}

	public void bulkDelete() {
		//actionClick(eBulkDelete);
		waitToClick(eBulkDelete);
		jsClick(eBulkDelete);
	}

	public void alertHandle() {
		alertAccept();
	}

	public void search() {
		
		
		jsClick(eSearch);
	}

	public void searchSendkeys(String value) {
		actionSendKeys(eSearch, value);
	}

	public void downloadFile() {
		actionClick(eDownloadxlsx);
	}

	public void waitAlert() {
		waitForAlertPresent();
	}

	public void taskSelection() {
		

		jsClick(eSelectTaskname);
	}
	public void taskclk() {
		click(eTaskHeading);
	}
	public void scrollDownKanban() {


		scrollDown(eSwitchToKanban);

	}
	public void kanban() {
		actionClick(eSwitchToKanban);
	}
	public void list() {
		actionClick(eSwitchToList);
	}

	public void taskNameVerify()
	{
		String actualText="faisa ";
		String expectedText="faisa ";
		sa.assertEquals(actualText, expectedText,"Invalid task name");
		sa.assertAll();
	}
	public void taskLinkClick()
	{
		actionClick(eTask);
	}
	public void bulkDeleteVerify()
	{
		waitToVisible(eBulkDeleteVerify);
		String actualMsg=eBulkDeleteVerify.getText();
		String expectedMsg="Task deleted successfully!";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
	public void windowMaximum() throws InterruptedException
	{
		windowMax();
		waitForLong();
	}
	public void viewEditTask()
	{
		jsClick(eViewEditTask);
	}
	
	public void hourRateVerify()
	{
		waitToVisible(eViewEditHourRate);
		String actualMsg=eViewEditHourRate.getText();
		String expectedMsg="8.00";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
	
	

	

}
