import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ChallengeTenObjects;
import pageObjects.PersonalRoadAssistanceObjects;
import utils.DriverManager;
import utils.Navigator;


public class ChallengeTen {

    public ChallengeTen() {
    }

    @BeforeTest
    public void initDriver(){
        DriverManager.initializeDriver();
    }
    @Test
    public void registerAndVerifyUser(){
        ChallengeTenObjects challengeTenObjects=Navigator.getChallengeTen().registerUser();

        Assert.assertEquals(challengeTenObjects.getID(), challengeTenObjects.getUserID(),"ID does not match");
        Assert.assertEquals(challengeTenObjects.getTableUsername(), challengeTenObjects.getUsername(),"Username does not match");
        Assert.assertEquals(challengeTenObjects.getTablePassword(), challengeTenObjects.getPassword(),"Password does not match");
        Assert.assertEquals(challengeTenObjects.getTableFirstname(), challengeTenObjects.getFirstName(),"Firstname does not match");
        Assert.assertEquals(challengeTenObjects.getTableLastname(), challengeTenObjects.getLastName(),"Lastname does not match");

        PersonalRoadAssistanceObjects praObjects=Navigator.getChallengeTenVerify()
                .logIn(challengeTenObjects.getUsername(), challengeTenObjects.getPassword());

        Assert.assertEquals(praObjects.getWelcomeMessageFromWebpage(), praObjects.getWelcomeMessage(),"Wellcome message does not match");
    }

    @AfterTest
    public void teardown(){
        DriverManager.closeDriver();
    }
}
