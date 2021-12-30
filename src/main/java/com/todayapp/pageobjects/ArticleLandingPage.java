package com.todayapp.pageobjects;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

public class ArticleLandingPage extends DriverFactory{
	
	
	
	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	
	public By article = By
			.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_image']");
	
	public By btn_back = By.xpath("//android.widget.TextView[@resource-id='com.sg.mc.android.itoday:id/iv_back']");
	
	public By btn_share = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_share']");
	public By btn_textResize = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_text_resize']");
	
	
	public void clickArticle() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(article).click();

	}
	
	public void clickBackButton() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(btn_back).click();

	}

	public void verifyNavBar() throws InterruptedException {

		Thread.sleep(2000);

		try {
			softassert.assertTrue(driver.findElement(btn_back).isEnabled());
			softassert.assertTrue(driver.findElement(btn_share).isEnabled());
			softassert.assertTrue(driver.findElement(btn_textResize).isEnabled());
		
		} catch (Exception e) {
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}

	}

}
