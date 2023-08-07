package vaidikappiumtraining;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void browserTest() {
		
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
		//To scroll on mobile browser
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		assertEquals(text, "Devops");
	}
}
