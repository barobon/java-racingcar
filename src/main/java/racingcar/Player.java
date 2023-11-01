package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    private final String name;
    private int score;

    public Player(String name){
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }

    public void race(){
        int moveAmount = Randoms.pickNumberInRange(0,9);
        if(moveAmount>=4)
            score++;
    }

}
