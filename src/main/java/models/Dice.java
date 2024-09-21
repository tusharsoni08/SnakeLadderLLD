package models;

public class Dice {
    int maxValue;

    public Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int rollDice() {
        return (int) Math.floor(Math.random()*maxValue)+1;
    }
}
