package exampleHooks;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
//	@Before
//	public void setup() {
//
//		System.out.println("Before senario----");
//	}
//
//	@After
//	public void tearDown() {
//		System.out.println("After scenario----");
//		if (driver != null) {
//			captureScreenshot("test-failure.png"); // Screenshot BEFORE quitting
//			driver.quit();
//			driver = null; // Reset driver instance to avoid stale session issues
//		}
//	}
//
//	public void captureScreenshot(String filename) {
//		if (driver == null) {
//			System.out.println("Skipped screenshot: WebDriver is already closed.");
//			return;
//		}
//
//		try {
//			// Get the project root directory dynamically
//			String projectRoot = System.getProperty("user.dir");
//			File screenshotDir = new File(projectRoot, "screenshots"); // Creates inside project folder
//
//			// Ensure 'screenshots' directory exists inside the project root
//			if (!screenshotDir.exists()) {
//				boolean created = screenshotDir.mkdir();
//				if (created) {
//					System.out.println("Created 'screenshots' directory inside the project root.");
//				} else {
//					System.out.println("Failed to create 'screenshots' directory.");
//					return; // Stop execution if directory creation fails
//				}
//			}
//
//			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(screenshot, new File(screenshotDir, filename));
//			System.out.println("Screenshot saved at: " + new File(screenshotDir, filename).getAbsolutePath());
//		} catch (Exception e) {
//			System.out.println("Failed to capture screenshot: " + e.getMessage());
//		}
//	driver.quit();
//	}

}
