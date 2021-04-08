package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class ChallengeTenObjects {

    Utils utils=new Utils();
    ArrayList<String> data=utils.getData("usernames", "kipi");

    private final String Username=Utils.randomUsernameGenerator();
    private final String Password=data.get(1);
    private final String Firstname=data.get(2);
    private final String Lastname=data.get(3);
    private final int userID=1;

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="firstname")
    private WebElement firstname;

    @FindBy(name = "lastname")
    private WebElement lastname;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//tbody/tr[2]/th[1]")
    private WebElement tableID;

    @FindBy(xpath = "//tbody/tr[2]/th[2]")
    private WebElement tableUsername;

    @FindBy(xpath = "//tbody/tr[2]/th[3]")
    private WebElement tablePassword;

    @FindBy(xpath = "//tbody/tr[2]/th[4]")
    private WebElement tableFirstname;

    @FindBy(xpath = "//tbody/tr[2]/th[5]")
    private WebElement tableLastname;

    public ChallengeTenObjects() throws IOException {
    }
    public ChallengeTenObjects registerUser(){
        username.sendKeys(Username);
        password.sendKeys(Password);
        firstname.sendKeys(Firstname);
        lastname.sendKeys(Lastname);
        submit.click();
        return this;
    }
    public int getID(){
        return Integer.parseInt(tableID.getText());
    }
    public String getTableUsername(){ return tableUsername.getText(); }
    public String getTablePassword(){
        return tablePassword.getText();
    }
    public String getTableFirstname(){
        return tableFirstname.getText();
    }
    public String getTableLastname(){
        return tableLastname.getText();
    }
    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return Password;
    }
    public String getFirstName(){ return Firstname;
    }
    public String getLastName(){
        return Lastname;
    }
    public int getUserID(){ return userID;}


}
