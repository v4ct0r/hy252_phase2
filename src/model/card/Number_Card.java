
package model.card;

public abstract class Number_Card extends card {
    private int value;

    public Number_Card(int value,String id) {
        super(id);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}