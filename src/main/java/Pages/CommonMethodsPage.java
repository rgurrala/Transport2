package Pages;

import Support.ElementUtils;
import org.openqa.selenium.By;

public class CommonMethodsPage {

    ElementUtils utils = new ElementUtils();

    public void clickEdit(boolean editWithNoSpace) throws InterruptedException {
        if (editWithNoSpace) {
            utils.clickBtn(By.xpath("//span[text()='EDIT']"));
        } else {
            utils.sleep(1000);
            utils.clickBtn(By.xpath("//span[text()='EDIT ']"));
        }
    }

    public void clickSubmit() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//button[@type='submit']"));
    }

    public void clickSave() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='SAVE']"));
    }

    public void clickView() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='VIEW']"));
    }

    public void clickAdd() throws InterruptedException {
        utils.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[text()='ADD']"));
    }


    public String xpathGenerator_inputTag(String id) {
        return "//input[@id='" + id + "']";
    }
}
