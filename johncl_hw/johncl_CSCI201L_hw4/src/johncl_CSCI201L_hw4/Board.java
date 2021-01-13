package johncl_CSCI201L_hw4;

public class Board {
	private String[] row1 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "5", "_", " "
			," ", " ", " ", " "};
	private String[] row2 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " "
			," ", " ", " ", " "};
	private String[] row3 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " "
			," ", " ", " ", " "};
	private String[] row4 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "3", "_", " ", "_", " "
			,"_", " ", "_", " "};
	private String[] row5 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "4", "_", " ", " ", " ", "_", " "
			," ", " ", " ", " "};
	private String[] row6 = {" ", " ", " ", " ", " ", " ", " ", " ", "1", "_", " ", "_", " ", "_", " ", "_", " ", "_", " "
			,"_", " ", "_", " "};
	private String[] row7 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", "_", " ", " ", " ", "_", " "
			," ", " ", " ", " "};
	private String[] row8 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", "_", " ", " ", " ", "_", " "
			," ", " ", " ", " "};
	private String[] row9 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " "
			," ", " ", " ", " "};
	private String[] row10 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " "
			," ", " ", " ", " "};
	private String[] row11 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " "
			," ", " ", " ", " "};
	private String[] row12 = {"2", "_", " ", "_", " ", "_", " ", "_", " ", "_", " ", "_", " ", "_", " ", " ", " ", " ", " "
			," ", " ", " ", " "};
	private String[] row13 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " "
			," ", " ", " ", " "};
	private static int row = 13;
	private static int col = 23;
	public String[][] b = {row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13};
	
	String A1 = "1 What is USC’s mascot?";
	String A2 = "2 What professional baseball team is closest to USC?";
	String A3 = "3 What is the four-letter prefix for Computer Science?";
	
	String D1 = "1 What is the name of USC’s white horse?";
	String D2 = "4 What is one of USC’s colors?";
	String D3 = "5 Who is USC’s School of Business named after?";
	
	public String[]Across_question = {A1,A2,A3};
	public String[]Down_question = {D1,D2,D3};
	
	public Board() {	
	}
	public String printBoardMsg() {
		String response = "";
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				response += b[i][j];
			}
			response += "\n";
		}
//		System.out.println(response);
//		System.out.println("Across");
		String AQuestion = "Across" + "\n";
		for(int k=0; k<Across_question.length; k++){
			AQuestion += Across_question[k] + "\n";
		}
//		System.out.println(AQuestion);
//		System.out.println("Down");
		String DQuestion = "Down" + "\n";
		for(int k=0; k<Down_question.length; k++){
			DQuestion += Down_question[k] + "\n";
		}
		System.out.println(DQuestion);
		String Msg = response + "\n" + AQuestion + "\n" + DQuestion;
		return Msg;
	}
	
	public static Board A1_correct(Board b) {
		Board puzzle = b;
		String[] R6 = {" ", " ", " ", " ", " ", " ", " ", " ", "1", "T", " ", "R", " ", "O", " ", "J", " ", "A", " "
				,"N", " ", "S", " "};
		puzzle.b[5] = R6;
		return puzzle;
	}
	
	public static Board A2_correct(Board b) {
		Board puzzle = b;
		String[] R12 = {"2", "D", " ", "O", " ", "D", " ", "G", " ", "E", " ", "R", " ", "S", " ", " ", " ", " ", " "
				," ", " ", " ", " "};
		puzzle.b[11] = R12;
		return puzzle;
	}
	public static Board A3_correct(Board b) {
		Board puzzle = b;
		String[] R4 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "3", "C", " ", "S", " "
				,"C", " ", "I", " "};	
		puzzle.b[3] = R4;
		return puzzle;
	}
	public static Board D1_correct(Board b) {
		Board puzzle = b;
		puzzle.b[5][9] = "T";
		puzzle.b[6][9] = "R";
		puzzle.b[7][9] = "A";
		puzzle.b[8][9] = "V";
		puzzle.b[9][9] = "E";
		puzzle.b[10][9] = "L";
		puzzle.b[11][9] = "E";
		puzzle.b[12][9] = "R";
		return puzzle;
	}
	public static Board D2_correct(Board b) {
		Board puzzle = b;
		puzzle.b[4][13] = "G";
		puzzle.b[5][13] = "O";
		puzzle.b[6][13] = "L";
		puzzle.b[7][13] = "D";
		return puzzle;
	}
	public static Board D3_correct(Board b) {
		Board puzzle = b;
		puzzle.b[0][17] = "M";
		puzzle.b[1][17] = "A";
		puzzle.b[2][17] = "R";
		puzzle.b[3][17] = "S";
		puzzle.b[4][17] = "H";
		puzzle.b[5][17] = "A";
		puzzle.b[6][17] = "L";
		puzzle.b[7][17] = "L";
		return puzzle;
	}
	public static boolean completeBoard(Board b) {
		Board temp = new Board();
		temp = A1_correct(temp);
		temp = A2_correct(temp);
		temp = A3_correct(temp);
		temp = D1_correct(temp);
		temp = D2_correct(temp);
		temp = D3_correct(temp);
		boolean check = true;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(b.b[i][j] != temp.b[i][j]) {
					check = false;
					break;
				}
			}
		}
		return check;
	}
	
	public static void main(String[] args) {
//		Board puzzle = new Board();
//		if(completeBoard(puzzle) == false) {
//			System.out.println("Incomplete!");
//		}
//		puzzle.printBoard();
//
//		puzzle = A1_correct(puzzle);
//		puzzle = A2_correct(puzzle);
//		puzzle = A3_correct(puzzle);
//		puzzle = D1_correct(puzzle);
//		puzzle = D2_correct(puzzle);
//		puzzle = D3_correct(puzzle);
//		if(completeBoard(puzzle) == true) {
//			System.out.println("Complete!");
//		}
//		puzzle.printBoard();
		
		
		
	}

}
