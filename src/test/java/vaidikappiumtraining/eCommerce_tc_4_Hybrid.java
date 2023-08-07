package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.functions.ExpectedCondition;

public class eCommerce_tc_4_Hybrid extends BaseTest{
	
	@Test
	public void validateHybridApp() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaidik Soni");
//		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//I again gave the same index value because after selecting the above product there is only one product on the screen available
		//Selects second product in the list.
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//Or
//		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();		
		Thread.sleep(5000);
		
		//Explicit wait to check if user is redirect to the Cart page
		//Verify the title of the Cart page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		//Sum of product prices
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double TotalSum = 0;
		
		for(int i = 0; i< count; i++) {
			String amountString = productPrices.get(i).getText();
			Double price = Double.parseDouble(amountString.substring(1));
			TotalSum = TotalSum + price;
		}
		
		//Total sum displayed at the Cart
		String displayAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum =  getFormattedAmount(displayAmount);
		assertEquals(TotalSum, displayFormattedSum);
		
		//Long press on Terms & Conditions
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		//Find the Contexts Handles available for the application
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts) {
			System.out.println(contextName);
		}
		//Select the WebView context to get access of webElements
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		//After redirecting back to the Native app change the context again.
		driver.context("NATIVE_APP");
	}

}
