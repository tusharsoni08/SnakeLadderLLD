package models;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return "Snake_"+this.getEndPosition();
    }
}
