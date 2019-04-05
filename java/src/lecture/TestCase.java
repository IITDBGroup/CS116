    
package lecture;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCase {
    
	private static List<Integer> l1, l2, l3;
	
    // method that will be executed once before any test method is run 
    @BeforeAll
    public static void globalSetup() {
        l1 = List.of(1,2,3);
        l2 = List.of();
        l3 = List.of(4,5);
    }

    // method that will be executed once before any test method is run 
    @AfterAll
    public static void globalTearDown() {
        l1 = null;
        l2 = null;
        l3 = null;
    }

    // method that will be executed before each testcase
    @BeforeEach
    public void setup() {
        System.out.println("before a test");
    }
    
    // method that will be exected after each testcase
    @AfterEach
    public void tearDown() {
        System.out.println("after a test");
    }
    
    // a test case
    @Test
    public void testSeqAccess () {
        for(int i = 0; i < l1.size(); i++) {
        	assertTrue(l1.get(i) == i + 1);
    }
    }
    
    // another test case
    @Test
    public void testLength() {
        assertTrue(l1.size() == 3);
        assertEquals(1,1);
    }
    
    
}