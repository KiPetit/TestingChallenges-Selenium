package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.DriverManager.driver;

public class ChallengeTenLogInPageObjects {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement  password;

    @FindBy(xpath = "//button[@formaction='login.php']")
    private WebElement submit;

    public PersonalRoadAssistanceObjects logIn(String Username, String Password){
        username.sendKeys(Username);
        password.sendKeys(Password);
        submit.click();
        return initElements(driver, PersonalRoadAssistanceObjects.class);
    }
}
