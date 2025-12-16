import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class LotoEngine {
	 static Timer timer;
	
	 // Laiks
	public LotoEngine(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Laiks beidzies!");
            timer.cancel(); //beidz laiku
        }
    }


	public static void main(String[] args) {
		String izvele;
		Stack<Integer> Trauks = new Stack<>();
		Stack<Integer> LaimigieSk = new Stack<>();
		Random rand = new Random();
		
		String[] darbibas = {"Sākt laimestu", "Apskatīt laimestu", "Apturēt"};
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null,
					"Izvlēlies darbību", "Darbību saraksts",
					JOptionPane.QUESTION_MESSAGE, null,
					darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
		switch(izvele) {
		case "Sākt laimestu":
			 LocalDateTime Datums = LocalDateTime.now();
			 DateTimeFormatter Formatets = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 String formatetsDatums = Datums.format(Formatets);
			
			if(timer == null) {
			Trauks.clear();
			for(int i=0; i<10; i++) {
				Trauks.push(rand.nextInt(10)+1);
			}
			
			for(int i=0; i<3; i++) {
				int laimests = Trauks.peek();
				Trauks.pop();
				JOptionPane.showMessageDialog(null,
						i+". Izvelktais skaitlis ir "+laimests+"!", "Informācija",
						JOptionPane.INFORMATION_MESSAGE);
				
				LaimigieSk.push(laimests);
			}
			
			JOptionPane.showMessageDialog(null,
					"Laimests beidzies, atgriežaties pēc 1 minūtes!", "Informācija",
					JOptionPane.INFORMATION_MESSAGE);
			new LotoEngine(60);
			break;
			} else if(timer != null) {
				JOptionPane.showMessageDialog(null,
						"Laimests ir slēgts, nav vel pagājusi 1 minūte! Pēdējais laimests bija "+formatetsDatums, "Brīdinājums",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			break;
			
		case "Apskatīt laimestu":
			int laimigais, laimigais2, laimigais3;
			if(!LaimigieSk.isEmpty()) {
				
				laimigais = LaimigieSk.pop();
				laimigais2 = LaimigieSk.pop();
				laimigais3 = LaimigieSk.pop();
				
				JOptionPane.showMessageDialog(null,
						"Tavi trīs laimīgie skaitļi: "+laimigais3+", "+laimigais2+" un "+laimigais+"!",
						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
			}else
				JOptionPane.showMessageDialog(null,
						"Laimests ir tukšs!",
						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
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
