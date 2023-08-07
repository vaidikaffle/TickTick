package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DialogWithMessage extends BaseTest{
	
	@Test(priority = 1)
	public void dialogDemo() {
	
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		String text =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(text, "Lorem ipsum dolor sit aie consectetur adipiscing...");
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	
	@Test(priority = 2)
	public void dialogWithLongMessage() {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		String text =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(text, "Header title");
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	
	@Test
	public void UltraLongMessage() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		String text =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(text, "Header title");
		scrollToEndAction();
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}


















