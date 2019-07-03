package StepDefinitions;

import Support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;

import static Pages.HomePage.randomNumber;
import static Pages.OrganisationPage.randomName;
import static Support.ElementUtils.randomVehicleRegGenerator;


public class smokePack_StepDefs {
    WebModel webModel = new WebModel();

    @Given("^I am logged in as a super admin$")
    public void iAmLoggedInAsASuperAdmin() {
        webModel.getLoginPage().assertLoginPage();
        webModel.getLoginPage().login("rajeshgurrala@coachhire.com", "Sriya@747");
    }

    @When("^I click on the plus icon$")
    public void iClickOnThePlusIcon() {
        webModel.getHomePage().assertHomePage();

    }

    @Then("^I should be able to add an organisation and search and assert the creation organisation and search and assert the creation$")
    public void iShouldBeAbleToAddAnOrganisationAndSearchAndAssertTheCreationOrganisationAndSearchAndAssertTheCreation() throws InterruptedException {
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("1");
        webModel.getHomePage().randomNumber = webModel.getUtils().randomNumber();
        webModel.getHomePage().addOrganisation("OrgCreatedForAutoTest" + randomNumber + "", "ORGANISATION", "Super Admin");
        webModel.getHomePage().searchAndAssertOrganisation(true, "OrgCreatedForAutoTest" + randomNumber + "", "ORGANISATION");

    }

    @Then("^I should be able to edit the created organisation and assert the changes$")
    public void iShouldBeAbleToEditTheCreatedOrganisationAndAssertTheChanges() throws InterruptedException {
        webModel.getHomePage().editOrganisation(true, "EditedOrgCreatedForAutoTest" + randomNumber + "", "SUPPLIER");
        webModel.getHomePage().searchAndAssertOrganisation(true, "EditedOrgCreatedForAutoTest" + randomNumber + "", "SUPPLIER");

    }


    @When("^i navigate to the magic search page and search & select a particular organization$")
    public void iNavigateToTheMagicSearchPageAndSearchSelectAParticularOrganization() throws InterruptedException {
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");

    }

    @Then("^i should be able to add an auth group and assert its creation$")
    public void iShouldBeAbleToAddAnAuthGroupAndAssertItsCreation() throws InterruptedException {
        webModel.getOrganisationPage().assertOrganisationPage();
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("5");
        webModel.getOrganisationPage().assertAddAuthGroupPage();
        webModel.getHomePage().randomNumber = webModel.getUtils().randomNumber();
        webModel.getOrganisationPage().addAuthGroup("AuthGroup" + randomNumber + "", "OrgCreatedForAutoTest");
        webModel.getOrganisationPage().assertAuthGroup("AuthGroup" + randomNumber);
    }

    @And("^I should be able to edit the created auth group and assert the changes$")
    public void iShouldBeAbleToEditTheCreatedAuthGroupAndAssertTheChanges() throws InterruptedException {
        webModel.getOrganisationPage().editAuthGroup("AuthGroup" + randomNumber + "");

    }

    @Then("^I should be able to add a person profile and assert its creation$")
    public void iShouldBeAbleToAddAPersonProfileAndAssertItsCreation() throws InterruptedException {
        webModel.getOrganisationPage().assertOrganisationPage();
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("6");
        webModel.getOrganisationPage().assertAddPersonProfilePage();
        randomName = webModel.getUtils().randomName();
        randomNumber = webModel.getUtils().randomNumber();
        webModel.getOrganisationPage().captureValidationMessagesAndAddPersonProfile(randomName, randomNumber);
    }

    @And("^I should be able to edit the created person profile and assert the changes$")
    public void iShouldBeAbleToEditTheCreatedPersonProfileAndAssertTheChanges() throws InterruptedException {
        webModel.getOrganisationPage().assertCreatedPersonProfile(randomName, randomNumber);
        webModel.getOrganisationPage().editPersonProfile(randomName);


    }

    @Then("^I should be able to create an action plan and assert its creation$")
    public void iShouldBeAbleToCreateAnActionPlanAndAssertItsCreation() throws InterruptedException {
        webModel.getOrganisationPage().assertOrganisationPage();
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("4");
    }

    @And("^I should be able to edit the created action plan and assert the changes$")
    public void iShouldBeAbleToEditTheCreatedActionPlanAndAssertTheChanges() throws InterruptedException, AWTException {
        webModel.getOrganisationPage().assertActionPlanCreationPage();
        webModel.getOrganisationPage().createNewActionPlan();

    }

