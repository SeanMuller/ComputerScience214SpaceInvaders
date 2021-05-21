//Code written by Sean Muller 23575786

//Class used to manage and control the state of the game

import java.awt.Graphics;

public class GameStateHandler {
    // Variable to store the state of the game;
    private GameState state;
    private MainMenu menu;
    private GameObjectHandler gameHandler;

    // Constructor for the GameState Object
    GameStateHandler(GameState state) {
        this.state = state;
        menu = new MainMenu();
        gameHandler = new GameObjectHandler();
        gameHandler.addObject(new Player(Game.WIDTH / 2, Game.HEIGHT - 80, ID.Player, gameHandler));
    }

    // Method to control which part of the game is getting updated every tick.
    public void tick() {
        switch (state) {
            case MainMenu:
                menu.tick();
                break;

            case Game:
                gameHandler.tick();
                break;
        }
    }

    // Method to control which part of the game is getting renderd to the window.
    public void render(Graphics g) {
        switch (state) {
            case MainMenu:
                menu.render(g);
                break;

            case Game:
                gameHandler.render(g);
                break;
        }
    }

    // Method to set the game state
    public void setGameState(GameState state) {
        this.state = state;
    }

    // Method to get the GameState
    public GameState getGameState() {
        return state;
    }

    // Method to get the GameObjectHandler
    public GameObjectHandler getGameObjectHandler() {
        return gameHandler;
    }

}
