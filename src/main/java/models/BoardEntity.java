package models;

public abstract class BoardEntity {
    private int start;
    private int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public abstract String getId();

    public int getActionPosition() {
        return this.start;
    }

    public int getEndPosition() {
        return this.end;
    }
}
