package org.vistula.selenium.test.zadanie;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageIsLoaded() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("login")));

        Assertions.assertThat(loginButton.isDisplayed());
    }

    public void loginAsAdmin( String emailText, String passwordText) {
        emailInput.sendKeys(emailText);
        passwordInput.sendKeys(passwordText);
        loginButton.click();
    }
}
