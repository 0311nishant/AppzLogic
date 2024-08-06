package Firstapp;

import java.awt.event.KeyEvent;

public class test {

	public static void main(String[] args) {
		String uname = "username1";
	    for(char n: uname.toCharArray()) {
	    	int code = KeyEvent.getExtendedKeyCodeForChar(n);
	    	
	    	System.out.println(n ); 
	}

}
}