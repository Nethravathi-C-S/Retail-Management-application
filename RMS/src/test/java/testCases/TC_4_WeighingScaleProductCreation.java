package testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductCreatePage;

import java.time.Duration;

public class TC_4_WeighingScaleProductCreation extends TC_2_OrgSelectTest{
    private static final Logger log = LoggerFactory.getLogger(TC_4_WeighingScaleProductCreation.class);

    @Test(groups = {"Sanity", "Master"},dataProvider = "ProductTitleData",dataProviderClass = utilities.DataProviders.class)
    public void productCreation_WeighingScale(String productTitle) {
        log.info("Starting TC_4_WeighingScaleProductCreation");

        try {
            ProductCreatePage pcr = new ProductCreatePage(driver);
//            pcr.clickOnNavbaricon();
            pcr.clickOnProduct();
            pcr.clickOnAllproducts();
            pcr.clickOnNewbtn();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            pcr.enterProductTitle(productTitle);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            pcr.SelectMainCategory();
            pcr.SelectCategory_1();
            pcr.SelectCategory_2();
            pcr.EnterBrand();
            pcr.SelectManufacturer();
            pcr.SelectVendor();
            pcr.ClickOnWeighingScaleCheckbox();
            pcr.clickOnGenerateBarcodeBtn();
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
            Assert.fail("WeighingScale Product creation failed  " + e);
        }
        log.info("Finished TC_4_WeighingScaleProductCreation");
    }
}
