import java.util.ArrayList;
/*
 * Representation of a chess board
 * Made up of cells, each can be occupied by a chess piece
 */
public class Board {
    private Cell[][] cells; // 2d array of all the cells in the board
    private int width;			// with of board (traditionally 8 cells)
    private int height;			// height of board (traditionally 8 cells)
    public ArrayList<Piece> whitePieces = new ArrayList<Piece>(); // list of all white pieces on board currently
    public ArrayList<Piece> blackPieces = new ArrayList<Piece>(); // list of all black pieces on board currently

    /*
     * Creates a board given the number of x and y cells
     *
     * @param width number of x cells
     * @param height number of y cells
     */
    public Board(int width, int height) {
        this.cells = new Cell[width][height];
        this.width = width;
        this.height = height;

        this.whitePieces = new ArrayList<Piece>();
        this.blackPieces = new ArrayList<Piece>();

        initializeCells(width, height);
        initializePieces();
    }

    /*
     * Private helper for constructor
     * Initializes the board to have the correct number of cells
     *
     * @param width number of x cells on board
     * @param height number of y cells on board
     */
    private void initializeCells(int width, int height) {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                this.cells[x][y] = new Cell(x, y);
            }
        }
    }

    /*
     * Private helper for constructor
     * Initializes the board to have the correct pieces for a standard chess board
     * Adds each piece initialized to the pieces array
     *
     */
    private void initializePieces() {
        // set pawns
        for(int i = 0; i < 8; i++) {
            Piece whitePawn = new Pawn(this, 1);
            whitePawn.cell = new Cell(i, 1);
            this.cells[i][1].setPiece(whitePawn);
            this.whitePieces.add(whitePawn);

            Piece blackPawn = new Pawn(this, -1);
            blackPawn.cell = new Cell(i, 6);
            this.cells[i][6].setPiece(blackPawn);
            this.blackPieces.add(blackPawn);
        }

        Piece whiteKnight1 = new Knight(this, 1);
        whiteKnight1.cell = new Cell(1, 0);
        this.cells[1][0].setPiece(whiteKnight1);
        this.whitePieces.add(whiteKnight1);

        Piece whiteKnight2 = new Knight(this, 1);
        whiteKnight2.cell = new Cell(6, 0);
        this.cells[6][0].setPiece(whiteKnight2);
        this.whitePieces.add(whiteKnight2);

        Piece blackKnight1 = new Knight(this, -1);
        blackKnight1.cell = new Cell(1, 7);
        this.cells[1][7].setPiece(blackKnight1);
        this.blackPieces.add(blackKnight1);

        Piece blackKnight2 = new Knight(this, -1);
        blackKnight2.cell = new Cell(6, 7);
        this.cells[6][7].setPiece(blackKnight2);
        this.blackPieces.add(blackKnight2);

        Piece whiteBishop1 = new Bishop(this, 1);
        whiteBishop1.cell = new Cell(2, 0);
        this.cells[2][0].setPiece(whiteBishop1);
        this.whitePieces.add(whiteBishop1);

        Piece whiteBishop2 = new Bishop(this, 1);
        whiteBishop2.cell = new Cell(5, 0);
        this.cells[5][0].setPiece(whiteBishop2);
        this.whitePieces.add(whiteBishop2);

        Piece blackBishop1 = new Bishop(this, -1);
        blackBishop1.cell = new Cell(2, 7);
        this.cells[2][7].setPiece(blackBishop1);
        this.blackPieces.add(blackBishop1);

        Piece blackBishop2 = new Bishop(this, -1);
        blackBishop2.cell = new Cell(5, 7);
        this.cells[5][7].setPiece(blackBishop2);
        this.blackPieces.add(blackBishop2);

        Piece whiteRook1 = new Rook(this, 1);
        whiteRook1.cell = new Cell(0, 0);
        this.cells[0][0].setPiece(whiteRook1);
        this.whitePieces.add(whiteRook1);

        Piece whiteRook2 = new Bishop(this, 1);
        whiteRook2.cell = new Cell(7, 0);
        this.cells[7][0].setPiece(whiteRook2);
        this.whitePieces.add(whiteRook2);

        Piece blackRook1 = new Bishop(this, -1);
        blackRook1.cell = new Cell(0, 7);
        this.cells[0][7].setPiece(blackRook1);
        this.blackPieces.add(blackRook1);

        Piece blackRook2 = new Bishop(this, -1);
        blackRook2.cell = new Cell(7, 7);
        this.cells[7][7].setPiece(blackRook2);
        this.blackPieces.add(blackRook2);

        Piece whiteQueen = new Queen(this,1);
        whiteQueen.cell = new Cell(4,0);
        this.cells[4][0].setPiece(whiteQueen);
        this.whitePieces.add(whiteQueen);

        Piece blackQueen = new Queen(this,-1);
        blackQueen.cell = new Cell(4,7);
        this.cells[4][7].setPiece(blackQueen);
        this.blackPieces.add(blackQueen);

        Piece whiteKing = new King(this,1);
        whiteKing.cell = new Cell(3,0);
        this.cells[3][0].setPiece(whiteKing);
        this.whitePieces.add(whiteKing);

        Piece blackKing = new King(this,-1);
        blackKing.cell = new Cell(3,7);
        this.cells[3][7].setPiece(blackKing);
        this.blackPieces.add(blackKing);
    }

    /*
     * Checks if a cell is within the board's width and height
     */
    public boolean isValid(Cell cell) {
        return (0 <= cell.x) && (cell.x < 8) && (0 <= cell.y) && (cell.y < 8);
    }

    /*
     * Checks if a cell is occupied by an enemy piece
     */
    public boolean oppositeColorOccupied(Cell cell, int color) {
        ArrayList<Piece> pieces = color == 1 ? blackPieces : whitePieces;
        return isOccupiedHelper(pieces, cell);
    }

    /*
     * Checks if a cell is occupied by a piece of the same color.
     */
    public boolean sameColorOccupied(Cell cell, int color) {
        ArrayList<Piece> pieces = color == 1 ? whitePieces : blackPieces;
        return isOccupiedHelper(pieces, cell);
    }

    /*
     * Function to check if a cell is occupied
     */
    public boolean isOccupied(Cell cell) {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(blackPieces);
        pieces.addAll(whitePieces);
        return isOccupiedHelper(pieces, cell);
    }

    /*
     * Helper function to check if a cell is occupied
     */
    private boolean isOccupiedHelper(ArrayList<Piece> pieces, Cell cell) {
        for(Piece piece: pieces) {
            if(piece.cell.equals(cell)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns the piece at the given cell
     */
    public Piece getPieceAt(Cell cell) {
        for(Piece piece : whitePieces) {
            if(piece.cell.equals(cell)) {
                return piece;
            }
        }
        for(Piece piece : blackPieces) {
            if(piece.cell.equals(cell)) {
                return piece;
            }
        }
        return null;
    }
    /**
     * @param color the color of the player to find the king for
     * @return the space (rank,file) the player's king  is on
     */
    private Cell findKingCell(int color) {
        Piece king = null;
        if (color == 1) {
            for (int i = 0; i < whitePieces.size(); ++i) {
                if (whitePieces.get(i).type == Type.KING)
                    king = whitePieces.get(i);
            }
        }
        else {
            for (int i = 0; i < blackPieces.size(); ++i) {
                if (blackPieces.get(i).type == Type.KING)
                    king = blackPieces.get(i);
            }
        }
        return king.cell;
    }

    /**
     * @param color the color of the player to find the king for
     * @return the space (rank,file) the player's king  is on
     */
    private Piece findKing(int color) {
        Piece king = null;
        if (color == 1) {
            for (int i = 0; i < whitePieces.size(); ++i) {
                if (whitePieces.get(i).type == Type.KING)
                    king = whitePieces.get(i);
            }
        }
        else {
            for (int i = 0; i < blackPieces.size(); ++i) {
                if (blackPieces.get(i).type == Type.KING)
                    king = blackPieces.get(i);
            }
        }
        return king;
    }

    /**
     * @param color the color of the player check for check
     * @return true if the given player is in check
     */
    public boolean inCheck(int color) {
        Cell kingCell = findKingCell(color);

        if (color == 1) {
            for (Piece piece : blackPieces) {
                if (piece.possibleMoves().contains(kingCell)) {
                    return true;
                }
            }
        }
        else {
            for (Piece piece : whitePieces) {
                if (piece.possibleMoves().contains(kingCell)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param color the color of the player to check for checkmate
     * @return true if the given player is in checkmate
     */
    public boolean inCheckmate(int color) {
        Piece king = findKing(color);
        if (!inCheck(color))
            return false;

         return (king.possibleMoves().size() == 0);

    }

    /**
     * @param color the color of the player to check for stalemate
     * @return true if the given player is in stalemate
     */
    public boolean inStalemate(int color) {
        Piece king = findKing(color);
        if (!inCheck(color))
            return (king.possibleMoves().size() == 0);

        return false;

    }

    /*
     * Width of board
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /*
     * Height of board
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /*
     * Return a 2d array representation of the board
     * @return 2D cells array
     */
    public Cell[][] getCells() {
        return this.cells;
    }

    /*
     * Returns the cell with the given coordinates
     * @param x
     * @param y
     * @return
     */
    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    /*
     * Returns the cell with the coordinates of given cell
     * @param cell = cell with x and y coordinates
     * @return
     */
    public Cell getCell(Cell cell) {
        return this.cells[cell.x][cell.y];
    }

    /*
     * Array of all the white pieces currently on the board
     * @return arraylist of all white pieces currently alive
     */
    public ArrayList<Piece> getWhitePieces() {
        return this.whitePieces;
    }

    /*
     * Array of all the black pieces currently on the board
     * @return arraylist of all black pieces currently alive
     */
    public ArrayList<Piece> getBlackPieces() {
        return this.blackPieces;
    }
}
