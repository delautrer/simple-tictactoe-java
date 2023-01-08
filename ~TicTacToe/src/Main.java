import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		
		while(!game.isFinished()) {
			
			game.printField();
						
			int chosenField = scanner.nextInt();
			
			switch(chosenField) {
				case 1: {
					game.setOnField(0, 0);
					break;
				}
				case 2: {
					game.setOnField(0, 1);
					break;
				}
				case 3: {
					game.setOnField(0, 2);
					break;
				}
				case 4: {
					game.setOnField(1, 0);
					break;
				}
				case 5: {
					game.setOnField(1, 1);
					break;
				}
				case 6: {
					game.setOnField(1, 2);
					break;
				}
				case 7: {
					game.setOnField(2, 0);
					break;
				}
				case 8: {
					game.setOnField(2, 1);
					break;
				}
				case 9: {
					game.setOnField(2, 2);
					break;
				}
			}
		}
		System.exit(0);
	}
	
}
