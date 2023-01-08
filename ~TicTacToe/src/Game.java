
public class Game {

	private char[][] gameField = new char[3][3];
	
	private char nowMoving = 'X';
	private char lastMoved = 'Q';
	private boolean finished = false;
			
	public boolean setOnField(int y, int x) {
		if(gameField[y][x] == 0 && nowMoving != gameField[y][x]) {
			gameField[y][x] = nowMoving;
			nowMoving = lastMoved;
			lastMoved = (nowMoving == 'Q') ? 'X' : 'Q';
			return true;
		}
		return false;
	}
	
	public char checkWinner() {
				
		for(int a = 0; a < 8; a++) {
			String line = "";
			
			switch (a) {
				case 0:{
					line = String.valueOf(gameField[0][0]) + String.valueOf(gameField[0][1]) + String.valueOf(gameField[0][2]);
					break;					
				}
				case 1:{
					line = String.valueOf(gameField[1][0]) + String.valueOf(gameField[1][1]) + String.valueOf(gameField[1][2]);
					break;					
				}
				case 2:{
					line = String.valueOf(gameField[2][0]) + String.valueOf(gameField[2][1]) + String.valueOf(gameField[2][2]);
					break;					
				}
				case 3:{
					line = String.valueOf(gameField[0][0]) + String.valueOf(gameField[1][0]) + String.valueOf(gameField[2][0]);
					break;					
				}
				case 4:{
					line = String.valueOf(gameField[0][1]) + String.valueOf(gameField[1][1]) + String.valueOf(gameField[2][1]);
					break;					
				}
				case 5:{
					line = String.valueOf(gameField[0][2]) + String.valueOf(gameField[1][2]) + String.valueOf(gameField[2][2]);
					break;					
				}
				case 6:{
					line = String.valueOf(gameField[0][0]) + String.valueOf(gameField[1][1]) + String.valueOf(gameField[2][2]);
					break;					
				}
				case 7:{
					line = String.valueOf(gameField[2][0]) + String.valueOf(gameField[1][1]) + String.valueOf(gameField[0][2]);
					break;					
				}				
			}
			
			if(line.equals("XXX")) {
				finished = true;
				return 'X';				
			}
			
			if(line.equals("QQQ")) {
				finished = true;
				return 'Q';				
			}
			
		}
		
		if(getEmptyFields() <= 0) {
			finished = true;
			return 'D';			
		}
		
		return 0;
	}
	
	public int getEmptyFields() {
		int a = 0;
		for(int y = 0; y < gameField.length; y++) {
			for(int x = 0; x < gameField[0].length; x++) {
				if(gameField[y][x] == 0) a++;
			}
		}
		
		return a;
	}
	
	public void printField() {
		System.out.println("\n\n\n\n\n\n\n");
		checkWinner();
		int offset = 0;
		int c = 1;
		for(int y = 0; y < gameField.length * 2 - 1; y++) {
			if(y % 2 != 0) {
				System.out.println("-----------");
				offset++;
				continue;
			}
			
			for(int x = 0; x < gameField[0].length; x++) {
				char currentChar = gameField[y - offset][x];
				
				if(x > 0)
					System.out.print("|");
				if(currentChar == 0 && !isFinished())
					System.out.print(" " + c + " ");
				else
					System.out.print(" " + currentChar + " ");
				
				
				c++;				
				
			}
			if(y == 0 && !isFinished())
				System.out.print("\tSpieler ist dran: " + nowMoving);
			if(y == 2 && !isFinished())
				System.out.print("\tBitte wählen Sie eines der Felder aus!");
			if(y == 2 && isFinished()) 
				if(checkWinner() == 'D')
					System.out.print("\t Niemand hat gewonnen!");
				else
					System.out.print("\t Spieler " + checkWinner() + " hat gewonnen!");
			System.out.println("");
		}
		if(!isFinished())
			System.out.print("\nIhre Auswahl => ");
	}
	
	public boolean isFinished() {
		return finished;
	}
	
}
