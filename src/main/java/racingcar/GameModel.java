package racingcar;

import java.util.ArrayList;

public class GameModel {
    int max;
    ArrayList<Player> players;

    public GameModel(){
        max = -1;
        players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<String> getWinner(){
        int winnerScore = calculateMaxScore();
        ArrayList<String> winners = new ArrayList<String>();
        for(Player player : players){
            if(player.getScore() == winnerScore)
                winners.add(player.getName());
        }
        return winners;
    }

    private int calculateMaxScore(){
        for(Player player : players){
            int score = player.getScore();
            if(score>max)
                max = score;
        }
        return max;
    }
}
