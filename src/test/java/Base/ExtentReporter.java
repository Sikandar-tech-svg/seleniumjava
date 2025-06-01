package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReporter extends base {
	
	static ExtentReports extent;	
	public static ExtentReports getReporterObject() {
		
		String reportPath = System.getProperty("user.dir") + "/Reports/TestRpt" + getCurrentDateTime() + ".html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath).viewConfigurer().viewOrder()
				.as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST}).apply();
		reporter.config().setDocumentTitle("Test Reports");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Abhishek");
		extent.setSystemInfo("Environment", "QA/UAT");
		extent.setSystemInfo("Manager", "ManagerName");
		
		return extent;
	}

}
