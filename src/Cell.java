/*
 * Represents one cell of the chess board
 * May or may not be occupied by a piece
 *
 */
public class Cell {
    public int x;
    public int y;
    private Piece piece;

    /*
     * Constructor of a cell with a piece
     * @param x = x coordinate on board
     * @param y = y coordinate on board
     * @param piece = piece to be placed on that cell
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    /*
     * Sets the given piece onto the current cell
     *
     * @param piece The piece that is now occupying the cell.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /*
     * Checks if two cells are equal.
     *
     * @param o The cell that we are checking against
     */
    @Override
    public boolean equals(Object o) {
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }
}
