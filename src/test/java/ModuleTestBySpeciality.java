import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModuleTestBySpeciality {

	WebDriver driver = null;

	@BeforeClass
	public void setupTest() {

		// Setting up Chrome driver through web driver manager

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// Fetching the URL

		driver.get("https://www.mountsinai.org/appointment");

		// Maximizing the window for better look and feel

		driver.manage().window().maximize();

	}

	/*
	 * Testing the right text on the home page
	 */
	@Test(priority = 0)
	public void testhomepage() {

		
		WebElement registertext = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div/div/section/div[1]/ul[2]/li/a"));

		// check whether request an appointment text is present on the screen
		Assert.assertEquals(registertext.getText(), "Request an Appointment");
	}

	/*
	 * Testing appointment registration by both name and speciality
	 */
	@Test(priority = 1)
	public void testsubmitBynamebyspeciality() throws InterruptedException {
		// Apply time wait for 4 seconds for elements to be loaded on the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.findElement(By.xpath("//*[@id=\"tab-tab-request-an-appointment\"]/section/form[1]/div[1]/input"))
				.sendKeys("John Grisham");
		
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[1]/div/div/div/div/section/div[2]/div/section/form[2]/div[1]/div[1]/select/option[10]"))
				.click();
		
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[1]/div/div/div/div/section/div[2]/div/section/form[2]/div[1]/div[2]"))
				.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		// on the next screen checking whether the selected value from the dropdown is displayed
		WebElement text = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[1]/div/p/strong"));
		Assert.assertEquals(text.getText(), "Dentistry");

	}
/*
 *  Testing a scenario where the submit button is disabled when input fields are blank
 */
	@Test(priority = 2)

	
	public void testsubmitbuttonisdisabledwithblankvalues() {
		WebElement submit = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/div/div/section/button"));
		Assert.assertFalse(submit.isEnabled());

	}
/*
 * Entering the values of the patient information 
 */
	
	@Test(priority = 3)

	

	public void testpatientmandatoryfields() throws InterruptedException {

	
		WebElement firstname = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[1]/div[1]/input"));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		

		firstname.sendKeys("Robert");

	
		WebElement lastname = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[1]/div[2]/input"));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		lastname.sendKeys("Watson");
		
		WebElement addressline1 = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[2]/div[1]/input"));
	
		addressline1.sendKeys("Douwe Egberts street");
		
		WebElement city = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[3]/div[1]/input"));
		
		city.sendKeys("Charlotte");
		
		WebElement state = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[3]/div[2]/select/option[45]"));
		
		state.click();
		
		WebElement phone = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[4]/div[1]/input"));
		
		phone.sendKeys("5551234567");
		
		WebElement email = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[4]/div[2]/input"));
		
		email.sendKeys("robert.watson@gmail.com");
		
		WebElement dateofbirth = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[5]/div[1]/input"));
		
		dateofbirth.sendKeys("07/16/1977");
	
		WebElement contacttime = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[2]/div[6]/div[2]/select/option[3]"));
		
		contacttime.click();
	}
	/*
	 * Filling the values for the appointment information
	 */

	@Test(priority = 4)

	

	public void testappointmentmandatoryfields() {
		

		WebElement existingpatientradiobutton = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[3]/div[1]/label[3]"));
		
		existingpatientradiobutton.click();
		
		WebElement preferredphysiciangender = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[3]/div[2]/label[4]"));
		
		preferredphysiciangender.click();
		
		WebElement physicianlanguage = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[3]/div[3]/div[2]/select/option[1]"));
		
		physicianlanguage.click();
		
		WebElement healthinsurance = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[3]/div[5]/div/select/option[29]"));
		
		healthinsurance.click();
		
		WebElement zipcode = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/fieldset[3]/div[6]/div[2]/input"));
		
		zipcode.sendKeys("52322");
		
		WebElement submit = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/div/div/section/button"));
				Assert.assertTrue(submit.isEnabled());
		submit.click();
	
		WebElement receivedrequest = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/section/div/div[1]/div/div/div/div/div/div/div/h1"));
		
		Assert.assertTrue(receivedrequest.isDisplayed());
		
	}
	@AfterClass
	public void quitthebrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.quit();
	}
}
