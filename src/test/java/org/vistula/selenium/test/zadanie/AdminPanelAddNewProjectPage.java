package org.vistula.selenium.test.zadanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelAddNewProjectPage {
    private WebDriver driver;

    @FindBy (css = "input#name") private WebElement title;
    @FindBy (id = "prefix") private WebElement prefix;
    @FindBy (id = "description") private WebElement description;
    @FindBy (id = "save") private WebElement save;
    @FindBy (className = "activeMenu") private WebElement projects;

    public AdminPanelAddNewProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void fillTitle(String randomTitle) {
        title.sendKeys(randomTitle);
    }

    public void fillPrefix (String randomPrefix) {
        prefix.sendKeys(randomPrefix);
    }

    public void fillDescription (String randomDescription) {
        description.sendKeys(randomDescription);
    }

    public void saveNewProject() {
        save.click();
    }

    public void goToSearchProjectsPage() {
        projects.click();
    }
}
