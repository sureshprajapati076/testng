package youtube;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class TestNGTest1 {

    @Parameters({"param1","param2"})
    @Test(groups = {"first"})
    public void testA(@Optional String value1, @Optional String value2){

        System.out.println("Started TestA : at: "+ LocalDateTime.now().getSecond());
        System.out.println("Values : "+value1 + " : "+value2);

        waitForNSeconds(5);

        System.out.println("Ended Test A: at: "+ LocalDateTime.now().getSecond());


    }


    private void waitForNSeconds(int n){
        try{
            Thread.sleep(n*1000);
        }
        catch (InterruptedException ex){

        }
    }






}
