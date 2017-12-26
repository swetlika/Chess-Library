import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(8, 8);

        Piece piece = new Pawn(board, 1);
        Piece enemy = new Pawn(board, -1);
        Piece enemy2 = new Pawn(board, -1);

        piece.cell = new Cell(3, 3);
        enemy.cell = new Cell(4, 4);
        enemy2.cell = new Cell(2, 4);

        piece.setPossibleMoves();
        ArrayList<Cell> positions = piece.possibleMoves();
        System.out.println((positions.size()));
    }
}