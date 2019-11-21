package org.vistula.selenium.test.zadanie;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPanelProjectViewPage {

    private WebDriver driver;

    @FindBy(className = "j_close_button")
    private WebElement closeButton;
    @FindBy (className = "item2")
    private WebElement projectsMenuItem;

    public AdminPanelProjectViewPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyProjectIsAdded() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("j_info_box")));

        WebElement foundInfoText = driver.findElement(By.cssSelector("p"));
        Assertions.assertThat(foundInfoText.getAttribute("innerText")).isEqualTo("Projekt został dodany.");
    }

    public void closingInfoBox() {
        closeButton.click();
    }

    public void goToSearchProjectsPage() {
        projectsMenuItem.click();
    }
}