/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constants.Constants;
import adt.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class Map {

    Dice dice = new Dice();
    private String[][] map;
    private String[][] properties;
    private int[][] index;

    public void setMap(String[][] newMap) {
        map = newMap;        
    }
   /* private String[][] friendsMatrix = new String[][];
    public void becomeFriends(String name1, String name2){
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < len ; i++){
            if(s[i].equals(name1)){
                x = i;
            }
            if(s[i].equals(name2)){
                y = i;
            }
        }
        friendsMatrix[x][y] = "*";
    }
    public boolean areTheyFriends(String name1, String name2){
        boolean isFriends = false;
        
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < len ; i++){
            if(s[i].equals(name1)){
                x = i;
            }
            if(s[i].equals(name2)){
                y = i;
            }
        }
        if("*".equals(friendsMatrix[x][y]) || "*".equals(friendsMatrix[y][x])){
            isFriends = true;
        }
        return isFriends;
    }*/
    
    
    public void getMap() {
        for (int i = 0; i < Constants.ROW; i++) {
            for (int j = 0; j < Constants.COLUMN; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> randomMapProperties() {

        Random rand = new Random();

        ArrayList<Integer> property = new ArrayList<>();
        String saveNumber = "";
        int randomProperty = 0;
        for (int i = 0; i < Constants.PROPERTIES.length; i++) {
            do {
                randomProperty = rand.nextInt(Constants.PROPERTIES.length);
            } while (checkRepeatNumber(saveNumber, randomProperty) == false);

            saveNumber += "|" + Integer.toString(randomProperty) + "|";
            property.add(randomProperty);
        }

        return property;
    }
    
    public String getProperty(int playerLocation) {

         for (int k = 0; k < Constants.ROW; k++) {
            for (int j = 0; j < Constants.COLUMN; j++) {
                if (playerLocation == Constants.FIXEDINDEXFORMAP[k][j]) {                   
                    return properties[k][j];
                }
            }
        }
         return null;
        
    }
    
    public String[][] setProperties(ArrayList<Integer> property){
        String[][] setProperties = new String[10][10];
        int z = 1;
        for (int k = 0; k < Constants.ROW; k++) {
            for (int j = 0; j < Constants.COLUMN; j++) {
                if (Constants.FIXEDMAP[k][j].contains("X")) {                   
                    setProperties[k][j] = Constants.PROPERTIES[property.getEntry(z)];
                    z++;
                } else {
                    setProperties[k][j] = " ";
                }
            }
        }
        properties = setProperties;
        return setProperties;
    }
    
    
    public String[][] fillPropertiesToMap(String[][] setProperties, int numberOfPlayers){
        String[][] newMap = new String[10][10];
        
        int z = 0;
        for (int k = 0; k < Constants.ROW; k++) {
            for (int j = 0; j < Constants.COLUMN; j++) {
                String temp = Constants.FIXEDMAP[k][j];
                if (Constants.FIXEDMAP[k][j].contains("X")) {
                    temp = Constants.FIXEDMAP[k][j].replaceAll("X", setProperties[k][j]);
                    
                    newMap[k][j] = temp;
                    z++;
                } else {
                    newMap[k][j] = temp;
                }
            }
        }
        switch(numberOfPlayers){
            case 2: newMap[0][0] = "[12🎌  ]";
                break;
            case 3: newMap[0][0] = "[12🎌3 ]";
                break;
            case 4: newMap[0][0] = "[12🎌34]";
                break;
        }
        return newMap;
    }
    
    public int updateMap(int diceSides, int playerLocation, int playerID){
        int moveTo = (diceSides + playerLocation) % 36;
        int tempCol = 0, tempRow = 0;
        String[][] changeMap = new String[10][10];
        String id = Integer.toString(playerID);
        String temp;
        
        for(int i = 0 ; i < Constants.ROW; i++){
            for(int j = 0 ; j < Constants.COLUMN; j++){
                //delete previous location
                if(map[i][j].contains(id)){
                    map[i][j] = map[i][j].replaceAll(id, " ");
                    
                }
                //get row,col index to update player location
                if(moveTo == Constants.FIXEDINDEXFORMAP[i][j]){
                    tempCol = i;
                    tempRow = j;
                    
                }

            }
        }
        switch(playerID){
            case 1: map[tempCol][tempRow] = changePlayerLocation(map[tempCol][tempRow], playerID, playerID);
                break;
            case 2: map[tempCol][tempRow] = changePlayerLocation(map[tempCol][tempRow], playerID, playerID);
                break;
            case 3: map[tempCol][tempRow] = changePlayerLocation(map[tempCol][tempRow], playerID, playerID + 1);
                break;
            case 4: map[tempCol][tempRow] = changePlayerLocation(map[tempCol][tempRow], playerID, playerID + 1);
                break;
        }
        
        setMap(map);
        
        //print the latest location the player is now located at
        for (int a = 0; a < Constants.ROW; a++) {
            for (int b = 0; b < Constants.COLUMN; b++) {               
                System.out.print(map[a][b]);
            }
            System.out.println();
        }
       return moveTo;
    }
    
    public String changePlayerLocation(String map, int playerID, int playerIDToItsLocation ){
        StringBuilder old = new StringBuilder(map);
        String convert = Integer.toString(playerID);
        char playerChar = convert.charAt(0);
        old.setCharAt(playerIDToItsLocation, playerChar);
        return old.toString();
    }
    

    public static boolean checkRepeatNumber(String saveNumber, int randomIndex) {
        if (saveNumber.contains("|" + Integer.toString(randomIndex) + "|")) {
            return false;
        } else {
            return true;
        }

    }


    
}
