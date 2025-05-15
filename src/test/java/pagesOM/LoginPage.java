package pagesOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	 // Locators using PageFactory
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    @FindBy(css = "[class*='error-message-container']")
    private WebElement errorMessageContainer;
    
//    @FindBy(css = ".error-message-container.error")
//    private WebElement errorMessageContainer;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Explicit wait
        PageFactory.initElements(driver, this); // Initializing PageFactory elements
    }

    // Page Actions(Methods)
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isUserRedirected() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl); // Prints the URL
        return currentUrl.contains("inventory.html");
    }
    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageContainer));
        return errorMessageContainer.isDisplayed();
    }
    }

	
	

