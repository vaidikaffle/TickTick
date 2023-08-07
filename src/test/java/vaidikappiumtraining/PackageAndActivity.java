package vaidikappiumtraining;
//Xpath, id, accessibilityId, classname, androidUIAutomator

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;


public class PackageAndActivity extends BaseTest{
	
	@SuppressWarnings("deprecation")
	@Test
	public void WifiSettingsNameWithPackage() throws MalformedURLException, InterruptedException
	{
		//adb shell dumpsys window | grep -E 'mCurrentFocus'
		//App Package and App Activity
		//Will directly open the desired activity screen.
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
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
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	
	}
}
