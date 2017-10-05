package appium1;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class junitappium1 {
	
	// create global variable
	private static AndroidDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Specify the device name
		capabilities.setCapability("deviceName", "FA49RY901596");

		// Platform version
		capabilities.setCapability("platformVersion", "6.0.0");

		// platform name
		capabilities.setCapability("platformName", "Android");

		// specify the application package that we copied from appium
		capabilities.setCapability("appPackage", "com.groupon");

		// specify the application activity that we copied from appium
		capabilities.setCapability("appActivity", "com.groupon.home.main.activities.Carousel");

		// Start android driver I used 4727 port by default it will be 4723
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//Specify the implicit wait of 5 second
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		//close the application
		driver.quit();
	}

	@Test
	public void test_1() {
		
		WebElement AllowButton = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		assertFalse(AllowButton.getText()==null);
		assertEquals("Allow", AllowButton.getText());
		AllowButton.click();
		

		WebElement Continue = driver.findElement(By.name("Continue"));
		assertTrue(Continue.isDisplayed());
		assertNotNull(Continue);
		Continue.click();
		
		WebElement Just_Deals = driver.findElement(By.name("Just show me the deals"));
		assertNotNull(Just_Deals);
		assertTrue(Just_Deals.isDisplayed());
		assertTrue(Just_Deals.isEnabled());
		Just_Deals.click();
				
		WebElement GlobalSearchButton = driver.findElement(By.id("com.groupon:id/global_search_button_text"));
		assertEquals("Search Groupon", GlobalSearchButton.getText());
		GlobalSearchButton.click();

		WebElement SearchEditText = driver.findElement(By.id("com.groupon:id/search_edittext"));
		assertFalse(SearchEditText.isSelected());
		SearchEditText.sendKeys("Mouse");
		assertEquals("Mouse", SearchEditText.getText());

		
		WebElement SuggestedSearchItem = driver.findElement(By.id("com.groupon:id/suggested_search_item"));
		assertTrue(SuggestedSearchItem.getText()!=null);
		assertTrue(SuggestedSearchItem.getText().contains("mou"));
		SuggestedSearchItem.click();
		
		WebElement DealImage = driver.findElement(By.id("com.groupon:id/deal_image"));
		assertTrue(DealImage.isDisplayed());
		DealImage.click();

		WebElement Option_Image = driver.findElement(By.id("com.groupon:id/option_image"));
		assertFalse(Option_Image.isSelected());
		assertTrue(Option_Image.isEnabled());
		Option_Image.click();

		WebElement Buy_Button = driver.findElement(By.id("com.groupon:id/buy_button"));
		assertEquals("Buy!", Buy_Button.getText());
		Buy_Button.click();

		WebElement User_name = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email"));
		assertEquals("E-mail", User_name.getText());
		User_name.sendKeys("razormantis112@gmail.com");
		assertNotNull(User_name);
		
		WebElement Password = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password"));
		assertTrue(Password.isEnabled());
		assertNotNull(Password);
		Password.sendKeys("SpiggyHoles");
		assertNotNull(Password);
		
		WebElement Log_In_Groupon = driver.findElement(By.name("Log in with Groupon"));
		assertTrue(Log_In_Groupon.isEnabled());
		assertNotNull(Log_In_Groupon);
		Log_In_Groupon.click();
		
	}
	

}
