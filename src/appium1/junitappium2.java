package appium1;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class junitappium2 {
	
	private static AndroidDriver driver;
	
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
	public void test_2(){
		
		WebElement AllowButton = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		assertEquals("Allow", AllowButton.getText());
		AllowButton.click();
		

		WebElement Continue = driver.findElement(By.name("Continue"));
		assertTrue(Continue.isDisplayed());
		Continue.click();

		WebElement Log_In = driver.findElement(By.id("com.groupon:id/done"));
		assertEquals("Sign In / Sign Up", Log_In.getText());
		Log_In.click();
		
		WebElement User_name = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email"));
		assertNotNull(User_name);
		User_name.sendKeys("razormantis112@gmail.com");

		WebElement Password = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password"));
		assertTrue(Password.isEnabled());
		assertNotNull(Password);
		Password.sendKeys("SpiggyHoles");
		
		WebElement Log_In_Groupon = driver.findElement(By.name("Log in with Groupon"));
		assertNotNull(Log_In_Groupon);
		Log_In_Groupon.click();

		WebElement Restaurants = driver.findElement(By.name("Restaurants"));
		assertTrue(Restaurants.isDisplayed() && Restaurants.isEnabled());
		Restaurants.click();
		System.out.println(Restaurants.getText());

		WebElement Restaurant_Deal = driver.findElement(By.name("Up to 46% Off Pizzeria Fare at 4th St. Pizza Co."));
		assertTrue(Restaurant_Deal.isDisplayed());
		assertNotNull(Restaurant_Deal);
		Restaurant_Deal.click();
		
		WebElement Buy_Button = driver.findElement(By.id("com.groupon:id/buy_button"));
		assertEquals("Buy!", Buy_Button.getText());
		Buy_Button.click();

		WebElement Navigate_Up = driver.findElement(MobileBy.AccessibilityId("Navigate up"));
		assertNotNull(Navigate_Up);
		assertTrue(Navigate_Up.isDisplayed()!=false);
		Navigate_Up.click();
		Navigate_Up.click();
		Navigate_Up.click();
	}

}
