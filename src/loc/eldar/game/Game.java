package loc.eldar.game;

public class Game {

	// Игровое поле
	private Field field;
	// Массив игроков
	private Player[] players = new Player[2];
	
	/**
	 * Конструктор класса Game
	 * @param size - размер стороны квадратного игрового поля
	 */
	public Game(int size) {
		field = new Field(size);
	}
	
	/**
	 * Добавление игрока в игру
	 * @param id - идентификатор игрока
	 * @param name - имя игрока
	 * @return true - в случае успешного добавления игрока
	 */
	public boolean addPlayer(int id, String name) {
		
		if(players[1] == null) {
			Piece piece = null;
			int index;
			
			/** первый играет за крестики */
			if(players[0] == null) {
				piece = Piece.x;
				index = 0;
			} else {
				/** второй играет за нолики */
				piece = Piece.o;
				index = 1;
			}
			
			players[index] = new Player(id, name, piece);
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
		
		if(player == null) {
			return;
		}
		
		/** разместить фигуру игрока на поле */
		field.place(player.getPiece(), value);
	}
	
	/**
	 * Текущее состояние игры
	 * @return возвращаемые значения: начата, закончена, ничья, победа
	 */
	public String getState() {
		return null;
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
