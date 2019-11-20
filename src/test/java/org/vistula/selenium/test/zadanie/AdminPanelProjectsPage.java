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

    @FindBy (id = "search") private WebElement searchArea;
    @FindBy (id = "j_searchButton") private WebElement searchButton;
    @FindBy(className = "button_link") private WebElement newProject;

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
        newProject.click();
    }

    public void enterTheProjectTitle(String randomTitle) {
        searchArea.sendKeys(randomTitle);
    }

    public void searchTheProject() {
        searchButton.click();
    }

    public void waitForResults() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table")));
    }

    public void verifyProjectTitle(String randomTitle) {
        WebElement foundTitle = driver.findElement(By.cssSelector("td"));
        Assertions.assertThat(foundTitle.getAttribute("innerText")).isEqualTo(randomTitle);
    }
}
