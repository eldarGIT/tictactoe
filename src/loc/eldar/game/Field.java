package loc.eldar.game;

import java.lang.StringBuilder;

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
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cells.length; i++) {
			if(cells[i].getPiece() == null) {
				sb.append("_");
			} else {
				sb.append(cells[i].getPiece());
			}
			sb.append(", ");
		}
		
		return sb.toString();
	}
	
	/**
	 * Разместить фигуру в ячейке с номером
	 * @param piece - фигура
	 * @param number - номер ячейки
	 */
	public boolean place(Piece piece, int number) {
		
		if(number >= 0 && number < cells.length && piece != null) {
			if(cells[number].getPiece() == null) {
				cells[number].setPiece(piece);
				return true;
			}
		}
		return false;
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