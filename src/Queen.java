import java.util.ArrayList;
/**
 * A type of Piece that can move horizontally, vertically, and diagonally
 */

public class Queen extends Piece {

    public Queen(Board board, int color) {
        super(board, color, Type.QUEEN);
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
        moves.addAll(this.getAllStraights());
        return moves;
    }
}

