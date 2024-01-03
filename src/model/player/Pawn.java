package model.player;

public class Pawn {
    private int position;
    private boolean isSafe;
    private Boolean isHome;
    private boolean isStart;
    private String color;
    private boolean moveable;
    private int id;
    public Pawn(int position, String color,int id) {
        this.position = position;
        this.color = color;
        this.id = id;
        this.isStart = true;
        this.isSafe = false;
        this.isHome = false;
    }


    public int getId() {
        return id;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if(position>71)
            position = position-72;
        if(this.color.equals("yellow") && position>2 && position<8)
            position = position + 6 ;
        if(this.color.equals("red") && position>38 && position<44)
            position = position + 6 ;


        if(this.color.equals("red")&& position == 8)
            this.isHome = true;
        if(this.color.equals("yellow")&& position == 44)
            this.isHome = true;
        if(this.color.equals("red")) {
            if(position > 2 && position < 8)
                this.isSafe = true;
            else
                this.isSafe = false;
        }
        if(this.color.equals("yellow")){
            if(position > 38 && position < 44)
                this.isSafe = true;
            else
                this.isSafe = false;
        }

        if(this.color.equals("red")&& position == -1)
            this.isStart = true;
        else if(this.color.equals("yellow")&& position == -2)
            this.isStart = true;
        else
            this.isStart = false;

        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }

    public Boolean getHome() {
        return isHome;
    }

    public void setHome(Boolean home) {
        isHome = home;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }
}
