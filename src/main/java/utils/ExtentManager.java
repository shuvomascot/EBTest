package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports("src/main/resources/Reports/ExtentReport.html", true);  // Create a new report
            extent.addSystemInfo("Host Name", "Test Machine")
                    .addSystemInfo("Environment", "Automation Testing")
                    .addSystemInfo("User Name", "Shuvo Ali");
        }
        return extent;
    }
}
