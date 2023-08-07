package vaidikappiumtraining;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// Code to start the server
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.usingDriverExecutable(new File("//usr//local//bin//node"))
//				.withIPAddress("127.0.0.1")
//				.usingPort(4723)
//				.build();
//		service.start();

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		//For hybrid apps
		options.setChromedriverExecutable("//home//vaidiksoni//Documents//ChromeDriver//chromedriver");
		options.setDeviceName("Pixel 2 API 28");
		options.setCapability("browserName", "Chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		// Stop the server
		driver.quit();
//		service.stop();
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	
	
	
}
