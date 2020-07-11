package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions {

    private static final int TIMEOUT = 5;

    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasicActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TIMEOUT);
        actions = new Actions(this.driver);
    }

    public void waitForElementPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void assertClick(WebElement element) {
        this.waitForElementPresent(element);
        this.waitForElementClickable(element);
        element.click();
    }

    public void writeToInput(WebElement element, String message){
        this.waitForElementPresent(element);
        element.sendKeys(message);
    }

    public void hoverElement(WebElement element){
        this.waitForElementPresent(element);
        actions.moveToElement(element).perform();
    }

public void skipAgeCheck(){
      String  currentURL = this.driver.getCurrentUrl();
      System.out.println(currentURL);

      if (currentURL.contains("agecheck")) {
          Select ageDrop = new Select(this.driver.findElement(By.name("ageYear")));
          ageDrop.selectByValue("1984");
          WebElement verPagina = this.driver.findElement(By.xpath("//*/span[.='Ver página']"));
          assertClick(verPagina);
      }
          else
              System.out.println("No Age Check");
      }


}





