import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ChallengeOneObjects;
import utils.DriverManager;
import utils.Navigator;
import utils.Utils;

public class ChallengeOne {
    private int i=0;
    @BeforeTest
    public void initDriver()  {
        DriverManager.initializeDriver();
        Navigator.getChallengeOne();
    }
    @Test(dataProvider="getData", dataProviderClass = Utils.class)
    public void submitFirstName(String FirstName, String textMessage) throws InterruptedException {
        ChallengeOneObjects challengeOneObjects=Navigator.getChallengeOneObjects().submitFirstName(FirstName);
        i++;
        Thread.sleep(500);
        challengeOneObjects.waitForCounterChange(Integer.toString(i));
        Assert.assertEquals(challengeOneObjects.getCounter(), i, "Counter does not match");
        Assert.assertEquals(challengeOneObjects.getTextValue(), textMessage, "Text message does not match");
    }
    @AfterTest
    public void teardown(){
        DriverManager.closeDriver();
    }
}
