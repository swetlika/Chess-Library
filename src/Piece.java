import java.util.ArrayList;

/**
 * Abstract class to represent a chess piece
 * Each piece can either be black or white
 */
public abstract class Piece {

    protected int color; // 1 = White, -1 = Black
    public Cell cell; // current cell the piece is on
    protected Type type; //type of piece
    private ArrayList<Cell> moves;
    protected Board board;


    /*
	 * Constructor to initializes the piece
	 * @param color:  1=WHITE, -1=BLACK
	 */
    public Piece(Board board, int color, Type type) {
        this.board = board;
        this.color = color;
        this.type = type;
        this.cell = null;
        if (color == 1) {
            board.whitePieces.add(this);
        }
        else {
            board.blackPieces.add(this);
        }
    }

    // get/set methods
    public int getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public ArrayList<Cell> getMoves() {
        return this.moves;
    }

    public void setPossibleMoves() {
        this.moves = possibleMoves();
    }

    /**
     * Calculates a list of all the cells the piece can move to
     *
     * @return list of all possible moves for the piece
     */
    protected abstract ArrayList<Cell> possibleMoves();

    /**
     * Moves the piece to the destination cell.
     *
     * @param destination The cell to move to.
     */
    public boolean move(Cell destination) {
        setPossibleMoves();
        if(!this.moves.contains(destination)) {
            return false;
        }
        capture(destination);
        this.cell = destination;
        return true;
    }

    public void capture(Cell destination) {
        Piece enemy = board.getPieceAt(destination);
        ArrayList<Piece> enemies = null;
        if (this.color == 1) {
            enemies = this.board.blackPieces;
        }
        else {
            enemies = this.board.whitePieces;
        }
        enemies.remove(enemy);
    }

    public ArrayList<Cell> getAllDiagonals() {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells.addAll(getAllHelper(1, 1));
        cells.addAll(getAllHelper(-1, 1));
        cells.addAll(getAllHelper(-1, -1));
        cells.addAll(getAllHelper(1, -1));

        return cells;
    }

    public ArrayList<Cell> getAllStraights() {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells.addAll(getAllHelper(1, 0));
        cells.addAll(getAllHelper(0, 1));
        cells.addAll(getAllHelper(-1, 0));
        cells.addAll(getAllHelper(0, -1));

        return cells;
    }

    private ArrayList<Cell> getAllHelper(int x, int y) {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        Cell newPosition = new Cell( this.cell.x + x, this.cell.y + y);
        for (int i = 2; board.isValid(newPosition) && !board.sameColorOccupied(newPosition, color); i++) {
            cells.add(newPosition);

            if(board.oppositeColorOccupied(newPosition, color)) {
                break;
            }

            newPosition = new Cell(this.cell.x + i*x, this.cell.y + i*y
            );
        }
        return cells;
    }
}

