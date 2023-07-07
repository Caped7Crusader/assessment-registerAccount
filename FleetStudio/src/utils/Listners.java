package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners extends Setup implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
	    String timeString = formatter.format(time);
	    
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	FileUtils.copyFile(screenshot, new File(".\\Target\\screenshots\\failedTC\\"+date+timeString+".png"));
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}

}
