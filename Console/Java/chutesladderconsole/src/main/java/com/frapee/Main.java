package com.frapee;

import com.frapee.game.GameType;
import com.frapee.inputs.InputProvider;
import com.frapee.managers.BoardManager;
import com.frapee.managers.PlayerManager;
import com.frapee.session.PlaySession;

/**
 * Main class - handle primary menu for actions 
 * Also main function (start point is present)
 */
public class Main {

    private static PlaySession session;
    private static PlayerManager playerManager = new PlayerManager(session);
    private static BoardManager boardManager = new BoardManager(session);

    public static void displaySelectionMenu() {
        System.out.println("Snake and ladders Application");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Create new Club");
        System.out.println("2. Manage Player");
        System.out.println("3. Manage Board");
        System.out.println("4. Save Club");
        System.out.println("5. Load last saved club");
        System.out.println("6. Perpare play");
        System.out.println("7. Execute a play");
        System.out.println("8. Quit");
    }

    public static void processSelection() {
        displaySelectionMenu();
        int selection = InputProvider.provideInteger();
        while (selection < 8) {
            interactSelection(selection);
            displaySelectionMenu();
            selection = InputProvider.provideInteger();
        }
    }

    public static void interactSelection(int choice) {
        switch (choice) {
            case 1:
                session = new PlaySession();
                playerManager = new PlayerManager(session);
                boardManager = new BoardManager(session);
                break;
            case 2:
                playerManager.manage();
                break;
            case 3:
                boardManager.manage();
                break;
            case 4:
                session.saveAvailableBoardsToFile("sal.dat");
                break;
            case 5:
                session.loadAvailableBoardsFromFile("sal.dat");
                break;
            case 6:
                preparePlay();
                break;
            case 7:
                session.playSession();
                break;
            default:
                break;
        }
    }

    /**
     * Basic prepare function for default 2 players
     */
    public static void preparePlay() {
        System.out.println("How many player per games ?");
        int noPlayers = InputProvider.provideInteger();
        if (noPlayers < 2) {
            noPlayers = 2;
        }
        session.setupBoardsForPlaying(1);
        session.setupGameToPlay(GameType.NORMAL);
        session.assignPlayersToGames(noPlayers);
        session.startPlaySession();
    }

    public static void main(String[] args) {
        session = new PlaySession();
        playerManager = new PlayerManager(session);
        boardManager = new BoardManager(session);
        processSelection();
    }
}