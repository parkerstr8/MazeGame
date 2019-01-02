
package Maps;

import Rooms.Room;

public class Board

{

    private Room[][]Maze;

    public Board(Room[][]Maze)
    {
        this.Maze=Maze;
    }
    public void fill(Room room)
    {
        for(int x=0; x<Maze.length; x++)
        {
            for (int y=0; y<Maze.length; y++)
            {
                room=this.Maze[x][y];
            }

        }
    }

    public void print()
    {
        String row="";
        for(int x=0; x<Maze.length; x++)
        {
            row="";
            for(int y=0; y<Maze.length; y++)
            {
                row=row+Maze[x][y].toString();
            }
            System.out.println(row);
        }
    }
    //setup half-way through maze to equal position of half the number of rows, half the number of columns







}