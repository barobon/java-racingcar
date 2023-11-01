package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.Contstants.*;

public class UI {
    public String askPlayerNames(){
        System.out.println(ASK_PLAYERS_MESSAGE);
        String players_String = Console.readLine();
        return players_String;
    }

    public int askRaceNum(){
        System.out.println(ASK_RACE_NUMBERS_MESSAGE);
        String raceNumberString = Console.readLine();
        try {
            int raceNumber = Integer.parseInt(raceNumberString);
            return raceNumber;
        } catch (NumberFormatException e) {
            // 정수로 파싱할 수 없는 값이 입력될 때 예외 처리
            throw new IllegalArgumentException();
        }
    }

    public void printRaceResult(ArrayList<Player> playersList, int raceNumber){
        System.out.println();   //줄바꿈
        System.out.println(RACE_RESULT_MESSAGE);
        for(int i=0; i<raceNumber; i++){
            printCurrentPlayersScore(playersList);
            System.out.println();   //줄바꿈
        }
    }

    public void printWinnerText(ArrayList<String> winnerList){
        String winners = winnerList.stream().collect(Collectors.joining(", "));
        System.out.print(LAST_WINNER_MESSAGE+winners);
    }
    private void printCurrentPlayersScore(ArrayList<Player> playersList){
        for(Player player : playersList){
            String name = player.getName();
            player.race();
            int score = player.getScore();

            System.out.print(name+COLON);
            for(int i=0; i<score; i++){
                System.out.print(SCORE_TEXT);
            }
            System.out.println();   //줄바꿈
        }
    }

}
