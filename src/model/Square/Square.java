package model.Square;

public abstract class Square {
    private String id ;
    int position ;


    public Square(int position,String id) {
        this.position = position;
        this.id = id ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
