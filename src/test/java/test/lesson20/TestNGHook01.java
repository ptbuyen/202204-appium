package test.lesson20;

import org.testng.annotations.*;

public class TestNGHook01 {

    // Scope lon nen de 1 noi chung chung, lon hon test class
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    // Scope lon nen de 1 noi chung chung, lon hon test class
    @BeforeTest
    public void beforeTest(){
        System.out.println("\t--> Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t--> Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t--> Before Method");
    }

    // Scope lon nen de 1 noi chung chung, lon hon test class
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    // Scope lon nen de 1 noi chung chung, lon hon test class
    @AfterTest
    public void afterTest(){
        System.out.println("\t--> After Test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t\t--> After lass");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\t--> After Method");
    }

    @Test
    public void testA(){
        System.out.println("\t\t\t\t--> Test A");
    }

    @Test
    public void testB(){
        System.out.println("\t\t\t\t--> Test B");
    }
}
