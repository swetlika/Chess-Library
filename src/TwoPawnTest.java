import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPawnTest {
    Board board;
    Piece piece;

    @Before
    public void setUp() {
        board = new Board(8,8);
        piece = new TwoPawn(board, 1);
        piece.cell = new Cell(3, 3);
    }
    @Test
    public void testAllStraightMoves() {
        piece.setPossibleMoves();
        assertEquals(1, piece.possibleMoves().size());
    }

}