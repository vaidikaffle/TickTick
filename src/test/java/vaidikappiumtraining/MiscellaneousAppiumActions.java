package vaidikappiumtraining;
//Xpath, id, accessibilityId, classname, androidUIAutomator

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest{
	
	@Test
	public void WifiSettingsName() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Rotate device to LandScape mode
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//Fetching text
		String title =  driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(title, "WiFi settings");
		
		//Copy Paste - copy to clipboard - paste it clipboad
		driver.setClipboardText("Vaidik Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	}
}
