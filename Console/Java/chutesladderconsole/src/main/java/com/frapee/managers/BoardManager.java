package com.frapee.managers;

import com.frapee.board.Board;
import com.frapee.board.Board10x10;
import com.frapee.board.Board12x12;
import com.frapee.board.Board8x8;
import com.frapee.board.RandomBoardCreation;
import com.frapee.inputs.InputProvider;
import com.frapee.session.PlaySession;

/**
 * Manage the board created, 
 */
public class BoardManager {

    private PlaySession session;
    private Board aBoard;

    public BoardManager(PlaySession session) {
        this.session = session;
        this.aBoard = new Board10x10();
    }

    private static void displayCreateMenu() {
        System.out.println("Provide board size");
        System.out.println("1. 8x8");
        System.out.println("2. 10x10");
        System.out.println("3. 12x12");
    }    

    private void interactCreate(int choice) {
        switch (choice) {
            case 1:
                aBoard = new Board8x8();
                break;
            case 3:
                aBoard = new Board12x12();
                break;
            default:
                aBoard = new Board10x10();
                break;
        }
    }

    private void create() {
        displayCreateMenu();
        int selection = InputProvider.provideInteger();
        while (selection > 3) {
            interactCreate(selection);
            displayCreateMenu();
            selection = InputProvider.provideInteger();
        }
    }

    private void displayMenu() {
        System.out.println("Boards");
        System.out.println("~~~~~~~");
        System.out.println("1. Create");
        System.out.println("2. Place ladder and chutes normally random");
        System.out.println("3. Place ladder and chutes all random");
        System.out.println("4. Save current board");
        System.out.println("5. Exit");
    }    

    private void interact(int choice) {
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                aBoard.runBoardSetup(RandomBoardCreation.NORMAL);
                break;
            case 3:
                aBoard.runBoardSetup(RandomBoardCreation.MAXITEMS);
                break;
            default:
                session.makeNewBoardAvailable(aBoard);
                break;
        }
    }

    public void manage() {
        displayMenu();
        int selection = InputProvider.provideInteger();
        while (selection < 5) {
            interact(selection);
            displayMenu();
            selection = InputProvider.provideInteger();
        }
    }
}
