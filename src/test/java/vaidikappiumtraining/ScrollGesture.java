package vaidikappiumtraining;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollGesture extends BaseTest {
	
	@Test
	public void scrollGestureDemo() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Where to scroll is known prior
		WebElement webView = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		webView.click();
		//When we have no prior idea.
//		scrollToEndAction();
		
		
		Thread.sleep(2000);
	}

}
