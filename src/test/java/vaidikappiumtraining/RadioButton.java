package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class RadioButton extends BaseTest{
	
	@Test
	public void radioButtonDemo() {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		String text =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(text, "Single choice list");
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[3]")).click();
		driver.findElement(By.id("android:id/button1")).click();
	}

}
