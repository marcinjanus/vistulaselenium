package org.vistula.selenium.test.zadanie;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPanelAddProjectPage {
    private WebDriver driver;

    @FindBy (css = "input#name")
    private WebElement titleInput;
    @FindBy (id = "prefix")
    private WebElement prefixInput;
    @FindBy (id = "description")
    private WebElement descriptionInput;
    @FindBy (id = "save")
    private WebElement saveButton;

    public AdminPanelAddProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyAddProjectPageIsLoaded() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("content_title")));

        Assertions.assertThat(driver.getTitle()).contains("Dodaj projekt");
    }

    public void addProject(String randomName, String randomPrefix, String randomDescription) {
        titleInput.sendKeys(randomName);
        prefixInput.sendKeys(randomPrefix);
        descriptionInput.sendKeys(randomDescription);
        saveButton.click();
    }
}
