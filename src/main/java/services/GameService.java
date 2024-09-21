package services;

import exceptions.GameException;
import models.Dice;
import models.GameStatus;
import models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameService {
    BoardService boardService;
    Dice dice;
    Queue<Player> players;
    GameStatus gameStatus;

    public GameService(BoardService boardService, Dice dice) {
        this.boardService = boardService;
        this.dice = dice;
        this.players = new LinkedList<>();
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void addPlayers(List<Player> playerList) throws GameException {
        if(gameStatus == GameStatus.STARTED) {
            throw new GameException("Game already started, cannot add players now");
        }
        players.addAll(playerList);
    }

    public void startGame() {
        this.gameStatus = GameStatus.STARTED;

        while(players.size() > 1) {
            Player curPlayer = players.poll();
            makeMove(curPlayer);
            if(curPlayer.getPosition() == boardService.getTotalCells()) {
                System.out.println(curPlayer.getName() + " reached the goal");
            } else {
                players.add(curPlayer);
            }
        }

        this.gameStatus = GameStatus.FINISHED;
    }

    private void makeMove(Player player) {
        System.out.println(player.getName() + " Press any key to roll dice ...");

        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        int diceVal = dice.rollDice();
        System.out.println("Dice value came " + diceVal);
        int newPosition = player.getPosition() + diceVal;
        if(newPosition > boardService.getTotalCells()) {
            System.out.println("Couldn't move forward you need " + (boardService.getTotalCells() - player.getPosition()));
            return;
        }
        if(boardService.hasBoardEntity(newPosition)) {
            System.out.println("BoardEntity Found at newPosition: " + newPosition + " as " + boardService.getBoardEntity(newPosition).getId() + " for player " + player.getName());
            newPosition = boardService.getBoardEntity(newPosition).getEndPosition();
        }
        System.out.println(player.getName() + " moved to " + newPosition);
        player.setPosition(newPosition);
    }
}
