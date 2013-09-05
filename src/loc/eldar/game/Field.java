package loc.eldar.game;

import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

public class Field {
	
	/** массив ячеек игрового поля */
	private List<Cell> cells;

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
		
		for(int i = 0; i < cells.size(); i++) {
			if(cells.get(i).getPiece() == null) {
				sb.append("_");
			} else {
				sb.append(cells.get(i).getPiece());
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
		
		if(number >= 0 && number < cells.size() && piece != null) {
			if(cells.get(number).getPiece() == null) {
				cells.get(number).setPiece(piece);
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
		
		cells = new ArrayList<Cell>(size * size);
		for(int i = 0; i < cells.size(); i++) {
			cells.add(new Cell(i));
		}
	}
	
	public Piece getPiece(int number) {
		return cells.get(number).getPiece();
	}
}