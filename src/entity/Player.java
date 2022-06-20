package entity;

/**
 *
 * @author CHEW HONG YU
 */
import adt.ArrayList;
import adt.Queue;
import adt.Stack;
import constants.Constants;
import java.util.Scanner;

public class Player {

    private int playerID;
    private String playerName;
    private int playerGold;
    private int playerLocation;
    private int playerTurn;
    private String playerStatus;
    public static Queue<Player> playerTurns = new Queue<Player>();

    public Player() {
        playerID = ++playerID;
        playerName = "";
        playerGold = Constants.INITIALGOLD;
        playerLocation = 0;
        playerTurn = ++playerTurn;
        playerStatus = " ";
    }

    public Player(int id, String name) {
        playerID = id;
        playerName = name;
        playerGold = Constants.INITIALGOLD;
        playerLocation = 0;
        playerTurn = id;
        playerStatus = " ";
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getCurrentGold() {
        return this.playerGold;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(int location) {
        this.playerLocation = location;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String getPlayerStatus() {
        return playerStatus;
    }


    public void updateGold(int amountOfGold) {
        playerGold = playerGold + amountOfGold;
    }


    public ArrayList<Player> setNoOfPlayers() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> playerList = new ArrayList<>();
        System.out.println("\n");

        String noOfPlayer = "";
        do {
            System.out.print("Enter the number of players( 2 - 4 ): ");
            noOfPlayer = sc.nextLine();
            if (!noOfPlayer.equals("2") && !noOfPlayer.equals("3") && !noOfPlayer.equals("4")) {
                System.out.println("Only 2, 3, 4 allowed for this input!\n");
            }
        } while (!noOfPlayer.equals("2") && !noOfPlayer.equals("3") && !noOfPlayer.equals("4"));

        String name = "";

        for (int i = 1; i <= Integer.valueOf(noOfPlayer); i++) {

            System.out.print(String.format("Enter player %d name: ", i));
            name = sc.nextLine();
            Player players = new Player(i, name);

            playerList.add(players);
            playerTurns.enqueue(players);
        }

        return playerList;
    }

    public void printPlayers(ArrayList<Player> playerList) {
        System.out.println(String.format("\n\n%-15s %-50s %-50s", "Player ID", "Player Name", "Player Gold"));

        for (int i = 1; i <= playerList.getLength(); i++) {
            System.out.println(playerList.getEntry(i));
        }
    }

    public Player takeTurns() {
        Player temp = playerTurns.getFront();
        playerTurns.dequeue();
        playerTurns.enqueue(temp);

        return temp;
    }

    public Queue<Player> getPlayerQueue() {
        return playerTurns;
    }

    public Player removeLast(Queue<Player> q) {
        Player first = q.getFront();
        Player current = null;
        while (true) {
            current = q.dequeue();
            if (q.getFront() == first) {
                break;
            }
            q.enqueue(current);
        }
        return current;
    }

    public void displayPlayerRank(Queue<Player> playerWinRank, Stack<Player> playerLoseRank, int winPlayerCount, int losePlayerCount) {
        int place = 1;
        String placeStr = "";
        for (int i = 0; i < winPlayerCount; i++) {
            if (!playerWinRank.isEmpty()) {
                switch (place) {
                    case 1:
                        placeStr = "1st:";
                        break;
                    case 2:
                        placeStr = "2nd:";
                        break;
                    case 3:
                        placeStr = "3rd:";
                        break;
                    case 4:
                        placeStr = "4th:";
                        break;
                }
                System.out.print(String.format("|%42s      %-40s %10s\n", placeStr, playerWinRank.getFront().getPlayerName(), "|"));
                place++;
                playerWinRank.dequeue();
            }
        }
        for (int i = 0; i < losePlayerCount; i++) {
            if (!playerLoseRank.isEmpty()) {
                switch (place) {
                    case 1:
                        placeStr = "1st:";
                        break;
                    case 2:
                        placeStr = "2nd:";
                        break;
                    case 3:
                        placeStr = "3rd:";
                        break;
                    case 4:
                        placeStr = "4th:";
                        break;
                }
                System.out.print(String.format("|%42s      %-40s %10s\n", placeStr, playerLoseRank.pop().getPlayerName(), "|"));
                place++;
            }
        }
    }

    @Override
    public String toString() {

        return String.format("%-15s %-50s %-50s %-10s", getPlayerID(), getPlayerName(), getCurrentGold(), getPlayerStatus());

    }

}
