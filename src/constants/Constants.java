/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author User
 */
public final class Constants {


    //the starting gold for each player
    public static final int INITIALGOLD = 10;

    //the total gold required inn order to win the game
    public static final int GOLDTOWIN = 30;

    //the minimum gold to have while playing the game, those who have lower than the minimum gold will be elimintaed from the game
    public static final int MINIMUMGOLD = 0;
    
    public static final int STARTINGPOINTGOLD = 1;
    
    //the amount of gold will be given after answering the quiz correctly
    public static final int QUIZREWARD = 5;

    //the amount of gold will be deducted after answering the quiz wrongly
    public static final int QUIZPUNISHMENT = -3;

    //the amount of gold will be rewarded after successfully solving the sudoku in the given time
    public static final int SUDOKUREWARD = 4;

    //the amount of gold a player will get for landing at Luxury block
    public static final int LUXURY = 3;

    //the amount of gold a player will lose for landing at Poverty block
    public static final int POVERTY = -3;

    //the amount of gold a player can steal from other players
    public static final int THEFT = 2;

    //the amount of gold a player has to give to other players
    public static final int CHARITY = -2;

    //the amount of quiz the game has 
    public static final int QUIZCOUNT = 100;
    
    public static final char[][] FIXEDMAPFORCAVEGAME = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'G', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'G', '.', '#'},
            {'#', '.', '.', '.', 'G', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '#'},
            {'#', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', 'G', '.', '.', '.', '.', '#', '#', '.', '.', '#'},
            {'#', '.', 'G', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', 'G', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'G', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', 'G', '.', '.', '#', '.', 'G', '#', 'G', '.', '.', '.', '.', '.', 'G', '.', '.', '.', '.', '.', '.', 'G', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '#', 'G', '.', '.', '#', '.', '.', '.', '.', '.', '#', 'G', '.', '.', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'G', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},};
    
    //the fixed map for the game
    public static final String[][] FIXEDMAP = {
        {"[  🎌  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "[  X  ]"},
        {"[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]", "[  X  ]"}
    };

    //the fixed index map for the game
    public static final int[][] FIXEDINDEXFORMAP = {
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        {35, 88, 88, 88, 88, 88, 88, 88, 88, 10},
        {34, 88, 88, 88, 88, 88, 88, 88, 88, 11},
        {33, 88, 88, 88, 88, 88, 88, 88, 88, 12},
        {32, 88, 88, 88, 88, 88, 88, 88, 88, 13},
        {31, 88, 88, 88, 88, 88, 88, 88, 88, 14},
        {30, 88, 88, 88, 88, 88, 88, 88, 88, 15},
        {29, 88, 88, 88, 88, 88, 88, 88, 88, 16},
        {28, 88, 88, 88, 88, 88, 88, 88, 88, 17},
        {27, 26, 25, 24, 23, 22, 21, 20, 19, 18}};

    //types and number of properties of the map
    public static final String[] PROPERTIES = {"Q", "Q", "Q", "Q", "Q", "Q", "Q",
        "Q", "Q", "Q", "Q", "Q", "Q", "Q",
        "Q", "Q", "Q", "Q", "Q", "Q", "M",
        "M", "M", "B", "B", "L", "L", "L",
        "P", "P", "P", "T", "T", "C", "C"};

    //the amount of row for the map
    public static final int ROW = 10;

    //the amount of column for the map
    public static final int COLUMN = 10;

    //the number of sides of the die
    public static final int NOOFSIDES = 6;

    //welcome word 
    public static final String WELCOME = "  .oooooo.          .o.       ooo        ooooo oooooooooooo        .oooooo.   oooooooooooo        .oooooo.    oooooooooooo ooooo      ooo ooooo ooooo     ooo  .oooooo..o \n"
            + "  d8P'  `Y8b        .888.      `88.       .888' `888'     `8       d8P'  `Y8b  `888'     `8       d8P'  `Y8b   `888'     `8 `888b.     `8' `888' `888'     `8' d8P'    `Y8 \n"
            + "888               .8\"888.      888b     d'888   888              888      888  888              888            888          8 `88b.    8   888   888       8  Y88bo.      \n"
            + "888              .8' `888.     8 Y88. .P  888   888oooo8         888      888  888oooo8         888            888oooo8     8   `88b.  8   888   888       8   `\"Y8888o.  \n"
            + "888     ooooo   .88ooo8888.    8  `888'   888   888    \"         888      888  888    \"         888     ooooo  888    \"     8     `88b.8   888   888       8       `\"Y88b \n"
            + "`88.    .88'   .8'     `888.   8    Y     888   888       o      `88b    d88'  888              `88.    .88'   888       o  8       `888   888   `88.    .8'  oo     .d8P \n"
            + " `Y8bood8P'   o88o     o8888o o8o        o888o o888ooooood8       `Y8bood8P'  o888o              `Y8bood8P'   o888ooooood8 o8o        `8  o888o    `YbodP'    8\"\"88888P'  \n";

    //logo
    public static final String LOGO = "        _________   _________                                                                             ___                                                                                    \n"
            + "   ____/ Welcome \\ /   TO    \\____                                                         ________.-----''                                                                                     \n"
            + " /| -----THE----- |  ----GAME---- |\\                                               ___.--'\"\"___.----''                                                                                         \n"
            + "||| ------------- | ------------- |||                                            .-'    _.-'\"                                                                                                    \n"
            + "||| ------------- | ------------- |||                                 _ .-.__.--'    .-'                                                                                                          \n"
            + "||| ------- ----- | ------------- |||                               .' `  / ' __ _.-'                                                                                                             \n"
            + "||| ------------- | ------------- |||                               ) '  '   )   /`-._.                                                                                                           \n"
            + "||| ------------- | ------------- |||                              (.'\\          )/))-)\\                                                                                                        \n"
            + "|||  ------------ | ----------    |||                            .'    >.________.--'                                                                                                             \n"
            + "||| ------------- |  ------------ |||                         .-'   .-'                                                                                                                           \n"
            + "||| ------------- | ------------- |||                       .'    .'                                                                                                                              \n"
            + "||| ------------- | ------------- |||                    .-'   .-'                                                                                                                                \n"
            + "||| ------------- | ------ -----  |||                  .'    .'                                                                                                                                   \n"
            + "||| ------------  | ------------- |||                 /    .'                              _______ _             _____            _            __          __        _     _                      \n"
            + "|||_____________  |  _____________|||               .'   .'                               |__   __| |           / ____|          (_)           \\ \\        / /       | |   | |                   \n"
            + " /_____/--------\\\\_// -------\\_____\\               /  ,,/                                    | |  | |__   ___  | |  __  ___ _ __  _ _   _ ___   \\ \\  /\\  / /__  _ __| | __| |                  \n"
            + "                                                  /'''/                                      | |  | '_ \\ / _ \\ | | |_ |/ _ \\ '_ \\| | | | / __|   \\ \\/  \\/ / _ \\| '__| |/ _` |             \n"
            + "                                                 / ,''                                       | |  | | | |  __/ | |__| |  __/ | | | | |_| \\__ \\    \\  /\\  / (_) | |  | | (_| |                 \n"
            + "                                                /''                                          |_|  |_| |_|\\___|  \\_____|\\___|_| |_|_|\\__,_|___/     \\/  \\/ \\___/|_|  |_|\\__,_|             \n";

    public static final String DICE1 = "+-------+\n"
            + "|       |\n"
            + "|   o   |\n"
            + "|       |\n"
            + "+-------+\n";

    public static final String DICE2 = "+-------+\n"
            + "| o     |\n"
            + "|       |\n"
            + "|     o |\n"
            + "+-------+\n";

    public static final String DICE3 = "+-------+\n"
            + "| o     |\n"
            + "|   o   |\n"
            + "|     o |\n"
            + "+-------+\n";

    public static final String DICE4 = "+-------+\n"
            + "| o   o |\n"
            + "|       |\n"
            + "| o   o |\n"
            + "+-------+\n";

    public static final String DICE5 = "+-------+\n"
            + "| o   o |\n"
            + "|   o   |\n"
            + "| o   o |\n"
            + "+-------+\n";

    public static final String DICE6 = "+-------+\n"
            + "| o   o |\n"
            + "| o   o |\n"
            + "| o   o |\n"
            + "+-------+\n";

    public static final String GAMEOPTION = String.format("%85s \n%85s \n%78s \n", "1. Start Game!", "2. Instruction", "3. Exit");

    public static final String INSTRUCTION = "INSTRUCTION: \n"
            + "1. Enter 1 to start game, 2 to view game instruction, 3 to quit game\n"
            + "2. If 1 is entered, enter the number of players involved in the game (2 - 4)\n"
            + "3. Enter name of each players\n"
            + "4. When it come to the turn of the particular player to roll dice, enter 1 to roll dice,"
            + " 2 to view current progress, 3 to give up this round\n"
            + "5. If 1 is entered, the dice will be rolled to generate a random number (1 - 6) to represent, the player's movement\n"
            + "6. The map will randomly generate property to retrieve the game type such as mini games, quiz,"
            + " special actions, starting point and betting game when the player lands on the particular, game type location\n"
            + "      6.1 A gold will be rewarded to the players each time when they pass by the starting point except for the starting round of the game\n"
            + "      6.2 Quiz questions (Objective/Subjective) will be displayed when the players land on the quiz space\n"
            + "      6.3 The program will randomly pick a mini game among sudoku, tictactoe, and game of dungeon when the players land on the mini games space\n"
            + "      6.4 When the players land on the betting space, the players will need to choose the amount of gold they want to bet (from 0 - 4), 0 indicate the players give up on the betting game\n"
            + "      6.5 Special actions included luxury(earn 3golds instantly for landing in this space), poverty(lost 3golds instantly for landing in this space), theft(steal 2 golds from one of the "
            + " players randomly),\n          and charity(give 2 golds to one of the players randomly).\n"
            + "7. If the first player who obtains 30 golds will win the game or the player who lose all the golds will be eliminated\n"
            + "8. The remaining players will continue to play the game until only one player left in the game\n"
            + "9. A rank list is generated once the game is ended based on their rank\n";
}
