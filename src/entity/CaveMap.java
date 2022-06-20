package entity;


import constants.Constants;
import java.util.Random;

public class CaveMap {

    public CavePlayer player;
    private Random random;
    
    private int x;
    private int y;

    private int PlayersiteX;
    private int PlayersiteY;
  
    private int movement1;
    private int movement2;

    public boolean SiteGold = false;
    public boolean GoldPickUp = false;


    private char[][] map;

    private String mapName;


    private int goldRequired;

   
    public CaveMap() {
        random = new Random();
        mapName = "Game of Cave";
        goldRequired = 4;
        map = Constants.FIXEDMAPFORCAVEGAME;

        spawnplayer('P');
    }

 
    public int getGoldRequired() {
        return goldRequired;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(){
        map = Constants.FIXEDMAPFORCAVEGAME;
    }
    
    
    public String getMapName() {
        return mapName;
    }

 
    public void spawnplayer(char c) {
        int ri = random.nextInt(map.length);
        int rj = random.nextInt(map[ri].length);
        if (map[ri][rj] != '#' && map[ri][rj] != 'G') {
            map[ri][rj] = c;
        } else {
            spawnplayer(c);
        }
    }
    
    public void deletePlayer(char c){
        int ri = random.nextInt(map.length);
        int rj = random.nextInt(map[ri].length);
        if (map[ri][rj] == 'P') {
            map[ri][rj] = '.';
        } else {
            deletePlayer(c);
        }
    }

    public void findPosition(char playerLocation) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == playerLocation) {
                    y = i;
                    x = j;
                    if (playerLocation == 'P') {
                        PlayersiteY = i;
                        PlayersiteX = j;

                    }
                }
            }
        }
    }


    public int getSiteX() {
        return PlayersiteX;
    }


    public int getSiteY() {
        return PlayersiteY;
    }


    public boolean Movement(String Command, char playerLocation) {
        findPosition(playerLocation);
        if (Command.equalsIgnoreCase("W")) {
            movement1 = x;
            movement2 = y - 1;
        } else if (Command.equalsIgnoreCase("S")) {
            movement1 = x;
            movement2 = y + 1;
        } else if (Command.equalsIgnoreCase("D")) {
            movement1 = x + 1;
            movement2 = y;
        } else if (Command.equalsIgnoreCase("A")) {
            movement1 = x - 1;
            movement2 = y;
        }

        if (map[movement2][movement1] == '#') {
            return false;
        } else if (GoldPickUp == false && SiteGold == true && playerLocation == 'P') {
            map[y][x] = 'G';
            map[movement2][movement1] = playerLocation;
            SiteGold = false;
            if (map[movement2][movement1] == 'G') {
                SiteGold = true;
            }
            return true;
        } else if (map[movement2][movement1] == 'G') {
            if (playerLocation == 'P') {
                SiteGold = true;
            }

            map[movement2][movement1] = playerLocation;
            map[y][x] = '.';
            return true;

        }  else {
            map[movement2][movement1] = playerLocation;
            map[y][x] = '.';
            return true;
        }
    }

    public String toString(char playerLocation) {
        findPosition(playerLocation);
        String s = "";
        for (int vertical = y - 2; vertical < y + 3; vertical++) {
            for (int horizontal = x - 2; horizontal < x + 3; horizontal++) {
                if (vertical < 0 || vertical >= map.length) {
                    s += '#';
                } else if (horizontal < 0 || horizontal >= map[y].length) {
                    s += '#';
                } else {
                    s += map[vertical][horizontal];
                }
            }
            s += "\n";
        }
        return s;
    }
}
