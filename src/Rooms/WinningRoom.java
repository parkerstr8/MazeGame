package Rooms;

import Rooms.Room;
import People.Person;
import Game.Runner;

import static Game.Runner.normal;

public class WinningRoom extends Room
        /**
         * This room is the last room that will advance to the next level if current level is easy or medium
         * otherwise,
         */
{
    public WinningRoom(int x, int y)
    {

        super(x,y);

    }


    @Override

    public void enterRoom(Person x)
    {

        System.out.println("YOU'VE FOUND THE WINNING ROOM! NICE JOB!!!!!");

        person=x;
        x.setXLoc(this.xLoc);
        x.setYLoc(this.yLoc);
        if(x.level == 1)
        {
            x.level += 1;
            x.setXLoc(0);
            x.setYLoc(0);

            Game.Runner.gameOn=true;
        }





    }
    public void leaveRoom(Person x)
    {
        person = null;
    }

    @Override
    public String toString(){
        return("[W]");
    }


}
