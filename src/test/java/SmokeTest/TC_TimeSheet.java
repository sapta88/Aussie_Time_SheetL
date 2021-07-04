package SmokeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_TimeSheet extends TestHelper {

	@Test(priority = 0, description = "Login Verification Of Valid User admin and Search")
	public void tc_1_2LoginVerificationAndSearch() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objLogPage.verifySuccessfulLogDashBoard();
		objHomePage.verifySearchMenu();
		objHomePage.searchBox("Mailbox");
		objHomePage.mailBoxSearch();

	}

	@Test(priority = 1, description = "Draft the Mail And File attachment")
	public void tc_3_5DraftMailAndFileAttach() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objHomePage.verifySearchMenu();
		objHomePage.mailBoxSearch();
		objDraftMail.verifyMailBoxPage();
		objDraftMail.draftMail();
		objDraftMail.enterToSub("abc@gmail.com");
		objDraftMail.toSub();
		objDraftMail.subject("Are we able to draft the compose mail.If not Please inform");
		driver.switchTo().frame(0);
		objDraftMail.mainMessageBodyClick();
		objDraftMail.mainMessageBodyText("Are we Able to draft this mail?");
		driver.switchTo().defaultContent();
		objDraftMail.draftfunct();
		objDraftMail.waitForDraftToClick();
		objDraftMail.draftsClick();
		objDraftMail.verifyDraftMail();
		objDraftMail.darftSubText();
		objDraftMail.scrool();
		objDraftMail.waitFor();
		objDraftMail.fileAttachmt();
		objDraftMail.waitFor();
		objDraftMail.fileUpload();
		objDraftMail.waitToClickSend();
		objDraftMail.sendfutn();
		objDraftMail.waitToBeVisible();
		objDraftMail.verifyMailSendNotification();

	}

	 @Test(priority = 2, description = "Announcement Details")
	public void tc_6AnnouncementDetails() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.viewDetails();
		objDashBoard.announcementDetailsVerify();
		objDashBoard.closeButton();

	}

	 @Test(priority = 3, description = "Dashboard payment received page")
	public void tc_7PaymentPage() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.verifyDashBoardText();
		objDashBoard.paymentTaskMoreInfo();
		objPaymentPage.paymentPageVerification();

	}

	@Test(priority = 5, description = "View OverDue Tasks and update the tasks from Dashboard TaskDetails")
	public void tc_8_10OverdueTaskAndUpdate() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.overdueTask();
		objDashBoard.viewTask();
		objDashBoard.tasksNameVerify();
		objDashBoard.statusChangeButton();
		objDashBoard.statusUpdate();
		objDashBoard.validationMessageVerify();
	}

	@Test(priority = 6, description = "Add New List from Dashboard ")
	public void tc_9AddNewList() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.scrollDown();
		objDashBoard.addNew();
		objDashBoard.whatToDo("Add new feature to Drag and drop the file in Compose Mail Mail Box Section");
		objDashBoard.statusUpdated();
		objDashBoard.dueDate("2021-07-10");
		objDashBoard.saveButton();
		objDashBoard.addNewvalidationMessageVerify();

	}

	 @Test(priority = 7, description = "Task Page-New Task Creation")
	public void tc_11_12NewTask() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.clickNewTask();
		objTaskPage.enterTaskName("faisa");
		objTaskPage.selectRelatedTo();
		objTaskPage.startDate("2021-06-01");
		objTaskPage.dueDate("2021-07-10");
		objTaskPage.hourlyRate("9");
		objTaskPage.taskHour("0.64");
		objTaskPage.checkBoxTaskHoursSelect();
		objTaskPage.taskStatusSelect();
		objTaskPage.taskDescription(
				"Verify whether the admin is able to assign the New Task from Dashboard In progress Task.");
		objTaskPage.billable();
		objTaskPage.assignTo();
		objTaskPage.saveButton();
		objTaskPage.viewTask();
		objTaskPage.taskNameVerify();
	}

	@Test(priority = 9, description = "import Tasks")
	public void tc_13_14TaskImport() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.importTask();
		objTaskPage.fileAttachment();
		objTaskPage.taskStatus();
		objTaskPage.assignToCustom();
		objTaskPage.listsSelection();
		objTaskPage.upload();

	}

	@Test(priority = 9, description = "Task Bulk delete ")
	public void tc_15BulkDelete() throws Exception {

		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.clickNewTask();
		objTaskPage.enterTaskName("faisa");
		objTaskPage.selectRelatedTo();
		objTaskPage.startDate("2021-06-01");
		objTaskPage.dueDate("2021-07-10");
		objTaskPage.hourlyRate("9");
		objTaskPage.taskHour("0.64");
		objTaskPage.checkBoxTaskHoursSelect();
		objTaskPage.taskStatusSelect();
		objTaskPage.taskDescription(
				"Verify whether the admin is able to assign the New Task from Dashboard In progress Task.");
		objTaskPage.billable();
		objTaskPage.assignTo();
		objTaskPage.saveButton();
		objTaskPage.windowMaximum();
		objTaskPage.taskLinkClick();
		objTaskPage.scrollDown();
		objTaskPage.taskSelection();
		objTaskPage.bulkDelete();
		objTaskPage.waitAlert();
		objTaskPage.alertHandle();
		objTaskPage.bulkDeleteVerify();
	}

	@Test(priority = 10, description = "Edit Tasks and Export report")
	public void tc_16_17TaskEdition() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.clickNewTask();
		objTaskPage.enterTaskName("faisa");
		objTaskPage.selectRelatedTo();
		objTaskPage.startDate("2021-06-01");
		objTaskPage.dueDate("2021-07-10");
		objTaskPage.hourlyRate("10");
		objTaskPage.taskHour("0.64");
		objTaskPage.checkBoxTaskHoursSelect();
		objTaskPage.taskStatusSelect();
		objTaskPage.taskDescription(
				"Verify whether the admin is able to assign the New Task from Dashboard In progress Task.");
		objTaskPage.billable();
		objTaskPage.assignTo();
		objTaskPage.saveButton();
		objTaskPage.windowMaximum();
		objTaskPage.taskLinkClick();
		objTaskPage.scrollDown();
		objTaskPage.search();
		objTaskPage.searchSendkeys("faisa");
		objTaskPage.taskEdit();
		objTaskPage.hourlyRate("8");
		objTaskPage.taskUpdates();
		objTaskPage.viewEditTask();
		objTaskPage.hourRateVerify();
		objTaskPage.exportReport();

	}

	 @Test(priority = 11, description = "Back up database")
	public void tc_18VBackUpDatabase() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBackupPage.backUpMenu();
		objBackupPage.backupDatabase();
		objBackupPage.backupVerify();

	}

	@Test(priority = 12, description = "New Bug Assignment & Edit the Bug and Printout")
	public void tc_19_20_21NewBugAssignment() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.newTask();
		objBugPage.bugTitle("Drag and Drop");
		objBugPage.relatedTo(2);
		objBugPage.reporter(1);
		objBugPage.priority(1);
		objBugPage.severity(2);
		objBugPage.description("user is unable to perform drag and drop");
		objBugPage.reproducibility("abc");
		objBugPage.bugStatus(2);
		objBugPage.save();
		objBugPage.bugAssignVerify();
		objBugPage.editopportunity();
		objBugPage.addNewLink("http://buffalocart.com/demo/erp/admin/opportunities/opportunity_details/1#bugs");
		objBugPage.updatesButton();
		objBugPage.updateSuccessVerify();
		objBugPage.bugMainMenu();
		objBugPage.printIcon();

	}

	@Test(priority = 13, description = "Download All Bugs")
	public void tc_22DownloadAllBug() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.scroolDown();
		objBugPage.allBugXl();
		objBugPage.allBugCsv();
		objBugPage.allBugPdf();
	}

	@Test(priority = 14, description = "Update the Bug status")
	public void tc_23UpdateBugStatus() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.newTask();
		objBugPage.bugTitle("Drag and Drop");
		objBugPage.relatedTo(2);
		objBugPage.reporter(1);
		objBugPage.priority(1);
		objBugPage.severity(2);
		objBugPage.description("user is unable to perform drag and drop");
		objBugPage.reproducibility("abc");
		objBugPage.bugStatus(2);
		objBugPage.save();
		objBugPage.bugMenu();
		objBugPage.scroolDown();
		objBugPage.clearSearchBoxResult();
		objBugPage.searchBox("Drag and Drop");
		objBugPage.scroolDown();
		objBugPage.changeProgressStatusIcon();
		objBugPage.statusProgressUpdate();
		objBugPage.clearSearchBoxResult();
		objBugPage.searchBox("Drag and Drop");
		objBugPage.statusUpdateVerify();
		

	}

	@Test(priority = 15, description = "Delete the bug")
	public void tc_24DeleteBug() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.scroolDown();
		objBugPage.deleteBug();
		objBugPage.deleteAlertHandle();
		objBugPage.deleteVerify();
	}

	@Test(priority = 16, description = "Add new client to the project")
	public void tc_25AddNewClient() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objProjectPage.projectMenu();
		objProjectPage.newProject();
		objProjectPage.projectName("Aussie Time Sheet");
		objProjectPage.newClient();
		objProjectPage.companyName("Caxita Solutions Private Limited");
		objProjectPage.companyEmail("abc@gmail.com");
		objProjectPage.shortNote("abc");
		objProjectPage.save();
		objProjectPage.clientVerify();
		

	}

	 @Test(priority = 17, description = "View User details")
	public void tc_26VerifyMyDetails() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.myDetails();
		objUserPage.scrollDown();
	}

	 @Test(priority = 18, description = "Update Profile")
	public void tc_27UpdateProfile() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.scrollDown();


	}

	 @Test(priority = 18, description = "Update User Email details",dataProvider="ReadFromExcel")
	public void tc_27UpdateEmailSDetails(String newPassword,String newEmail) throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.scrollDown();
		objUserPage.passwordUpdate(newPassword);
		objUserPage.newEmailUpdate(newEmail);
		objUserPage.changeEmailupdate();

	}

	@Test(priority = 19, description = "Update User details")
	public void tc_28updateUserDetails() throws Exception {
		 objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.phoneUpdate("6479965437");
		objUserPage.updateProfile();
		objUserPage.profileUpdateVerify();
	}

@Test(priority = 20, description = "Update company details")
	public void tc_29UpdateCompanyDetails() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objSettingsPage.settingsMenu();
		objSettingsPage.contactPersonUpdate("Hari");
		objSettingsPage.saveChanges();
		objSettingsPage.saveVerify();

	}

	@Test(priority = 21, description = "View All The Activities From Dashboard")
	public void tc_30ViewActivities() throws Exception {
		objLogPage.waitForVisibility();
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objUserPage.imageIcon();
		objDashBoard.activities();
		objDashBoard.activitiesViewVerify();
		

	}
}
