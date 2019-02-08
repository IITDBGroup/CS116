    
package lecture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCase {
    
    // method that will be executed once before any test method is run 
    @BeforeAll
    public static void globalSetup() {
        System.out.println("before all test cases");
    }

    // method that will be executed once before any test method is run 
    @AfterAll
    public static void globalTearDown() {
        System.out.println("after all test cases");
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
    public void test1 () {
        assertEquals(1,1);
    }
    
    // another test case
    @Test
    public void test2() {
        assertEquals(1,2);
    }
    
    
}