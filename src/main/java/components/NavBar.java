package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasicActions;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends BasicActions {

    @FindBy(id = "foryou_tab")
    private WebElement yourStoreTab;

    @FindBy (id = "store_nav_search_term")
    private WebElement storeSearch;

    @FindBy(css = "#search_suggestion_contents > a > .match_name")
    private List<WebElement> suggestedGames;

    @FindBy (css = ".apphub_AppName")
    public WebElement gameTitle;

    @FindBy (css = "div.game_details .block_content_inner > div:nth-of-type(1)")
    public WebElement detailsBlock;

    public NavBar(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void gameSearchInput(String gameName){
        this.writeToInput(storeSearch, gameName);
        }

    public ArrayList<String> getSuggestedGames(){

        ArrayList<String> suggestedList = new ArrayList<String>();

        for (WebElement suggestedGame : suggestedGames)
        {
            suggestedList.add(suggestedGame.getText());
        }

        return suggestedList;
    }


public void enterGamePageStore(String gameName){
   WebElement game = this.driver.findElement(By.xpath("//*/div[.='"+gameName+"']"));
   assertClick(game);
}


}




