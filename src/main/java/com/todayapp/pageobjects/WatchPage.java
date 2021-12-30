package com.todayapp.pageobjects;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

public class WatchPage extends DriverFactory {

	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	public By btn_watch = By
			.xpath("//android.widget.TextView[@text='Watch']");
	public By btn_menu = By.xpath("(//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_icon'])[4]");
	public By watchText = By
			.xpath("(//android.widget.TextView[@resource-id='com.sg.mc.android.itoday:id/tv_title'])[1]");

	public void clickWatchButton() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(btn_watch).click();

	}

	public void clickMenu() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(btn_menu).click();

	}

	public void watchLandingScreen() throws InterruptedException {

		Thread.sleep(2000);

		try {
			String actual = driver.findElement(watchText).getText();
			softassert.assertEquals(actual, "Watch");
		} catch (Exception e) {
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}

	}

}
