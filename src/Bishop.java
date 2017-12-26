import java.util.ArrayList;
/**
 * A type of Piece that can only move diagonally
 */

public class Bishop extends Piece {

    public Bishop(Board board, int color) {
        super(board, color, Type.BISHOP);
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
        moves.addAll(this.getAllDiagonals());
        return moves;
    }
}

