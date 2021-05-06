//Code written by Sean Muller 23575786
//This class will manage all the key presses in the game for all GameStates

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter {

    // ArrayList of all the keys currently pressed
    // This is to make player movement more smooth
    private ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
    private GameStateHandler stateHandler;

    // Constructor for the class
    KeyInput(GameStateHandler stateHandler) {
        this.stateHandler = stateHandler;
    }

    // Method that gets called on every key press
    public void keyPressed(KeyEvent e) {
        GameState state = stateHandler.getGameState();
        switch (state) {
            case MainMenu:
                MainMenuKeyPressed(e);
                break;
            case Game:
                GameKeyPressed(e);
                break;
        }
    }

    // Method that gets called on every key release
    public void keyReleased(KeyEvent e) {
        GameState state = stateHandler.getGameState();
        switch (state) {
            case MainMenu:
                break;
            case Game:
                GameKeyReleased(e);
                break;
        }
    }

    // Method to deal with all key presses while in the Game GameState
    void GameKeyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Key pressed to pause the game
        if (key == KeyEvent.VK_P) {
            stateHandler.setGameState(GameState.MainMenu);
        }

        // Loop through all game objects and if the current one is a player call the
        // method to update the player based on the pressed key
        LinkedList<GameObject> objects = stateHandler.getGameObjectHandler().gameObjects;
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            if (tempObject.getId() == ID.Player) {
                playerKeyPress((Player) tempObject, key);
            }
        }
    }

    // Method to deal with all key releases while in the Game GameState
    void GameKeyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        LinkedList<GameObject> objects = stateHandler.getGameObjectHandler().gameObjects;
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            if (tempObject.getId() == ID.Player) {
                playerKeyRelease((Player) tempObject, key);
            }
        }
    }

    // Method to deal with all key presses while in the MainMenu GameState
    void MainMenuKeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_ENTER:
                stateHandler.setGameState(GameState.Game);
                break;
        }

    }

    // Method to control the actions of a player when the right key is pressed
    void playerKeyPress(Player player, int key) {
        if (key == KeyEvent.VK_A) {
            player.setVelX(-player.getPlayerSpeed());
            addKeyToList(key);
        }

        if (key == KeyEvent.VK_D) {
            player.setVelX(player.getPlayerSpeed());
            addKeyToList(key);
        }
    }

    // Method to control the actions of a player when the right key is released
    void playerKeyRelease(GameObject tempObject, int key) {
        if (tempObject.getId() == ID.Player) {
            if (key == KeyEvent.VK_A) {
                tempObject.setVelX(0);
                removeKeyFromList(key);
            }

            if (key == KeyEvent.VK_D) {
                tempObject.setVelX(0);
                removeKeyFromList(key);
            }

            for (int i = 0; i < pressedKeys.size(); i++) {
                playerKeyPress((Player) tempObject, pressedKeys.get(i));
            }
        }
    }

    // Method to add pressed keys to the list
    private void addKeyToList(int key) {
        if (pressedKeys.contains(key)) {

        } else {
            pressedKeys.add(key);
        }
    }

    // Method to remove keys from the list
    private void removeKeyFromList(int key) {
        for (int i = 0; i < pressedKeys.size(); i++) {
            if (pressedKeys.get(i).equals(key)) {
                pressedKeys.remove(i);
            }
        }
    }
}
