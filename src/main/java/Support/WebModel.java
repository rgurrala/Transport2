package Support;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrganisationPage;

public class WebModel {

    private LoginPage loginPage = new LoginPage();
    private ElementUtils utils = new ElementUtils();
    private HomePage homePage = new HomePage();
    private OrganisationPage organisationPage = new OrganisationPage();


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ElementUtils getUtils() {
        return utils;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public OrganisationPage getOrganisationPage() {
        return organisationPage;
    }


}
