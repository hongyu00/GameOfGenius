/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author User
 */
import constants.Constants;
import java.util.Random;

public class Dice {

    private int numOfSides;
    private final Random roll;

    public Dice() {
        numOfSides = Constants.NOOFSIDES;
        roll = new Random();
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public void setNumOfSides(int n) {
        numOfSides = n;
    }

    public int rollDice() {
        return roll.nextInt(numOfSides) + 1;
    }

    public String getDiceImage(int diceNo) {
        switch (diceNo) {
            case 1: return Constants.DICE1;
                
            case 2: return Constants.DICE2;
                
            case 3: return Constants.DICE3;
                
            case 4: return Constants.DICE4;
                
            case 5: return Constants.DICE5;
                
            case 6: return Constants.DICE6;
            
            default: return "";
        }
    }

    public String toString() {
        return "You have rolled on number " + getNumOfSides();
    }

}