    @Then("^I should be able to add a new vehicle and assert its creation$")
    public void iShouldBeAbleToAddANewVehicleAndAssertItsCreation() throws InterruptedException {
        webModel.getOrganisationPage().assertOrganisationPage();
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("3");
        webModel.getOrganisationPage().assertAddVehiclePage();
        webModel.getOrganisationPage().addNewVehicle();
        webModel.getOrganisationPage().assertVehicle(randomVehicleRegGenerator.toString(), "20", "Volvo", "7900", "Orange");


    }

    @And("^I should be able to edit the created vehicle and assert the changes$")
    public void iShouldBeAbleToEditTheCreatedVehicleAndAssertTheChanges() throws InterruptedException {
        webModel.getOrganisationPage().editVehicle(randomVehicleRegGenerator.toString());
    }

    @Then("^I should be able to add a new trip and assert the creation$")
    public void iShouldBeAbleToAddANewTripAndAssertTheCreation() throws InterruptedException, AWTException {
        webModel.getOrganisationPage().assertOrganisationPage();
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("2");
        webModel.getOrganisationPage().assertAddTripPage();
        randomName = webModel.getUtils().randomName();
        webModel.getOrganisationPage().checkValidationMessages_addTrip("trip_" + randomName + "");
        webModel.getOrganisationPage().assertTrip("trip_" + randomName + "");


    }

    @Given("^I login as a user linked to auth group associated with more then one organisation$")
    public void iLoginAsAUserLinkedToAuthGroupAssociatedWithMoreThenOneOrganisation() throws InterruptedException {
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().linkAuthGroupToPersonProfile("passengerOne", "AuthGroup_OrgCreatedForAutoTest");
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(4);


    }

    @Then("^I should be able to see all the organisations the auth group is linked to$")
    public void iShouldBeAbleToSeeAllTheOrganisationsTheAuthGroupIsLinkedTo() {
        Assert.assertTrue(webModel.getUtils().getWebElementCount(By.xpath("//th[text()='OrgCreatedForAutoTest']")) > 1);

    }


    @And("^I will be shown link up screen once his auth group is unlinked from his profile$")
    public void IWillBeShownLinkUpScreenOnceHisAuthGroupIsUnlinkedFromHisProfile() throws InterruptedException {
        webModel.getHomePage().logout();
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().unLinkAuthGroupToPersonProfile("passengerOne");
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
        webModel.getHomePage().assertLinkCodeMessage();


    }

    @Given("^I have permission to view, edit and create an org$")
    public void iHavePermissionToViewEditAndCreateAnOrg() throws InterruptedException {
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().issueAdd_View_EditPermissionsToAuthGroup(true, false, false, "AuthGroupForPermissionTests");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().linkAuthGroupToPersonProfile("passengerOne", "AuthGroupForPermissionTests");
    }

    @When("^I login I should be able to view, edit and create org$")
    public void iLoginIShouldBeAbleToViewEditAndCreateOrg() throws InterruptedException {
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getHomePage().editOrganisation(false, "EditedOrgCreatedForAutoTest", "SUPPLIER");
        webModel.getHomePage().searchAndAssertOrganisation(false, "EditedOrgCreatedForAutoTest", "SUPPLIER");
        webModel.getHomePage().editOrganisation(false, "OrgCreatedForAutoTest", "ORGANISATION");
        webModel.getHomePage().searchAndAssertOrganisation(false, "OrgCreatedForAutoTest", "ORGANISATION");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("1");
        webModel.getHomePage().randomNumber = webModel.getUtils().randomNumber();
        webModel.getHomePage().assertAddOrgPage();
        webModel.getHomePage().assertAuthGroupsAreVisibleUnderAddOrgPage("AuthGroupForPermissionTests");


    }

    @And("^when the permissions are revoked$")
    public void whenThePermissionsAreRevoked() throws InterruptedException {
        webModel.getHomePage().logout();
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().issueAdd_View_EditPermissionsToAuthGroup(false, false, false, "AuthGroupForPermissionTests");
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
    }

    @Then("^i should loose the ability to view, edit and create$")
    public void iShouldLooseTheAbilityToViewEditAndCreate() throws InterruptedException {
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(4);
        webModel.getOrganisationPage().assertNoDataUnderOrganisations_revokedView_EditAndAddPermissions();
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().assertLinkCode();


    }


    @Given("^I have permissions to view, edit and create auth groups$")
    public void iHavePermissionsToViewEditAndCreateAuthGroups() throws InterruptedException {
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().issueAdd_View_EditPermissionsToAuthGroup(false, true, false, "AuthGroupForPermissionTests");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().linkAuthGroupToPersonProfile("passengerOne", "AuthGroupForPermissionTests");
    }

