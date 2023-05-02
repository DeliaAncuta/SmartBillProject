package ExtendUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReport {

    private ExtentSparkReporter htmlReport;
    private ExtentReports extent;
    private ExtentTest testReport;
    private final String pathReport = System.getProperty("user.dir") + "/target/report/";


    public ExtentReport(String reportName) {
        createDirectory();
        deleteFiles();
        createReport(reportName);
    }

    public ExtentReport() {
        createDirectory();
        deleteFiles();
        createReport();
    }

    public void createDirectory(){
        File directory = new File(pathReport);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    public void deleteFiles(){
        File directory = new File(pathReport);
        File [] listFiles = directory.listFiles();
        for(Integer i =0; i < listFiles.length; i++){
            listFiles[i].delete();
        }
    }

    public void createReport(String reportName){
        htmlReport = new ExtentSparkReporter("target/report/"+reportName+".html");
        htmlReport.config().setTheme(Theme.DARK);
        extent = new ExtentReports();

        extent.attachReporter(htmlReport);
        testReport=extent.createTest("" + reportName+ "- report");
        attacheReport("info", "--- Start "+ reportName+" test ---");
    }

    public void createReport(){
        htmlReport = new ExtentSparkReporter("target/report/Report.html");
        htmlReport.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
    }

    public void attacheReport(String entryType, String mesaj)
    {
        if(entryType.equals("info")){
            testReport.log(Status.INFO, mesaj);
        }
        if(entryType.equals("pass")){
            testReport.log(Status.PASS, mesaj);
        }
    }

    public String getScreenShot(WebDriver driver, String reportName){
        String path = pathReport+reportName+".png";
        byte [] imageBytes;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            imageBytes= IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public void attacheReport(String entryType, String mesaj, WebDriver driver, String reportName)
    {
        if(entryType.equals("Fail")){
            testReport.fail(mesaj, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot(driver, reportName)).build());
        }
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getTestReport() {
        return testReport;
    }




}
