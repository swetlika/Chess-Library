import java.util.ArrayList;
/**
 * Type of piece that can only move two spaces forward,
 * or two spaces right/left and up/down (depending on color) to kill
 * White TwoPawns can only move up
 * Black TwoPawns can only move down
 */
public class TwoPawn extends Piece {
    public TwoPawn(Board board, int color) {
        super(board, color, Type.TWOPAWN);
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

        Cell leftDiagonal = new Cell(this.cell.x - 2, this.cell.y + 2*this.getColor());
        if(validDiagonalMove(leftDiagonal)) {
            positions.add(leftDiagonal);
        }

        Cell rightDiagonal = new Cell(this.cell.x + 2, this.cell.y + 2*this.getColor());
        if(validDiagonalMove(rightDiagonal)) {
            positions.add(rightDiagonal);
        }

        Cell doubleStraight = new Cell(this.cell.x, this.cell.y + 2*this.getColor());
        if(validStraightMove(doubleStraight)) {
            positions.add(doubleStraight);
        }

        return positions;
    }
    boolean validDiagonalMove(Cell destination) {
        return board.oppositeColorOccupied(destination, this.getColor()) && board.isValid(destination);
    }
    boolean validStraightMove(Cell destination) {
        return (!board.isOccupied(destination)) && board.isValid(destination);
    }
}
