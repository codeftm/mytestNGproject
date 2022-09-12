package myTestNG.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day14_SoftAssert {
    @Test
    public void softAssertTest(){
//        Soft Assert is used to do multiple assertion in the same class
//        hard assert is  more common
//        When did you use soft assert?
//        I used especially when I do scratch test cases
//        to see all of the steps on my test case
        SoftAssert sa = new SoftAssert();
        System.out.println("Line 8");
        sa.assertEquals(4,5);//FAILS. 	expected [5] but found [4],
        System.out.println("Line 12");
        sa.assertTrue(false);//FAIL   	expected [true] but found [false]
        System.out.println("Line 15");
        sa.assertEquals("a","a");//PASS
        sa.assertAll();
    }
}
