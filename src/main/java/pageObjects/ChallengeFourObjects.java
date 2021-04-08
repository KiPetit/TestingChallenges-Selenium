package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class ChallengeFourObjects {

    private final String expectedResultText="YOU HAVE DONE IT";
    @FindBy(className = "inputbox")
    private WebElement cnpField;

    @FindBy(name = "formSubmit")
    private WebElement submit;

    @FindBy(className = "values-tested")
    private WebElement counter;

    @FindBy(xpath = "//span[1]/font")
    private WebElement resultText;

    public void submitCNP(){
        cnpField.sendKeys(Utils.generateCNP());
        submit.click();
    }
    public void waitForCounterChange(String counterValue){
        Utils.waitForElementToBeVisible(counter, counterValue);
    }
    public int getCounter(){
        return Integer.parseInt(counter.getText());
    }
    public String getResultText(){
        return resultText.getText();
    }
    public String getExpectedResultText(){
        return expectedResultText;
    }
}
