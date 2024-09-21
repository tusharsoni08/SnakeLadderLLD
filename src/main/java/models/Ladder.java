package models;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return "Ladder_"+this.getEndPosition();
    }
}
