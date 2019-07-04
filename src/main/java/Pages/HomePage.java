package Pages;

import Support.ElementUtils;
import org.openqa.selenium.By;


public class HomePage {
    ElementUtils utils = new ElementUtils();
    CommonMethodsPage commonMethodsPage = new CommonMethodsPage();
    public static String randomNumber;

    public void assertHomePage() {
        utils.assertElementPresent(By.xpath("//h6[text()='Home']"));
    }

    public void assertAddOrgPage() {
        utils.assertElementPresent(By.xpath("//h5[text()='Please enter the details of the organisation']"));

    }

    public void assertAuthGroupsAreVisibleUnderAddOrgPage(String authGroup) {
        utils.clickBtn(By.xpath("//div[@id='select-Authorisation Group']"));
        utils.assertElementPresent(By.xpath("//li[text()='" + authGroup + "']"));
    }

    public void addOrganisation(String orgName, String organisationType, String authGroup) throws InterruptedException {
        assertAddOrgPage();
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), orgName);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("legalName")), orgName);
        utils.clickBtn(By.id("select-Organisation Type"));
        utils.clickBtn(By.xpath("//li[text()='" + organisationType + "']"));
        utils.sleep(1000);
        utils.clickBtn(By.xpath("//div[@id='select-Authorisation Group']"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//li[text()='" + authGroup + "']"));
        commonMethodsPage.clickSubmit();
    }

    public void magicSearch(String text) {
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("search")), text);
    }

    public void searchAndAssertOrganisation(boolean search, String org, String type) {
        if (search) {
            magicSearch(org);
            utils.assertElementPresent(By.xpath("//span[text()='" + org + "']"));
            utils.assertElementPresent(By.xpath("//p[text()='" + type + "']"));
        } else {
            utils.assertElementPresent(By.xpath("//input[@value='" + org + "']"));
            utils.assertElementPresent(By.xpath("//input[@value='" + type + "']"));

        }
    }

    public void editOrganisation(boolean editWithNoSpace, String orgName, String type) throws InterruptedException {
        commonMethodsPage.clickEdit(editWithNoSpace);
        utils.sendText(By.xpath(commonMethodsPage.xpathGenerator_inputTag("name")), orgName);
        utils.clickBtn(By.id("select-Organisation Type"));
        utils.clickBtn(By.xpath("//li[text()='" + type + "']"));
        commonMethodsPage.clickSubmit();
    }

    public void searchAndPickOrganisation(String org) throws InterruptedException {
        magicSearch(org);
        commonMethodsPage.clickView();
    }

    public void logout() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='root']//button[2]"));
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//li[text()='Logout']"));

    }

    public void chooseDesiredIconFromVerticalIndex(int option) throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='root']/div//ul//div[" + option + "]"));
    }

    public void assertLinkCodeMessage() {
        utils.assertElementPresent(By.xpath("//p[text()='You are not linked to an organisation, ']"));
    }

    public void assertLinkCode() {
        utils.assertElementPresent(By.xpath("//label[text()='Enter Code']"));
    }


}
