import java.util.Stack;

import javax.swing.JOptionPane;

public class LotoEngine {

	public static void main(String[] args) {
		String izvele;
		Stack<String> mansSteks = new Stack<>();
		
		String[] darbibas = {"Ievadīt vārdu", "Apturēt"};
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null,
					"Izvlēlies darbību", "Darbību saraksts",
					JOptionPane.QUESTION_MESSAGE, null,
					darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
		switch(izvele) {
		case "Ievadīt vārdu":

			break;
	
		case "Apturēt":
			JOptionPane.showMessageDialog(null,
					"Programma apturēta!", "Informācija",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		} while(!izvele.equals("Apturēt"));

	}

}
