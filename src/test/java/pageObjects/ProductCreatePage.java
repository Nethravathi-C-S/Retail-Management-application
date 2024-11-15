package pageObjects;

import groovyjarjarasm.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCreatePage extends BasePage {

    public ProductCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/header/div/div[1]/button/span")
    WebElement NavbarHideIcon;

    public void clickOnNavbaricon() {
        NavbarHideIcon.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/ul/li[1]/div")
    WebElement Products;

    public void clickOnProduct() {
        Products.click();
    }

    @FindBy(xpath = "//span[normalize-space()='All products']")
    WebElement AllProducts;

    public void clickOnAllproducts() {
        AllProducts.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[1]/div/div[2]/div/button[1]")
    WebElement NewBtnProductCreate;

    public void clickOnNewbtn() {
        NewBtnProductCreate.click();
    }

    @FindBy(xpath = "//*[@id=\"free-solo-with-text-demo\"]")
    WebElement inputProductTitle;
    @FindBy(xpath = "//*[@id=\"free-solo-with-text-demo-option-0\"]")
    WebElement selectProduct;

    public void enterProductTitle(String ProductTitle) {
        inputProductTitle.sendKeys(ProductTitle);
        selectProduct.click();
    } //Capture product title from dataprovider class in Utility package

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[1]/div[2]/button")
    WebElement GenerateBarcodeBtn;

    public void clickOnGenerateBarcodeBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(GenerateBarcodeBtn)).click();
    }

    @FindBy(xpath = " //*[@id=\"react-select-2-input\"]")
    WebElement MainCategory;
    @FindBy(xpath = "//*[@id=\"react-select-2-option-0\"]")
    WebElement AllCategory;

    public void SelectMainCategory() {
        MainCategory.click();
        AllCategory.click();
    }

    @FindBy(xpath = " //*[@id=\"react-select-3-input\"]")
    WebElement Category_1;
    @FindBy(xpath = "//*[@id=\"react-select-3-option-0\"]")
    WebElement AllCategory_1;

    public void SelectCategory_1() {
        Category_1.click();
        AllCategory_1.click();
    }

    @FindBy(xpath = " //*[@id=\"react-select-4-input\"]")
    WebElement Category_2;
    @FindBy(xpath = "//*[@id=\"react-select-4-option-0\"]")
    WebElement AllCategory_2;

    public void SelectCategory_2() {
        Category_2.click();
        AllCategory_2.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[9]/div[2]/input")
    WebElement inputBrand;

    public void EnterBrand() {
        inputBrand.sendKeys("Surf Excel");
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[10]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement inputManufacturer;
    @FindBy(xpath = " /html[1]/body[1]/div[3]/div[1]/ul[1]/li[1]")
    WebElement Manufacturer;

    public void SelectManufacturer() {
        inputManufacturer.sendKeys("Hindustan Unilever Ltd");
        Manufacturer.click();
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[11]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement inputVendor;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]")
    private WebElement Vendor;

    public void SelectVendor() {
        inputVendor.sendKeys("Amma Super Store");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement Element = wait.until(ExpectedConditions.visibilityOf(Vendor));
//        System.out.println("Vendor Element present");
        WebElement clickvendor = wait.until(ExpectedConditions.elementToBeClickable(Vendor));
        System.out.println("Vendor Element present");
        clickvendor.click();
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[12]/div/input\n")
    WebElement WeighingScaleCheckbox;
    public void ClickOnWeighingScaleCheckbox() {
        WeighingScaleCheckbox.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GenerateBarcodeBtn);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[13]/div/div/div[1]/input")
    WebElement inputMinOrderquantity;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[13]/div/div/div[2]/div/div/div[1]/div[1]")
    WebElement MinOrdQntType;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[13]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]")
    WebElement Kg_MinOrdQntType;

    public void SelectMinOrdQntType() {
        inputMinOrderquantity.sendKeys("1");
        MinOrdQntType.click();
        Kg_MinOrdQntType.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[14]/div[2]/textarea[1]")
    WebElement Description;

    public void AddDescription() {
        Description.sendKeys("An automated product description is a product description generated by a software program that uses artificial intelligence and natural language processing algorithms to analyze product specifications, features, and images and create descriptive text automatically.");
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[16]/input")
    WebElement comparePriceCheckbox;

    public void ClickOnComparePriceCheckbox() {
        comparePriceCheckbox.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[17]/input")
    WebElement ReturnableItemCheckbox;

    public void ClickOnReturnableItemCheckbox() {
        ReturnableItemCheckbox.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[18]/input")
    WebElement OrganicCheckbox;

    public void ClickOnOrganicCheckbox() {
        OrganicCheckbox.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[19]/input")
    WebElement ContinueSellCheckbox;

    public void ClickOnContinueSellCheckbox() {
        ContinueSellCheckbox.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[20]/div/input")
    WebElement FoodItemCheckbox;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[20]/div[2]/div/div[1]")
    WebElement SelectFooditem;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div/div[20]/div[2]/div/div[2]/div/div[1]")
    WebElement VegFooditem;

    public void ClickOnFoodItemCheckbox() {
        FoodItemCheckbox.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isSelectFooditem = wait.until(ExpectedConditions.elementToBeClickable(SelectFooditem)) != null;

        if (isSelectFooditem) {
            SelectFooditem.click();
            System.out.println("Clicked on the fooditem");
        } else {
            System.out.println("Selcting fooditem is not clickable");
        }
        VegFooditem.click();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[5]/div[1]/div[2]/input")
    WebElement ProductTitleInLocal;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[2]/div/div/div[5]/div[2]/div/div[2]/select")
    WebElement loc;

    public void ProductInLocalLanguage() {
        ProductTitleInLocal.sendKeys("ಕನ್ನಡ ಪಠ್ಯ");
        Select select = new Select(loc);
        select.selectByVisibleText("Karnataka");
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[1]/div/div[2]/div[1]/input")
    WebElement specification;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div\n")
    WebElement specificationType;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]")
    WebElement Kg_specificationType;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[2]/div[2]/input")
    WebElement openStock;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[3]/div/div[2]/div/div")
    WebElement MarginBasedOn;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div/div[1]")
    WebElement MRP_MarginBasedOn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[4]/div/div[2]/div[1]/input")
    WebElement Margin;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[4]/div/div[2]/div[2]/div/div")
    WebElement MarginType;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[4]/div/div[2]/div[2]/div/div[2]/div/div[1]")
    WebElement pert_MarginType;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[5]/div[2]/input")
    WebElement ReorderPoints;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[6]/div/div/div[1]/input")
    WebElement ReorderQuantity;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[6]/div/div/div[2]/div/div")
    WebElement ReorderQuantityType;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div[6]/div/div/div[2]/div/div[2]/div/div[2]")
    WebElement KG_ReorderQuantityUnit;

    public void SpecificationStockMarginReorder() {
        specification.sendKeys("1");
        specificationType.click();
        Kg_specificationType.click();
        openStock.clear();
        openStock.sendKeys("100");
        MarginBasedOn.click();
        MRP_MarginBasedOn.click();
        Margin.sendKeys("5");
        MarginType.click();
        pert_MarginType.click();
        ReorderPoints.sendKeys("5");
        ReorderQuantity.sendKeys("50");
        ReorderQuantityType.click();
        KG_ReorderQuantityUnit.click();
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[4]/div/div/button")
    WebElement AddBatchBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[1]/div[2]/input")
    WebElement BatchNo;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div[2]/input")
    WebElement Quantity;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[3]/div[2]/input")
    WebElement MRP;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[4]/div[2]/input")
    WebElement SellingPrice;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[5]/div[2]/input")
    WebElement PurchasePrice;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div/div/div/div/div[6]/div[2]/input")
    WebElement ExpiryDate;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div/button")
    WebElement ProductSaveBtn;
    @FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]")
    WebElement ProductCreateBtn;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement ProductCreate_OKBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div")
    WebElement ProductListing;

    public void BatchDetails(){
        AddBatchBtn.click();
        BatchNo.sendKeys("Random123");
        Quantity.sendKeys("100");
        MRP.sendKeys("50");
        SellingPrice.sendKeys("46");
        PurchasePrice.sendKeys("38");
        ExpiryDate.sendKeys("15-03-2024");
        ProductSaveBtn.click();
        ProductCreateBtn.click();
        ProductCreate_OKBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ProductListing));
    }



}




