import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    Board board;
    Piece whitePiece;
    Piece blackPiece;

    @Before
    public void setBoard() {
        board = new Board(8,8);
        whitePiece = new Pawn(board, 1);
        whitePiece.cell = new Cell(2, 2);
        blackPiece = new Pawn(board, -1);
        blackPiece.cell = new Cell(3, 3);
    }


    @Test
    public void checkBoardCreate() {
        Board board = new Board(8,8);
        for(int i=0; i<8;i++){
            for(int j=0; j<8; j++){
                assertEquals(true, board.getCells()[i][j]!=null);
            }
        }
    }

    @Test
    public void testOppositeColorOccupied() throws Exception {
        boolean isOccupied = board.oppositeColorOccupied(new Cell(2, 2), 1);
        assertEquals(false, isOccupied);

        isOccupied = board.oppositeColorOccupied(new Cell(3, 3), 1);
        assertEquals(true, isOccupied);
    }

    @Test
    public void testSameColorOccupied() throws Exception {
        boolean isOccupied = board.sameColorOccupied(new Cell(2, 2), 1);
        assertEquals(true, isOccupied);

        isOccupied = board.sameColorOccupied(new Cell(2, 2), -1);
        assertEquals(false, isOccupied);
    }

    @Test
    public void testIsOccupied() throws Exception {
        boolean isOccupied = board.isOccupied(new Cell(2, 2));
        assertEquals(true, isOccupied);

        isOccupied = board.isOccupied(new Cell(3, 3));
        assertEquals(true, isOccupied);

        isOccupied = board.isOccupied(new Cell(4, 4));
        assertEquals(false, isOccupied);
    }

}