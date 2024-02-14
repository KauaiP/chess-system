package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        if(rows < 1 || columns < 1){
            throw new BoardExceptions("Error creating board: there must be at least 1 row and 1 colum");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int colum){
        if(!positionExists(row, colum)){
            throw new BoardExceptions("Position not on the board");
        }
        return pieces[row][colum];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptions("Position not on the board");
        }
        return pieces[position.getRow()][position.getColum()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardExceptions("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }

    public boolean positionExists(int row, int colum){
        return row >= 0 && row < rows && colum >= 0 && colum < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColum());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptions("Position not on the board");
        }
        return piece(position) != null;
    }
}
