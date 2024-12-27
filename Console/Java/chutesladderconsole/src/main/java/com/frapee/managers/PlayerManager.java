package com.frapee.managers;

import com.frapee.inputs.InputProvider;
import com.frapee.players.Player;
import com.frapee.session.PlaySession;

/**
 * Class to manage player interaction
 */
public class PlayerManager {

    private PlaySession session;

    public PlayerManager(PlaySession session) {
        this.session = session;
    }

    private void displayMenu() {
        System.out.println("Players");
        System.out.println("~~~~~~~");
        System.out.println("1. Create");
        System.out.println("2. Remove");
        System.out.println("3. Exit");
    }

    private void createPlayer() {
        System.out.println("Add new player");
        System.out.println("Provide player first name");
        String firstName = InputProvider.provideString();
        System.out.println("Provide player last name");
        String lastName = InputProvider.provideString();
        session.registerPlayer(new Player(firstName, lastName));
    }

    private void removePlayer() {
        System.out.println("Remove player");
        System.out.println("Provide player first name");
        String firstName = InputProvider.provideString();
        System.out.println("Provide player last name");
        String lastName = InputProvider.provideString();
        session.unregisterPlayer(new Player(firstName, lastName));
    }

    private void interact(int choice) {
        switch (choice) {
            case 1:
                createPlayer();
                break;
            case 2:
                removePlayer();
            break;
            default:
                break;
        }
    }

    public void manage() {
        displayMenu();
        int selection = InputProvider.provideInteger();
        while (selection < 3) {
            interact(selection);
            displayMenu();
            selection = InputProvider.provideInteger();
        }
    }    

}
