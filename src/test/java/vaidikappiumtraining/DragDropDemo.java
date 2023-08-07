package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest {
	
	@Test
	public void dragDrop () throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		dragDropAction(source, 624, 562);
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) source).getId(),
//			    "endX", 624,
//			    "endY", 562
//			));
		Thread.sleep(3000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		assertEquals(result, "Dropped!");
	}
	

}
