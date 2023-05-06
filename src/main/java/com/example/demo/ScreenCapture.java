package com.example.demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenCapture 
{
	public void shot()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		WebDriver driver = new ChromeDriver(options);
		try 
		{
			
		
			
	        // 이제 ChromeDriver를 사용할 수 있습니다.        
	        driver.get("http://localhost:8080");
			
            // 스크린샷을 찍습니다.
            //File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(screenshot, new File("screenshot.png"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver를 종료합니다.
            driver.quit();
        }
		
	}
}
