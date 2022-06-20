package entity;

import adt.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public char[][] tictacBoard = {{' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '}};
    public char[][] tictacBoardExample = {{'1', '|', '2', '|', '3'},
    {'-', '+', '-', '+', '-'},
    {'4', '|', '5', '|', '6'},
    {'-', '+', '-', '+', '-'},
    {'7', '|', '8', '|', '9'}};
    public static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    public static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

    public TicTacToe() {

    }

    public void displayBoard(char[][] tictacBoard) {
        for (char[] row : tictacBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void insertInto(char[][] tictacBoard, int position, String user) {
        char symbol = ' ';
        if (user.equalsIgnoreCase("player")) {
            symbol = 'X';
            playerPosition.add(position);
        } else if (user.equalsIgnoreCase("cpu")) {
            symbol = 'O';
            cpuPosition.add(position);
        }
        switch (position) {
            case 1:
                tictacBoard[0][0] = symbol;
                break;
            case 2:
                tictacBoard[0][2] = symbol;
                break;
            case 3:
                tictacBoard[0][4] = symbol;
                break;
            case 4:
                tictacBoard[2][0] = symbol;
                break;
            case 5:
                tictacBoard[2][2] = symbol;
                break;
            case 6:
                tictacBoard[2][4] = symbol;
                break;
            case 7:
                tictacBoard[4][0] = symbol;
                break;
            case 8:
                tictacBoard[4][2] = symbol;
                break;
            case 9:
                tictacBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public String checkWinner(char[][] tictacBoard) {
        String result = "";
        boolean last = false;
        if (tictacBoard[0][0] == 'X' && tictacBoard[0][2] == 'X' && tictacBoard[0][4] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[2][0] == 'X' && tictacBoard[2][2] == 'X' && tictacBoard[2][4] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[4][0] == 'X' && tictacBoard[4][2] == 'X' && tictacBoard[4][4] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[0][0] == 'X' && tictacBoard[2][0] == 'X' && tictacBoard[4][0] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[0][2] == 'X' && tictacBoard[2][2] == 'X' && tictacBoard[4][2] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[0][4] == 'X' && tictacBoard[2][4] == 'X' && tictacBoard[4][4] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[0][0] == 'X' && tictacBoard[2][2] == 'X' && tictacBoard[4][4] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }
        if (tictacBoard[0][4] == 'X' && tictacBoard[2][2] == 'X' && tictacBoard[4][0] == 'X') {
            result = "Congratulation! You won!!!";
            last = true;
        }

        if (tictacBoard[0][0] == 'O' && tictacBoard[0][2] == 'O' && tictacBoard[0][4] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[2][0] == 'O' && tictacBoard[2][2] == 'O' && tictacBoard[2][4] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[4][0] == 'O' && tictacBoard[4][2] == 'O' && tictacBoard[4][4] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[0][0] == 'O' && tictacBoard[2][0] == 'O' && tictacBoard[4][0] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[0][2] == 'O' && tictacBoard[2][2] == 'O' && tictacBoard[4][2] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[0][4] == 'O' && tictacBoard[2][4] == 'O' && tictacBoard[4][4] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[0][0] == 'O' && tictacBoard[2][2] == 'O' && tictacBoard[4][4] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (tictacBoard[0][4] == 'O' && tictacBoard[2][2] == 'O' && tictacBoard[4][0] == 'O') {
            result = "Opps!!! You lose!!!";
            last = true;
        }
        if (last == false) {
            if (playerPosition.getLength() + cpuPosition.getLength() == 9) {
                result = "Tie Game";
            }
        }

        return result;
    }

    public int playGame() {
        playerPosition.clear();
        cpuPosition.clear();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String result = "";
        String cpuResult = "";
        boolean gameResult = false;
        displayBoard(tictacBoard);
        do {
            int position = 0;
            String chrPosition;

            boolean inputCheck = false;
            boolean repeatPosition = false;

            do {
                System.out.print("Please select a position(1-9):");
                chrPosition = sc.nextLine();
                boolean temp = !chrPosition.equals("1") && !chrPosition.equals("2") && !chrPosition.equals("3") && !chrPosition.equals("4") && !chrPosition.equals("5") && !chrPosition.equals("6") && !chrPosition.equals("7") && !chrPosition.equals("8") && !chrPosition.equals("9");

                if (temp == false) {
                    position = Integer.parseInt(chrPosition);
                    if (playerPosition.contains(position) || cpuPosition.contains(position)) {
                        System.out.println("This position is taken! Enter in an empty position. Please select again: ");
                        repeatPosition = false;

                    } else {
                        repeatPosition = true;
                        position = Integer.parseInt(chrPosition);
                        inputCheck = true;
                    }
                } else {
                    System.out.println("Wrong input!");
                    inputCheck = false;
                }

            } while (inputCheck == false && repeatPosition == false);

            insertInto(tictacBoard, position, "player");
            result = checkWinner(tictacBoard);
            if (result.equals("Congratulation! You won!!!") || result.equals("Opps!!! You lose!!!") || result.equals("Tie Game")) {
                System.out.println("\n" + result);
                break;
            }

            int rndPosition = rnd.nextInt(9) + 1;
            while (playerPosition.contains(rndPosition) || cpuPosition.contains(rndPosition)) {
                rndPosition = rnd.nextInt(9) + 1;
            }
            insertInto(tictacBoard, rndPosition, "cpu");
            displayBoard(tictacBoard);

            cpuResult = checkWinner(tictacBoard);
            if (cpuResult.equals("Congratulation! You won!!!") || cpuResult.equals("Opps!!! You lose!!!") || cpuResult.equals("Tie Game")) {

                System.out.println("\n" + cpuResult);
                break;

            }

        } while (gameResult == false);
        
        if (result.equals("Congratulation! You won!!!")) {
            System.out.println("5 golds will be added into your pocket!\n");
            return 5;
        } else if (result.equals("Opps!!! You lose!!!") || result.equals("Tie Game")) {
            System.out.println("No golds will be given to you!\n");
            return 0;
        } else {
            System.out.println("No golds will be given to you!\n");
            return 0;
        }
    }
}
