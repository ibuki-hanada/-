package janken;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopGame extends JFrame implements Param {	
	
	public static void popjudge(String str) {
		headerlabel.setText(str);
		if(str == "myhit") {
			headerlabel.setText("HIT!あなたの勝ち！");
		}else  if(str == "mysafe") {
			headerlabel.setText("守った！もう一度だ");

		}else if(str == "pchit") {
			headerlabel.setText("痛い！あなたの負け...");

		}else if(str == "pcsafe") {
			headerlabel.setText("防がれた！もう一度だ！");
		}else if(str == "miss"){
			headerlabel.setText("持つ物が違う！あなたの負け...");

		}else {
			headerlabel.setText("時間切れ！あなたの負け・・・");
		}
	}
	
	public static void popResult1(ImageIcon my, ImageIcon pc) {
		myLabel.setIcon(my);
		pcLabel.setIcon(pc);
		myPanel.setVisible(true);
		pcPanel.setVisible(true);
		contentsPanel.setVisible(false);
	}
	
	public static void popResult2(ImageIcon icon) {
		popLabel.setIcon(icon);
		popLabel.setHorizontalAlignment(JLabel.CENTER);
		popLabel.setVerticalAlignment(JLabel.CENTER);
		contentsPanel.add(popLabel);
		popLabel.setVisible(true);
		contentsPanel.setVisible(true);
		myPanel.setVisible(false);
		pcPanel.setVisible(false);
	}
	
	public static void makepop(String popresult){
		popjudge(popresult);
		if(popresult == "myhit") {
			popResult1(hammer, hit);
		}else if(popresult == "mysafe") {
			popResult2(mysafe);
		}else if(popresult == "pchit"){
			popResult1(hit, hammer);
		}else if(popresult == "pcsafe"){
			popResult2(pcsafe);
		}else {
			popResult2(lose);
		}
	}
}

