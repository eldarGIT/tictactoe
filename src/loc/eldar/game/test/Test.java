package loc.eldar.game.test;

import loc.eldar.game.*;
import static java.lang.System.out;

public class Test {

	public static void main(String[] args) {
		
		//testAddPlayer();
		//testMove();
		
		// тестирование ячеек по горизонтали
		//testGameStateHor();
		
		// тестирование ячеек по вертикали
		//testGameStateVer();
		
		// тестирование ячеек по диагонали слева-сверху вправо-вниз
		//testGameStateDiag1();
		
		// тестирование ячеек по диагонали справа-сверху влево-вниз
		//testGameStateDiag2();
	}
	
	/**
	 * Тестирование различных вариантов добавления игрока
	 */
	private static void testAddPlayer() {
		
		Game game = new Game(3);
		Player player;
		
		// добавление первого игрока с пустым именем
		game.addPlayer(1, "");
		player = game.getPlayer(1);
		if(player == null) {
			out.println("Ошибка добавления игрока");
		} else {
			out.printf("Первый игрок добавлен. Имя первого игрока - %s\n", player.getName());
		}
		
		// добавление второго игрока
		game.addPlayer(2, "player two");
		player = game.getPlayer(2);
		if(player == null) {
			out.println("Ошибка добавления второго игрока");
		} else {
			out.printf("Второй игрок добавлен. Имя второго игрока - %s\n", player.getName());
		}
		
		// добавление третьего игрока
		game.addPlayer(3, "player three");
		player = game.getPlayer(3);
		if(player == null) {
			out.println("Ошибка добавления третьего игрока");
		} else {
			out.println("Третий игрок добавлен");
		}
		
		// добавдение игрока с повторным id
		game.addPlayer(2, "new player two");
		player = game.getPlayer(2);
		if(player == null) {
			out.println("Нет игрока с id = 2");
		} else {
			out.printf("Имя игрока с id = 2: %s\n", player.getName());
		}
	}
	
	/**
	 * Тестирование совершения хода игроком
	 */
	public static void testMove() {
		
		Game game = new Game(3);
		Player player1, player2;
		
		game.init();
		
		// Добавление игроков
		game.addPlayer(1, "Player 1");
		game.addPlayer(2, "Player 2");
		
		// Получить добавленных игроков
		player1 = game.getPlayer(1);
		player2 = game.getPlayer(2);
		
		// ход первого игрока
		game.move(1, 5);
		out.println(game.getField());
		
		// повторный ход первого игрока
		game.move(1, 6);
		out.println(game.getField());
		
		// ход второго игрока
		game.move(2, 0);
		out.println(game.getField());
		
		// ход первого игрока в занятое поле
		game.move(1, 0);
		out.println(game.getField());
		
		// проверка не переключился ли активный игрок после ошибочного хода игрока
		game.move(1, 1);
		out.println(game.getField());
		
		// ход второго игрока в недобустимое поле
		game.move(2, 100);
		out.println(game.getField());
		
		// ход второго игрока в недобустимое поле
		game.move(2, -100);
		out.println(game.getField());
		
		// правильный ход второго игрока
		game.move(2, 2);
		out.println(game.getField());
	}
	
	private static void testGameStateHor() {
		Game game = new Game(3);
		Player player1, player2;
		
		game.init();
		
		// Добавление игроков
		game.addPlayer(1, "Player 1");
		game.addPlayer(2, "Player 2");
		
		// Получить добавленных игроков
		player1 = game.getPlayer(1);
		player2 = game.getPlayer(2);
		
		// ход первого игрока
		game.move(1, 3);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 1);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 5);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 8);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 4);
		out.println(game.getField());
		out.println(game.getState());
	}
	
	public static void testGameStateVer() {
		Game game = new Game(3);
		Player player1, player2;
		
		game.init();
		
		// Добавление игроков
		game.addPlayer(1, "Player 1");
		game.addPlayer(2, "Player 2");
		
		// Получить добавленных игроков
		player1 = game.getPlayer(1);
		player2 = game.getPlayer(2);
		
		// ход первого игрока
		game.move(1, 1);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 0);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 2);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 3);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 4);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 6);
		out.println(game.getField());
		out.println(game.getState());
	}
	
	public static void testGameStateDiag1() {
		Game game = new Game(3);
		Player player1, player2;
		
		game.init();
		
		// Добавление игроков
		game.addPlayer(1, "Player 1");
		game.addPlayer(2, "Player 2");
		
		// Получить добавленных игроков
		player1 = game.getPlayer(1);
		player2 = game.getPlayer(2);
		
		// ход первого игрока
		game.move(1, 1);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 0);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 2);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 4);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 5);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 8);
		out.println(game.getField());
		out.println(game.getState());
	}
	
	public static void testGameStateDiag2() {
		Game game = new Game(3);
		Player player1, player2;
		
		game.init();
		
		// Добавление игроков
		game.addPlayer(1, "Player 1");
		game.addPlayer(2, "Player 2");
		
		// Получить добавленных игроков
		player1 = game.getPlayer(1);
		player2 = game.getPlayer(2);
		
		// ход первого игрока
		game.move(1, 2);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 0);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 6);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход второго игрока
		game.move(2, 3);
		out.println(game.getField());
		out.println(game.getState());
		
		// ход первого игрока
		game.move(1, 4);
		out.println(game.getField());
		out.println(game.getState());
	}
}
