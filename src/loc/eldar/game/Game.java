package loc.eldar.game;

import java.util.List;
import java.util.ArrayList;

public class Game {

	// Игровое поле
	private Field field;
	// Массив игроков
	private List<Player> players = new ArrayList<Player>(2);
	// размер поля
	int fieldSize;
	// Активный игрок
	int activePlayer;
	// последняя занятая ячейка
	int lastMoveCell = 0;
	// количество занятых ячеек для победы
	int counlWinCell = 3;
	
	/**
	 * Конструктор класса Game
	 * @param size - размер стороны квадратного игрового поля
	 */
	public Game(int size) {
		fieldSize = size;
		field = new Field(size);
	}
	
	public void init() {
		activePlayer = 0;
	}
	
	/**
	 * Добавление игрока в игру
	 * @param id - идентификатор игрока
	 * @param name - имя игрока
	 * @return true - в случае успешного добавления игрока
	 */
	public boolean addPlayer(int id, String name) {
		
		if(players.get(1) == null) {
			Piece piece = null;
			int index;
			
			/** первый играет за крестики */
			if(players.get(0) == null) {
				piece = Piece.x;
				index = 0;
			} else {
				/** второй играет за нолики */
				piece = Piece.o;
				index = 1;
			}
			
			// если игрок не передал имя
			if(name.isEmpty()) {
				name = String.format("Игрок %d", index + 1);
			}
			
			players.add(new Player(id, name, piece));
			return true;
		}
		return false;
	}
	
	/**
	 * Совершить ход
	 * @param id - идентификатор игрока
	 * @param value - номер ячейки, куда сделать ход
	 */
	public void move(int id, int value) {
		
		/** получить игрока по id */
		Player player = getPlayer(id);
		
		if(player == null || player != players.get(activePlayer)) {
			return;
		}
		
		/** разместить фигуру игрока на поле */
		boolean placeStatus = field.place(player.getPiece(), value);
		
		if(placeStatus) {
			lastMoveCell = value;
			if(activePlayer == 0) {
				activePlayer = 1;
			} else {
				activePlayer = 0;
			}
		}
	}
	
	/**
	 * Текущее состояние игры
	 * @return возвращаемые значения: начата, закончена, ничья, победа
	 */
	public boolean getState() {
		
		int countEqualCells = 1;
		Piece cellPiece;
		int startPos;
		boolean defineWinner = false;
		int maxIndex = fieldSize * fieldSize - 1;
		
		// получим фигуру, которой ходил пользователь
		Piece piece;
		if(activePlayer == 0) {
			piece = players.get(1).getPiece();
		} else {
			piece = players.get(0).getPiece();
		}
		
		// проверка по горизонтали
		int row = lastMoveCell / fieldSize;
		
		// движение влево от последней вставленной позиции
		startPos = lastMoveCell;
		startPos--;
		// флаг движения налево 
		boolean goLeft = true;
		while(startPos >= 0 && goLeft && !defineWinner) {
			cellPiece = field.getPiece(startPos);
			if(cellPiece != null && cellPiece.equals(piece)) {
				countEqualCells++;
			} else {
				goLeft = false;
			}
			
			// проверка на количество одинаковых ячеек
			if(countEqualCells == counlWinCell) {
				defineWinner = true;
			}
			startPos--;
		}
		
		// движение направо от последней вставленной позиции
		startPos = lastMoveCell;
		startPos++;
		// флаг движения налево 
		boolean goRight = true;
		while(startPos <= maxIndex && goRight && !defineWinner) {
			cellPiece = field.getPiece(startPos);
			if(cellPiece != null && cellPiece.equals(piece)) {
				countEqualCells++;
			} else {
				goRight = false;
			}
			
			// проверка на количество одинаковых ячеек
			if(countEqualCells == counlWinCell) {
				defineWinner = true;
			}
			startPos--;
		}
		
		// если победитель не определился
		if(!defineWinner) {
			// проверка по вертикали
			countEqualCells = 1;
			
			// движение влево от последней вставленной позиции
			startPos = lastMoveCell;
			startPos -= fieldSize;
			// флаг движения вверх 
			boolean goTop = true;
			while(startPos >= 0 && goTop && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goTop = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos -= fieldSize;
			}
			
			// движение вниз от последней вставленной позиции
			startPos = lastMoveCell;
			startPos += fieldSize;
			// флаг движения налево 
			boolean goBottom = true;
			while(startPos <= maxIndex && goBottom && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goBottom = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos += fieldSize;
			}
		}
		
		// если победитель не определился
		if(!defineWinner) {
			// проверка по диагонали слева-сверху вправо-вниз
			countEqualCells = 1;
			
			// движение влево-вверх от последней вставленной позиции
			startPos = lastMoveCell;
			startPos -= fieldSize + 1;
			// флаг движения влево-вверх 
			boolean goLeftTop = true;
			while(startPos >= 0 && goLeftTop && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goLeftTop = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos -= fieldSize + 1;
			}
			
			// движение вправо-вниз от последней вставленной позиции
			startPos = lastMoveCell;
			startPos += fieldSize + 1;
			// флаг движения влево-вверх 
			boolean goRightBottom = true;
			while(startPos <= maxIndex && goRightBottom && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goRightBottom = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos += fieldSize + 1;
			}
		}
		
		// если победитель не определился
		if(!defineWinner) {
			// проверка по диагонали справа-сверху влево-вниз
			countEqualCells = 1;
			
			// движение вправо-вверх от последней вставленной позиции
			startPos = lastMoveCell;
			startPos -= fieldSize - 1;
			// флаг движения влево-вверх 
			boolean goRightTop = true;
			while(startPos >= 0 && goRightTop && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goRightTop = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos -= fieldSize - 1;
			}
			
			// движение влево-вниз от последней вставленной позиции
			startPos = lastMoveCell;
			startPos += fieldSize - 1;
			// флаг движения влево-вверх 
			boolean goLeftBottom = true;
			while(startPos <= maxIndex && goLeftBottom && !defineWinner) {
				cellPiece = field.getPiece(startPos);
				if(cellPiece != null && cellPiece.equals(piece)) {
					countEqualCells++;
				} else {
					goLeftBottom = false;
				}
				
				// проверка на количество одинаковых ячеек
				if(countEqualCells == counlWinCell) {
					defineWinner = true;
				}
				startPos += fieldSize - 1;
			}
		}
		
		return defineWinner;
	}
	
	/**
	 * Получить игрока по id
	 * @param id - идентификатор игрока
	 * @return - вернет игрока или null
	 */
	public Player getPlayer(int id) {
		
		for(Player elem: players) {
			
			if(elem != null && elem.getId() == id) {
				return elem;
			}
		}
		
		return null;
	}
	
	/** 
	 * Текстовое представление игрового поля
	 * @return поле
	 */
	public String getField() {
		return field.getField();
	}
}