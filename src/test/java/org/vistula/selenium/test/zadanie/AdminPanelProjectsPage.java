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

    public AdminPanelProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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


    @FindBy(className = "button_link") private WebElement newProject;

    public void selectAddProject() {
        newProject.click();
    }
}
