package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class PICreatePage extends BasePage {
    public PICreatePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div/div[1]/div/ul/div/div/div/ul[2]/a/li/div/div/span")
    WebElement PurchaseIndent;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div[2]/div/div/button")
    WebElement PINewBtn;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[1]/div[1]")
    WebElement deliveryloc;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div")
    WebElement clickloc;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[1]/div[1]")
    WebElement selectAssignee;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]")
    WebElement Assignee;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[3]/div[1]/div/div/div/button")
    WebElement PiDate;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/button")
    WebElement PiExpectedDeliveryDate;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/div[1]/div/div/div[2]/div")
    WebElement approverInput;
    @FindBy(xpath = "//*[@id=\"react-select-4-option-3\"]")
    WebElement approver;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/div[2]/div[2]/div/div[1]\n")
    WebElement shippingMethodInput;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/div[2]/div[2]/div[2]/div/div[1]")
    WebElement shippingMethod_Vendor;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/div[3]/div[2]/div/div[1]")
    WebElement shippingTerm;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/div[3]/div[2]/div[2]/div/div[1]")
    WebElement shippingTerm_freightOnDelivery;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/input")
    WebElement product1_input;
    @FindBy(xpath = "/html/body/div[2]/div/ul/li[1]")
    WebElement product1;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div[4]/div/div")
    WebElement product1_quantity;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[6]/div[1]/div/select")
    WebElement product1_vendor;
//    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[6]/div[1]/div/select")
//    WebElement product1_AmmaSuperStore_Vendor;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/div/label")
    WebElement AddmoreBtn;


    public void FindPurchaseIndent(){
        PurchaseIndent.click();
        PINewBtn.click();
    }
    public void AddPiDetails(){
        deliveryloc.click();
        clickloc.click();
        selectAssignee.click();
        Assignee.click();
    }
//    public void selectCurrentPIDate() {
//        try {
//            Thread.sleep(1000); // Add a small wait before clicking the PiDate element
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        PiDate.click();
//        String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
//        String currentDateXPath = String.format("//td[@data-date='%s']", formattedDate);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(currentDateXPath))).click();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error: Unable to click the element.");
//        }
//    }
public void selectCurrentPIDate() {
    PiDate.click();
    Date currentDate = Calendar.getInstance().getTime();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(currentDate);
    // Split the date into day, month, and year
    String[] dateParts = formattedDate.split("/");
    String day = dateParts[0];
    String month = dateParts[1];
    String year = dateParts[2];
    selectDateFromPicker(driver, day, month, year);
}
    private static void selectDateFromPicker(WebDriver driver, String day, String month, String year) {
        List<WebElement> dayElements = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div"));
        for (WebElement dayElement : dayElements) {
            if (dayElement.getText().equals(day)) {
                dayElement.click();
                break;
            }
        }
    }
    public void selectExpectedDeliveryDate(){
        try {
            Thread.sleep(1000); // Add a small wait before clicking the PiDate element
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PiExpectedDeliveryDate.click();
        String formattedDate1= new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String ExpectedDateXPath = String.format("/html/body/div[2]/div[2]/div/div/div", formattedDate1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ExpectedDateXPath))).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: Unable to click the element.");
        }
    }
    public void otherdetails() {
        approverInput.click();
        approver.click();
        shippingMethodInput.click();
        shippingMethod_Vendor.click();
        shippingTerm.click();
        shippingTerm_freightOnDelivery.click();
    }
    public void Addproduct() {
        product1_input.sendKeys("55555");
        product1.click();
        product1_quantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        product1_quantity.sendKeys(Keys.BACK_SPACE);
        product1_quantity.sendKeys("100");
        Select dropdown = new Select(product1_vendor);
        dropdown.selectByIndex(0);
        AddmoreBtn.click();

    }



    }

