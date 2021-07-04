package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class PaymentPage extends PageUtility {
	WebDriver driver;
	SoftAssert sa;
	@FindBy(xpath = "//a[text()='Payments Received']")
	WebElement ePaymentRecieveText;
	@FindBy(xpath = "//a[text()='Payments Received']")
	WebElement ePaymentReceivedPageVerification;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	public void verfyPaymentReceiveText() {

		String expectedTitle = "Payments Received";
		String actualTitle = ePaymentRecieveText.getText();
		sa.assertEquals(actualTitle, expectedTitle);
		sa.assertAll();

	}
	public void paymentPageVerification()
	{
		String expectedTitle = "Payments Received";
		String actualTitle = ePaymentReceivedPageVerification.getText();
		sa.assertEquals(actualTitle, expectedTitle);
		sa.assertAll();
	}

}
