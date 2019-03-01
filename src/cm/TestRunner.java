package cm;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        // Result result = JUnitCore.runClasses(PeriodTest.class);
        Result result = JUnitCore.runClasses(RateTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            System.out.println("in  for loop ");

        }
        if(result.wasSuccessful()) {
            System.out.println(result.wasSuccessful());
            System.out.println("at result from cm.TestRunner passed ");
        }else{
            System.out.println(result.wasSuccessful());
            System.out.println("at result from cm.TestRunner failed ");
        }
    }
}
