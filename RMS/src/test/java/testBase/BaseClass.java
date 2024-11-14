package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Slf4j
public class BaseClass {
    public ResourceBundle rb;// to read config.properties
    public static WebDriver driver;  // make it static so that you can use same instance in Extent report manager

    @BeforeClass(groups = {"Master", "Sanity", "Regression"}) //Step8 groups added
    @Parameters("browser")   // getting browser parameter from testng.xml

    public void setup(String br) {

        rb = ResourceBundle.getBundle("config", Locale.getDefault());

        //launch right browser based on parameter
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().driverVersion("120.0.6099.109").setup();
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(rb.getString("appURL")); // get url from config.properties file
        driver.manage().window().maximize();
    }

   @AfterClass(groups = { "Sanity", "Regression"})
    public void teadDown() {
        driver.quit();
    }

//    public String randomeString() {
//        String generatedString = RandomStringUtils.randomAlphabetic(5);
//        return (generatedString);
//    }
//
//    public String randomeNumber() {
//        String generatedString2 = RandomStringUtils.randomNumeric(10);
//        return (generatedString2);
//    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }

}
