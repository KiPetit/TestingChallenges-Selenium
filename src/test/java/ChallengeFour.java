import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ChallengeFourObjects;
import utils.DriverManager;
import utils.Navigator;


public class ChallengeFour {
    @BeforeTest
    public void initDriver(){
        DriverManager.initializeDriver();
    }
    @Test
    public void inputCNP()  {
        ChallengeFourObjects challengeFourObjects = Navigator.getChallengeFour();
        int i=0;
        while (i<4) {
            i++;
            challengeFourObjects.submitCNP();
            challengeFourObjects.waitForCounterChange(Integer.toString(i));
            Assert.assertEquals(challengeFourObjects.getCounter(), i, "Count does not match");
        }
        challengeFourObjects.submitCNP();
        String expectedResultText = challengeFourObjects.getExpectedResultText();
        String resultText = challengeFourObjects.getResultText();
        Assert.assertTrue(resultText.contains(expectedResultText),"Value does not match");
    }
   @AfterTest
    public void teardown(){
        DriverManager.closeDriver();
    }
}
