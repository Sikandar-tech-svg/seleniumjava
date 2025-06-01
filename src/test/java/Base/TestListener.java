package Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class TestListener extends base implements ITestListener {
	
	ExtentReports extent = ExtentReporter.getReporterObject();
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("**** ---- Test Started --- ****");
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "**** ---- Test Started --- ****");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("**** ---- Test Success --- ****");
		test.log(Status.PASS, "**** ---- Test Success --- ****");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("**** ---- Test Failure --- ****");
		test.log(Status.FAIL, "**** ---- Test Failed --- ****");
		
		try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver)
					,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("**** ---- Test Slipped --- ****");
		test.log(Status.SKIP, "**** ---- Test Skipped --- ****");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	@Override
	public void onFinish(ITestContext context) {
		logger.info("**** ---- Test Finished --- ****");
		test.log(Status.INFO, "**** ---- Test Finished --- ****");
		extent.flush();
	}


}
