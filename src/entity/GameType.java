/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.LinkedList;
import constants.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GameType {

    //Quiz quiz = new Quiz();
    LinkedList<String> questions = new LinkedList<>();
    LinkedList<String> answers = new LinkedList<>();
    Random rand = new Random();
    static int quizCount = Constants.QUIZCOUNT;

    public int betting() {
        String gold;
        Scanner sc = new Scanner(System.in);
        System.out.println("Betting game!\n");
        System.out.println("Borrow from the Genius Bank! If you win the amount you bet, it's double all yours! But if you lose the amount you bet, you have to pay back the bank!");
        System.out.println("How many gold do you want to borrow from the bank to bet? Minimum Gold: 0 Maximum gold: 4\n");
        do {
            System.out.print("Gold: ");
            gold = sc.nextLine();
            if (!gold.equals("0") && !gold.equals("1") && !gold.equals("2") && !gold.equals("3") && !gold.equals("4")) {
                System.out.println("Wrong input. Please try again");
            }
        } while (!gold.equals("0") && !gold.equals("1") && !gold.equals("2") && !gold.equals("3") && !gold.equals("4"));

        if (Integer.parseInt(gold) == 0) {
            System.out.println("\nYou choose not to bet! Seems like you are afraid of losing your gold.");
            return 0;
        } else {
            Random rand = new Random();
            int headTail = rand.nextInt(2) + 1;

            String selection;
            System.out.println("\nChoose either head or tail!");
            System.out.println("1. Head");
            System.out.println("2. Tail");
            do {
                System.out.print("Selection: ");
                selection = sc.nextLine();
                if (!selection.equals("1") && !selection.equals("2")) {
                    System.out.println("Wrong input. Please try again");
                }
            } while (!selection.equals("1") && !selection.equals("2"));
            if (headTail == 1) {
                System.out.println("System random out a Head!");
            } else {
                System.out.println("System random out a Tail!");
            }

            if (selection.equals(Integer.toString(headTail))) {
                System.out.println("\nYou have guessed it right! You will earn double the gold that you bet!!");
                return (Integer.parseInt(gold) * 2);
            } else {
                System.out.println("\n50% chance and you couldn't get it right. The amount of gold you bet will be lost. Better luck next time!");
                return (-(Integer.parseInt(gold)));
            }
        }

    }

    public int charity() {
        System.out.println("\nCharity game!\n");
        System.out.println("You have done a good deed for donating 2 golds to other players. ");
        return Constants.CHARITY;
    }

    public int luxury() {
        System.out.println("\nCongratulations! You have gained extra 3 golds for landing at Luxury block!");

        return Constants.LUXURY;
    }

    public int miniGame() {
        Random r = new Random();
        int i = r.nextInt(2) + 1;
        System.out.println("\nMini Game!");
        int gold;
        switch (i) {
            case 1:
                System.out.println("It's dungeon time!!!!!!\n\n");
                System.out.println("W: ↑ ,S: ↓ ,A: ← ,D: →");
                System.out.println("Type \'W\' to move upwards.\nType \'S\' to move downwards.\nType \'A\' to move left.\nType \'D\' to move right.");
                System.out.println("Type \'GG\' to give up on this mini game!\n");
                System.out.println("Every turn will only show the player his current 5x5 vision. Which is the obstacles of this mini game!");
                System.out.println("Get to the location that has a \'G\' sign to collect a maximum of 3 golds!Good luck!\n");

                CaveGame game = new CaveGame();
                gold = game.playgame();
                
                System.out.println("You have earned a total of " + gold + " gold(s) in Game of Cave!");
                return gold;
            case 2:
                System.out.println("It's tic-tac-toe time!!!!!!\n\n");
                System.out.println("\'X\' indicates player and \'O\' indicates system!\n");

                TicTacToe t1 = new TicTacToe();
                t1.displayBoard(t1.tictacBoardExample);
                System.out.println("\nGood luck!!!\n");
                gold = t1.playGame();
                System.out.println("You have earned a total of " + gold + " gold(s) in Tic Tac Toe!");
                return gold;

        }
        return 0;
    }

    public int poverty() {
        System.out.println("\nOh noooooo! You just lost 3 golds for landing at Poverty block! How unlucky you are!");

        return Constants.POVERTY;
    }

    public int theft() {
        System.out.println("theft game");
        System.out.println("You sneaky little player. Stealing is not good tho! But in order to beat your friends, just steal their gold!");
        return Constants.THEFT;
    }

    public int quiz() {

        int index;
        index = rand.nextInt(quizCount--) + 1;
        System.out.println("\n\nQuestion: ");
        System.out.println(questions.getEntry(index));
        String answer = answers.getEntry(index);
        questions.removeAt(index);
        answers.removeAt(index);

        if (questions.getLength() == 0) {
            readBothFiles();
        }

        System.out.print("\n\nAnswer: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.toUpperCase().equals(answer)) {
            System.out.println("\nCorrect answer! You have earned yourself 5 gold!\n");
            return Constants.QUIZREWARD;
        } else {
            System.out.println("\nOpps, you failed to answer it correctly. 3 golds will be deducted from you. Better luck next time!\n");
            return Constants.QUIZPUNISHMENT;
        }
    }

    public void readBothFiles() {

        File myQuestion = new File("questions.txt");

        try {

            Scanner readQuestion = new Scanner(myQuestion);
            while (readQuestion.hasNextLine()) {
                String temp = readQuestion.nextLine();
                temp = temp.replaceAll("\\?", "?\n\n");
                questions.insert(temp);

            }
            readQuestion.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }

        File myAns = new File("answers.txt");

        try {

            Scanner readAns = new Scanner(myAns);
            while (readAns.hasNextLine()) {
                String temp = readAns.nextLine();
                temp = temp.replaceAll("\\?", "?\n\n");
                answers.insert(temp);
            }
            readAns.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
    }

}
