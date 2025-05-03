package reportConfig;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class BaseTest {

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

//    private static ExtentReports extentReports;
//    private static ExtentTest extentTest;

    @BeforeTest
    public void startReporter() {
        String reportPath = System.getProperty("user.dir") + "/target/ExtentReport/extentReport.html";
        File reportDir = new File(reportPath);

        // Create directory if it does not exist
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        extentSparkReporter = new ExtentSparkReporter(reportPath + "extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        // Configure the report appearance
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

//    public void startReporter()
//    {
//        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport/extentReport.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(extentSparkReporter);
//
//        //configuration items to change the look and feel
//        //add content, manage tests etc.
//        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
//        extentSparkReporter.config().setReportName("Test Report");
//        extentSparkReporter.config().setTheme(Theme.STANDARD);
//        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//    }

    @AfterMethod
    public void getResult(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, result.getTestName());
        }
        else {
            extentTest.log(Status.SKIP, result.getTestName());
        }
    }
    @AfterTest
    public void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
    }

//    public static ExtentReports getExtentReports() {
//        return extentReports;
//    }
//
//    public static ExtentTest startTest(String testName) {
//        extentTest = extentReports.createTest(testName);
//        return extentTest;
//    }
//
//    public static void flushReports() {
//        extentReports.flush();
//    }


}
