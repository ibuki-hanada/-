package janken;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game {
	public static void main(String[] args) {
		JFrame frame = new JankenView("鬼ムズ！叩いてかぶってじゃんけんぽん");
		frame.setVisible(true);
	}
}

interface Param {
	
	//パネルを作るメソッド（幅と高さを指定する用）
	public static JPanel makePanel(Color color, int width, int height) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//パネルのサイズを「width、height」に設定
		panel.setPreferredSize(new Dimension(width, height));
		//作ったパネルを返す
		return panel;
	}
	
	//パネルを作るメソッド（幅と高さを指定しない用）
	public static JPanel makePanel(Color color) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//作ったパネルを返す
		return panel;
	}
	
	//テキストを作るメソッド
	public static JLabel makeText(String str, int size, Color color) {
		//JLabelクラスをインスタンス化
		JLabel label = new JLabel(str);
		//テキストの文字を白にする
		label.setForeground(color);
		//テキストのフォントを設定
		label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));
		//テキストの位置を、水平方向の中心にする
		label.setHorizontalAlignment(JLabel.CENTER);
		//テキストの位置を、垂直方向の中心にする
		label.setVerticalAlignment(JLabel.CENTER);
		//作ったテキストを返す
		return label;
	}
	
	public static ImageIcon setImageSize(String iconPath, int height, int width) {
		ImageIcon imageIcon = new ImageIcon(iconPath);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(height, width, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
		
	}
	
	static JPanel btnpanel = makePanel(Color.BLACK, 600, 50);

	//画像のインポート
	ImageIcon guu = new ImageIcon("guu.png");
	ImageIcon tyoki = new ImageIcon("tyoki.png");
	ImageIcon paa = new ImageIcon("paa.png");
	
	ImageIcon miniguu = setImageSize("guu.png", 50, 50);
	ImageIcon minityoki = setImageSize("tyoki.png", 50, 50);
	ImageIcon minipaa = setImageSize("paa.png", 50, 50);
	
	ImageIcon hit = new ImageIcon("hit.png");
	ImageIcon mysafe = new ImageIcon("mysafe.png");
	ImageIcon pcsafe = new ImageIcon("pcsafe.png");
	ImageIcon lose = new ImageIcon("lose.png");
	
	ImageIcon hammer = new ImageIcon("hammer.png");
	ImageIcon helmet = new ImageIcon("helmet.png");
	
	ImageIcon minihammer = setImageSize("hammer.png", 50, 50);
	ImageIcon minihelmet = setImageSize("helmet.png", 50, 50);
	
	ImageIcon cont = setImageSize("continue.png", 50, 50);
	ImageIcon exit = setImageSize("exit.png", 50, 50);
	
	//各ボタンの作成
	JButton btnRock = new JButton(miniguu);
	JButton btnScissors = new JButton(minityoki);
	JButton btnPaper = new JButton(minipaa);
	JButton btnHammer = new JButton(minihammer);
	JButton btnHelmet = new JButton(minihelmet);
	JButton btnContinue = new JButton(cont);
	JButton btnExit = new JButton(exit);
	
	//コンテンツパネルを作成
	JPanel contentsPanel = makePanel(Color.WHITE);
	//テキストを作成
	JLabel contentsLabel = makeText("じゃんけん……", 54, Color.BLACK);
	
	//ヘッダーパネルの作成
	JPanel headerPanel = makePanel(Color.BLACK, 600, 50);
	//ヘッダラベルの作成
	JLabel headerlabel = new JLabel("手を選んでください");

	//手のパネルの作成
	JPanel myPanel = makePanel(Color.WHITE, 300, 200);
	JLabel myLabel = new JLabel();

	JPanel pcPanel = makePanel(Color.WHITE, 300, 200);
	JLabel pcLabel = new JLabel();
	
	JLabel popLabel = new JLabel();
	
}
