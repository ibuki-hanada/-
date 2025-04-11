package janken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class PopView extends JFrame implements Param {	
	
	Timer timer = new Timer();
	
	Timer timer2 = new Timer();
	
	TimerTask waitTime = new TimerTask() {
		
		@Override
		public void run() {
			//ここに定期実行させたい処理を記述
			String JankenResult = JankenView.jankenResult; 
			if(JankenResult == "勝ち") {
				PopGame.makepop("pcsafe");
				//popLabel.setVisible(true);//画像の差し替え
				visibleJankenButton();//じゃんけんボタンの削除
				unvisiblePopButton();
				jankenOff();
				timer2.schedule(jankenLock, 500);
			}else {
				PopGame.makepop("pchit");
				popOff();
				jankenOff();
				unvisiblePopButton();
				visibleEndbutton();
				endOff();
				timer2.schedule(endLock, 1000);
			}
		}
	};
	
	TimerTask jankenLock = new TimerTask() {
		@Override
		public void run() {
			jankenOn();
		}
	};
	
	TimerTask endLock = new TimerTask() {
		@Override
		public void run() {
			endOn();
		}
	};
	
	TimerTask popLock = new TimerTask() {
		@Override
		public void run() {
			popOn();
		}
	};
	
	public PopView() {
		// 初期化: 
		// 1. グーチョキパーのボタンを非表示にする
		// 2. ハンマーとヘルメットのボタンを表示する
		// 3. 各ボタンのリスナーを追加する（ここでいい？？）
		unvisibleJankenButton();
		visiblePopButton();
		Random rand = new Random();
		popOff();
		timer2.schedule(popLock, 201);
		timer.schedule(waitTime, (rand.nextInt(1300) + 200) );
		btnHammer.addActionListener(new myListenerHammer());
		btnHelmet.addActionListener(new myListenerHelmet());
		btnContinue.addActionListener(new myListenerContinue());
		btnExit.addActionListener(new myListenerExit());
	}
	
	public class myListenerHammer implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO 処理の記述
			timer.cancel();
			String JankenResult = JankenView.jankenResult; 
			if(JankenResult == "勝ち") {
				PopGame.makepop("myhit");	
				jankenOff();
				popOff();
				unvisibleJankenButton();
				unvisiblePopButton();
				visibleEndbutton();
				endOff();
				timer2.schedule(endLock, 1000);
			}else if(JankenResult == "負け") {
				PopGame.makepop("miss");
				jankenOff();
				popOff();
				unvisibleJankenButton();
				unvisiblePopButton();
				visibleEndbutton();
				endOff();
				timer2.schedule(endLock, 1000);
			}
		}
	}
	
	public class myListenerHelmet implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO 処理の記述
			timer.cancel();
			String JankenResult = JankenView.jankenResult; 
			if(JankenResult == "勝ち") {
				PopGame.makepop("miss");
				jankenOff();
				popOff();
				unvisibleJankenButton();
				unvisiblePopButton();
				visibleEndbutton();
				endOff();
				timer2.schedule(endLock, 1000);
			}else if(JankenResult == "負け") {
				PopGame.makepop("mysafe");
				unvisiblePopButton();
				visibleJankenButton();
				jankenOff();
				timer2.schedule(jankenLock, 500);
			}
		}
	}
	
	public class myListenerContinue implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JankenView.init();
		}
	}
	
	public class myListenerExit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO 処理の記述
			System.exit(0);
		}
	}
	
	public static void popOn() {
		btnHammer.setEnabled(true);
		btnHelmet.setEnabled(true);
	}
	
	public static void popOff() {
		btnHammer.setEnabled(false);
		btnHelmet.setEnabled(false);
	}
	
	public static void jankenOn() {
		btnRock.setEnabled(true);
		btnScissors.setEnabled(true);
		btnPaper.setEnabled(true);
	}
	
	public static void jankenOff() {
		btnRock.setEnabled(false);
		btnScissors.setEnabled(false);
		btnPaper.setEnabled(false);
	}

	public static void endOn() {
		btnContinue.setEnabled(true);
		btnExit.setEnabled(true);
	}
	
	public static void endOff() {
		btnContinue.setEnabled(false);
		btnExit.setEnabled(false);
	}
	
	public void visibleJankenButton() {
		btnRock.setVisible(true);
		btnScissors.setVisible(true);
		btnPaper.setVisible(true);
	}
	
	public static void unvisibleJankenButton() {
		btnRock.setVisible(false);
		btnScissors.setVisible(false);
		btnPaper.setVisible(false);
	}
	
	public void visiblePopButton() {
		btnHammer.setVisible(true);
		btnHelmet.setVisible(true);
	}
	
	public void unvisiblePopButton() {
		btnHammer.setVisible(false);
		btnHelmet.setVisible(false);
	}
	
	public void visibleEndbutton() {
		btnContinue.setVisible(true);
		btnExit.setVisible(true);
	}
	
	public void unvisibleEndbutton() {
		btnContinue.setVisible(false);
		btnExit.setVisible(false);
	}
}
