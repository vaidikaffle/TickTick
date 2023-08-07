package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {
	
	@Test
	public void  FillForm() throws InterruptedException {
	
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaidik Soni");
//		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Handling toast messages
//		String ToastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		assertEquals(ToastMessage, "Please enter your name");
		Thread.sleep(3000);
		}
}