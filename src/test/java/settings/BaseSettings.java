package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

abstract public class BaseSettings {
    protected WebDriver driver;

    @BeforeSuite
    public void Setup(){

         this.driver = new DriverSetup("Chrome").getDriver();
         this.driver.get("https://store.steampowered.com/");
    }
    @AfterSuite
    public void suitTearDown(){
        this.driver.close();
        this.driver.quit();
    }


}
