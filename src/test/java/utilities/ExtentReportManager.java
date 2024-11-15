package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());// time stamp
		reportName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);// specify location of the report

		sparkReporter.config().setDocumentTitle("RMS Automation Report"); // Title of report
		sparkReporter.config().setReportName("RMS Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Web_RMS");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "Stage Testing");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
//		sendEmailWithAttachment(testContext.getName());
	}
	private static final String EMAIL_USERNAME = "nethravathi.c@twinleaves.co";
	private static final String EMAIL_PASSWORD = "Anjucs@2909";
	private void sendEmailWithAttachment(String testName) {
		try {
			// Set up the email attachment
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(generateReportPath(reportName));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Test Report");
			// Create the email
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));
			email.setSSLOnConnect(true);
			email.addTo("anjucscta@gmail.com");
			email.setFrom(EMAIL_USERNAME);
			email.setSubject("Test Automation Report - " + testName);
			email.setMsg("Please find attached the test automation report for: " + testName);
			email.attach(attachment);

			// Send the email
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   private String generateReportPath(String testName) {
			return System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName;
		}




//		  try {
//		  File reportFile = new File(System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName);
//		  URL url = reportFile.toURI().toURL();
//		  //URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+reportName);
//			  // Create the email message
//		  ImageHtmlEmail email = new ImageHtmlEmail();
//		  email.setDataSourceResolver(new DataSourceUrlResolver(url));
//		  email.setHostName("smtp.googlemail.com");
//		  email.setSmtpPort(465);
//		  email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator("nethravathi.c@twinleaves.co", "fvvfvfg"));
//		  //email.setSSLOnConnect(true);
//	      email.setStartTLSEnabled(true);
//		  email.setFrom("nethravathi.c@twinleaves.co"); //Sender
//		  email.setSubject("RMS Automation Test Results");
//		  email.setMsg("Please find Attached Report....");
//		  email.addTo("anjucscta@gmail.com"); //Receiver
//		  email.attach(url, "extent report", "please check report...");
//		  email.send(); // send the email
//		  }
//		  catch(Exception e) { e.printStackTrace(); }
//	}

}
