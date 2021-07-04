package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class DashboardPage extends PageUtility {

	WebDriver driver;
	SoftAssert sa;
	JavascriptExecutor js;
	@FindBy(xpath = "//a[text()='Dashboard']")
	WebElement eDashBoard;
	@FindBy(linkText = "Dashboard")
	WebElement eDashText;
	@FindBy(xpath = "//p[text()='Payment Today']/following-sibling::*//a")
	WebElement eMoreInfoLink;
	@FindBy(xpath = "//p[text()='In Progress Task']/following-sibling::*/a")
	WebElement eMoreInfoLinkPT;
	@FindBy(xpath = "//a[@href='#tasks']")
	WebElement eOverdueTask;
	@FindBy(xpath = "//*[@id=\"datatable_action\"]/tbody/tr[1]/td[4]/a")
	WebElement eView;
	@FindBy(xpath = "//*[@id=\"task_details\"]/div/div[2]/div[1]/div[2]/div/button")
	WebElement eStatusChangeBtn;
	@FindBy(xpath = "//*[@id=\"task_details\"]/div/div[2]/div[1]/div[2]/div/button/following-sibling::ul/li[2]")
	WebElement eStatusUpdated;
	@FindBy(xpath = "//a[text()='Add new']")
	WebElement eAddNew;
	@FindBy(xpath = "//textarea[@data-parsley-id='6']")
	WebElement eWhatToDo;
	@FindBy(xpath = "//select[@data-parsley-id='8']/option[text()='On Hold']")
	WebElement eStatus;
	@FindBy(xpath = "//input[@data-parsley-id='10']")
	WebElement eDueDate;
	@FindBy(xpath = "//button[@id='sbtn']")
	WebElement eSaveButton;
	@FindBy(xpath = "//a[text()='Activities']")
	WebElement eActivities;
	@FindBy(xpath = "//*[@id=\"DataTables_wrapper\"]/div[2]/a[1]")
	WebElement eADownload;
	@FindBy(xpath = "//*[@id=\"14\"]/div/div[1]/div[3]/span/strong/a")
	WebElement eViewDetails;
	@FindBy(xpath = "//button[text()='Close']")
	WebElement eClose;
	@FindBy(xpath = "//div[@class='panel-heading']/button/following-sibling::*")
	WebElement eAnnounceDetailsVerify;
	@FindBy(xpath = "//div[@class='panel-heading']/h3[text()='Task Name Upload1                            ']")
	WebElement eTaskNameVerify;
	@FindBy(xpath="//body/div[8]/div")
	WebElement eTaskValidationMsgVerify;
	@FindBy(xpath="//div[8]/div")
	WebElement eAddNewValidationMsgVerify;
	@FindBy(xpath="//th[@class='col-xs-2 sorting']")
	WebElement eActivitiesViewVerify;
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
		js = (JavascriptExecutor) driver;
	}

	public void dashBoardClick() {
		waitToVisible(eDashBoard);
		click(eDashBoard);

	}

	public void verifyDashBoardText() {

		String expectedTitle = "Dashboard";
		String actualTitle = eDashText.getText();
		sa.assertEquals(actualTitle, expectedTitle);
		sa.assertAll();
	}

	public void paymentTaskMoreInfo() {
		click(eMoreInfoLink);

	}
	

	public void progressTaskMoreInfo() {
		click(eMoreInfoLinkPT);

	}

	public void overdueTask() {

		click(eOverdueTask);

	}

	public void viewTask() {

		click(eView);

	}

	public void statusChangeButton() {
		click(eStatusChangeBtn);

	}

	public void statusUpdate() throws InterruptedException {
		waitForLong();
		click(eStatusUpdated);

	}

	public void scrollDown() {
		waitToVisible(eAddNew);
		scrollDown(eAddNew);
	}

	public void addNew() {
		//waitToVisible(eAddNew);
		//click(eAddNew);
		js.executeScript("arguments[0].click();", eAddNew);

	}

	public void whatToDo(String value) throws InterruptedException {
		Thread.sleep(3000);

		js.executeScript("arguments[0].click();", eWhatToDo);
		act.moveToElement(eWhatToDo).click(eWhatToDo).sendKeys(eWhatToDo, value).build().perform();

	}

	public void statusUpdated() {
		click(eStatus);

	}

	public void dueDate(String value) {

		js.executeScript("arguments[0].click();", eDueDate);
		act.moveToElement(eDueDate).click(eDueDate).sendKeys(eDueDate, value).build().perform();
	}

	public void saveButton() {
		actionClick(eSaveButton);

	}

	public void activities() {
		click(eActivities);

	}

	public void download() {
		click(eADownload);

	}
	public void viewDetails() {
		waitToVisible(eViewDetails);
		click(eViewDetails);

	}
	public void closeButton() {
		
		waitToVisible(eClose );
		js.executeScript("arguments[0].click();",eClose);

	}
	public void announcementDetailsVerify()
	{
		
		String actualText="Announcements Details";
		String expectedText="Announcements Details";
		sa.assertEquals(actualText, expectedText,"Announcements Details page is  not present");
		sa.assertAll();
	}
	
	public void tasksNameVerify()
	{
		
		String actualText="Task Name Upload1";
		String expectedText="Task Name Upload1";
		sa.assertEquals(actualText, expectedText,"Announcements Details page is  not present");
		sa.assertAll();
	}
	public void validationMessageVerify()
	{
		String actualMsg=eTaskValidationMsgVerify.getText();
		String expectedMsg="Change Status";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
	public void addNewvalidationMessageVerify()
	{
		String actualMsg=eAddNewValidationMsgVerify.getText();
		String expectedMsg="Todo information successfully updated";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
	public void activitiesViewVerify()
	{
		String actualMsg=eActivitiesViewVerify.getText();
		String expectedMsg="Activity Date";
		sa.assertEquals(actualMsg, expectedMsg);
		sa.assertAll();
	}
	

}
