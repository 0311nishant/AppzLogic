package Firstapp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class MQTT_IOT {
	@SuppressWarnings("rawtypes")
	WindowsDriver mot;
	Actions act;
	Robot rbt;
	
    
	@Test
	(priority =0)
	@SuppressWarnings("rawtypes")
	public void iot () {
	  final String iotpath = "C:\\Users\\hp\\AppData\\Local\\Programs\\azure-iot-explorer\\Azure IoT Explorer Preview.exe";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", iotpath);
		cap.setCapability("platformName", "windows");
		 try { mot = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
 		}
catch (Exception e) {
	   e.printStackTrace();}
		
	}
	
	@Test
	(priority = 2)
	public void mqtt () throws InterruptedException {
		  final String mqttpath = "C:\\Users\\hp\\AppData\\Local\\Programs\\MQTT-Explorer\\MQTT Explorer.exe";
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", mqttpath);
			cap.setCapability("platformName", "windows");
			 try { mot = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
			 Thread.sleep(5000);
	 		}
	catch (Exception e) {
		   e.printStackTrace();}
			
			 
			 
		}
	
	@SuppressWarnings("unchecked")
	@Test
	(priority = 1)
	public void intitializationiot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(mot, 30);
		act = new Actions(mot);
		Thread.sleep(4000);
		WebElement addc = mot.findElement(By.name("Add connection"));
		wait.until(ExpectedConditions.visibilityOf(addc));
		act.click(addc).perform();
		
		
		WebElement input = mot.findElement(By.name("Connection string *"));
		wait.until(ExpectedConditions.visibilityOf(input));
		act.click(input).click().sendKeys("Iot Input successful").perform();
		
		WebElement cancel = mot.findElement(By.name("Cancel Add of Connection String"));
		wait.until(ExpectedConditions.visibilityOf(cancel));
		act.click(cancel).perform();
		
		WebElement settings = mot.findElement(By.name("Settings"));
		wait.until(ExpectedConditions.visibilityOf(settings));
		act.click(settings).perform();
		
		try {
		WebElement light = mot.findElement(By.name("Light"));
		wait.until(ExpectedConditions.visibilityOf(light));
		act.click(light).perform();
		}
		catch(Exception e) {
			WebElement dark = mot.findElement(By.name("Dark"));
			wait.until(ExpectedConditions.visibilityOf(dark));
			act.click(dark).perform();
		}
		
		List<WebElement> close = mot.findElements(By.name("Close"));
		wait.until(ExpectedConditions.visibilityOfAllElements(close));
		if(close.size()>1) {
			act.click(close.get(1)).perform();
		}
		else {
			act.click(close.get(2)).perform();
		}
		
		act.click(close.get(0)).perform();
		
	}
	@Test
	(priority = 3, description = "This Method Perform Actions in MQTT")
	@SuppressWarnings("unchecked")
	public void initializationmqtt() throws InterruptedException, AWTException {
		
//		
		Thread.sleep(3000);
	    rbt = new Robot();
	    rbt.mouseMove(482, 508);
	    rbt.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    rbt.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    String uname = "username1";
	    for(char n: uname.toCharArray()) {
	    	int code = KeyEvent.getExtendedKeyCodeForChar(n);
	    	
	    	rbt.keyPress(code);
	    	rbt.keyRelease(code);
	    	Thread.sleep(500);
	    }
	    	
	     Thread.sleep(3000);
	    	
	     WebElement pass = mot.findElement(By.name("Password"));
	     System.out.println("Element Found");
	     act.click(pass).sendKeys("Password");
	     
	     
	     
	   	
		
	  
		
	    }
	    
	}


	

    



	
	
