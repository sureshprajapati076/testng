package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgGroup {

    @Test(groups = {"sanity1"})
    public void testFbA(){
        System.out.println("FB test A");
        Assert.assertTrue(true);
        System.out.println("REVERt 2nd TESTING");
    }

    @Test(groups = {"sanity2"})
    public void testFbB(){
        System.out.println("FB test B");
        Assert.assertTrue(true);
        System.out.println("REVERt 2nd TESTING");
    }

    @Test(groups = {"sanity3","sanity1"})
    public void testFbC(){
        System.out.println("FB test C");
        Assert.assertTrue(true);
    }
}
