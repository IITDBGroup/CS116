/**
 * 
 */
package lecture;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author lord_pretzel
 *
 */
//maintainers have first and last names and are accessible at runtime
@Retention(RetentionPolicy.RUNTIME) 
public @interface Maintainer {
 String firstName();
 String lastName();
}
