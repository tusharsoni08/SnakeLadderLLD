import exceptions.GameException;
import models.*;
import services.BoardService;
import services.GameService;

import java.util.List;

public class Driver {

    public static void main(String[] args) throws GameException {
        BoardEntity snake1 = new Snake(50, 20);
        BoardEntity snake2 = new Snake(30, 5);
        BoardEntity snake3 = new Snake(82, 58);
        BoardEntity snake4 = new Snake(70, 40);

        BoardEntity ladder1 = new Ladder(10, 34);
        BoardEntity ladder2 = new Ladder(5, 24);
        BoardEntity ladder3 = new Ladder(30, 68);
        BoardEntity ladder4 = new Ladder(50, 90);

        BoardService boardService = new BoardService(10);
        boardService.addBoardEntity(snake1);
        boardService.addBoardEntity(snake2);
        boardService.addBoardEntity(snake3);
        boardService.addBoardEntity(snake4);

        boardService.addBoardEntity(ladder1);
        boardService.addBoardEntity(ladder2);
        boardService.addBoardEntity(ladder3);
        boardService.addBoardEntity(ladder4);

        Dice dice = new Dice(6);
        GameService gameService = new GameService(boardService, dice);

        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Player player3 = new Player("C");

        gameService.addPlayers(List.of(player1, player2));

        gameService.startGame();
    }

}
