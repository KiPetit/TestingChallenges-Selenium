package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;
    public static void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        driver=new ChromeDriver();
    }
    public static void closeDriver(){
       driver.quit();
    }


}
