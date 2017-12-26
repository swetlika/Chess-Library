import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
    Board board;
    Piece piece;

    @Before
    public void setUp() {
        board = new Board(8,8);
        piece = new Queen(board, 1);
        piece.cell = new Cell(3, 3);
    }
    @Test
    public void testMoves() {
        piece.setPossibleMoves();
        assertEquals(19, piece.possibleMoves().size());
    }

}