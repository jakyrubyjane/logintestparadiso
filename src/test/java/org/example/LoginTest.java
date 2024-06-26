package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Navigate to login page
        driver.get("http://localhost:5173");
        loginPage = new LoginPage(driver);
    }

    @When("I enter the name {string}")
    public void iEnterTheName(String name) {
        loginPage.enterName(name);
    }

    @When("I enter the email {string}")
    public void iEnterTheEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("I enter the password {string}")
    public void iEnterThePassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void iShouldBeRedirectedToTheDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the URL changes to the expected dashboard URL
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/dashboard"));

        // Assert that the current URL matches the expected dashboard URL
        String expectedUrl = "http://localhost:5173/dashboard";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        // Wait until the title contains "Dashboard"
        wait.until(ExpectedConditions.urlContains("http://localhost:5173/dashboard"));

        // Assert that the page title contains "Dashboard"
        assertTrue(driver.getCurrentUrl().contains("http://localhost:5173/dashboard"));
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
