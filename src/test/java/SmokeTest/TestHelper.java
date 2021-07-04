package SmokeTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.BackupPage;
import pages.BugPage;
import pages.DashboardPage;
import pages.DraftMailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProjectPage;
import pages.SettingsPage;
import pages.TaskPage;
import pages.UserPage;
import utilities.ExcelUtility;

public class TestHelper
{
	WebDriver driver;
	LoginPage objLogPage;
	ExcelUtility excel;
	HomePage objHomePage;
	DraftMailPage objDraftMail;
	DashboardPage objDashBoard;
	TaskPage objTaskPage;
	PaymentPage objPaymentPage;
	BugPage objBugPage;
	ProjectPage objProjectPage;
	UserPage objUserPage;
	SettingsPage objSettingsPage;
	BackupPage objBackupPage;
	  @BeforeClass
	  public void beforeClass() 
	  {
		  System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sapta\\git\\Aussie_Time_SheetL\\drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://buffalocart.com/demo/erp/login");
		  objLogPage=new LoginPage(driver);
		  objHomePage=new HomePage(driver);
		  objDraftMail=new DraftMailPage(driver);
		  objDashBoard=new DashboardPage(driver);
		  objTaskPage=new TaskPage(driver);
		  objPaymentPage=new PaymentPage(driver);
		  objBugPage=new BugPage(driver);
		  objProjectPage=new ProjectPage(driver);
		  objUserPage=new UserPage(driver);
		  objSettingsPage=new SettingsPage(driver);
		  objBackupPage=new BackupPage(driver);
		 excel =new ExcelUtility("Sheet1");
	  }

	  @AfterClass
	  public void afterClass() 
	  {
		  //driver.quit();
	  }
	  
//*****************************************************DataProvider **********************************
	  @DataProvider(name = "ReadFromExcel")
		public Object[][] readData() throws IOException {
			FileInputStream fls = new FileInputStream(
					"C:\\Users\\sapta\\git\\Aussie_Time_SheetL\\src\\test\\resources\\TestDataL.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(fls);
			XSSFSheet sheet = book.getSheet("Sheet2");
			XSSFRow row = sheet.getRow(0);

			int r = sheet.getLastRowNum() + 1; 
			int c = row.getLastCellNum(); 
			System.out.println("r=" + r);
			System.out.println("c=" + c);

			String values[][] = new String[r][c];

			for (int i = 0; i < r; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < c; j++) {
					XSSFCell cell = row.getCell(j);
					DataFormatter formatter = new DataFormatter();
					values[i][j] = formatter.formatCellValue(cell);

				}
			}
			return values;

		}	


}