    @When("^I login i should be able to view, edit and create auth group$")
    public void iLoginIShouldBeAbleToViewEditAndCreateAuthGroup() throws InterruptedException {
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().checkPermission_EditAuthGroups_userLogin("AuthGroupForPermissionTests");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("1");
        webModel.getOrganisationPage().checkPermission_addAuthGroup_userLogin();


    }

    @Given("^I am permissions to view, edit and create trips$")
    public void iAmPermissionsToViewEditAndCreateTrips() throws InterruptedException {
        iAmLoggedInAsASuperAdmin();
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().issueAdd_View_EditPermissionsToAuthGroup(false, false, true, "AuthGroupForPermissionTests");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().linkAuthGroupToPersonProfile("passengerOne", "AuthGroupForPermissionTests");
    }


    @When("^I login I should be able to view, edit and create trips$")
    public void iLoginIShouldBeAbleToViewEditAndCreateTrips() throws InterruptedException, AWTException {
        webModel.getHomePage().logout();
        webModel.getLoginPage().login("rgurrala@gmail.com", "Sriya@747");
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("1");
        webModel.getOrganisationPage().assertAddTripPage();
        randomName = webModel.getUtils().randomName();
        webModel.getOrganisationPage().checkValidationMessages_addTrip("trip_" + randomName + "");
        webModel.getOrganisationPage().assertTrip("trip_" + randomName + "");
    }


    @When("^I update an existing action plan$")
    public void iUpdateAnExistingActionPlan() throws InterruptedException {
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().updateAnActionPlan("ActionPlan1");

    }

    @Then("^I should be able to use it to create a client booing$")
    public void iShouldBeAbleToUseItToCreateAClientBooing() throws InterruptedException {
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("1");
        randomNumber = webModel.getUtils().randomNumber();
        webModel.getOrganisationPage().createContracts("contract" + randomNumber);
        webModel.getOrganisationPage().assertCreatedContract("contract" + randomNumber);
    }

    @And("^I should be able to edit the created booking$")
    public void iShouldBeAbleToEditTheCreatedBooking() throws InterruptedException {
        webModel.getOrganisationPage().editContract("contract" + randomNumber, "updatedContract" + randomNumber);
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().assertCreatedContract("updatedContract" + randomNumber);


    }


    @Given("^I am logged in as a super admin and a trip has been recently created$")
    public void iAmLoggedInAsASuperAdminAndATripHasBeenRecentlyCreated() throws InterruptedException, AWTException {
        webModel.getLoginPage().assertLoginPage();
        webModel.getLoginPage().login("rajeshgurrala@coachhire.com", "Sriya@747");
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().hoverOverPlusAndClickDesiredOption_OrganisationsPage("2");
        webModel.getOrganisationPage().assertAddTripPage();
        randomName = webModel.getUtils().randomName();
        webModel.getOrganisationPage().checkValidationMessages_addTrip("trip_" + randomName + "");
    }


    @When("^I navigate to the view trip I should be able to clone the trip in reverse$")
    public void iNavigateToTheViewTripIShouldBeAbleToCloneTheTripInReverse() throws InterruptedException {
        webModel.getOrganisationPage().cloneTripInReverse("trip_" + randomName + "");
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().navigateToTripSummaryDropDown(2, "trip_" + randomName + "");
    }

    @And("^add extra passengers from trip schedule for the first day of the trip$")
    public void addExtraPassengersFromTripScheduleForTheFirstDayOfTheTrip() throws InterruptedException {
        webModel.getOrganisationPage().addPassengersToFirstDayOfTripViaTripSchedule();
    }

    @Then("^I should be able to asset added passengers for the first day$")
    public void iShouldBeAbleToAssetAddedPassengersForTheFirstDay() throws InterruptedException {
        webModel.getOrganisationPage().assertPassengersAreAddedToTheFirstDayOnly("trip_" + randomName + "");
    }


    @And("^I should be able to add extra passenger way points for the last day of the trip$")
    public void iShouldBeAbleToAddExtraPassengerWayPointsForTheLastDayOfTheTrip() throws InterruptedException {
        webModel.getOrganisationPage().addingExtraWayPointFromEditScreen();

    }


    @And("^assert that the way point is only added to the last day of the trip$")
    public void assertThatTheWayPointIsOnlyAddedToTheLastDayOfTheTrip() throws InterruptedException {
        webModel.getHomePage().chooseDesiredIconFromVerticalIndex(2);
        webModel.getHomePage().searchAndPickOrganisation("OrgCreatedForAutoTest");
        webModel.getOrganisationPage().navigateToTripSummaryDropDown(1, "trip_" + randomName + "");
        webModel.getOrganisationPage().clickViewTripOnSummaryDropDown();
        webModel.getUtils().assertElementAbsent(By.xpath("//span[text()='Little London']"));
    }
}
