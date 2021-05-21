//Code written by Sean Muller 23575786

//This is the abstract class for all objects that will appear in the game.

import java.awt.Graphics;

public abstract class GameObject
{
    //ID to store what type of game object it is.
    protected ID id;

    //Variables to store the position and velocity of the object
    protected float x,y;
    protected float velX,velY;

    //Constructor method for a GameObject object
    public GameObject(float x, float y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    //Abstract methods that all classes that inherit from GameObject must implement

    //Method that is used to update the object
    public abstract void tick();
    //Method for drawing the object
    public abstract void render (Graphics g);


    //Getter and setter methods for a GameObject
    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVelX(float velX)
    {
        this.velX = velX;
    }

    public void setVelY(float velY)
    {
        this.velY=velY;
    }

    public void setId(ID id)
    {
        this.id = id;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getVelX()
    {
        return velX;
    }

    public float getVelY()
    {
        return velY;
    }

    public ID getId()
    {
        return id;
    }

}