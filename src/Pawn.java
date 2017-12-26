import java.util.ArrayList;
/**
 * Type of piece that can only move forward one space
 * If there is a piece of the opposite color one space diagonal (only forward)
 * then it can move forward diagonal to kill that piece
 * cannot kill just by moving one space
 * Can move 2 spaces on first move
 */
public class Pawn extends Piece {

    private boolean first = true;

    public Pawn(Board board, int color) {
        super(board, color, Type.PAWN);
    }

    /*
     * Calculates a list of all the cells the piece can move to
     * This does not have to be legal moves
     *
     * @param board current board of the game
     * @return list of all possible (but not necessarily legal) moves for the piece
     */
    public ArrayList<Cell> possibleMoves() {
        ArrayList<Cell> positions = new ArrayList<Cell>();

        Cell leftDiagonal = new Cell(this.cell.x - 1, this.cell.y + this.getColor());
        if(validKillMove(leftDiagonal)) {
            positions.add(leftDiagonal);
        }

        Cell rightDiagonal = new Cell(this.cell.x + 1, this.cell.y + this.getColor());
        if(validKillMove(rightDiagonal)) {
            positions.add(rightDiagonal);
        }

        Cell straight = new Cell(this.cell.x, this.cell.y + this.getColor());
        if(validNormalMove(straight)) {
            positions.add(straight);
        }

        Cell doubleStraight = new Cell(this.cell.x, this.cell.y + 2*this.getColor());
        if(validNormalMove(doubleStraight) && first) {
            positions.add(doubleStraight);
        }

        return positions;
    }

    /*
     *  If one cell diagonal has a piece of the opposite color
     *  pawn can move diagonal to kill
     */
    boolean validKillMove(Cell destination) {
        return board.oppositeColorOccupied(destination, this.getColor()) && board.isValid(destination);
    }

    /*
     *  Pawns can only move one cell straight
     */
    boolean validNormalMove(Cell destination) {
        return (!board.isOccupied(destination)) && board.isValid(destination);
    }
    @Override
    public boolean move(Cell destination) {
        super.move(destination);
        this.first = false;
        return true;
    }
}
