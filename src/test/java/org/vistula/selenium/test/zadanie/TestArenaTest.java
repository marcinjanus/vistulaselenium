package org.vistula.selenium.test.zadanie;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class TestArenaTest extends TestArenaSeleniumTest {
    @Test
    public void shouldAddNewProject (){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("administrator@testarena.pl", "sumXQQ72$L");

        CokpitPage cokpitPage = new CokpitPage(driver);
        cokpitPage.openAdminPage();

        AdminPanelProjectsPage adminPage = new AdminPanelProjectsPage(driver);
        adminPage.selectAddProject();

        AdminPanelAddNewProjectPage newProjectPage = new AdminPanelAddNewProjectPage(driver);
        String randomTitle = RandomStringUtils.randomAlphabetic(20);
        String randomPrefix = RandomStringUtils.randomAlphabetic(5);
        String randomDescription = RandomStringUtils.randomAlphabetic(50);
        newProjectPage.fillTitle(randomTitle);
        newProjectPage.fillPrefix(randomPrefix);
        newProjectPage.fillDescription(randomDescription);
        newProjectPage.saveNewProject();

        newProjectPage.goToSearchProjectsPage();

        AdminPanelProjectsPage searchProjectsPage = new AdminPanelProjectsPage(driver);
        searchProjectsPage.enterTheProjectTitle(randomTitle);
        searchProjectsPage.searchTheProject();
        searchProjectsPage.waitForResults();
        searchProjectsPage.verifyProjectTitle(randomTitle);
    }
}
