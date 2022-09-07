package techproed.tests;

import org.testng.annotations.*;
public class Day13_TestNGAnnotation {
    /*
    Suite > Test > Group > Class > Method
    @Test -> creates test case
    @Before and @After -> multiple annotation are used to control the flow and design of test cases
    @Ignore -> skips test case
    @Test(enabled=false) -> disables the test case, similar to @Ignore
    @Test(priority = 3) -> prioritize test cases in specific order
    If there is no priority, then priority of that one is @Test(priority = 0)
    So best practice is when we use priority, we should use for all Test method within that class
    TestNG test cases runs in alphabetical order by default
    Priority can be must when there are multiple test cases in the same class to run in specific order
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod //@Before in JUNIT
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod //@After in JUNIT
    public void tearDown(){
        System.out.println("After Method");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("test2");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 1)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority = -2)
    public void test5(){
        System.out.println("test5");
    }
    @Test
    public void test6(){
        System.out.println("test6");
    }
}