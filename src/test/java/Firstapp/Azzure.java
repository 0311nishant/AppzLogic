package Firstapp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

import java.net.URL;
import java.util.List;

public class Azzure {
    
    @SuppressWarnings("rawtypes")
    WindowsDriver iotDriver = null ;
    
    @SuppressWarnings("rawtypes")
    @BeforeTest
    public void initialization() {
        // Path to Azure IoT Explorer executable
        final String iotPath = "C:\\Users\\hp\\AppData\\Local\\Programs\\azure-iot-explorer\\Azure IoT Explorer Preview.exe"; // Adjust the path as per your installation

         //Set capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", iotPath);
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "Windows 10");
        
        // Initialize WindowsDriver
        try {
            iotDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Initialize Actions
        Actions act = new Actions(iotDriver);
    }

    //Name:	

    
    @Test
    public void interact() throws InterruptedException {
    	
    	Actions act = new Actions(iotDriver);
    	WebDriverWait wait = new WebDriverWait(iotDriver, 20);
    	if (iotDriver != null) {
        	 
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add connection")));
        	iotDriver.findElementByName("Add connection").click();
        	        } else {
            System.out.println("WindowsDriver is not initialized.");
            
        }
    	
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@Name='Connection string *']")));
        Thread.sleep(2000);
    	iotDriver.findElement(By.xpath("//*[@Name='Connection string *']")).sendKeys("Thanks");
        
        Thread.sleep(3000);
        WebElement cancel = iotDriver.findElement(By.name("Cancel Add of Connection String"));
		wait.until(ExpectedConditions.visibilityOf(cancel));
		act.click(cancel).perform();
		
		WebElement settings = iotDriver.findElement(By.name("Settings"));
		wait.until(ExpectedConditions.visibilityOf(settings));
		act.click(settings).perform();
		
		try {
		WebElement light = iotDriver.findElement(By.name("Light"));
		wait.until(ExpectedConditions.visibilityOf(light));
		act.click(light).perform();
		}
		catch(Exception e) {
			WebElement dark = iotDriver.findElement(By.name("Dark"));
			wait.until(ExpectedConditions.visibilityOf(dark));
			act.click(dark).perform();
		}
		
		List<WebElement> close = iotDriver.findElements(By.name("Close"));
		wait.until(ExpectedConditions.visibilityOfAllElements(close));
		if(close.size()>1) {
			act.click(close.get(1)).perform();
		}
		else {
			act.click(close.get(2)).perform();
		}
		
		act.click(close.get(0)).perform();
		
	}
    }

