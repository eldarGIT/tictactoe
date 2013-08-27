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
	 * Инициализация игры
	 */
	public void init() {
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
	
}
