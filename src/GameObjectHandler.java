//Code written by Sean Muller 23575786
//Class that will handler all the GameObjects in the game

import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;

public class GameObjectHandler {
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    // Method that will call the tick method of every GameObject
    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.tick();
        }
    }

    // Method that will call the render method of every GameObject
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(g);
        }
    }

    // Method to add a new GameObject to the list of GameObjects
    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    // Method to remove a GameObject to the list of GameObjects
    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }
}
