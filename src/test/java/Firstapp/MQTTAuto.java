package Firstapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class MQTTAuto {

	WebDriver mqa = null;
	Actions act;
	
@SuppressWarnings({ "rawtypes" })
@BeforeMethod
public void initialization() {
	final String mqttPath = "C:\\Users\\hp\\AppData\\Local\\Programs\\MQTT-Explorer\\MQTT Explorer.exe";
	DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("app", mqttPath);
    cap.setCapability("platformName", "windows");
    try { mqa = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
    		}
   catch (Exception e) {
	   e.printStackTrace();}
    
}


@Test
public void interactwMqtt() throws InterruptedException {
	act = new Actions(mqa);
	WebDriverWait wait = new WebDriverWait(mqa, 30);
	
	List<WebElement> uname = mqa.findElements(By.xpath("//*[@LocalizedControlType='edit']"));
	
//	wait.until(ExpectedConditions.visibilityOfAllElements(uname));
  
	Thread.sleep(5000);
	if(uname.size()>2) {
		act.click(uname.get(3)).sendKeys("Username").perform();
	}
	else if (uname.size()>3) {
		act.click(uname.get(4)).sendKeys("Username").perform();
	}
	else {
		System.out.println("Element Not Tracked");
	}
	Thread.sleep(3000);
	WebElement pass = mqa.findElement(By.name("Password"));
	act.click(pass).sendKeys("Wrong Password").perform();

	WebElement connect = mqa.findElement(By.name("CONNECT"));
	act.click(connect).perform();
	
	
}
 }