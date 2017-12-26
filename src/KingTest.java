import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {
    Board board;
    Piece piece;

    @Before
    public void setUp() {
        board = new Board(8,8);
        piece = new King(board, 1);
        piece.cell = new Cell(3, 3);
    }
    @Test
    public void testMoves() {
        piece.setPossibleMoves();
        assertEquals(4, piece.possibleMoves().size());
    }

    @Test
    public void moveMoreSpaces() {
        assertFalse(piece.move(new Cell(3, 5)));
    }

}