package entity;

import adt.ListADT;
import java.util.Scanner;
public class CaveGame {

    private CaveMap map;
    private int gold;
    CavePlayer player1 = new CavePlayer('P');
    ListADT<CavePlayer> players = new ListADT<>();
    Scanner sc = new Scanner(System.in);

    public CaveGame() {
        map = new CaveMap();

    }

    public int playgame() {

        map.setMap();
        players.add(player1);
        System.out.println(map.getMapName());
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 25; j++) {
                System.out.print(map.getMap()[i][j]);
            }
            System.out.println();
        }
        System.out.println("Game Starts!");
        boolean loop = false;
        while (loop == false) {
            CavePlayer current = players.getEntry(0);
            String input = sc.nextLine();
            //String input = current.getMove();

            if (input.equalsIgnoreCase("W") || input.equalsIgnoreCase("A") || input.equalsIgnoreCase("S") || input.equalsIgnoreCase("D") || input.equalsIgnoreCase("GG")) {
                if (input.equalsIgnoreCase("W") || input.equalsIgnoreCase("A") || input.equalsIgnoreCase("S") || input.equalsIgnoreCase("D")) {
                    System.out.println(move(input, current.getToken()));
                } else {
                    loop = true;
                }
            } else {
                System.out.println("Invalid Command - try again");
            }

            System.out.println("\n" + pickup());
            System.out.println("\n\nYOUR CURRENT LOCATION\n" + viewLimitedMap('P'));
            System.out.println(goldOwned());

            if (input.equalsIgnoreCase("GG") || gold == 3) {
                System.out.println("End Game");
                map.deletePlayer('P');
                loop = true;
            }
        }
        return gold;
    }

    public int goldRequired() {
        return map.getGoldRequired();
    }

    public String goldOwned() {

        return ("Gold owned: " + gold);
    }


    public String move(String direction, char playerLocation) {
        if (map.Movement(direction, playerLocation) == true) {
            return "SUCCESSFULLY MOVE";
        } else {
            return "MOVE FAILED";
        }
    }


    public String viewLimitedMap(char playerLocation) {
        return map.toString(playerLocation);
    }

 
    public String pickup() {
        if (map.SiteGold == true) {
            map.SiteGold = false;
            gold++;
            return ("SUCCESS. Gold owned: " + gold);
        }
        return ("NO GOLD HERE...");
    }

}
