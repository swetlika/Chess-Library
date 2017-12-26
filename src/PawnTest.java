import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PawnTest {
    Board board = new Board(8,8);

    @Test
    public void testValidKillMove() throws Exception {
        Piece piece = new Pawn(board, 1);
        Piece enemy = new Pawn(board, -1);
        Piece enemy2 = new Pawn(board, -1);

        piece.cell = new Cell(3, 3);
        enemy.cell = new Cell(4, 4);
        enemy2.cell = new Cell(2, 4);

        piece.setPossibleMoves();
        ArrayList<Cell> positions = piece.possibleMoves();

        assertEquals(4, positions.size());
        assertEquals(true, positions.contains(new Cell(4, 4)));
        assertEquals(true, positions.contains(new Cell(2, 4)));
    }

    @Test
    public void testValidNormalMove() throws Exception {
        Piece piece = new Pawn(board, 1);
        piece.cell = new Cell(3, 3);
        piece.setPossibleMoves();
        ArrayList<Cell> positions = piece.possibleMoves();

        assertEquals(2, positions.size());
        assertEquals(true, positions.contains(new Cell(3, 4)));
        assertEquals(true, positions.contains(new Cell(3, 5)));
    }

}