package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalRoadAssistanceObjects {
    private final String message="Wellcome To Your Personal Road Assitance";

    @FindBy(xpath = "//tbody/tr/th/h1")
    private WebElement welcomeMessage;

    public String getWelcomeMessageFromWebpage(){
        return welcomeMessage.getText();
    }
    public String getWelcomeMessage(){
        return message;
    }


}
