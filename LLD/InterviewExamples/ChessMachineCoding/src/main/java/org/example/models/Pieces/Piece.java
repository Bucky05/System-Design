package org.example.models.Pieces;

import org.example.models.Board.Cell;
import org.example.models.Helpers.Color;
import org.example.models.Helpers.Direction;
import org.example.models.Pieces.Strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private boolean isKilled;
    private final PieceName pieceName;
    private final Color color;
    private List<Move> movesDone;
    protected List<MovementStrategy> movementStrategies;

    public Piece(PieceName name, Color color) {
        this.pieceName = name;
        this.isKilled = false;
        this.color = color;
        movesDone = new ArrayList<>();
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public Color getColor() {
        return color;
    }

    public boolean isMovingForFirstTime() {
        return movesDone.isEmpty();
    }

    protected boolean isMovingDiagonally(Cell startingCell, Cell endingCell) {
        return Math.abs(startingCell.getX() - endingCell.getX()) > 0 && Math.abs(startingCell.getY() - endingCell.getY()) > 0;
    }

    protected boolean isMovingVertically(Cell startingCell, Cell endingCell) {
        return Math.abs(startingCell.getX() - endingCell.getX()) == 0 && Math.abs(startingCell.getY() - endingCell.getY()) > 0;
    }
    protected boolean isMovingHorizontally(Cell startingCell, Cell endingCell) {
        return Math.abs(startingCell.getX() - endingCell.getX()) > 0 && Math.abs(startingCell.getY() - endingCell.getY()) == 0;
    }

    protected boolean canMove(Cell start, Cell end) {
        return movementStrategies.stream().anyMatch( strategy -> strategy.canMove(start, end));
    }
    protected Direction getDirection(Cell starting, Cell ending) {
        if(starting.getVerticalDistance(ending) == 0 && starting.getHorizontalDistance(ending) == 0) return Direction.NONE;

        if(starting.getVerticalDistance(ending) == 0) {
            if(ending.getX() - starting.getX() > 0) {
                return Direction.RIGHT;
            } else {
                return Direction.LEFT;
            }
        } else if(starting.getHorizontalDistance(ending) == 0) {
            if(ending.getY() - starting.getY() > 0) {
                return Direction.UP;
            } else {
                return Direction.DOWN;
            }
        } else if(starting.getY() - ending.getY() > 0) {
            if(ending.getX() - starting.getX() > 0) {
                return Direction.RIGHT_UP;
            } else {
                return Direction.LEFT_UP;
            }
        } else {
            if(ending.getX() - starting.getX() <0 ) {
                return Direction.RIGHT_DOWN;
            } else {
                return Direction.LEFT_DOWN;
            }
        }
    }


}
