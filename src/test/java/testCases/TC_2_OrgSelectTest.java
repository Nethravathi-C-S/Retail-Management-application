package testCases;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OrgSelectPage;

import testBase.BaseClass;

import java.time.Duration;
@Slf4j
public class TC_2_OrgSelectTest extends TC_1_LoginTest {
    private static final Logger log = LoggerFactory.getLogger(TC_2_OrgSelectTest.class);

    @Test(groups = {"Sanity", "Master"}) //Step8 groups added
    public void OrgSelect() {
        log.info("Starting TC_2_OrgSelectTest");

        try {
            OrgSelectPage os = new OrgSelectPage(driver);
            os.clickLoc();
            os.scrollAndClickOnOrgLoc();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//            os.clickonorgloc();
//            String contentName = "Erode";
//            scrollUntilContentFound(driver, contentName);
//            System.out.println("Content Selected");
        } catch (Exception e) {
            Assert.fail("org select failed" + e);
        }
        log.info("Finished TC_2_OrgSelectTest");
    }


//    private static void scrollUntilContentFound(WebDriver driver, String contentName) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        while (true) {
//            if (isContentPresent(driver, contentName)) {
//                System.out.println("Content found!");
//                break;
//            }
//            js.executeScript("window.scrollBy(0,500)");
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static boolean isContentPresent(WebDriver driver, String contentName) {
//        By contentLocator = By.xpath("//*[contains(text(), '" + contentName + "')]");
//
//        try {
//            WebElement contentElement = driver.findElement(contentLocator);
//
//            return contentElement.isDisplayed();
//        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
//            // Content element not found or not visible
//            return false;
//        }
//    }
}


