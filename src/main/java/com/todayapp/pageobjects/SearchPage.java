package com.todayapp.pageobjects;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

public class SearchPage extends DriverFactory {

	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	public By btn_search = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_search']");
	public By searchPlaceHolder = By.xpath("//android.widget.EditText[@text='Search keywords or topics']");
	public By btn_close = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_close']");
			

	public void clickSearch() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(btn_search).click();

	}

	public void verifySearchPlaceHolder() throws InterruptedException {

		Thread.sleep(2000);
		
		try {
		String actual = driver.findElement(searchPlaceHolder).getText();
		softassert.assertEquals(actual, "Search keywords or topics");
		}catch(Exception e){
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}
	}
	
	
	public void clickClose() {
		
		
		driver.findElement(btn_close).click();
	}

}
