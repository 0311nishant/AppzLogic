package Firstapp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

import java.net.URL;

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

    @Test
    public void interact() {
    	WebDriverWait wait = new WebDriverWait(iotDriver, 20);
    	if (iotDriver != null) {
        	 
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add connection")));
        	iotDriver.findElementByName("Add connection").click();
        	        } else {
            System.out.println("WindowsDriver is not initialized.");
            
        }
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@Name='Connection string *']")));
        iotDriver.findElement(By.xpath("//*[@Name='Connection string *']")).sendKeys("Thanks");
    }
}
