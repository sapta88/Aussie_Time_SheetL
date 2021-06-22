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
	@FindBy(xpath = "//a[@title][@href='http://buffalocart.com/demo/erp/admin/dashboard']")
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
	@FindBy(xpath = "//*[@id=\"task_details\"]/div/div[2]/div[1]/div[2]/div/button/following-sibling::ul/li[5]")
	WebElement eStatusUpdated;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/dashboard/new_todo']")
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
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
		js = (JavascriptExecutor) driver;
	}

	public void dashBoardClick() {
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

	public void statusUpdate() {
		click(eStatusUpdated);

	}

	public void scrollDown() {
		
		scrollDown(eAddNew);
	}

	public void addNew() {
		click(eAddNew);

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
		click(eViewDetails);

	}
	public void closeButton() {
		click(eClose);

	}
	
	

}
