package racingcar;

import java.util.ArrayList;

public class GameControl {
    private int raceNumber;
    private String[] playerNames;
    private ArrayList<Player> players;

    private GameModel gameModel;
    private UI ui;


    private void set(){
        String unsplitPlayerNames = ui.askPlayerNames();
        playerNames = unsplitPlayerNames.split(",");

        for(String inputName : playerNames){
            String name = inputName.trim();

            if(name.length() > 5)
                throw new IllegalArgumentException();

            Player player = new Player(name);
            gameModel.addPlayer(player);
        }

        players = gameModel.getPlayers();
        raceNumber = ui.askRaceNum();
    }

    private void play(){
        ui.printRaceResult(players, raceNumber);
        ArrayList<String> winners = gameModel.getWinner();
        ui.printWinnerText(winners);
    }

    public void run(){
        set();
        play();
    }
}
