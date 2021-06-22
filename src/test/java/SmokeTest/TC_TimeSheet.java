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

	// @Test(priority = 0, description = "Login Verification Of Valid User admin")
	public void tc_1_2LoginVerificationAndSearch() throws Exception {

		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objLogPage.verifySuccessfulLogDashBoard();
		objHomePage.searchBox("Mailbox");
		objHomePage.mailBoxSearch();

	}

	// @Test(priority = 1, description = "Drafted Mail And File attachment")
	public void tc_3_5DraftMail() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objHomePage.mailBoxSearch();
		objDraftMail.draftMail();
		objDraftMail.enterToSub("abc@gmail.com");
		objDraftMail.toSub();
		objDraftMail.subject("Are we able to draft the compose mail");
		driver.switchTo().frame(0);
		objDraftMail.mainMessageBodyClick();
		objDraftMail.mainMessageBodyText("Are we Able to draft this mail?");
		driver.switchTo().defaultContent();
		objDraftMail.draftfunct();
		objDraftMail.waitForDraftToClick();
		objDraftMail.draftsClick();
		objDraftMail.darftVerify();
		objDraftMail.waitForFileAttach();
		objDraftMail.fileAttachmt();
		objDraftMail.sendfutn();
		objDraftMail.waitForLong();

	}

	// @Test(priority = 2, description = "Announcement Details")
	public void tc_6AnnouncementDetails() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.viewDetails();

	}

	// @Test(priority = 3, description = "Dashboard progress taskMoreInFoLinkClick")
	public void tc_7ProgressTask() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.verifyDashBoardText();
		objDashBoard.paymentTaskMoreInfo();
	}

	// @Test(priority = 5, description = "Verify OverDue Tasks")
	public void tc_8_10OverdueTask() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objDashBoard.overdueTask();
		objDashBoard.viewTask();
		objDashBoard.statusChangeButton();
		objDashBoard.statusUpdate();
	}

	// @Test(priority = 6, description = "Add New List")
	public void tc_9AddNewList() throws Exception {
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

	}

	// @Test(priority = 7, description = "Task Page-New Task Creation")
	public void tc_11_12NewTask() throws Exception {
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
		objTaskPage.bilLable();
		objTaskPage.assignTo();
		objTaskPage.saveButton();
		objTaskPage.viewTask();
	}

	// @Test(priority = 8, description = "View All Tasks")
	public void paymentSection() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objPaymentPage.verfyPaymentReceiveText();
	}

	// @Test(priority = 9, description = "import Tasks")
	public void tc_13_14_15AllTaskImport() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.importTask();
		objTaskPage.fileAttachment();
		objTaskPage.waitForLong();
		objTaskPage.taskStatus();
		objTaskPage.assignToCustom();
		objTaskPage.listsSelection();
		objTaskPage.waitForLong();
		objTaskPage.upload();
		objTaskPage.scrollDown();
		objTaskPage.taskSelection();
		objTaskPage.bulkDelete();
		objTaskPage.waitAlert();
		objTaskPage.alertHandle();
	}

	// @Test(priority = 10, description = "Edit Tasks")
	public void tc_16_17TaskEdition() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.progressTaskMoreInfo();
		objTaskPage.verifyIfTaskPageIsPresent();
		objTaskPage.scrollDown();
		objTaskPage.search();
		objTaskPage.searchSendkeys("faisa");
		objTaskPage.waitForLong();
		objTaskPage.taskEdit();
		objTaskPage.waitForLong();
		objTaskPage.hourlyRate("10");
		objTaskPage.taskUpdates();
		objTaskPage.exportReport();

	}

	// @Test(priority = 11, description = "Back up")
	public void tc_18VBackUpDatabase() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBackupPage.backUpMenu();
		objBackupPage.backupDatabase();

	}

	 //@Test(priority = 12, description = "New Bug Assignment")
	public void tc_19_20_21NewBugAssignment() throws Exception {
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
		objBugPage.editopportunity();
		objBugPage.addNewLink("http://buffalocart.com/demo/erp/admin/opportunities/opportunity_details/1#bugs");
		objBugPage.updatesButton();
		objBugPage.bugMainMenu();
		objBugPage.printIcon();

	}

	// @Test(priority = 13, description = "Download All Bugs")
	public void tc_22DownloadAllFiles() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.scroolDown();
		objBugPage.allBugXl();
		objBugPage.allBugCsv();
		objBugPage.allBugPdf();
	}

	// @Test(priority = 14, description = "Update the status")
	public void tc_23UpdateStatus() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.scroolDown();
		objBugPage.clearSearchBoxResult();
		objBugPage.searchBox("Drag and Drop");
		objBugPage.scroolDown();
		objBugPage.changeProgressStatusIcon();
		objBugPage.statusProgressUpdate();
		objBugPage.scroolDown();

	}

	// @Test(priority = 15, description = "Delete the bug")
	public void tc_24DeleteBug() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objBugPage.bugMenu();
		objBugPage.unConfirmed();
		objBugPage.scroolDown();
	}

	// @Test(priority = 16, description = "Add new client to the"project")
	public void tc_25AddNewClient() throws Exception {
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

	}

	// @Test(priority = 17, description = "Verification of User details")
	public void tc_26VerifyMyDetails() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.myDetails();
		objUserPage.scrollDown();
	}
	//@Test(priority = 18, description = "Update User Email details")
	public void tc_27UpdateEmailSDetails() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.scrollDown();
		objUserPage.passwordUpdate("123456");
		objUserPage.newEmailUpdate("abcde@gmail.com");
		objUserPage.changeEmailupdate();

	}

	//@Test(priority = 18, description = "Update User Email details",dataProvider = "ReadFromExcel")
	public void tc_27UpdateEmailSDetails(String email,String newemail) throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.scrollDown();
		objUserPage.passwordUpdate(email);
		objUserPage.newEmailUpdate(newemail);
		objUserPage.changeEmailupdate();

	}

	// @Test(priority = 19, description = "Update User details")
	public void tc_28updateUserDetails() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objUserPage.userMenu();
		objUserPage.imageIcon();
		objUserPage.updateDetails();
		objUserPage.phoneUpdate("6479965437");
		objUserPage.updateProfile();
	}

	// @Test(priority = 20, description = "Update company details")
	public void tc_29UpdateCompanyDetails() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objSettingsPage.settingsMenu();
		objSettingsPage.contactPersonUpdate("Hari");
		objSettingsPage.saveChanges();

	}

	// @Test(priority = 21, description = "Download All The Activities From Dashboard")
	public void tc_30DownloadActivities() throws Exception {
		objLogPage.enterUsername(excel.ReadData("username"));
		objLogPage.enterPassword(excel.ReadData("password"));
		objLogPage.signIn();
		objDashBoard.dashBoardClick();
		objUserPage.imageIcon();
		objDashBoard.activities();
		objDashBoard.download();

	}
}
