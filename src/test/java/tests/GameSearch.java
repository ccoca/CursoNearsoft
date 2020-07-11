package tests;

import components.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.BaseSettings;


public class GameSearch extends BaseSettings {

    private NavBar navBar;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
    }



    // search for term "Hunt", from hunt:showdown   --- If you can read this you should totally buy the game --
    @Test
    public void searchForGame(){
        navBar.gameSearchInput("Hunt");
        navBar.getSuggestedGames();
    }

    // Go to game store page
    @Test
    public void enterGameStorePage(){
        String gameName = "Hunt: Showdown";
        navBar.gameSearchInput(gameName);
        navBar.enterGamePageStore(gameName);
        System.out.println("debug");
        navBar.skipAgeCheck();
        String currentGameStoreTitle = navBar.gameTitle.getText();
        Assert.assertEquals(currentGameStoreTitle,gameName);
    }

    @Test
    public void validateGameStoreGameInfo() {
        String gameName = "Age of Empires II: Definitive Edition";
        String expTitle = "Age of Empires II: Definitive Edition";
        String expGenre = "Estrategia";
        String expDev = "Forgotten Empires, Tantalus Media, Wicked Witch";
        String expEditor = "Xbox Game Studios";
        String expFranchise = "Age of Empires";
        String expLaunchDate = "14 NOV 2019";
        String expData = "TÍTULO: "+expTitle+"\n" +
                "GÉNERO: "+expGenre+"\n" +
                "DESARROLLADOR: "+expDev+"\n" +
                "EDITOR: "+expEditor+"\n" +
                "FRANQUICIA: "+expFranchise+"\n" +
                "FECHA DE LANZAMIENTO: "+expLaunchDate;


        navBar.gameSearchInput(gameName);
        navBar.enterGamePageStore(gameName);
        System.out.println("debug");
        navBar.skipAgeCheck();
        String currentGameStoreTitle = navBar.gameTitle.getText();
        String currentTitle = "";
        String detailsBlock = navBar.detailsBlock.getText();
        Assert.assertEquals(detailsBlock,expData);
    }


}
