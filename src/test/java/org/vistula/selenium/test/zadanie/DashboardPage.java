package org.vistula.selenium.test.zadanie;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;

    @FindBy (className = "header_admin")
    private WebElement adminPanelButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyDashboardPageIsLoaded() {
        new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("wrapper")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");
    }

    public void openAdminPage() {
        adminPanelButton.click();
    }
}
