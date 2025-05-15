package stepsDef;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagesOM.LoginPage;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setup() {

		System.out.println("Before senario----");
	}

	@After
	public void tearDown() {
		System.out.println("After scenario----");
		if (driver != null) {
			captureScreenshot("test-failure.png"); // Screenshot BEFORE quitting
			driver.quit();
		}
	}

	public void captureScreenshot(String filename) {
		if (driver == null) {
			System.out.println("Skipped screenshot: WebDriver is already closed.");
			return;
		}

		try {
			// Get the project root directory dynamically
			String projectRoot = System.getProperty("user.dir");
			File screenshotDir = new File(projectRoot, "screenshots"); // Creates inside project folder

			// Ensure 'screenshots' directory exists inside the project root
			if (!screenshotDir.exists()) {
				boolean created = screenshotDir.mkdir();
				if (created) {
					System.out.println("Created 'screenshots' directory inside the project root.");
				} else {
					System.out.println("Failed to create 'screenshots' directory.");
					return; // Stop execution if directory creation fails
				}
			}

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(screenshotDir, filename));
			System.out.println("Screenshot saved at: " + new File(screenshotDir, filename).getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}

	@Given("the user is on the SauceDemo login page")
	public void the_user_is_on_the_sauce_demo_login_page() throws Exception {
		System.out.println("Setting up WebDriver before scenario");
		WebDriverManager.chromedriver().setup(); // Auto-downloads WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");

		loginPage = new LoginPage(driver); // Initialize Page Object
	}

	@When("the user enters a valid {string} and {string}")
	public void the_user_enters_a_valid_credentials(String username, String password) throws Exception {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

	}

	@When("the user enters an invalid {string} or {string}")
	public void the_user_enters_an_invalid_or(String username, String password2) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password2);
		// loginPage.clickLogin();
	}

	@And("clicks the login button")
	public void clicks_the_login_button() {
		loginPage.clickLogin();
	}

	@And("the user should be redirected to the product_page")
	public void the_user_should_be_redirected_to_the() {
		if (loginPage.isUserRedirected()) {
			System.out.println("Test passed: Redirected to inventory page");
		} else {
			System.out.println("Test failed: Expected inventory page but found " + driver.getCurrentUrl());
		}

		// driver.quit();
	}

	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() {
		// Ideally, the LoginPage class should contain a method to check error messages
		System.out.println("Login failed, an error message should be displayed.");
		// driver.quit();
	}
}
