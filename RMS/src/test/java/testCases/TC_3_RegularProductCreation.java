package testCases;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OrgSelectPage;
import pageObjects.ProductCreatePage;

import java.time.Duration;
@Slf4j
public class TC_3_RegularProductCreation  extends TC_2_OrgSelectTest {
    private static final Logger log = LoggerFactory.getLogger(TC_3_RegularProductCreation.class);

    @Test(groups = {"Sanity", "Master"},dataProvider = "ProductTitleData",dataProviderClass = utilities.DataProviders.class)
    public void productCreation_Regular(String productTitle) {
        log.info("Starting TC_3_RegularProductCreation");

        try {
            ProductCreatePage pcr = new ProductCreatePage(driver);
//            pcr.clickOnNavbaricon();
            pcr.clickOnProduct();
            pcr.clickOnAllproducts();
            pcr.clickOnNewbtn();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            pcr.enterProductTitle(productTitle);
            pcr.clickOnGenerateBarcodeBtn();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            pcr.SelectMainCategory();
            pcr.SelectCategory_1();
            pcr.SelectCategory_2();
            pcr.EnterBrand();
            pcr.SelectManufacturer();
            pcr.SelectVendor();
            pcr.SelectMinOrdQntType();
            pcr.AddDescription();
            pcr.ClickOnComparePriceCheckbox();
            pcr.ClickOnReturnableItemCheckbox();
            pcr.ClickOnOrganicCheckbox();
            pcr.ClickOnContinueSellCheckbox();
            pcr.ClickOnFoodItemCheckbox();
            pcr.ProductInLocalLanguage();
            pcr.SpecificationStockMarginReorder();
            pcr.BatchDetails();


        } catch (Exception e) {
            Assert.fail("Regular Product creation failed  " + e);
        }
        log.info("Finished TC_3_RegularProductCreation");
    }
}