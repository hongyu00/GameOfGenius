package gameofgenius;

import entity.GameLogic;
import constants.Constants;
import java.util.Scanner;

public class GameOfGenius {

    GameLogic game = new GameLogic();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GameOfGenius gg = new GameOfGenius();
        gg.welcome();
        gg.getOption();

    }

    public void welcome() {
        System.out.println(Constants.WELCOME);
        System.out.println(Constants.LOGO);
        System.out.println("\n\n\n");
        System.out.println(Constants.GAMEOPTION);
    }

    public void getOption() {

        String selection = "";
        do {
            System.out.print("Selection: ");
            selection = sc.nextLine();
            if (!selection.equals("1") && !selection.equals("2") && !selection.equals("3")) {
                System.out.println("Invalid input!\n");
            }
        } while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3"));

        switch (Integer.valueOf(selection)) {
            case 1: ;
                game.gameStarts();
                break;
            case 2:
                System.out.println(Constants.INSTRUCTION);
                System.out.println(Constants.GAMEOPTION);
                getOption();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

}
