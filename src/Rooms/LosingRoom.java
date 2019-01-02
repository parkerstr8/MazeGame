package Rooms;

import People.Person;
import Game.Runner;

public class LosingRoom extends Room

        /**
         *This class will create a random room that transports the player halfway through the maze
         *It can be a shortcut or a setback, depending on the positions of the room and the person*/
{


    public LosingRoom(int x, int y) {

        super(x, y);

    }

    @Override

    public void enterRoom(Person x)
    {
        System.out.println("You entered the losing room. You lose. Good try.");
        Runner.normal[(Runner.normal.length-1)/2][(Runner.normal[0].length-1)/2].enterRoom(x);
        Game.Runner.gameOff();
    }


    public void leaveRoom(Person x) {
        person = null;
    }

    public String toString() {
        return ("[L]");
    }
}