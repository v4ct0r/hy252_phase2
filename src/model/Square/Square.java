package model.Square;

public abstract class Square {
    private Position position;
    private String id ;


    public Square(Position position , String id) {
        this.position = position;
        this.id = id ;
    }

    public Position getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
