package vaidikappiumtraining;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

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

		// Appium Code -> Appium Server -> Mobile
		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		//For hybrid apps
		options.setChromedriverExecutable("//home//vaidiksoni//Documents//ChromeDriver//chromedriver");
		options.setDeviceName("Pixel 2 API 28");
//		options.setApp(
//				"//home//vaidiksoni//eclipse-workspace//AppiumTraining//src//test//java//resources/ApiDemos-debug.apk");
		options.setApp(
				"//home//vaidiksoni//eclipse-workspace//AppiumTraining//src//test//java//resources/General-Store.apk");

		// AndroidDriver , IOSDriver
		// 127.0.0.1 - local
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		// Stop the server
		driver.quit();
//		service.stop();
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	

	//When we have no prior idea.
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	
	public void swipeAction (WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragDropAction(WebElement ele, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", endX,
			    "endY", endY
			));
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	
	
	
}
