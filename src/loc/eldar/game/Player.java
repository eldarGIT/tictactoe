package loc.eldar.game;

public class Player {
	
	/** идентификатор игрока */
	private final int id;
	/** имя игрока */
	private final String name;
	/** фигура игрока */
	private final Piece piece;

	/**
	 * Конструктор Player
	 * @param id - идентификатор игрока
	 * @param name - имя игрока
	 * @param piece - фигура игрока
	 */
	Player(int id, String name, Piece piece) {
		this.id = id;
		this.name = name;
		this.piece = piece;
	}
	
	/**
	 * Получить id пользователя
	 * @return id пользователя
	 */
	public int getId() {
		return this.id;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
}