package testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class TestNGTest2 {

    @Parameters({"param1","param2"})
    @Test(groups = {"first"})
    public void testB(@Optional String value1, @Optional String value2){

        System.out.println("Started TestB : at: "+ LocalDateTime.now().getSecond());
        System.out.println("Values : "+value1 + " : "+value2);

        waitForNSeconds(5);

        System.out.println("Ended Test B: at: "+ LocalDateTime.now().getSecond());


    }


    private void waitForNSeconds(int n){
        try{
            Thread.sleep(n*1000);
        }
        catch (InterruptedException ex){

        }
    }






}
