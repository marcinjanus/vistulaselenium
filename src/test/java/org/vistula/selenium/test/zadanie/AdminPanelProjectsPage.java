package org.vistula.selenium.test.zadanie;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPanelProjectsPage {

    private WebDriver driver;

    @FindBy (className = "button_link")
    private WebElement newProjectButton;
    @FindBy (id = "search")
    private WebElement searchInput;
    @FindBy (id = "j_searchButton")
    private WebElement searchButton;

    public AdminPanelProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyProjectsPageIsLoaded() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("content_title")));

        Assertions.assertThat(driver.getTitle()).contains("Projekty");
    }

    public void clickAddProject() {
        newProjectButton.click();
    }

    public void inputAndSearchProjectName(String randomName) {
        searchInput.sendKeys(randomName);
        searchButton.click();
    }

    public void waitForSearchResults() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table")));
    }

    public void verifyProjectName(String randomName) {
        WebElement foundName = driver.findElement(By.cssSelector("td"));
        Assertions.assertThat(foundName.getAttribute("innerText")).isEqualTo(randomName);
    }
}