import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		
		while(!game.isFinished()) {
			
			game.printField();
						
			while(!scanner.hasNextInt()) {
				scanner.next();
				game.printField();
			}
			
			int chosenField = scanner.nextInt();
			game.setOnField(chosenField);
						
		}
		System.exit(0);
	}
	
}
