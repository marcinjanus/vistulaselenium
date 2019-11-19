package org.vistula.selenium.test.zadanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CokpitPage {
    private WebDriver driver;

    @FindBy(className = "header_admin") private WebElement adminPanel;

    public CokpitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAdminPage() {
        adminPanel.click();
    }
}
