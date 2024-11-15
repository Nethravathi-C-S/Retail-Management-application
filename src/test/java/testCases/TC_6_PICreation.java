package testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PICreatePage;
import pageObjects.VendorCreationPage;

public class TC_6_PICreation extends TC_2_OrgSelectTest{
    private static final Logger log = LoggerFactory.getLogger(TC_6_PICreation.class);
    @Test(groups = {"Sanity", "Master"})
    public void PICreation() {
        log.info("Starting TC_6_PICreation");

        try {
            PICreatePage PI = new PICreatePage(driver);
            VendorCreationPage vcr = new VendorCreationPage(driver);
            vcr.Findpurchase();
            PI.FindPurchaseIndent();
            PI.AddPiDetails();
            PI.selectCurrentPIDate();
            PI.selectExpectedDeliveryDate();
            PI.otherdetails();
            PI.Addproduct();
        } catch (Exception e) {
            Assert.fail("PI creation failed  " + e);
        }
        log.info("Finished TC_6_PICreation");
    }
}
