package Support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import static Support.BaseClass.driver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ElementUtils {

    Properties prop;
    FileInputStream fileInputStream;
    public String date;
    public static StringBuilder randomVehicleRegGenerator;


    public void sendText(By by, String text) {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(by));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public void hitEnter(By by) {
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public void clickBtn(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    public void assertElementPresent(By by) {
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed());

    }

    public void assertElementAbsent(By by) {
        List<WebElement> element = driver.findElements(by);
        Assert.assertEquals(element.size(), 0);
    }

    public void sleep(int timeOutInMilliSeconds) throws InterruptedException {
        Thread.sleep(timeOutInMilliSeconds);
    }

    public String getProperty(String key) throws IOException {
        prop = new Properties();
        fileInputStream = new FileInputStream("src/test/Resources/config.properties");
        prop.load(fileInputStream);

        return prop.getProperty(key);
    }

    public WebDriver browser() throws IOException {

        String browser = getProperty("browser");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "headless":
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Rajesh Gurrala\\IdeaProjects\\FeatureFiles\\BrowserFiles\\MicrosoftWebDriver.exe");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rajesh Gurrala\\IdeaProjects\\FeatureFiles\\BrowserFiles\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;

    }

    public void hoverOverElement(By by) {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(by));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void actionsClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.click(element).build().perform();
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(4);
    }

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(4);
    }

    public void selectByVisibleText(By by, String text) {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(by));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void javaScriptExecutorClick(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        //arguments[0].scrollIntoView();
    }

    public ElementUtils makeSureBoxIsChecked(By by1, By by2) throws InterruptedException {
        WebElement element = driver.findElement(by1);
        if (element.isSelected()) {
        } else {
            sleep(1000);
            javaScriptExecutorClick(by2);

        }
        return this;
    }

    public ElementUtils makeSureBoxIsUnChecked(By by1, By by2) throws InterruptedException {
        WebElement element = driver.findElement(by1);
        if (element.isSelected()) {
            sleep(1000);
            javaScriptExecutorClick(by2);
        } else {
        }
        return this;
    }

    public void assertUnchecked(By by) {
        WebElement element = driver.findElement(by);
        assertFalse(element.isSelected());
    }

    public void assertChecked(By by) {
        WebElement element = driver.findElement(by);
        assertTrue(element.isSelected());

    }

    public void dragAndDrop(By by1, By by2) throws InterruptedException {
        WebElement from = driver.findElement(by1);
        WebElement to = driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.clickAndHold(from).perform();
        actions.moveToElement(to).perform();
        actions.moveByOffset(0, 0).pause(1).perform();
        actions.release().perform();
    }

    public String getCurrentDate() {
        date = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
        return date;
    }

    public String addOneYearToCurrentDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        date = new SimpleDateFormat("dd/MM/yy").format(cal.getTime());
        return date;
    }

    public String addDaysToCurrentDate(int number, String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, number);
        date = new SimpleDateFormat(format).format(cal.getTime());
        return date;
    }

    public String getDayOfWeekBasedOnDaysAdded(int addedDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, addedDays);
        date = new SimpleDateFormat("EEE").format(cal.getTime());
        return date;
    }

    public String getCurrentMonthInString() {
        return new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime());
    }

    public String randomVehicleRegGenerator() {
        randomVehicleRegGenerator = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char ch = (char) (Math.random() * 26 + 'A');
            randomVehicleRegGenerator.append(ch);
        }
        for (int i = 0; i < 4; i++) {
            char digit1 = (char) (Math.random() * 10 + '0');
            randomVehicleRegGenerator.append(digit1);
        }
        return randomVehicleRegGenerator.toString();

    }

    public boolean checkIfElementIsDisplayed(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public ElementUtils scrollToView(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public int getWebElementCount(By by) {
        List<WebElement> all = driver.findElements(by);
        return all.size();
    }

    public void clickFirstAvailableElement(By by) {
        List<WebElement> all = driver.findElements(by);
        for (WebElement first : all) {
            first.click();
            break;
        }
    }

    public void uncheckAppBoxes(By by) throws InterruptedException {
        List<WebElement> all = driver.findElements(by);
        for (WebElement element : all) {
            if (element.isSelected()) {
                sleep(1000);
                element.click();
            } else {
            }
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean isAttributePresent(By by, String attribute) {
        boolean result = false;
        try {
            String value = driver.findElement(by).getAttribute(attribute);
            if (value != null) {
                return true;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void clickOnDesiredNumberOfLocator(int number, By by) {
        List<WebElement> all = driver.findElements(by);
        int i = 0;
        for (WebElement second : all) {
            i = i + 1;
            if (i == number) {
                second.click();
            }

        }
    }


}



