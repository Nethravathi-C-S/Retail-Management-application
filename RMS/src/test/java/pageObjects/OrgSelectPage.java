package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.TC_2_OrgSelectTest;

import java.security.PrivateKey;
import java.time.Duration;
import java.time.Instant;


public class OrgSelectPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div/button[2]")
    private WebElement SelectLoc;

//    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'MuiBox-root css-8hs5ht')]/div[contains(@class,'MuiBox-root css-91otsb')]/div[contains(@class,'MuiBox-root css-1rv2whj')]/div[contains(@class,'MuiBox-root css-91otsb')]/div[6]/div[2]/div[1]/div[1]")
    @FindBy(xpath = "//body/div[@id='app']/div[@class='MuiBox-root css-8hs5ht']/div[@class='MuiBox-root css-91otsb']/div[@class='MuiBox-root css-1rv2whj']/div[@class='MuiBox-root css-91otsb']/div[1]/div[2]/div[1]/div[1]/div[1]")
    private WebElement OrgLoc;

    public OrgSelectPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoc() {
        SelectLoc.click();
    }

    public void scrollAndClickOnOrgLoc() {
//        driver.manage().window().setSize(new Dimension(1200, 800));
        scrollUntilElementVisible(OrgLoc);
        Actions actions = new Actions(driver);
        actions.moveToElement(OrgLoc, 5, 5).click().perform();
//        OrgLoc.click();
    }
    public static void scrollUntilElementVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Frequency of checking
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
//   public void clickonorgloc() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(OrgLoc, 5, 5).click().perform();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(OrgLoc)).click();
//    }


}