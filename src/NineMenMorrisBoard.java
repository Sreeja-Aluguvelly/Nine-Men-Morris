
public class NineMenMorrisBoard {
  private int[][] boardState;
  private int currentPlayer;
  private int blackPieces;
  private int whitePieces;



  public NineMenMorrisBoard() {
    boardState = new int[7][7];
    currentPlayer = 1;
    blackPieces = 9;
    whitePieces = 9;

  }



  // placePiece function takes the selected position and
  // places the corresponding piece in the given location
  // return true if successful and false if not
  public boolean placePiece(int row, int col) {
    if (isValidMove(row, col)) {
      getBoardState()[row][col] = getCurrentPlayer();

      if (getCurrentPlayer() == 1) {
        setWhitePieces(getWhitePieces() - 1);

      } else {
        setBlackPieces(getBlackPieces() - 1);

      }
      setCurrentPlayer((getCurrentPlayer() == 1) ? 2 : 1);

      return true;
    }
    return false;
  }


  public boolean isValidMove(int row, int col) {

    if (isValidIntersecction(row, col) && (boardState[row][col] == 0)
        && (blackPieces > 0 || whitePieces > 0)) {
      return true;
    }
    return false;
  }


  public boolean isValidIntersecction(int row, int col) {
    if ((isCorner(row, col) || isEdge(row, col) || isCenter(row, col))) {

      return true;
    }
    return false;
  }



  public int getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(int player) {
    currentPlayer = player;
  }

  public int[][] getBoardState() {
    return boardState;
  }

  public int getBlackPieces() {
    return blackPieces;
  }

  public void setBlackPieces(int blackPieces) {
    this.blackPieces = blackPieces;
  }

  public int getWhitePieces() {
    return whitePieces;
  }

  public void setWhitePieces(int whitePieces) {
    this.whitePieces = whitePieces;
  }



  public boolean isCorner(int row, int col) {
    return (row == 0 && col == 0) || (row == 0 && col == 6) || (row == 6 && col == 0)
        || (row == 6 && col == 6);

  }

  public boolean isEdge(int row, int col) {
    return (row == 1 && col == 1) || (row == 1 && col == 5) || (row == 5 && col == 5)
        || (row == 5 && col == 1) || (row == 2 && col == 2) || (row == 2 && col == 4)
        || (row == 4 && col == 2) || (row == 4 && col == 4);

  }

  public boolean isCenter(int row, int col) {
    if ((row == 3 && col == 3)) {
      return false;
    }

    return row == 3 || col == 3;
  }

}
