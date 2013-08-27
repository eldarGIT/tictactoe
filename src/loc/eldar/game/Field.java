package loc.eldar.game;

public class Field {
	
	/** массив ячеек игрового поля */
	private Cell[] cells;

	/**
	 * Конструктор класса Field
	 * @param size - размер стороны квадратного игрового поля
	 */
	public Field(int size) {
		createCells(size);
	}
	
	/**
	 * текстовое представление игрового поля
	 * @return поле в тестовом виде
	 */
	public String getField() {
		return null;
	}
	
	/**
	 * Разместить фигуру в ячейке с номером
	 * @param piece - фигура
	 * @param number - номер ячейки
	 */
	public void place(Piece piece, int number) {
		
		if(number >= 0 && number < cells.length && piece != null) {
			cells[number].setPiece(piece);
		}
	}
	
	/**
	 * Создание ячеек игрового поля
	 * @param size - размер стороны квадратного игрового поля
	 */
	private void createCells(int size) {
		
		cells = new Cell[size * size];
		for(int i = 0; i < cells.length; i++) {
			cells[i] = new Cell(i);
		}
	}
}