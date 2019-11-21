package org.vistula.selenium.test.zadanie;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class TestArenaTest extends BaseTest {

    @Test
    public void addAndSearchProject (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageIsLoaded();
        loginPage.loginAsAdmin("administrator@testarena.pl", "sumXQQ72$L");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageIsLoaded();
        dashboardPage.openAdminPage();

        AdminPanelProjectsPage adminPanelProjectsPagePage = new AdminPanelProjectsPage(driver);
        adminPanelProjectsPagePage.verifyProjectsPageIsLoaded();
        adminPanelProjectsPagePage.clickAddProject();

        AdminPanelAddProjectPage adminPanelAddProjectPage = new AdminPanelAddProjectPage(driver);
        adminPanelAddProjectPage.verifyAddProjectPageIsLoaded();
        String randomName = RandomStringUtils.randomAlphabetic(20);
        String randomPrefix = RandomStringUtils.randomAlphabetic(5);
        String randomDescription = RandomStringUtils.randomAlphabetic(50);
        adminPanelAddProjectPage.addProject(randomName, randomPrefix, randomDescription);

        AdminPanelProjectViewPage adminPanelProjectViewPage = new AdminPanelProjectViewPage(driver);
        adminPanelProjectViewPage.verifyProjectIsAdded();
        adminPanelProjectViewPage.closingInfoBox();
        adminPanelProjectViewPage.goToSearchProjectsPage();

        AdminPanelProjectsPage searchProjectsPage = new AdminPanelProjectsPage(driver);
        searchProjectsPage.inputAndSearchProjectName(randomName);
        searchProjectsPage.waitForSearchResults();
        searchProjectsPage.verifyProjectName(randomName);
    }
}
