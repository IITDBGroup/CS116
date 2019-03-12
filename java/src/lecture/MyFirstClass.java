package lecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This is a simple class which only prints <it>"hello world"</it> when its main method is called.
 * 
 * @author lord_pretzel
 *
 */
public class MyFirstClass {

	/**
	 * The main methods prints <it>"hello world"</it>. Nothing more to tell you really.
	 * 
	 * @param args parameters are ignored
	 * @throws IOException if we have trouble reading from the file
	 */
    public static void main(String[] args) throws IOException {
    	System.out.println("xxx");
    	File f = null;
    	FileOutputStream out = new FileOutputStream(f);
    	out.write(1);
    }
    
    /**
     * This method does nothing. Why would I write such a thing. To teach JavaDoc.
     * 
     * @param mes ignored
     */
    public static void doNothing(String mes) {
    	
    }

}
