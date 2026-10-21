package com.qa.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenshotUtil {
	
	public static String captureScreenshot(String testName) {
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String filename = testName+"_"+timestamp+".png";
		
		String directory="screenshots";
		
		Path directoryPath=Paths.get(directory);
		
		try {
            Files.createDirectories(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to create screenshot directory", e
            );
        }
		
		File sourceFile = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		
		Path destinationPath=Paths.get(directory, filename);
		
		try {
			Files.copy(sourceFile.toPath(), destinationPath);
		}catch (IOException e) {
            throw new RuntimeException(
                    "Unable to save screenshot", e
            );
        }
		return destinationPath.toString();

		
	}

}
