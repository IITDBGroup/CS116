/**
 * 
 */
package lecture;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import lecture.UseMaintainer.Inner;

/**
 * @author lord_pretzel
 *
 */
public class UseMaintainer {

	@Maintainer(firstName = "Peter", lastName = "Smith")
	public static class Inner {
		public String a;
	}
	
	public static void main(String[] args) {
		Inner x = new Inner();
		Class<? extends Inner> in = x.getClass();
		Maintainer a = in.getDeclaredAnnotation(Maintainer.class);
		System.out.println(a.firstName() + " " + a.lastName());
	}
	
}
