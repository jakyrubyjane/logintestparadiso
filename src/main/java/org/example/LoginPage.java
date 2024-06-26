package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By nameField = By.xpath("/html/body/div/div/main/div/div/div/form/label[1]/input");
    By emailField = By.xpath("/html/body/div/div/main/div/div/div/form/label[2]/input");

    By passwordField = By.xpath("/html/body/div/div/main/div/div/div/form/label[3]/input");
    By loginButton = By.xpath("/html/body/div/div/main/div/div/div/form/div[2]/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}

