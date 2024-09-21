package services;

import models.BoardEntity;

import java.util.HashMap;
import java.util.Map;

public class BoardService {
    int dimension;
    Map<Integer, BoardEntity> boardEntities;

    public BoardService(int dimension) {
        this.dimension = dimension;
        this.boardEntities = new HashMap<>();
    }

    public int getTotalCells() {
        return dimension*dimension;
    }

    public void addBoardEntity(BoardEntity entity) {
        int startPosition = entity.getActionPosition();
        boardEntities.put(startPosition, entity);
    }

    public boolean hasBoardEntity(int position) {
        return boardEntities.containsKey(position);
    }

    public BoardEntity getBoardEntity(int position) {
        return boardEntities.get(position);
    }
}
