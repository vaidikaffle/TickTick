package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class RepeatAlarmCheckBox extends BaseTest{
	
	@Test
	public void alarmCheckBox() {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		String text =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(text, "Repeat alarm");
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[1]")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}
