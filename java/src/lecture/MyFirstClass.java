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
	 * @throws IOException 
	 */
    public static void main(String[] args) throws IOException {
    	System.out.println("xxx");
    	File f = null;
    	FileOutputStream out = new FileOutputStream(f);
    	out.write(1);
    }

}
