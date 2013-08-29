package loc.eldar.game;

public class Cell {
	
	/** номер ячейки на поле */
	private final int number;
	/** фигура игрока, которая стоит в ячейке, null - если ячейка пуста */
	private Piece piece = null;
	
	public Cell(int number) {
		this.number = number;
	}

	/**
	 * Расположить фигуру игрока
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		
		// если ячейка не занята, расположим фигуру
		if(this.piece == null) {
			this.piece = piece;
		}
	}
	
	public Piece getPiece() {
		return this.piece;
	}
}
