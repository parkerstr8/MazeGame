
package Game;

import People.Person;
import Rooms.Room;
import Rooms.WinningRoom;
import Maps.Board;
import Rooms.LosingRoom;

import java.util.Scanner;
public class Runner {


    public static boolean gameOn = true;
    public static Room[][] normal;





    public static void main(String[] args)
    {
        Person x=new Person(1,0,0);

        if(x.getLevel()==1)
        {
            normal = new Room[5][5];
        }
        else if(x.level==2)
        {
            normal=new Room[6][6];
        }

        //Fill the building with normal rooms
        for (int b = 0; b<normal.length; b++)
        {
            for (int y = 0; y < normal[b].length; y++)
            {
                normal[b][y] = new Room(b,y);
            }
        }


        //Create a random WINNING room




        int i = (int) (Math.random() * normal.length);
        int z = (int) (Math.random() * normal.length);
        while (i==0 && z==0)
        {
            i = (int) (Math.random() * normal.length);
            z = (int) (Math.random() * normal.length);
        }
        normal[i][z] = new WinningRoom(i,z);


        //Create a random LOSING room
        boolean bad = true;
        int j=(int)(Math.random()*normal.length);
        int k=(int)(Math.random()*normal.length);
        while(bad)
        {
            j = (int) (Math.random() * normal.length);
            k = (int) (Math.random() * normal.length);
            if (j ==0 && k==0){
                bad = true;
            }
            else if (j==i && k == z){
                bad = true;
            }
            else if (j == (normal.length-1)/2 && k == (normal[0].length-1)/2){
                bad = true;
            }
            else{
                bad = false;
            }
        }
        normal[j][k]= new LosingRoom(j,k);


        Board b = new Board(normal);
        //Setup beginner player and the input scanner
        Person player1 = new Person(1, 0, 0);
        normal[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        b.print();
        System.out.println("You are in the top left corner");
        System.out.println("You are represented by the character 'o'");
        System.out.println("FIND A WINNING ROOM");
        while(gameOn)
        {

            System.out.println("Where would you like to move? (Choose W for up, S for down, D for right, or A for left)");
            if(player1.getLevel()==1)
            {
                System.out.println("Press 'M' to view the map");
            }
            String move = in.nextLine();
            if(move.trim().toLowerCase().equals("m")){
                b.print();
            }
            if(validMove(move, player1, normal))
            {
                System.out.println("Your coordinates: row = " + player1.getXLoc() + " col = " + player1.getYLoc());



            }
            else {
                System.out.println("YOU CAN'T DO THAT! Please pick another move.");
            }

            if(player1.getLevel() == 2)
            {
                System.out.println("This is the second level");




            }


            if(player1.getLevel()==3)
            {
                System.out.println("You win the game!! CONGRATS!");
                gameOff();

            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();

        switch (move)
        {

            case "w":
                if (p.getXLoc() > 0)
                {
                    map[p.getXLoc()][p.getYLoc()].leaveRoom(p);
                    map[p.getXLoc()-1][p.getYLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "d":
                if (p.getYLoc()< map[p.getYLoc()].length -1)
                {
                    map[p.getXLoc()][p.getYLoc()].leaveRoom(p);
                    map[p.getXLoc()][p.getYLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getXLoc() < map.length - 1)
                {
                    map[p.getXLoc()][p.getYLoc()].leaveRoom(p);
                    map[p.getXLoc()+1][p.getYLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "a":
                if (p.getYLoc() > 0)
                {
                    map[p.getXLoc()][p.getYLoc()].leaveRoom(p);
                    map[p.getXLoc()][p.getYLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;


        }
        return true;
    }

    public static void gameOff()
    {
        gameOn = false;
    }





}
