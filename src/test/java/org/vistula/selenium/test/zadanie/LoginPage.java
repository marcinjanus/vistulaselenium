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
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyIsLoaded() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");
    }

    public void login( String emailText, String passwordText) {
        email.sendKeys(emailText);
        password.sendKeys(passwordText);
        login.click();
    }
}
