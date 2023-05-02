package ShareData;

import ExtendUtility.ExtentReport;
import InputFile.PropertiesUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends ShareData{

    public HashMap <String, String> testData;
    private String testName;


    public static ExtentReport ExtentReportUtility = new ExtentReport();
    public static List<Log> logContext = new ArrayList<>();
    public ExtentReport testReport;
    @BeforeMethod
    public void prepareEnviroment() throws IOException {
        setupChrome();
        testName=this.getClass().getSimpleName();

        PropertiesUtilities propertiesUtilities = new PropertiesUtilities(testName);
        testData=propertiesUtilities.GetAllData();
        testReport = new ExtentReport(testName);

    }

    @AfterMethod
    public void clearEnviroment(ITestResult testResult){

        if(testResult.getStatus() == ITestResult.FAILURE){
            testReport.attacheReport("fail", testResult.getThrowable().getMessage(), getDriver(), testName);
        }

        testReport.attacheReport("info", " --- finish "+testName+" test ---");

        synchronized (ExtentReportUtility){

            ExtentTest currentTest = ExtentReportUtility.getExtent().createTest(" " + testName+ "- report");
            logContext.addAll(testReport.getTestReport().getModel().getLogs());
            for(Log log:logContext){
                currentTest.getModel().getLogs().add(log);
                if(log.getStatus().equals(Status.FAIL)){
                    currentTest.getModel().setStatus(Status.FAIL);
                }
            }
            ExtentReportUtility.getExtent().flush();
            logContext.clear();
        }

        //clearBrowser();
        }


}
