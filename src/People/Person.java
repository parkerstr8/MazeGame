package People;

public class Person
{
    public int level;

    int xLoc;
    int yLoc;




    public int getXLoc()
    {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Person (int level,  int xLoc, int yLoc)
    {

        this.level = level;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public void changeLevel(int a){
        this.level += a;
    }


    public int getLevel(){
        return this.level;
    }


}