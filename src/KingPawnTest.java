import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingPawnTest {
    Board board;
    Piece piece;

    @Before
    public void setUp() {
        board = new Board(8,8);
        piece = new KingPawn(board, 1);
        piece.cell = new Cell(3, 3);
    }
    @Test
    public void testAllStraightMoves() {
        piece.setPossibleMoves();
        assertEquals(4, piece.possibleMoves().size());
    }

}