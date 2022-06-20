package entity;

import adt.ArrayList;
import adt.Queue;
import adt.Stack;
import constants.Constants;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GameLogic {

    private int totalPlayers;

    Dice dice = new Dice();
    Map map = new Map();
    Player player = new Player();
    GameType gameType = new GameType();

    ArrayList<Player> playerList = new ArrayList<>();
    Queue<Player> playerWinRank = new Queue<>();
    Stack<Player> playerLoseRank = new Stack<>();
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public int getTotalPlayer() {
        return this.totalPlayers;
    }

    public void setTotalPlayer(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public void gameStarts() {
        gameType.readBothFiles();
        playerList = player.setNoOfPlayers();
        setTotalPlayer(playerList.getLength());
        player.printPlayers(playerList);
        int playerLeft = playerList.getLength();
        map.setMap(map.fillPropertiesToMap(map.setProperties(map.randomMapProperties()), getTotalPlayer()));
        System.out.println("\n\n");
        map.getMap();
        boolean gameOver = false;
        Player tempName;
        Player loserName;
        int winPlayerCount = 0, losePlayerCount = 0;
        //take players turn every do while loop
        do {
            tempName = player.takeTurns();
            playerTurnsSelection(tempName, playerLeft);

 
            if (tempName.getCurrentGold() >= Constants.GOLDTOWIN) {
                System.out.println("\n\n---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nCongratulations!!! " + tempName.getPlayerName().toUpperCase() + " has won the game.");

                playerWinRank.enqueue(tempName);
                Player temp2 = player.removeLast(tempName.getPlayerQueue());
                String tempnameee = temp2.getPlayerName();
                System.out.println("Player " + tempnameee.toUpperCase() + " has added into the top of the scoreboard!\n");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                playerLeft--;
                winPlayerCount++;
                playerList.getEntry(tempName.getPlayerID()).setPlayerStatus("WON");
            }

            if (tempName.getCurrentGold() <= Constants.MINIMUMGOLD) {
                System.out.println("\n\n---------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nOh no.... " + tempName.getPlayerName().toUpperCase() + " has lost all the gold and has been eliminated.");
                playerLoseRank.push(tempName);
                Player temp2 = player.removeLast(tempName.getPlayerQueue());
                String tempnameee = temp2.getPlayerName();
                System.out.println("Player " + tempnameee.toUpperCase() + " added into the bottom of the scoreboard!\n");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                playerLeft--;
                losePlayerCount++;
                playerList.getEntry(tempName.getPlayerID()).setPlayerStatus("LOST");
            }

            if (playerLeft == 1) {
                loserName = player.takeTurns();
                playerLoseRank.push(loserName);
                losePlayerCount++;
                gameOver = true;
            }

        } while (!gameOver);

        System.out.println("\n\n\n\n\n");
        System.out.println(String.format("%55s", "PLAYERS RANK"));
        for (int i = 0; i < 100; i++) {
            System.out.print("=");
        }
        System.out.println();

        player.displayPlayerRank(playerWinRank, playerLoseRank, winPlayerCount, losePlayerCount);

        for (int i = 0; i < 100; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void playerTurnsSelection(Player players, int playerLeft) {
        String name = players.getPlayerName().toUpperCase();
        System.out.println("\n\nIt's " + name + "'s turn!\n\n");
        String opt;
        do {
            System.out.println("What would " + name + " like to do for this round?");
            System.out.println("1. Roll Dice");
            System.out.println("2. Check Current Player Progress");
            System.out.println("3. Give Up this round");
            System.out.print("\nSelection: ");
            opt = sc.nextLine();
            if (!opt.equals("1") && !opt.equals("2") && !opt.equals("3")) {
                System.out.println("Invalid input!\n");
            }
        } while (!opt.equals("1") && !opt.equals("2") && !opt.equals("3"));

        switch (Integer.valueOf(opt)) {
            case 1:
                proceedRollDice(players, playerLeft);
                break;
            case 2:
                player.printPlayers(playerList);
                System.out.println("\n\n\n");
                playerTurnsSelection(players, playerLeft);
                break;
            case 3:
                System.out.println("\nAre you giving up or giving other player chances? Hmmmmm......");
                break;
        }
    }

    public void proceedRollDice(Player players, int playerLeft) {
        int diceRoll = dice.rollDice();
        System.out.println("\nYou have rolled on number " + diceRoll + "!\n" + dice.getDiceImage(diceRoll) + "\n");

        int location = players.getPlayerLocation();
        int playerID = players.getPlayerID();
        int newPlayerLocation = map.updateMap(diceRoll, location, playerID);
        if (newPlayerLocation < location) {
            players.updateGold(Constants.STARTINGPOINTGOLD);
            System.out.println("\nYou have pass by the Starting Point, 1 additional gold will be added!");
        }
        players.setPlayerLocation(newPlayerLocation);
        takeGameType(map.getProperty(newPlayerLocation), playerID, playerLeft);

    }

    public void takeGameType(String property, int playerID, int playerLeft) {
        int gold = 0;
        switch (property) {
            case "Q":
                gold = gameType.quiz();
                break;
            case "M":
                gold = gameType.miniGame();
                break;
            case "B":
                gold = gameType.betting();
                break;
            case "L":
                gold = gameType.luxury();
                break;
            case "P":
                gold = gameType.poverty();
                break;
            case "T":
                gold = gameType.theft();
                int victim = avoidWinLosePlayer(playerID);
                for (int i = 1; i <= getTotalPlayer(); i++) {
                    if (victim == playerList.getEntry(i).getPlayerID()) {
                        System.out.println("\nYou have stolen " + playerList.getEntry(i).getPlayerName() + "'s gold! Hope that player doesn't check the current player progress"
                                         + " to realise that he/she has lost 2 gold unexpectedly. Hehe......\n");
                        playerList.getEntry(i).updateGold(-gold);
                        player.updateGold(-gold);
                        break;
                    }
                }
                break;
            case "C":
                gold = gameType.charity();
                int receiver = avoidWinLosePlayer(playerID);
                for (int i = 1; i <= getTotalPlayer(); i++) {
                    if (receiver == playerList.getEntry(i).getPlayerID()) {
                        System.out.println("\nYou have donated your gold to " + playerList.getEntry(i).getPlayerName() + "! Being generous is always a good role model.\n");
                        playerList.getEntry(i).updateGold(Math.abs(gold));
                        player.updateGold(Math.abs(gold));
                        break;
                    }
                }
                break;
        }
        playerList.getEntry(playerID).updateGold(gold);
        player.updateGold(gold);
    }

    //prevent taking players gold who have won/lost
    public int avoidWinLosePlayer(int playerID) {
        int victim = 0;
        do {
            victim = rand.nextInt(getTotalPlayer()) + 1;
        } while (victim == playerID);
        for (int i = 1; i <= getTotalPlayer(); i++) {
            if (victim == playerList.getEntry(i).getPlayerID()) {
                if (playerList.getEntry(i).getPlayerStatus().equals("WON") || playerList.getEntry(i).getPlayerStatus().equals("LOST")) {
                    avoidWinLosePlayer(playerID);
                } else {
                    break;
                }
            }
        }
        return victim;
    }

}
