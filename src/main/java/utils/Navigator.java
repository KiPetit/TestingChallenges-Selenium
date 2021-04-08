package utils;

import pageObjects.*;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.DriverManager.driver;

public class Navigator {
    public static void getChallengeOne(){
    driver.get("http://testingchallenges.thetestingmap.org");
    }
    public static ChallengeOneObjects getChallengeOneObjects(){
        return initElements(driver, ChallengeOneObjects.class);
    }
    public static ChallengeTenObjects getChallengeTen(){
        driver.get("http://testingchallenges.thetestingmap.org/challenge10.php");
        return initElements(driver,  ChallengeTenObjects.class);
    }
    public static ChallengeFourObjects getChallengeFour(){
        driver.get("http://testingchallenges.thetestingmap.org/challenge4.php");
        return initElements(driver, ChallengeFourObjects.class);
    }
    public static ChallengeTenLogInPageObjects getChallengeTenVerify(){
        driver.get("http://testingchallenges.thetestingmap.org/login/login.php");
        return initElements(driver, ChallengeTenLogInPageObjects.class);
    }
}
