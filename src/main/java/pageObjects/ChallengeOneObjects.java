package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;


public class ChallengeOneObjects {

    @FindBy(id="firstname")
    private WebElement firstNameField;

    @FindBy(name="formSubmit")
    private WebElement submitButton;

    @FindBy(className="values-tested")
    private WebElement counter;

    @FindBy(xpath = "//ul[@class='values-description t10']/li[1]")
    private WebElement checkValue;

    public ChallengeOneObjects submitFirstName(String FirstName){
        firstNameField.sendKeys(FirstName);
        submitButton.click();
        return this; }
    public void waitForCounterChange(String counterValue){
        Utils.waitForElementToBeVisible(counter, counterValue);
    }
    public int getCounter(){
        return Integer.parseInt(counter.getText());
    }
    public String getTextValue(){
        return checkValue.getText();
    }



}
