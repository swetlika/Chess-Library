import java.util.ArrayList;
/**
 * Type of piece that can only move one space in all directions
 * Most important piece
 * If if it is check state, the player must block the check before moving anything else
 * Game ends when king has no valid moves left
 */
public class Knight extends Piece {

    public Knight(Board board, int color) {
        super(board, color, Type.KNIGHT);
    }

    /*
     * Calculates a list of all the cells the piece can move to
     * This does not have to be legal moves
     *
     * @param board current board of the game
     * @return list of all possible (but not necessarily legal) moves for the piece
     */
    protected ArrayList<Cell> possibleMoves() {
        ArrayList<Cell> moves = new ArrayList<>();
        for (Cell cell : generateAllPossibleMovesHelper()) {
            if (!board.sameColorOccupied(cell, this.color) && board.isValid(cell)) {
                moves.add(cell);
            }
        }
        return moves;

    }

    private Cell[] generateAllPossibleMovesHelper() {
        return new Cell[] {
                new Cell(this.cell.x + 2, this.cell.y + 1),
                new Cell(this.cell.x - 2, this.cell.y + 1),
                new Cell(this.cell.x + 2, this.cell.y - 1),
                new Cell(this.cell.x - 2, this.cell.y - 1),
                new Cell(this.cell.x + 1, this.cell.y + 2),
                new Cell(this.cell.x - 1, this.cell.y + 2),
                new Cell(this.cell.x + 1, this.cell.y - 2),
                new Cell(this.cell.x - 1, this.cell.y - 2),
        };
    }
}

