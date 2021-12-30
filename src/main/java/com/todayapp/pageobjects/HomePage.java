package com.todayapp.pageobjects;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

import com.cucumber.listener.Reporter;
import com.todayapp.utilities.DriverUtilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends DriverFactory {

	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.channelnewsasia:id/toolbar']")
	protected AndroidElement menu_top;

	// @CacheLookup
	// @AndroidFindBy(id = "com.channelnewsasia:id/iv_logo")
	// private AndroidElement img_logo;

	// @CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.channelnewsasia:id/tv_name' and @text='HOME']")
	protected AndroidElement btn_home;

	// @AndroidFindBy(id = "com.channelnewsasia:id/tv_time")
	// protected AndroidElement btn_search;

	@CacheLookup
	@FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='com.channelnewsasia:id/tab_layout']")
	public AndroidElement menu_bottom;

	// @AndroidFindBy(id = "com.channelnewsasia:id/iv_setting")
	// @AndroidFindBy(xpath =
	// "//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_setting']")
	// public AndroidElement btn_settings;

	public By btn_settings = By
			.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_setting']");
	public By btn_search = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_search']");
	public By img_logo = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_logo']");

	public By image = By.xpath("//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_image']");
	public By news_article = By
			.xpath("(//android.widget.TextView[@resource-id='com.sg.mc.android.itoday:id/tv_title'])[1]");
	public By threedots_button = By
			.xpath("(//android.widget.ImageView[@resource-id='com.sg.mc.android.itoday:id/iv_options'])[1]");
	public By share_button = By.xpath("//android.widget.TextView[@resource-id='com.sg.mc.android.itoday:id/tv_share']");
	public By textShare = By.xpath("//android.widget.TextView[@text='Share']");

	public By minuteButton = By.xpath("//android.widget.TextView[@respurce-id='MINUTE']");
	public By minuteHighlightedText = By.xpath("//android.widget.TextView[@text='MINUTE' and @selected = 'true']");
	public By searchButton = By
			.xpath("//android.widget.ImageView[@resource-id='com.channelnewsasia.mcbeta:id/iv_search']");
	public By searchBox = By.xpath("//android.widget.EditText[@resource-id='com.channelnewsasia.mcbeta:id/et_search']");
	public By searchSuggestion = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_suggestion']");
	public By searchErrorMessage = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_content']");

	public void clickMinuteMenu() throws Throwable {

		Thread.sleep(4000);

		String platform = System.getProperty("platform");

		try {

			if (platform.equals("Android")) {

				DriverUtilities.click(minuteButton);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.click(minuteButton);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}
	}

	public void verifyHomePageIsDisplayed() throws InterruptedException {
		// Assert.assertTrue(menu_top.isDisplayed());
		// Assert.assertTrue(img_logo.isDisplayed());
		// Assert.assertTrue(btn_search.isDisplayed());
		try {
			Assert.assertTrue(driver.findElement(btn_settings).isEnabled());
			Assert.assertTrue(driver.findElement(btn_search).isEnabled());
			Assert.assertTrue(driver.findElement(img_logo).isEnabled());
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();

		}

		// driver.findElement(btn_settings).click();
		// btn_settings.click();
		// Assert.assertTrue(btn_settings.isDisplayed());
		// Assert.assertTrue(menu_top.isDisplayed());
		// Assert.assertTrue(menu_top.isDisplayed());
		// assertVisibility(menu_top);
		// assertVisibility(img_logo);
		// assertVisibility(btn_search);
		// assertVisibility(btn_settings);

		// verify bottom menu
		// assertVisibility(menu_bottom);
		// assertVisibility(btn_home);
		// assertVisibility(btn_discover);
		// assertVisibility(btn_menu);
		// assertVisibility(btn_watch);
		// assertVisibility(btn_myfeed);

	}

	public void navigateToNewsArticle() {
		TouchAction action = new TouchAction(driver);

		action.longPress(driver.findElement(image)).moveTo(driver.findElement(news_article)).release().perform();

	}

	public void clickThreeDOts() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(threedots_button).click();

	}

	public void verifyShareButtonIsVisible() throws InterruptedException {

		Thread.sleep(2000);
		try {
			boolean sharebutton = driver.findElement(share_button).isEnabled();
			Assert.assertTrue(sharebutton);
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}

	}

	public void clickShareButton() throws InterruptedException {

		Thread.sleep(5000);

		try {
			driver.findElement(share_button).click();
		}catch(NoSuchElementException e) {
			driver.findElement(share_button).click();
		}

	}

	public void verfyShareButtonIsFunctional() throws InterruptedException {
		try {
			Thread.sleep(5000);
			boolean sharePresence = driver.findElement(textShare).isEnabled();
			Assert.assertTrue(sharePresence);
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}

	}

	public boolean verifyMinuteMenuIsHighlighted() throws Throwable {

		String platform = System.getProperty("platform");

		boolean menuItemPresence = false;

		try {

			if (platform.equals("Android")) {

				menuItemPresence = driver.findElement(minuteHighlightedText).isDisplayed();
			} else {
				menuItemPresence = driver.findElement(minuteHighlightedText).isDisplayed();
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to capture the element ");
			hooks.addScreenshot();

		}
		return menuItemPresence;

	}

	public void clickSearchButton() throws Throwable {

		String platform = System.getProperty("platform");

		try {
			Thread.sleep(6000);

			if (platform.equals("Android")) {

				DriverUtilities.click(searchButton);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.click(searchButton);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}
	}

	public void enterSearchText(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		try {

			if (platform.equals("Android")) {

				DriverUtilities.enterText(searchBox, searchText);
				driver.getKeyboard().pressKey(platform);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.enterText(searchBox, searchText);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}

	}

	public void verifySearchResults(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		if (platform.equals("Android")) {
			DriverUtilities.click(searchSuggestion);

			ArrayList<String> searchresults = new ArrayList<String>();

			List<WebElement> searchresultelements = new ArrayList<WebElement>();

			searchresultelements = driver.findElements(
					By.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_title']"));

			for (WebElement ele : searchresultelements) {

				searchresults.add(ele.getText());

			}

			for (String s : searchresults) {
				if (s.contains(searchText)) {
					Reporter.addStepLog("Search result contains " + searchText);
				} else {
					softassert.assertEquals(true, false);
					Reporter.addStepLog("Search result dont contain  " + searchText);
					hooks.addScreenshot();
				}
			}

		}

	}

	public void verifyErrorMessage(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		if (platform.equals("Android")) {

			String errorMessage = "Sorry, we can't find any results for '" + searchText
					+ "' with the selected filters. "
					+ "Please try again by refining your keyword(s) or applying different filters. Alternatively you might "
					+ "want to check out these top stories:";

			String actualErrorMessage = DriverUtilities.getText(searchErrorMessage);

			if (actualErrorMessage.equals(errorMessage)) {
				Reporter.addStepLog("Search Error message is validated " + errorMessage);
			} else {
				softassert.assertEquals(errorMessage, actualErrorMessage);
				Reporter.addStepLog("Search error message is not validated    " + errorMessage);
				hooks.addScreenshot();
			}
		}

	}

}
