package vaidikappiumtraining;
//Xpath, id, accessibilityId, classname, androidUIAutomator

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasic extends BaseTest{
	
	@Test
	public void WifiSettingsName() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//Fetching text
		String title =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(title, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Vaidik Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		Thread.sleep(3000);
		
	}
}
