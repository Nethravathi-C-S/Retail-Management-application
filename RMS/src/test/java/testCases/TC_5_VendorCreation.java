package testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.VendorCreationPage;

import java.time.Duration;

public class TC_5_VendorCreation extends TC_2_OrgSelectTest {
    private static final Logger log = LoggerFactory.getLogger(TC_5_VendorCreation.class);
    @Test(groups = {"Sanity", "Master"},dataProvider = "PANData",dataProviderClass = utilities.DataProviders.class)
    public void vendorCreation(String PANnum) {
        log.info("Starting TC_5_VendorCreation");

        try {
           VendorCreationPage VCP = new VendorCreationPage(driver);
           VCP.Findpurchase();
           VCP.FindVendor();
           VCP.VendorLogoUpload();
           VCP.BasicDetails(PANnum);

        } catch (Exception e) {
            Assert.fail("PI creation failed  " + e);
        }
        log.info("Finished TC_5_VendorCreation");
    }







}
