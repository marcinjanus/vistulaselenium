package org.vistula.selenium.test.zadanie;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class TestArenaTest extends BaseTest {

    @Test
    public void createAndSearchProject (){
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.verifyIsLoaded();
        loginPage.login("administrator@testarena.pl", "sumXQQ72$L");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageIsLoaded();
        dashboardPage.openAdminPage();

        AdminPanelProjectsPage adminPanelProjectsPagePage = new AdminPanelProjectsPage(driver);
        adminPanelProjectsPagePage.verifyProjectsPageIsLoaded();
        adminPanelProjectsPagePage.clickAddProject();

        AdminPanelAddProjectPage newProjectPage = new AdminPanelAddProjectPage(driver);
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
