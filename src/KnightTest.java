import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {
    Board board;
    Piece piece;

    @Before
    public void setUp() {
        board = new Board(8,8);
        piece = new Knight(board, 1);
        piece.cell = new Cell(3, 3);
    }
    @Test
    public void testAllStraightMoves() {
        piece.setPossibleMoves();
        assertEquals(6, piece.possibleMoves().size());
    }

}