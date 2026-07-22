package org.example.models;

public class Dice {

    int count ;
    int maxNum ;

    public Dice(int count, int maxNum) {
        this.count = count;
        this.maxNum = maxNum;
    }

    public int roll() {
        double move = 0;

        for(int i = count ; i < count ; i++) {
            move += Math.random()*(maxNum-1) + 1;
        }

        return (int)move;
    }
}
