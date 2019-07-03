package Pages;

import Support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

import static Support.BaseClass.driver;


public class OrganisationPage {
    ElementUtils utils = new ElementUtils();
    CommonMethodsPage commonMethodsPage = new CommonMethodsPage();
    public static String randomName;

    public void assertOrganisationPage() {
        utils.assertElementPresent(By.xpath("//h5[text()='View Organisation']"));
    }

    public void hoverOverPlusAndClickDesiredOption_OrganisationsPage(String option) throws InterruptedException {
        utils.sleep(1000);
        utils.hoverOverElement(By.xpath("//div[@id='root']//button[@aria-controls='Addanentity-actions']"));
        utils.actionsClick(By.xpath("//div[@id='Addanentity-actions']//button[" + option + "]"));
    }


    public void assertAddAuthGroupPage() {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the Authorisation Group']"));
    }

    public void addAuthGroup(String authGroupName, String orgName) throws InterruptedException {
        commonMethodsPage.clickAdd();
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), authGroupName);
        utils.makeSureBoxIsChecked(By.xpath("//input[@value='MAGIC_SEARCH']"), By.xpath("//input[@value='MAGIC_SEARCH']"));
        utils.clickBtn(By.xpath("//div[@id='select-Organisation']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//li[text()='" + orgName + "']"));
        commonMethodsPage.clickSubmit();
    }

    public void assertAuthGroup(String authGroupName) {
        utils.clickBtn(By.xpath("//span[text()='Auth Groups']"));
        utils.assertElementPresent(By.xpath("//td[text()='" + authGroupName + "']"));
    }

    public void editAuthGroup(String authGroupName) throws InterruptedException {
        utils.clickBtn(By.xpath("//td[text()='" + authGroupName + "']"));
        commonMethodsPage.clickEdit(false);
        utils.makeSureBoxIsUnChecked(By.xpath("//input[@value='MAGIC_SEARCH']"), By.xpath("//input[@value='MAGIC_SEARCH']"));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), "updated" + authGroupName);
        commonMethodsPage.clickSubmit();
        utils.assertUnchecked(By.xpath("//input[@value='MAGIC_SEARCH']"));
        utils.assertElementPresent(By.xpath("//input[@value='updated" + authGroupName + "']"));
    }

    public void assertAddPersonProfilePage() {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the person'] "));
    }

    public void captureValidationMessagesAndAddPersonProfile(String personProfile, String randomNumber) throws InterruptedException {
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), "personName123");
        utils.assertElementPresent(By.xpath("//p[text()='Please enter a valid name'] "));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), personProfile);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("email")), "@email.com");
        utils.assertElementPresent(By.xpath("//p[text()='Please enter a valid email address'] "));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("email")), "" + personProfile + "@email.com");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("phoneNumber")), "020123");
        utils.assertElementPresent(By.xpath("//p[text()='Please enter a valid phone number'] "));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("phoneNumber")), "0201234" + randomNumber + "");
        utils.makeSureBoxIsChecked(By.xpath("//input[@type='checkbox']"), By.xpath("//input[@type='checkbox']"));
        commonMethodsPage.clickSubmit();
    }

    public void assertCreatedPersonProfile(String profileName, String randomNumber) {
        utils.clickBtn(By.xpath("//span[text()='People']"));
        utils.assertElementPresent(By.xpath("//td[text()='" + profileName + "']"));
        utils.assertElementPresent(By.xpath("//th[text()='" + profileName + "@email.com']"));
        utils.assertElementPresent(By.xpath("//td[text()='0201234" + randomNumber + "']"));
    }

    public void editPersonProfile(String personProfile) throws InterruptedException {
        utils.clickBtn(By.xpath("//td[text()='" + personProfile + "']"));
        commonMethodsPage.clickEdit(false);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), "updated" + personProfile);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("email")), "updated" + personProfile + "@email.com");
        commonMethodsPage.clickSubmit();
        utils.assertElementPresent(By.xpath("//input[@value='updated" + personProfile + "']"));
        utils.assertElementPresent(By.xpath("//input[@value='updated" + personProfile + "@email.com']"));
    }

    public void assertActionPlanCreationPage() {
        utils.assertElementPresent(By.xpath("//h6[text()='Action Plan Builder']"));
    }

    public void createNewActionPlan() throws InterruptedException {
        utils.sleep(2000);
        utils.dragAndDrop(By.xpath("//h5[text()='Heading']"), By.xpath("//h4[text()='Preview']"));
        utils.dragAndDrop(By.xpath("//h5[text()='Heading']"), By.xpath("//h4[text()='Preview']"));
    }

    public void assertAddVehiclePage() {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the vehicle']"));
    }

    public void addNewVehicle() throws InterruptedException {
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("registration")), utils.randomVehicleRegGenerator());
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("capacity")), "20");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("make")), "Volvo");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("model")), "7900");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("color")), "Orange");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("insuranceStartDate_input")), utils.getCurrentDate());
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("insuranceEndDate_input")), utils.addOneYearToCurrentDate());
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("dVSAStartDate_input")), utils.getCurrentDate());
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("dVSAEndDate_input")), utils.addOneYearToCurrentDate());
        commonMethodsPage.clickSubmit();
    }

    public void assertVehicle(String regNumber, String capacity, String make, String model, String colour) {
        utils.clickBtn(By.xpath("//span[text()='Vehicles']"));
        utils.assertElementPresent(By.xpath("//td[text()='" + regNumber + "']"));
        utils.assertElementPresent(By.xpath("//th[text()='" + capacity + "']"));
        //utils.assertElementPresent(By.xpath("//td[text()='"+make+"']"));
        utils.assertElementPresent(By.xpath("//td[text()='" + model + "']"));
        utils.assertElementPresent(By.xpath("//td[text()='" + colour + "']"));
    }

    public void editVehicle(String vehicleRegNumber) throws InterruptedException {
        utils.clickBtn(By.xpath("//td[text()='" + vehicleRegNumber + "']"));
        commonMethodsPage.clickEdit(false);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("capacity")), "20");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("make")), "Man");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("model")), "001");
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("color")), "White");
        commonMethodsPage.clickSubmit();
        utils.assertElementPresent(By.xpath("//input[@value='White']"));
        utils.assertElementPresent(By.xpath("//input[@value='Man']"));
        utils.assertElementPresent(By.xpath("//input[@value='001']"));
    }

    public void assertAddTripPage() {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the trip']"));
    }

    public void checkValidationMessages_addTrip(String tripName) throws InterruptedException, AWTException {
        utils.clickBtn(By.xpath("//div[@id='select-Client Booking']"));
        utils.actionsClick(By.xpath("//li[text()='client booking']"));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), tripName);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("startDateTime_input")), utils.addDaysToCurrentDate(1, "dd/MM/yy"));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("endDate_input")), utils.addDaysToCurrentDate(3, "dd/MM/yy"));
        utils.clickBtn(By.xpath("//span[@class='rw-i rw-i-clock-o']"));
        utils.actionsClick(By.xpath("//li[text()='09:00:00']"));
        commonMethodsPage.clickSubmit();
        utils.assertElementPresent(By.xpath("//p[text()='Atleast one day must be selected']"));
        utils.sleep(1000);
        utils.actionsClick(By.xpath("//span[text()='" + utils.getDayOfWeekBasedOnDaysAdded(1) + "']"));
        utils.actionsClick(By.xpath("//span[text()='" + utils.getDayOfWeekBasedOnDaysAdded(2) + "']"));
        utils.actionsClick(By.xpath("//span[text()='" + utils.getDayOfWeekBasedOnDaysAdded(3) + "']"));
        utils.clickFirstAvailableElement(By.xpath("//span[@class='rw-i rw-i-clock-o']"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//li[text()='09:00:00']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//button[@aria-label='Open calendar']"));
        try {
            utils.actionsClick(By.xpath("//td[@class='rw-cell rw-now rw-state-focus rw-state-selected']/following-sibling::td[1]"));
        } catch (Exception e) {
            utils.actionsClick(By.xpath("//td[@class='rw-cell rw-now rw-state-focus rw-state-selected']/../following-sibling::tr/td[1]"));
        }
        utils.sleep(1000);
        utils.scrollToView(By.xpath("//p[text()='Search for a location']"));
        commonMethodsPage.clickSubmit();
        //validation message capturing all fields must be filled message
        utils.assertElementPresent(By.xpath("//p[contains(text(),'Ensure that all fields marked with * are filled')]"));
        if (utils.checkIfElementIsDisplayed(By.xpath("//p[text()='Search for a location']/..//input"))) {
            utils.sendText(By.xpath("//p[text()='Search for a location']/..//input"), "Maidenhead Road");
        }
        utils.clickBtn(By.xpath("//p[text()='Maidenhead Road']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='ADD']"));
        utils.sendText(By.xpath("//label[text()='Disembarking passengers']/..//input"), "passengerOne");
        utils.clickBtn(By.xpath("//div[@role='option'][text()='passengerOne']"));
        commonMethodsPage.clickSubmit();
        //validation message capturing cannot have de-board without boarding
        utils.assertElementPresent(By.xpath("//p[contains(text(),'An error occurred, please try again')]"));
        utils.clickBtn(By.xpath("//span[text()='passengerOne']/..//*[@role='presentation']"));
        utils.sendText(By.xpath("//label[text()='Boarding passengers']/..//input"), "passengerOne");
        utils.clickBtn(By.xpath("//div[@role='option'][text()='passengerOne']"));
        commonMethodsPage.clickSubmit();
        //validation message stating that asserts must de-board at the end of the trip
        utils.assertElementPresent(By.xpath("//p[contains(text(),'An error occurred, please try again')]"));
        utils.clickBtn(By.xpath("//p[text()='Maidenhead Road']"));
        utils.sendText(By.xpath("//p[text()='Search for a location']/..//input"), "Maidenhead bridge");
        utils.clickBtn(By.xpath("//p[text()='Maidenhead Bridge']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='ADD']"));
        utils.scrollToView(By.xpath("//button[@type='submit']"));
        utils.sendText(By.xpath("//span[text()='Maidenhead Bridge']/../..//input[@id='arrivalDateTime_input']"), utils.addDaysToCurrentDate(1, "dd/MM/yy") + ", " + "11:00");
        utils.actionsClick(By.xpath("//span[text()='ADD REMAINING']"));
        commonMethodsPage.clickSubmit();
    }


    public void assertTrip(String trip) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='Trips']"));
        try {
            utils.assertElementPresent(By.xpath("//span[text()='" + trip + "']"));
        } catch (Exception e) {
            utils.sleep(3000);
            utils.refreshPage();
            utils.sendText(By.xpath("//input[@type='text']"), trip);
            utils.assertElementPresent(By.xpath("//span[text()='" + trip + "']"));
        }

        utils.sleep(3000);
        utils.clickBtn(By.xpath("//span[text()='" + trip + "']"));
        Assert.assertEquals(utils.getWebElementCount(By.xpath("//p[text()='" + trip + "']")), 2);
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//p[text()='" + trip + "']"));
        utils.assertElementPresent(By.xpath("//span[text()='VIEW TRIP']"));
        utils.assertElementPresent(By.xpath("//span[text()='EDIT TRIP']"));
        utils.assertElementPresent(By.xpath("//span[text()='Edit Passengers']"));
        utils.assertElementPresent(By.xpath("//span[text()='Edit Routepoints']"));
        utils.assertElementPresent(By.xpath("//span[text()='Edit Suppliers']"));
        utils.clickBtn(By.xpath("//span[text()='VIEW TRIP']"));
        utils.assertElementPresent(By.xpath("//input[contains(@value,'" + utils.addDaysToCurrentDate(2, "dd/MM/yyyy") + "')]"));

    }

    public void navigateToTripSummaryDropDown(int whichDay, String trip) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='Trips']"));
        utils.sleep(1000);
        utils.sendText(By.xpath("//input[@type='text']"), trip);
        utils.clickBtn(By.xpath("//span[text()='" + trip + "']"));
        utils.sleep(1000);
        utils.clickOnDesiredNumberOfLocator(whichDay, By.xpath("//p[text()='" + trip + "']"));

    }

    public void clickViewTripOnSummaryDropDown() throws InterruptedException {
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//span[text()='VIEW TRIP']"));
    }

    public void cloneTripInReverse(String trip) throws InterruptedException {
        assertTrip(trip);
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='CLONE IN REVERSE']"));
        utils.sleep(1000);
        utils.scrollToView(By.xpath("//span[text()='SAVE']"));
        List<WebElement> allWayPoints = driver.findElements(By.xpath("//div[@style='display: initial;']/..//ul//li[1]//span"));
        for (WebElement firstWayPoint : allWayPoints) {
            utils.sleep(1000);
            Assert.assertTrue(firstWayPoint.getText().contentEquals("Maidenhead Bridge"));
            break;
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//input[@id='arrivalDateTime_input']"));
        for (WebElement firstDate : allDates) {
            utils.sleep(1000);
            Assert.assertTrue(firstDate.getAttribute("value").contains("09:00"));
            break;
        }
        utils.assertElementPresent(By.xpath("//span[text()='Maidenhead Road']/../..//input[contains(@value,'11:00')]"));
    }

    public void addPassengersToFirstDayOfTripViaTripSchedule() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='Edit Passengers']"));
        utils.sendText(By.xpath("//label[text()='Passenger']/..//input"), "PassengerTwo");
        utils.clickBtn(By.xpath("//div[@role='option'][contains(text(),'PassengerTwo')]"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//div[@id='select-Action']"));
        utils.clickBtn(By.xpath("//li[text()='ADD']"));
        utils.sendText(By.xpath("//input[@id='fromDate_input']"), utils.addDaysToCurrentDate(2, "dd/MM/yy"));
        utils.sendText(By.xpath("//input[@id='toDate_input']"), utils.addDaysToCurrentDate(2, "dd/MM/yy"));
        utils.selectByVisibleText(By.xpath("//select[@id='EmbarkRoutepoint']"), "Maidenhead Road");
        utils.selectByVisibleText(By.xpath("//select[@id='DisembarkRoutepoint']"), "Maidenhead Bridge");
        commonMethodsPage.clickSave();
    }

    public void assertPassengersAreAddedToTheFirstDayOnly(String trip) throws InterruptedException {
        utils.clickFirstAvailableElement(By.xpath("//p[text()='" + trip + "']"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//span[text()='VIEW TRIP']"));
        utils.refreshPage();
        utils.assertElementPresent(By.xpath("//label[text()='Boarding passengers']/..//p[text()='passengerOne, PassengerTwo']"));
        utils.assertElementPresent(By.xpath("//label[text()='Disembarking passengers']/..//p[text()='passengerOne, PassengerTwo']"));
        //asserting that the passenger is not added to the second day of the trip
        utils.navigateBack();
        utils.clickOnDesiredNumberOfLocator(2, By.xpath("//p[text()='" + trip + "']"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//span[text()='VIEW TRIP']"));
        utils.sleep(1000);
        utils.assertElementAbsent(By.xpath("//label[text()='Boarding passengers']/..//p[text()='passengerOne, PassengerTwo']"));
        utils.assertElementAbsent(By.xpath("//label[text()='Disembarking passengers']/..//p[text()='passengerOne, PassengerTwo']"));

    }

    public void addingExtraWayPointFromEditScreen() throws InterruptedException {
        commonMethodsPage.clickEdit(true);
        utils.sendText(By.xpath("//p[text()='Search for a location']/..//input"), "London Road");

        utils.clickBtn(By.xpath("//p[text()='London Road']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='ADD']"));
        utils.sendText(By.xpath("//span[text()='London Road']/../..//input[@id='arrivalDateTime_input']"), utils.addDaysToCurrentDate(3, "dd/MM/yy") + ", " + "13:30");
        commonMethodsPage.clickSave();
        utils.assertElementPresent(By.xpath("//h6[text()='Are you sure you want to make these changes?']"));
        utils.clickBtn(By.xpath("//span[text()='SAVE ANYWAY']"));
        utils.assertElementPresent(By.xpath("//span[text()='London Road']"));
    }


    public void linkAuthGroupToPersonProfile(String person, String authGroup) throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='People']"));
        utils.clickBtn(By.xpath("//td[text()='" + person + "']"));
        commonMethodsPage.clickEdit(false);
        if (utils.checkIfElementIsDisplayed(By.xpath("//span[text()='REMOVE']"))) {
            utils.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath("//span[text()='REMOVE']"));
        }
        utils.clickBtn(By.xpath("//span[text()='" + authGroup + "']/../../..//span[text()='ADD']"));
        commonMethodsPage.clickSubmit();
    }

    public void unLinkAuthGroupToPersonProfile(String person) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='People']"));
        utils.clickBtn(By.xpath("//td[text()='" + person + "']"));
        commonMethodsPage.clickEdit(false);
        if (utils.checkIfElementIsDisplayed(By.xpath("//span[text()='REMOVE']"))) {
            utils.clickBtn(By.xpath("//span[text()='REMOVE']"));
        }
        commonMethodsPage.clickSubmit();
    }

    public void issueAdd_View_EditPermissionsToAuthGroup(boolean issueAllOrgAndViewAuthPermissions, boolean issueViewOrgAndViewAddEditAuthGroups, boolean issueViewOrgClientBookingAndViewAddEditTrips, String authGroup) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='Auth Groups']"));
        utils.clickBtn(By.xpath("//td[text()='" + authGroup + "']"));
        commonMethodsPage.clickEdit(false);
        utils.sleep(1000);
        utils.uncheckAppBoxes(By.xpath("//input[@type='checkbox']"));
        if (issueAllOrgAndViewAuthPermissions) {
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='MAGIC_SEARCH']"), By.xpath("//input[@value='MAGIC_SEARCH']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='ADD_ORGANISATION']"), By.xpath("//input[@value='ADD_ORGANISATION']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_ORGANISATION']"), By.xpath("//input[@value='VIEW_ORGANISATION']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='EDIT_ORGANISATION']"), By.xpath("//input[@value='EDIT_ORGANISATION']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_AUTHGROUP']"), By.xpath("//input[@value='VIEW_AUTHGROUP']"));
        }
        if (issueViewOrgAndViewAddEditAuthGroups) {
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='MAGIC_SEARCH']"), By.xpath("//input[@value='MAGIC_SEARCH']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_ORGANISATION']"), By.xpath("//input[@value='VIEW_ORGANISATION']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='ADD_AUTHGROUP']"), By.xpath("//input[@value='ADD_AUTHGROUP']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_AUTHGROUP']"), By.xpath("//input[@value='VIEW_AUTHGROUP']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='EDIT_AUTHGROUP']"), By.xpath("//input[@value='EDIT_AUTHGROUP']"));

        }
        if (issueViewOrgClientBookingAndViewAddEditTrips) {
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='MAGIC_SEARCH']"), By.xpath("//input[@value='MAGIC_SEARCH']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_ORGANISATION']"), By.xpath("//input[@value='VIEW_ORGANISATION']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_CLIENTBOOKING']"), By.xpath("//input[@value='VIEW_CLIENTBOOKING']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='ADD_TRIP']"), By.xpath("//input[@value='ADD_TRIP']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_TRIP']"), By.xpath("//input[@value='VIEW_TRIP']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='EDIT_TRIP']"), By.xpath("//input[@value='EDIT_TRIP']"));
            utils.makeSureBoxIsChecked(By.xpath("//input[@value='VIEW_PERSONPROFILE']"), By.xpath("//input[@value='VIEW_PERSONPROFILE']"));


        }
        commonMethodsPage.clickSubmit();
    }

    public void assertNoDataUnderOrganisations_revokedView_EditAndAddPermissions() {
        utils.assertElementPresent(By.xpath("//p[text()='No data found']"));
        utils.assertElementAbsent(By.xpath("//div[@id='root']//button[@aria-controls='Addanentity-actions']"));
    }

    public void checkPermission_EditAuthGroups_userLogin(String authGroup) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='Auth Groups']"));
        Assert.assertTrue(utils.getWebElementCount(By.xpath("//div[@id='root']//main//table//tbody/tr")) > 1);
        utils.clickBtn(By.xpath("//td[text()='" + authGroup + "']"));
        commonMethodsPage.clickEdit(false);
        utils.clickFirstAvailableElement(By.xpath("//div[@id='select-Organisation']"));
        Assert.assertTrue(utils.getWebElementCount(By.xpath("//div[@role='presentation']//div[2]//li")) <= 2);
        Assert.assertTrue(utils.isAttributePresent(By.xpath("//div[@id='root']//tbody/tr[1]/td[1]/span/span/input"), "checked"));
        Assert.assertTrue(utils.isAttributePresent(By.xpath("//div[@id='root']//tbody/tr[2]/td[2]//span/span/input"), "disabled"));
        utils.refreshPage();
        commonMethodsPage.clickSubmit();
    }

    public void checkPermission_addAuthGroup_userLogin() throws InterruptedException {
        commonMethodsPage.clickAdd();
        utils.sleep(1000);
        utils.makeSureBoxIsChecked(By.xpath("//div[@id='root']//tbody/tr[1]/td[1]/span/span/input"), By.xpath("//div[@id='root']//tbody/tr[1]/td[1]/span/span/input"));
        utils.assertChecked(By.xpath("//div[@id='root']//tbody/tr[1]/td[1]/span/span/input"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='root']//tbody/tr[2]/td[2]//span/span/input"));
        utils.assertUnchecked(By.xpath("//div[@id='root']//tbody/tr[2]/td[2]//span/span/input"));
        utils.clickFirstAvailableElement(By.xpath("//div[@id='select-Organisation']"));
        Assert.assertTrue(utils.getWebElementCount(By.xpath("//div[@role='presentation']//div[2]//li")) <= 2);
    }

    public void updateAnActionPlan(String actionPlan) throws InterruptedException {
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//span[text()='Action Plans']"));
        utils.assertElementPresent(By.xpath("//label[text()='Action Plans']"));
        utils.clickBtn(By.xpath("//span[text()='" + actionPlan + "']/../..//button[2]"));
        utils.sendText(By.xpath("//input[@value='ActionPlan1']"), "updatedActionPlan1");
        utils.clickBtn(By.xpath("//h5[text()='driver late arrival']"));
        utils.sendText(By.xpath("//input[@value='driver late arrival']"), "updated driver late arrival");
        commonMethodsPage.clickSave();
        utils.clickBtn(By.xpath("//span[text()='EDIT PLAN']"));
        utils.assertElementPresent(By.xpath("//input[@value='updatedActionPlan1']"));
        utils.assertElementPresent(By.xpath("//h5[text()='updated driver late arrival']"));
        utils.sendText(By.xpath("//input[@value='updated driver late arrival']"), "driver late arrival");
        utils.sendText(By.xpath("//input[@value='updatedActionPlan1']"), "ActionPlan1");
        commonMethodsPage.clickSave();
    }

    public void createContracts(String contract) throws InterruptedException {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the client booking']"));
        commonMethodsPage.clickAdd();
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), contract);
        utils.clickBtn(By.xpath("//div[@id='select-Trigger Type']"));
        utils.clickBtn(By.xpath("//li[@data-value='NO_LOGON']"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//div[@id='select-Action Plan']"));
        utils.clickBtn(By.xpath("//li[text()='ActionPlan1']"));
        commonMethodsPage.clickSave();
    }

    public void assertCreatedContract(String contract) throws InterruptedException {
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//span[text()='Contracts']"));
        utils.assertElementPresent(By.xpath("//span[text()='" + contract + "']"));
    }

    public void editContract(String existingContract, String updatedContract) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='" + existingContract + "']/../../..//button"));
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), updatedContract);
        commonMethodsPage.clickSave();
    }


}



