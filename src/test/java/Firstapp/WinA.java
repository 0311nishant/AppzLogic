package Firstapp;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class WinA {

    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        
    
            
            Desktop desktop = Desktop.getDesktop();
            
            try {
                if (!desktop.isDesktopSupported()) {
                System.out.println("Not Supported");
                return;
            }

            File file = new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");

            if (file.exists()) {
                System.out.println("Opening WinAppDriver.exe");
                desktop.open(file);
            } else {
                System.out.println("WinAppDriver.exe isnt Available");
            }
            
        } 
            
            catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Caught");
        }

    }
}
